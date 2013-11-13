/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary;

import java.util.Locale;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.nju.starfish.ilibrary.action.ActionManager;
import cn.edu.nju.starfish.ilibrary.gui.MainWindow;
import cn.edu.nju.starfish.ilibrary.state.ApplicationState;

/**
 * The main class of the application.
 *
 * @author Haixing Hu
 */
public final class Application {

  public static final String CONTEXT_FILE = "applicationContext.xml";

  private final Logger logger;
  private final ApplicationContext context;
  private final Locale locale;
  private final MessageSource messageSource;
  private final Configuration config;
  private final String name;
  private final String version;
  private final ApplicationState state;
  private final ActionManager actionManager;
  private final MainWindow mainWindow;

  /**
   * Constructs an application.
   */
  public Application() {
    logger = LoggerFactory.getLogger(Application.class);
    context = new ClassPathXmlApplicationContext(CONTEXT_FILE);
    locale = Locale.getDefault();
    messageSource = context.getBean(MessageSource.class);
    config = context.getBean(Configuration.class);
    name = messageSource.getMessage("app.name", null, locale);
    version = config.getString("app.version");
    state = new ApplicationState(this, config);
    actionManager = new ActionManager(this);
    mainWindow = new MainWindow(this);
//    //  adjust the Mac OS X Cococa UI
//    if (SystemUtils.IS_OS_MAC) {
//      NsApplication nsApp = new DefaultNsApplication();
//      nsApp.addApplicationListener(new CococaApplicationListener(this));
//      nsApp.addAboutMenuItem();
//      nsApp.addPreferencesMenuItem();
//    }
  }

  /**
   * Runs this application.
   */
  public void run() {
    mainWindow.create();
    state.sync();
    mainWindow.setBlockOnOpen(true);
    mainWindow.open();
    final Display display = Display.getCurrent();
    if (display != null) {
      //  if the program is terminated by external command (i.e., press CMD+Q in Mac),
      //  the display could be null.
      display.dispose();
    }
  }

  /**
   * Gets the logger of this application.
   *
   * @return the logger of this application.
   */
  public Logger getLogger() {
    return logger;
  }

  /**
   * Gets the application context.
   *
   * @return the application context.
   */
  public ApplicationContext getContext() {
    return context;
  }

  /**
   * Gets the locale.
   *
   * @return the locale.
   */
  public Locale getLocale() {
    return locale;
  }

  /**
   * Gets the name of the application.
   *
   * @return the name of the application.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the version of the application.
   *
   * @return the version of the application.
   */
  public String getVersion() {
    return version;
  }

  /**
   * Gets the localized message for a specified key.
   *
   * @param key
   *          the key of the message.
   * @return the localized message for the specified key.
   */
  public String getMessage(String key) {
    return messageSource.getMessage(key, null, locale);
  }

  /**
   * Gets the localized message for a specified key formatted with specified
   * arguments.
   *
   * @param key
   *          the key of the message.
   * @param args
   *          the arguments used to format the message.
   * @return the localized message formatted with the specified arguments.
   */
  public String getMessage(String key, Object... args) {
    return messageSource.getMessage(key, args, locale);
  }

  /**
   * Gets the global configuration.
   *
   * @return the global configuration.
   */
  public Configuration getConfig() {
    return config;
  }

  /**
   * Gets the title associated with a specified action.
   *
   * @param key
   *          The key of the specified action.
   * @return The title associated with the specified action.
   */
  public String getTitle(String key) {
    final String title = messageSource.getMessage(key + KeySuffix.TITLE, null, locale);
    logger.debug("Find the title for {}: {}", key, title);
    return title;
  }

  /**
   * Gets the shortcut associated with a specified action.
   *
   * @param key
   *          The key of the specified action.
   * @return The shortcut associated with the specified action.
   */
  public String getShortcut(String key) {
    String shortcut = config.getString(key + KeySuffix.SHORTCUT);
    if (! StringUtils.isEmpty(shortcut)) {
      //  substitute the META key according to the operating system
      final String meta = (SystemUtils.IS_OS_MAC ? "COMMAND" : "CTRL");
      shortcut = shortcut.replace("META", meta);
    } else {
      shortcut = null;
    }
    logger.debug("Find the shortcut for {}: {}", key, shortcut);
    return shortcut;
  }

  /**
   * Gets the description of an action.
   *
   * @param key
   *          the key of a specified action.
   * @return the description the specified action, or null if it has no description.
   */
  public String getDescription(String key) {
    String description = messageSource.getMessage(key + KeySuffix.DESCRIPTION,
        null, null, locale);
    if (StringUtils.isEmpty(description)) {
      description = null;
    }
    logger.debug("Find the description for {}: {}", key, description);
    return description;
  }

  /**
   * Gets the URL of the icon of an action.
   *
   * @param key
   *          the key of a specified action.
   * @return the URL of the icon the specified action, or null if it has no icon.
   */
  public String getIcon(String key) {
    String icon = config.getString(key + KeySuffix.ICON);
    if (StringUtils.isEmpty(icon)) {
      icon = null;
    }
    logger.debug("Find the icon for {}: {}", key, icon);
    return icon;
  }

  /**
   * Displays an error message dialog indicating that the specified function has
   * not been implemented yet.
   *
   * @param key the key of the action.
   */
  public void displayUnimplementedError(String key) {
    final String title = this.getMessage("message.error");
    final String message = this.getMessage("message.error.unimplemented-function") + ": " + key;
    MessageDialog.openError(mainWindow.getShell(), title, message);
  }

  /**
   * Gets the action manager of this application.
   *
   * @return the action manager of this application.
   */
  public ActionManager getActionManager() {
    return actionManager;
  }

  /**
   * Gets the internal state of this application.
   *
   * @return the internal state of this application.
   */
  public ApplicationState getState() {
    return state;
  }

  /**
   * Gets the main window of this application.
   *
   * @return the main window of this application.
   */
  public MainWindow getMainWindow() {
    return mainWindow;
  }

  /**
   * Launch the application.
   *
   * @param args
   *   The command line arguments.
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    final Application app = new Application();
    try {
      app.run();
    } catch (final Throwable t) {
      t.printStackTrace();
    }
  }
}
