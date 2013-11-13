/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

/**
 * Provides XML utility functions.
 *
 * @author Haixing Hu
 */
public class XmlUtils {

  private static final Logger LOGGER = LoggerFactory.getLogger(XmlUtils.class);

  /**
   * Gets a DOM document for an XML file.
   *
   * @param resource
   *          the resource path of an XML file.
   * @return the DOM document for the XML file.
   */
  public static Document getDocument(String resource) {
    final URL url = XmlUtils.class.getResource(resource);
    if (url == null) {
      LOGGER.error("Failed to load the XML file from the resource: {}", url);
      return null;
    }
    InputStream stream = null;
    try {
      final DocumentBuilderFactory factory = DocumentBuilderFactory
          .newInstance();
      final DocumentBuilder builder = factory.newDocumentBuilder();
      stream = url.openStream();
      return builder.parse(stream);
    } catch (final Exception e) {
      LOGGER.error("Failed to load the XML file from the resource: {}", url, e);
      return null;
    } finally {
      if (stream != null) {
        try {
          stream.close();
        } catch (final IOException e) {
          LOGGER.error("Closing stream filed: {}", e);
        }
      }
    }
  }
}
