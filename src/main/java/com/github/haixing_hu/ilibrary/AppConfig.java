/*
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
 */
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
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
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


/**
 * The global configuration of the application.
 *
 * @author Haixing Hu
 */
public final class AppConfig implements ApplicationContext,
      Configuration, KeySuffix {

  private final Logger logger;
  private final ApplicationContext context;
  private final Configuration config;
  private final Locale locale;
  private final String name;
  private final String version;
  private final String stylesheet;

  /**
   * Constructs a {@link AppConfig}.
   */
  public AppConfig(final String contexFile) {
    logger = LoggerFactory.getLogger(AppConfig.class);
    context = new ClassPathXmlApplicationContext(contexFile);
    config = context.getBean(Configuration.class);
    final String localeName = config.getString(Application.ID + LOCALE);
    if (StringUtils.isEmpty(localeName)) {
      locale = Locale.getDefault();
    } else {
      locale = new Locale(localeName);
    }
    name = context.getMessage(Application.ID + NAME, null, locale);
    version = config.getString(Application.ID + VERSION);
    final String css = config.getString(Application.ID + STYLE);
    stylesheet = this.getClass().getResource(css).toExternalForm();

    logger.info("{} {}", name, version);
    logger.info("Sets the locale to {}.", locale);
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
   * Gets the path of the stylesheet of this application.
   *
   * @return the path of the stylesheet of this application.
   */
  public String getStylesheet() {
    return stylesheet;
  }

  @Override
  public Environment getEnvironment() {
    return context.getEnvironment();
  }

  @Override
  public boolean containsBeanDefinition(final String beanName) {
    return context.containsBeanDefinition(beanName);
  }

  @Override
  public <A extends Annotation> A findAnnotationOnBean(final String beanName,
      final Class<A> annotationType) {
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
  public String[] getBeanNamesForType(final Class<?> type) {
    return context.getBeanNamesForType(type);
  }

  @Override
  public String[] getBeanNamesForType(final Class<?> type,
      final boolean includeNonSingletons, final boolean allowEagerInit) {
    return context.getBeanNamesForType(type, includeNonSingletons,
        allowEagerInit);
  }

  @Override
  public <T> Map<String, T> getBeansOfType(final Class<T> type) throws BeansException {
    return context.getBeansOfType(type);
  }

  @Override
  public <T> Map<String, T> getBeansOfType(final Class<T> type,
      final boolean includeNonSingletons, final boolean allowEagerInit)
      throws BeansException {
    return context.getBeansOfType(type, includeNonSingletons, allowEagerInit);
  }

  @Override
  public Map<String, Object> getBeansWithAnnotation(
      final Class<? extends Annotation> annotationType) throws BeansException {
    return context.getBeansWithAnnotation(annotationType);
  }

  @Override
  public boolean containsBean(final String name) {
    return context.containsBean(name);
  }

  @Override
  public String[] getAliases(final String name) {
    return context.getAliases(name);
  }

  @Override
  public Object getBean(final String name) throws BeansException {
    return context.getBean(name);
  }

  @Override
  public <T> T getBean(final Class<T> requiredType) throws BeansException {
    return context.getBean(requiredType);
  }

  @Override
  public <T> T getBean(final String name, final Class<T> requiredType) throws BeansException {
    return context.getBean(name, requiredType);
  }

  @Override
  public Object getBean(final String name, final Object... args) throws BeansException {
    return context.getBean(name, args);
  }

  @Override
  public Class<?> getType(final String name) throws NoSuchBeanDefinitionException {
    return context.getType(name);
  }

  @Override
  public boolean isPrototype(final String name) throws NoSuchBeanDefinitionException {
    return context.isPrototype(name);
  }

  @Override
  public boolean isSingleton(final String name) throws NoSuchBeanDefinitionException {
    return context.isSingleton(name);
  }

  @Override
  public boolean isTypeMatch(final String name, final Class<?> targetType)
      throws NoSuchBeanDefinitionException {
    return context.isTypeMatch(name, targetType);
  }

  @Override
  public boolean containsLocalBean(final String name) {
    return context.containsLocalBean(name);
  }

  @Override
  public BeanFactory getParentBeanFactory() {
    return context.getParentBeanFactory();
  }

  @Override
  public String getMessage(final String key, final Object[] args, final String defaultMessage,
      final Locale locale) {
    return context.getMessage(key, args, defaultMessage, locale);
  }

  @Override
  public String getMessage(final String key, final Object[] args, final Locale locale)
      throws NoSuchMessageException {
    logger.trace("Getting message: {}", key);
    return context.getMessage(key, args, locale);
  }

  @Override
  public String getMessage(final MessageSourceResolvable resolvable, final Locale locale)
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
  public String getMessage(final String key) {
    logger.trace("Getting message: {}", key);
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
  public String getMessage(final String key, final Object... args) {
    logger.trace("Getting message: {}", key);
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
    logger.trace("Getting title: {}", key);
    key += KeySuffix.TITLE;
    final String title = context.getMessage(key, null, "", locale);
    logger.trace("Find the title for {}: {}", key, title);
    return title;
  }

  /**
   * Gets the shortcut associated with a specified action.
   *
   * @param id
   *          The ID of the specified action.
   * @return The shortcut associated with the specified action.
   */
  public String getShortcut(final String id) {
    logger.trace("Getting shortcut: {}", id);
    String shortcut = config.getString(id + KeySuffix.SHORTCUT);
    if (! StringUtils.isEmpty(shortcut)) {
      //  substitute the META key according to the operating system
      final String meta = (SystemUtils.IS_OS_MAC ? "META" : "CTRL");
      shortcut = shortcut.replace("META", meta);
    } else {
      shortcut = null;
    }
    logger.trace("Find the shortcut for {}: {}", id, shortcut);
    return shortcut;
  }

  /**
   * Gets the description of an action.
   *
   * @param id
   *          the ID of a specified action.
   * @return the description the specified action, or null if it has no description.
   */
  public String getDescription(final String id) {
    logger.trace("Getting description: {}", id);
    String description = context.getMessage(id + KeySuffix.DESCRIPTION,
        null, null, locale);
    if (StringUtils.isEmpty(description)) {
      description = null;
    }
    logger.trace("Find the description for {}: {}", id, description);
    return description;
  }

  /**
   * Gets the URL of the icon of an action.
   *
   * @param id
   *          the ID of a specified action.
   * @return the URL of the icon the specified action, or null if it has none.
   */
  public String getIcon(final String id) {
    logger.trace("Getting icon: {}", id);
    String icon = config.getString(id + KeySuffix.ICON);
    if (StringUtils.isEmpty(icon)) {
      icon = null;
    }
    logger.trace("Find the icon for {}: {}", id, icon);
    return icon;
  }

  /**
   * Gets the URL of the active icon of an action.
   *
   * @param id
   *          the ID of a specified action.
   * @return the URL of the active icon the specified action, or null if it has none.
   */
  public String getActiveIcon(final String id) {
    logger.trace("Getting active icon: {}", id);
    String icon = config.getString(id + KeySuffix.ICON + KeySuffix.ACTIVE);
    if (StringUtils.isEmpty(icon)) {
      icon = null;
    }
    logger.trace("Find the active icon for {}: {}", id, icon);
    return icon;
  }

  @Override
  public void publishEvent(final ApplicationEvent event) {
    context.publishEvent(event);
  }

  @Override
  public Resource[] getResources(final String locationPattern) throws IOException {
    return context.getResources(locationPattern);
  }

  @Override
  public Resource getResource(final String location) {
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
  public Configuration subset(final String prefix) {
    return config.subset(prefix);
  }

  @Override
  public boolean isEmpty() {
    return config.isEmpty();
  }

  @Override
  public boolean containsKey(final String key) {
    return config.containsKey(key);
  }

  @Override
  public void addProperty(final String key, final Object value) {
    config.addProperty(key, value);
  }

  @Override
  public void setProperty(final String key, final Object value) {
    config.setProperty(key, value);
  }

  @Override
  public void clearProperty(final String key) {
    config.clearProperty(key);
  }

  @Override
  public void clear() {
    config.clear();
  }

  @Override
  public Object getProperty(final String key) {
    return config.getProperties(key);
  }

  @Override
  public Iterator<String> getKeys(final String prefix) {
    return config.getKeys(prefix);
  }

  @Override
  public Iterator<String> getKeys() {
    return config.getKeys();
  }

  @Override
  public Properties getProperties(final String key) {
    logger.trace("Getting descriptors: {}", key);
    return config.getProperties(key);
  }

  @Override
  public boolean getBoolean(final String key) {
    logger.trace("Getting boolean: {}", key);
    return config.getBoolean(key);
  }

  @Override
  public boolean getBoolean(final String key, final boolean defaultValue) {
    logger.trace("Getting boolean: {}", key);
    return config.getBoolean(key, defaultValue);
  }

  @Override
  public Boolean getBoolean(final String key, final Boolean defaultValue) {
    logger.trace("Getting boolean: {}", key);
    return config.getBoolean(key, defaultValue);
  }

  @Override
  public byte getByte(final String key) {
    logger.trace("Getting byte: {}", key);
    return config.getByte(key);
  }

  @Override
  public byte getByte(final String key, final byte defaultValue) {
    logger.trace("Getting byte: {}", key);
    return config.getByte(key, defaultValue);
  }

  @Override
  public Byte getByte(final String key, final Byte defaultValue) {
    logger.trace("Getting byte: {}", key);
    return config.getByte(key, defaultValue);
  }

  @Override
  public double getDouble(final String key) {
    logger.trace("Getting double: {}", key);
    return config.getDouble(key);
  }

  @Override
  public double getDouble(final String key, final double defaultValue) {
    logger.trace("Getting double: {}", key);
    return config.getDouble(key, defaultValue);
  }

  @Override
  public Double getDouble(final String key, final Double defaultValue) {
    logger.trace("Getting double: {}", key);
    return config.getDouble(key, defaultValue);
  }

  @Override
  public float getFloat(final String key) {
    logger.trace("Getting float: {}", key);
    return config.getFloat(key);
  }

  @Override
  public float getFloat(final String key, final float defaultValue) {
    logger.trace("Getting float: {}", key);
    return config.getFloat(key, defaultValue);
  }

  @Override
  public Float getFloat(final String key, final Float defaultValue) {
    logger.trace("Getting float: {}", key);
    return config.getFloat(key, defaultValue);
  }

  @Override
  public int getInt(final String key) {
    logger.trace("Getting int: {}", key);
    return config.getInt(key);
  }

  @Override
  public int getInt(final String key, final int defaultValue) {
    logger.trace("Getting int: {}", key);
    return config.getInt(key, defaultValue);
  }

  @Override
  public Integer getInteger(final String key, final Integer defaultValue) {
    logger.trace("Getting integer: {}", key);
    return config.getInteger(key, defaultValue);
  }

  @Override
  public long getLong(final String key) {
    logger.trace("Getting long: {}", key);
    return config.getLong(key);
  }

  @Override
  public long getLong(final String key, final long defaultValue) {
    logger.trace("Getting long: {}", key);
    return config.getLong(key, defaultValue);
  }

  @Override
  public Long getLong(final String key, final Long defaultValue) {
    logger.trace("Getting long: {}", key);
    return config.getLong(key, defaultValue);
  }

  @Override
  public short getShort(final String key) {
    logger.trace("Getting short: {}", key);
    return config.getShort(key);
  }

  @Override
  public short getShort(final String key, final short defaultValue) {
    logger.trace("Getting short: {}", key);
    return config.getShort(key, defaultValue);
  }

  @Override
  public Short getShort(final String key, final Short defaultValue) {
    logger.trace("Getting short: {}", key);
    return config.getShort(key, defaultValue);
  }

  @Override
  public BigDecimal getBigDecimal(final String key) {
    logger.trace("Getting big decimal: {}", key);
    return config.getBigDecimal(key);
  }

  @Override
  public BigDecimal getBigDecimal(final String key, final BigDecimal defaultValue) {
    logger.trace("Getting big decimal: {}", key);
    return config.getBigDecimal(key, defaultValue);
  }

  @Override
  public BigInteger getBigInteger(final String key) {
    logger.trace("Getting big integer: {}", key);
    return config.getBigInteger(key);
  }

  @Override
  public BigInteger getBigInteger(final String key, final BigInteger defaultValue) {
    logger.trace("Getting big integer: {}", key);
    return config.getBigInteger(key, defaultValue);
  }

  @Override
  public String getString(final String key) {
    logger.trace("Getting string: {}", key);
    return config.getString(key);
  }

  @Override
  public String getString(final String key, final String defaultValue) {
    logger.trace("Getting string: {}", key);
    return config.getString(key, defaultValue);
  }

  @Override
  public String[] getStringArray(final String key) {
    logger.trace("Getting string array: {}", key);
    return config.getStringArray(key);
  }

  @Override
  public List<Object> getList(final String key) {
    logger.trace("Getting list: {}", key);
    return config.getList(key);
  }

  @Override
  public List<Object> getList(final String key, final List<?> defaultValue) {
    logger.trace("Getting list: {}", key);
    return config.getList(key, defaultValue);
  }

  @Override
  public String[] getBeanNamesForAnnotation(final Class<? extends Annotation> arg0) {
    return context.getBeanNamesForAnnotation(arg0);
  }

  @Override
  public <T> T getBean(final Class<T> arg0, final Object... arg1) throws BeansException {
    return context.getBean(arg0, arg1);
  }

  @Override
  public String getApplicationName() {
    return context.getApplicationName();
  }
}
