/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.utils;

import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides resources related utilities.
 *
 * @author Haixing Hu
 */
public class ResourceUtils {

  private static final Logger LOGGER = LoggerFactory.getLogger(ResourceUtils.class);

  private static final String GETTING_CONTEXT_RESOURCE = "Getting resource {} using context class loader ...";

  private static final String GETTING_SYSTEM_RESOURCE  = "Getting resource {} using system class loader ...";

  private static final String GETTING_CLASS_RESOURCE   = "Getting resource {} using specified class loader ...";

  private static final String RESOURCE_URL_IS          = "The URL of the resource {} is: {}";

  /**
   * Gets the URL of a resource.
   *
   * @param resource
   *          the path of the resource.
   * @return the URL of the resource.
   */
  public static URL getResource(final String resource) {
    LOGGER.debug(GETTING_CONTEXT_RESOURCE, resource);
    final ClassLoader loader = Thread.currentThread().getContextClassLoader();
    URL url = loader.getResource(resource);
    if (url == null) {
      LOGGER.debug(GETTING_SYSTEM_RESOURCE, resource);
      url = ClassLoader.getSystemResource(resource);
      if (url == null) {
        LOGGER.error("Failed to get the resource: {}", resource);
        return null;
      }
    }
    LOGGER.debug(RESOURCE_URL_IS, resource, url);
    return url;
  }

  /**
   * Gets the URL of a resource from a class's class loader.
   *
   * @param resource
   *          the path of the resource.
   * @param clazz
   *          a class.
   * @return the URL of the resource.
   */
  public static URL getResource(final String resource, final Class<?> clazz) {
    LOGGER.debug(GETTING_CLASS_RESOURCE, resource);
    URL url = clazz.getResource(resource);
    if (url == null) {
      LOGGER.debug(GETTING_CONTEXT_RESOURCE, resource);
      final ClassLoader loader = Thread.currentThread().getContextClassLoader();
      url = loader.getResource(resource);
      if (url == null) {
        LOGGER.debug(GETTING_SYSTEM_RESOURCE, resource);
        url = ClassLoader.getSystemResource(resource);
      }
    }
    LOGGER.debug(RESOURCE_URL_IS, resource, url);
    return url;
  }

  /**
   * Gets the URL of a resource from a class loader.
   *
   * @param resource
   *          the path of the resource.
   * @param loader
   *          a class loader.
   * @return the URL of the resource.
   */
  public static URL getResource(final String resource, final ClassLoader loader) {
    LOGGER.debug(GETTING_CLASS_RESOURCE, resource);
    URL url = loader.getResource(resource);
    if (url == null) {
      LOGGER.debug(GETTING_CONTEXT_RESOURCE, resource);
      final Thread current = Thread.currentThread();
      final ClassLoader contextLoader = current.getContextClassLoader();
      url = contextLoader.getResource(resource);
      if (url == null) {
        LOGGER.debug(GETTING_SYSTEM_RESOURCE, resource);
        url = ClassLoader.getSystemResource(resource);
      }
    }
    LOGGER.debug(RESOURCE_URL_IS, resource, url);
    return url;
  }

}
