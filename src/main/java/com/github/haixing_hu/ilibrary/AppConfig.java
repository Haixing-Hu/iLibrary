/******************************************************************************
 *
 * Copyright (c) 2014  Haixing Hu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package com.github.haixing_hu.ilibrary;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import com.github.haixing_hu.swt.utils.SWTResourceManager;

import static com.github.haixing_hu.ilibrary.KeySuffix.*;

/**
 * The global configuration of the application.
 *
 * @author Haixing Hu
 */
public final class AppConfig implements ApplicationContext, Configuration {

  private final Logger logger;
  private final ApplicationContext context;
  private final Configuration config;
  private final Locale locale;
  private final String name;
  private final String version;
  private final Color heavyFontColor;
  private final Color lightFontColor;

  /**
   * Constructs a {@link AppConfig}.
   */
  public AppConfig(String contexFile) {
    logger = LoggerFactory.getLogger(AppConfig.class);
    context = new ClassPathXmlApplicationContext(contexFile);
    config = context.getBean(Configuration.class);
    final String localeName = config.getString(Application.KEY + LOCALE);
    if (StringUtils.isEmpty(localeName)) {
      locale = Locale.getDefault();
    } else {
      locale = new Locale(localeName);
    }
    name = context.getMessage(Application.KEY + NAME, null, locale);
    version = config.getString(Application.KEY + VERSION);
    heavyFontColor = getColor(Application.KEY + FONT + HEAVY + COLOR);
    lightFontColor = getColor(Application.KEY + FONT + LIGHT + COLOR);
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
  public String getAppName() {
    return name;
  }

  /**
   * Gets the version of the application.
   *
   * @return the version of the application.
   */
  public String getAppVersion() {
    return version;
  }

  /**
   * Gets the heavyFontColor.
   *
   * @return the heavyFontColor.
   */
  public Color getHeavyFontColor() {
    return heavyFontColor;
  }

  /**
   * Gets the lightFontColor.
   *
   * @return the lightFontColor.
   */
  public Color getLightFontColor() {
    return lightFontColor;
  }

  @Override
  public Environment getEnvironment() {
    return context.getEnvironment();
  }

  @Override
  public boolean containsBeanDefinition(String beanName) {
    return context.containsBeanDefinition(beanName);
  }

  @Override
  public <A extends Annotation> A findAnnotationOnBean(String beanName,
      Class<A> annotationType) {
    return context.findAnnotationOnBean(beanName, annotationType);
  }

  @Override
  public int getBeanDefinitionCount() {
    return context.getBeanDefinitionCount();
  }

  @Override
  public String[] getBeanDefinitionNames() {
    return context.getBeanDefinitionNames();
  }

  @Override
  public String[] getBeanNamesForType(Class<?> type) {
    return context.getBeanNamesForType(type);
  }

  @Override
  public String[] getBeanNamesForType(Class<?> type,
      boolean includeNonSingletons, boolean allowEagerInit) {
    return context.getBeanNamesForType(type, includeNonSingletons,
        allowEagerInit);
  }

  @Override
  public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
    return context.getBeansOfType(type);
  }

  @Override
  public <T> Map<String, T> getBeansOfType(Class<T> type,
      boolean includeNonSingletons, boolean allowEagerInit)
      throws BeansException {
    return context.getBeansOfType(type, includeNonSingletons, allowEagerInit);
  }

  @Override
  public Map<String, Object> getBeansWithAnnotation(
      Class<? extends Annotation> annotationType) throws BeansException {
    return context.getBeansWithAnnotation(annotationType);
  }

  @Override
  public boolean containsBean(String name) {
    return context.containsBean(name);
  }

  @Override
  public String[] getAliases(String name) {
    return context.getAliases(name);
  }

  @Override
  public Object getBean(String name) throws BeansException {
    return context.getBean(name);
  }

  @Override
  public <T> T getBean(Class<T> requiredType) throws BeansException {
    return context.getBean(requiredType);
  }

