package com.github.haixing_hu.ilibrary.gui.mac;

/*
 * Copyright 2007 Eirik Bjorsnos.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

/**
 * Implements Application by calling the Mac OS X API through reflection. If
 * this class is used on a non-OS X platform the operations will have no effect
 * or they will simulate what the Apple API would do for those who manipulate
 * state. ({@link #setEnabledAboutMenu(boolean)} etc.)
 */
public class DefaultNsApplication implements NsApplication {

  private Object app;
  private Class<?> listenerClass;

  private final Map<NsApplicationListener, Object> listenerMap;
  private boolean enabledAboutMenu;
  private boolean enabledPreferencesMenu;
  private boolean aboutMenuItemPresent;
  private boolean preferencesMenuItemPresent;

  public DefaultNsApplication() {
    listenerMap = Collections.synchronizedMap(new HashMap<NsApplicationListener, Object>());
    enabledAboutMenu = true;
    aboutMenuItemPresent = true;
    try {
      final File file = new File("/System/Library/Java");
      if (file.exists()) {
        ClassLoader scl = ClassLoader.getSystemClassLoader();
        Class<?> clc = scl.getClass();
        if (URLClassLoader.class.isAssignableFrom(clc)) {
          Method addUrl = URLClassLoader.class.getDeclaredMethod("addURL",
              new Class[] { URL.class });
          addUrl.setAccessible(true);
          addUrl.invoke(scl, new Object[] { file.toURI().toURL() });
        }
      }
      Class<?> appClass = Class.forName("com.apple.eawt.Application");
      app = appClass.getMethod("getApplication", new Class[0])
                    .invoke(null, new Object[0]);
      listenerClass = Class.forName("com.apple.eawt.ApplicationListener");
    } catch (ClassNotFoundException e) {
      app = null;
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    } catch (NoSuchMethodException e) {
      throw new RuntimeException(e);
    } catch (InvocationTargetException e) {
      throw new RuntimeException(e);
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public boolean isMac() {
    return app != null;
  }

  @Override
  public void addAboutMenuItem() {
    if (isMac()) {
      callMethod(app, "addAboutMenuItem");
    } else {
      this.aboutMenuItemPresent = true;
    }
  }

  @Override
  public void addApplicationListener(NsApplicationListener applicationListener) {
    if (!Modifier.isPublic(applicationListener.getClass().getModifiers())) {
      throw new IllegalArgumentException(
          "ApplicationListener must be a public class");
    }
    if (isMac()) {
      Object listener = Proxy.newProxyInstance(getClass().getClassLoader(),
          new Class[] { listenerClass },
          new ApplicationListenerInvocationHandler(applicationListener));
      callMethod(app, "addApplicationListener",
          new Class[] { listenerClass }, new Object[] { listener });
      listenerMap.put(applicationListener, listener);
    } else {
      listenerMap.put(applicationListener, applicationListener);
    }
  }

  @Override
  public void addPreferencesMenuItem() {
    if (isMac()) {
      callMethod("addPreferencesMenuItem");
    } else {
      this.preferencesMenuItemPresent = true;
    }
  }

  @Override
  public boolean getEnabledAboutMenu() {
    if (isMac()) {
      return callMethod("getEnabledAboutMenu").equals(Boolean.TRUE);
    } else {
      return enabledAboutMenu;
    }
  }

  @Override
  public boolean getEnabledPreferencesMenu() {
    if (isMac()) {
      Object result = callMethod("getEnabledPreferencesMenu");
      return result.equals(Boolean.TRUE);
    } else {
      return enabledPreferencesMenu;
    }
  }

  @Override
  public Point getMouseLocationOnScreen() {
    if (isMac()) {
      try {
        Method method = app.getClass().getMethod(
            "getMouseLocationOnScreen", new Class[0]);
        return (Point) method.invoke(null, new Object[0]);
      } catch (NoSuchMethodException e) {
        throw new RuntimeException(e);
      } catch (IllegalAccessException e) {
        throw new RuntimeException(e);
      } catch (InvocationTargetException e) {
        throw new RuntimeException(e);
      }
    } else {
      return new Point(0, 0);
    }
  }

  @Override
  public boolean isAboutMenuItemPresent() {
    if (isMac()) {
      return callMethod("isAboutMenuItemPresent").equals(Boolean.TRUE);
    } else {
      return aboutMenuItemPresent;
    }
  }

  @Override
  public boolean isPreferencesMenuItemPresent() {
    if (isMac()) {
      return callMethod("isPreferencesMenuItemPresent").equals(Boolean.TRUE);
    } else {
      return this.preferencesMenuItemPresent;
    }
  }

  @Override
  public void removeAboutMenuItem() {
    if (isMac()) {
      callMethod("removeAboutMenuItem");
    } else {
      this.aboutMenuItemPresent = false;
    }
  }

  @Override
  public synchronized void removeApplicationListener(
      NsApplicationListener applicationListener) {
    if (isMac()) {
      Object listener = listenerMap.get(applicationListener);
      callMethod(app, "removeApplicationListener",
          new Class[] { listenerClass }, new Object[] { listener });

    }
    listenerMap.remove(applicationListener);
  }

  @Override
  public void removePreferencesMenuItem() {
    if (isMac()) {
      callMethod("removeAboutMenuItem");
    } else {
      this.preferencesMenuItemPresent = false;
    }
  }

  @Override
  public void setEnabledAboutMenu(boolean enabled) {
    if (isMac()) {
      callMethod(app, "setEnabledAboutMenu",
          new Class[] { Boolean.TYPE },
          new Object[] { Boolean.valueOf(enabled) });
    } else {
      this.enabledAboutMenu = enabled;
    }
  }

  @Override
  public void setEnabledPreferencesMenu(boolean enabled) {
    if (isMac()) {
      callMethod(app, "setEnabledPreferencesMenu",
          new Class[] { Boolean.TYPE },
          new Object[] { Boolean.valueOf(enabled) });
    } else {
      this.enabledPreferencesMenu = enabled;
    }

  }

  @Override
  public int requestUserAttention(int type) {
    if (type != REQUEST_USER_ATTENTION_TYPE_CRITICAL
        && type != REQUEST_USER_ATTENTION_TYPE_INFORMATIONAL) {
      throw new IllegalArgumentException(
          "Requested user attention type is not allowed: " + type);
    }
    try {
      Object application = getNSApplication();
      Field critical = application.getClass().getField(
          "UserAttentionRequestCritical");
      Field informational = application.getClass().getField(
          "UserAttentionRequestInformational");
      Field actual = type == REQUEST_USER_ATTENTION_TYPE_CRITICAL ? critical
          : informational;

      return ((Integer) application.getClass()
          .getMethod("requestUserAttention", new Class[] { Integer.TYPE })
          .invoke(application, new Object[] { actual.get(null) })).intValue();

    } catch (ClassNotFoundException e) {
      return -1;
    } catch (NoSuchMethodException e) {
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    } catch (InvocationTargetException e) {
      throw new RuntimeException(e);
    } catch (NoSuchFieldException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void cancelUserAttentionRequest(int request) {
    try {
      Object application = getNSApplication();
      application
      .getClass()
      .getMethod("cancelUserAttentionRequest", new Class[] { Integer.TYPE })
      .invoke(application, new Object[] { new Integer(request) });
    } catch (ClassNotFoundException e) {
      // Nada
    } catch (NoSuchMethodException e) {
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    } catch (InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }

  private Object getNSApplication() throws ClassNotFoundException {
    try {
      Class<?> cls = Class.forName("com.apple.cocoa.application.NSApplication");
      return cls.getMethod("sharedApplication", new Class[0])
                .invoke(null, new Object[0]);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    } catch (InvocationTargetException e) {
      throw new RuntimeException(e);
    } catch (NoSuchMethodException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void setApplicationIconImage(BufferedImage image) {
    if (isMac()) {
      try {
        Method setDockIconImage = app.getClass()
                                     .getMethod("setDockIconImage", Image.class);
        try {
          setDockIconImage.invoke(app, image);
        } catch (IllegalAccessException e) {
          //  ignore
        } catch (InvocationTargetException e) {
          //  ignore
        }
      } catch (NoSuchMethodException mnfe) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
          ImageIO.write(image, "png", stream);
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
        try {
          Class<?> nsDataClass = Class.forName("com.apple.cocoa.foundation.NSData");
          Constructor<?> constructor = nsDataClass.getConstructor(new Class[] { new byte[0].getClass() });
          Object nsData = constructor.newInstance(new Object[] { stream.toByteArray() });

          Class<?> nsImageClass = Class.forName("com.apple.cocoa.application.NSImage");
          Object nsImage = nsImageClass.getConstructor(new Class[] { nsDataClass })
                                        .newInstance(new Object[] { nsData });

          Object application = getNSApplication();
          application.getClass()
                     .getMethod("setApplicationIconImage", new Class[] { nsImageClass })
                     .invoke(application, new Object[] { nsImage });
        } catch (ClassNotFoundException e) {
          //  ignore
        } catch (NoSuchMethodException e) {
          throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
          throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
          throw new RuntimeException(e);
        } catch (InstantiationException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }

  @Override
  public BufferedImage getApplicationIconImage() {
    if (isMac()) {
      try {
        Method getDockIconImage = app.getClass()
                                     .getMethod("getDockIconImage");
        try {
          return (BufferedImage) getDockIconImage.invoke(app);
        } catch (IllegalAccessException e) {
          //  ignore
        } catch (InvocationTargetException e) {
          //  ignore
        }
      } catch (NoSuchMethodException nsme) {

        try {
          Class<?> nsDataClass = Class.forName("com.apple.cocoa.foundation.NSData");
          Class<?> nsImageClass = Class.forName("com.apple.cocoa.application.NSImage");
          Object application = getNSApplication();
          Object nsImage = application.getClass()
                                      .getMethod("applicationIconImage", new Class[0])
                                      .invoke(application, new Object[0]);
          Object nsData = nsImageClass.getMethod("TIFFRepresentation", new Class[0])
                                      .invoke(nsImage, new Object[0]);
          Integer length = (Integer) nsDataClass.getMethod("length",new Class[0])
                                                .invoke(nsData, new Object[0]);
          byte[] bytes = (byte[]) nsDataClass.getMethod("bytes", new Class[]{ Integer.TYPE, Integer.TYPE })
                                             .invoke(nsData, new Object[]{ Integer.valueOf(0), length });

          BufferedImage image = ImageIO.read(new ByteArrayInputStream(bytes));
          return image;
        } catch (ClassNotFoundException e) {
          e.printStackTrace();
        } catch (NoSuchMethodException e) {
          throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
          throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
          throw new RuntimeException(e);
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    }
    return null;
  }

  private Object callMethod(String methodname) {
    return callMethod(app, methodname, new Class[0], new Object[0]);
  }

  private Object callMethod(Object object, String methodname) {
    return callMethod(object, methodname, new Class[0], new Object[0]);
  }

  private Object callMethod(Object object, String methodname, Class<?>[] classes,
      Object[] arguments) {
    try {
      if (classes == null) {
        classes = new Class[arguments.length];
        for (int i = 0; i < classes.length; i++) {
          classes[i] = arguments[i].getClass();
        }
      }
      Method addListnerMethod = object.getClass()
                                      .getMethod(methodname, classes);
      return addListnerMethod.invoke(object, arguments);
    } catch (NoSuchMethodException e) {
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    } catch (InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }

  class ApplicationListenerInvocationHandler implements InvocationHandler {
    private final NsApplicationListener applicationListener;

    ApplicationListenerInvocationHandler(NsApplicationListener applicationListener) {
      this.applicationListener = applicationListener;
    }

    @Override
    public Object invoke(Object object, Method appleMethod, Object[] objects)
        throws Throwable {
      NsApplicationEvent event = createApplicationEvent(objects[0]);
      try {
        Method method = applicationListener.getClass()
                                           .getMethod(appleMethod.getName(), new Class[] { NsApplicationEvent.class });
        return method.invoke(applicationListener, new Object[] { event });
      } catch (NoSuchMethodException e) {
        if (appleMethod.getName().equals("equals") && objects.length == 1) {
          return Boolean.valueOf(object == objects[0]);
        }
        return null;
      }
    }
  }

  private NsApplicationEvent createApplicationEvent(
      final Object appleApplicationEvent) {
    return (NsApplicationEvent) Proxy.newProxyInstance(getClass().getClassLoader(),
        new Class[] { NsApplicationEvent.class }, new InvocationHandler() {
      @Override
      public Object invoke(Object o, Method method, Object[] objects)
          throws Throwable {
        return appleApplicationEvent.getClass()
                                    .getMethod(method.getName(), method.getParameterTypes())
                                    .invoke(appleApplicationEvent, objects);
      }
    });
  }
}
