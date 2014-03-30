/******************************************************************************
 *
 * Copyright (c) 2013  Haixing Hu
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

package com.github.haixing_hu.ilibrary.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * Provides utilities functions for XML.
 *
 * @author Haixing Hu
 */
public class XmlUtils {

  private static final Logger LOGGER = LoggerFactory.getLogger(XmlUtils.class);

  /**
   * Gets a parsed XML document from a resource.
   *
   * @param resource
   *          a resource to a XML file.
   * @return the parsed XML document of the XML file; or <code>null</code> if
   *         failed.
   */
  public static Document getDocument(String resource) {
    final URL url = ResourceUtils.getResource(resource, XmlUtils.class);
    if (url == null) {
      return null;
    }
    InputStream in = null;
    try {
      in = url.openStream();
      final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      final DocumentBuilder builder = factory.newDocumentBuilder();
      return builder.parse(in);
    } catch (final ParserConfigurationException e) {
      LOGGER.error("Failed to parse the XML document: {}", url, e);
      return null;
    } catch (final SAXException e) {
      LOGGER.error("Failed to parse the XML document: {}", url, e);
      return null;
    } catch (final IOException e) {
      LOGGER.error("Failed to parse the XML document: {}", url, e);
      return null;
    } finally {
      IOUtils.closeQuietly(in);
    }
  }
}