  @Override
  public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
    return context.getBean(name, requiredType);
  }

  @Override
  public Object getBean(String name, Object... args) throws BeansException {
    return context.getBean(name, args);
  }

  @Override
  public Class<?> getType(String name) throws NoSuchBeanDefinitionException {
    return context.getType(name);
  }

  @Override
  public boolean isPrototype(String name) throws NoSuchBeanDefinitionException {
    return context.isPrototype(name);
  }

  @Override
  public boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
    return context.isSingleton(name);
  }

  @Override
  public boolean isTypeMatch(String name, Class<?> targetType)
      throws NoSuchBeanDefinitionException {
    return context.isTypeMatch(name, targetType);
  }

  @Override
  public boolean containsLocalBean(String name) {
    return context.containsLocalBean(name);
  }

  @Override
  public BeanFactory getParentBeanFactory() {
    return context.getParentBeanFactory();
  }

  @Override
  public String getMessage(String key, Object[] args, String defaultMessage,
      Locale locale) {
    logger.debug("Getting message: {}", key);
    return context.getMessage(key, args, defaultMessage, locale);
  }

  @Override
  public String getMessage(String key, Object[] args, Locale locale)
      throws NoSuchMessageException {
    logger.debug("Getting message: {}", key);
    return context.getMessage(key, args, locale);
  }

  @Override
  public String getMessage(MessageSourceResolvable resolvable, Locale locale)
      throws NoSuchMessageException {
    return context.getMessage(resolvable, locale);
  }

  /**
   * Gets the localized message for a specified key.
   *
   * @param key
   *          the key of the message.
   * @return the localized message for the specified key.
   */
  public String getMessage(String key) {
    logger.debug("Getting message: {}", key);
    return context.getMessage(key, null, locale);
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
    logger.debug("Getting message: {}", key);
    return context.getMessage(key, args, locale);
  }

  /**
   * Gets the title associated with a specified action.
   *
   * @param key
   *          The key of the specified action.
   * @return The title associated with the specified action.
   */
  public String getTitle(String key) {
    logger.debug("Getting title: {}", key);
    key += KeySuffix.TITLE;
    final String title = context.getMessage(key, null, "", locale);
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
    logger.debug("Getting shortcut: {}", key);
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
    logger.debug("Getting description: {}", key);
    String description = context.getMessage(key + KeySuffix.DESCRIPTION,
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
   * @return the URL of the icon the specified action, or null if it has none.
   */
  public String getIcon(String key) {
    logger.debug("Getting icon: {}", key);
    String icon = config.getString(key + KeySuffix.ICON);
    if (StringUtils.isEmpty(icon)) {
      icon = null;
    }
    logger.debug("Find the icon for {}: {}", key, icon);
    return icon;
  }

  /**
   * Gets the URL of the active icon of an action.
   *
   * @param key
   *          the key of a specified action.
   * @return the URL of the active icon the specified action, or null if it has none.
   */
  public String getActiveIcon(String key) {
    logger.debug("Getting active icon: {}", key);
    String icon = config.getString(key + KeySuffix.ICON + KeySuffix.ACTIVE);
    if (StringUtils.isEmpty(icon)) {
      icon = null;
    }
    logger.debug("Find the active icon for {}: {}", key, icon);
    return icon;
  }

  @Override
  public void publishEvent(ApplicationEvent event) {
    context.publishEvent(event);
  }

  @Override
  public Resource[] getResources(String locationPattern) throws IOException {
    return context.getResources(locationPattern);
  }

  @Override
  public Resource getResource(String location) {
    return context.getResource(location);
  }

  @Override
  public ClassLoader getClassLoader() {
    return context.getClassLoader();
  }

  @Override
  public String getId() {
    return context.getId();
  }

  @Override
  public String getDisplayName() {
    return context.getDisplayName();
  }

  @Override
  public long getStartupDate() {
    return context.getStartupDate();
  }

  @Override
  public ApplicationContext getParent() {
    return context.getParent();
  }

  @Override
  public AutowireCapableBeanFactory getAutowireCapableBeanFactory()
      throws IllegalStateException {
    return context.getAutowireCapableBeanFactory();
  }

  @Override
  public Configuration subset(String prefix) {
    return config.subset(prefix);
  }

  @Override
  public boolean isEmpty() {
    return config.isEmpty();
  }

  @Override
  public boolean containsKey(String key) {
    return config.containsKey(key);
  }

  @Override
  public void addProperty(String key, Object value) {
    config.addProperty(key, value);
  }

  @Override
  public void setProperty(String key, Object value) {
    config.setProperty(key, value);
  }

  @Override
  public void clearProperty(String key) {
    config.clearProperty(key);
  }

  @Override
  public void clear() {
    config.clear();
  }

  @Override
  public Object getProperty(String key) {
    return config.getProperties(key);
  }

  @Override
  public Iterator<String> getKeys(String prefix) {
    return config.getKeys(prefix);
  }

  @Override
  public Iterator<String> getKeys() {
    return config.getKeys();
  }

  @Override
  public Properties getProperties(String key) {
    logger.debug("Getting properties: {}", key);
    return config.getProperties(key);
  }

  @Override
  public boolean getBoolean(String key) {
    logger.debug("Getting boolean: {}", key);
    return config.getBoolean(key);
  }

  @Override
  public boolean getBoolean(String key, boolean defaultValue) {
    logger.debug("Getting boolean: {}", key);
    return config.getBoolean(key, defaultValue);
  }

  @Override
  public Boolean getBoolean(String key, Boolean defaultValue) {
    logger.debug("Getting boolean: {}", key);
    return config.getBoolean(key, defaultValue);
  }

  @Override
  public byte getByte(String key) {
    logger.debug("Getting byte: {}", key);
    return config.getByte(key);
  }

  @Override
  public byte getByte(String key, byte defaultValue) {
    logger.debug("Getting byte: {}", key);
    return config.getByte(key, defaultValue);
  }

  @Override
  public Byte getByte(String key, Byte defaultValue) {
    logger.debug("Getting byte: {}", key);
    return config.getByte(key, defaultValue);
  }

  @Override
  public double getDouble(String key) {
    logger.debug("Getting double: {}", key);
    return config.getDouble(key);
  }

  @Override
  public double getDouble(String key, double defaultValue) {
    logger.debug("Getting double: {}", key);
    return config.getDouble(key, defaultValue);
  }

  @Override
  public Double getDouble(String key, Double defaultValue) {
    logger.debug("Getting double: {}", key);
    return config.getDouble(key, defaultValue);
  }

  @Override
  public float getFloat(String key) {
    logger.debug("Getting float: {}", key);
    return config.getFloat(key);
  }

  @Override
  public float getFloat(String key, float defaultValue) {
    logger.debug("Getting float: {}", key);
    return config.getFloat(key, defaultValue);
  }

  @Override
  public Float getFloat(String key, Float defaultValue) {
    logger.debug("Getting float: {}", key);
    return config.getFloat(key, defaultValue);
  }

  @Override
  public int getInt(String key) {
    logger.debug("Getting int: {}", key);
    return config.getInt(key);
  }

  @Override
  public int getInt(String key, int defaultValue) {
    logger.debug("Getting int: {}", key);
    return config.getInt(key, defaultValue);
  }

  @Override
  public Integer getInteger(String key, Integer defaultValue) {
    logger.debug("Getting integer: {}", key);
    return config.getInteger(key, defaultValue);
  }

  @Override
  public long getLong(String key) {
    logger.debug("Getting long: {}", key);
    return config.getLong(key);
  }

  @Override
  public long getLong(String key, long defaultValue) {
    logger.debug("Getting long: {}", key);
    return config.getLong(key, defaultValue);
  }

  @Override
  public Long getLong(String key, Long defaultValue) {
    logger.debug("Getting long: {}", key);
    return config.getLong(key, defaultValue);
  }

  @Override
  public short getShort(String key) {
    logger.debug("Getting short: {}", key);
    return config.getShort(key);
  }

  @Override
  public short getShort(String key, short defaultValue) {
    logger.debug("Getting short: {}", key);
    return config.getShort(key, defaultValue);
  }

  @Override
  public Short getShort(String key, Short defaultValue) {
    logger.debug("Getting short: {}", key);
    return config.getShort(key, defaultValue);
  }

  @Override
  public BigDecimal getBigDecimal(String key) {
    logger.debug("Getting big decimal: {}", key);
    return config.getBigDecimal(key);
  }

  @Override
  public BigDecimal getBigDecimal(String key, BigDecimal defaultValue) {
    logger.debug("Getting big decimal: {}", key);
    return config.getBigDecimal(key, defaultValue);
  }

  @Override
  public BigInteger getBigInteger(String key) {
    logger.debug("Getting big integer: {}", key);
    return config.getBigInteger(key);
  }

  @Override
  public BigInteger getBigInteger(String key, BigInteger defaultValue) {
    logger.debug("Getting big integer: {}", key);
    return config.getBigInteger(key, defaultValue);
  }

  @Override
  public String getString(String key) {
    logger.debug("Getting string: {}", key);
    return config.getString(key);
  }

  @Override
  public String getString(String key, String defaultValue) {
    logger.debug("Getting string: {}", key);
    return config.getString(key, defaultValue);
  }

  @Override
  public String[] getStringArray(String key) {
    logger.debug("Getting string array: {}", key);
    return config.getStringArray(key);
  }

  @Override
  public List<Object> getList(String key) {
    logger.debug("Getting list: {}", key);
    return config.getList(key);
  }

  @Override
  public List<Object> getList(String key, List<?> defaultValue) {
    logger.debug("Getting list: {}", key);
    return config.getList(key, defaultValue);
  }

  /**
   * Gets the color specified by a key.
   *
   * @param key
   *          the key.
   * @return the color specified by the key. The color must be specified in the
   *         RGB form "#aabbcc". If there is no value corresponding to the
   *         specified key, returns null.
   */
  public Color getColor(String key) {
    final String rgb = getString(key, null);
    if (rgb == null) {
      return null;
    } else {
      return SWTResourceManager.getColor(rgb);
    }
  }

  /**
   * Gets the image specified by a key.
   *
   * @param key
   *          the key.
   * @return the image specified by the key. The image must be specified as
   *         the path of a resource. If there is no value corresponding to the
   *         specified key, returns null.
   */
  public Image getImage(Class<?> cls, String key) {
    final String url = getString(key, null);
    if (url == null) {
      return null;
    } else {
      return SWTResourceManager.getImage(cls, url);
    }
  }
}
