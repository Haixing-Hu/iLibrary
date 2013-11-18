/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.utils.xml;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URI;
import java.net.URL;

/**
 * Thrown to indicate an error occurred while parsing the XML.
 *
 * @author Haixing Hu
 */
public class XmlParseException extends XmlException {

  private static final long serialVersionUID = - 9037334417781578122L;

  private static final String MESSAGE_PARSING_FAILED = "An error occurs while parsing the XML. ";

  public XmlParseException() {
    super(MESSAGE_PARSING_FAILED);
  }

  public XmlParseException(final String message) {
    super(message);
  }

  public XmlParseException(final File file) {
    super(MESSAGE_PARSING_FAILED + file);
  }

  public XmlParseException(final URL url) {
    super(MESSAGE_PARSING_FAILED + url);
  }

  public XmlParseException(final URI uri) {
    super(MESSAGE_PARSING_FAILED + uri);
  }

  public XmlParseException(final InputStream in) {
    super(MESSAGE_PARSING_FAILED + in);
  }

  public XmlParseException(final Throwable e) {
    super(MESSAGE_PARSING_FAILED + e, e);
  }

  public XmlParseException(final String message, final Throwable e) {
    super(message, e);
  }

  public XmlParseException(final File file, final Throwable e) {
    super(MESSAGE_PARSING_FAILED + file + " " + e, e);
  }

  public XmlParseException(final URL url, final Throwable e) {
    super(MESSAGE_PARSING_FAILED + url + " " + e, e);
  }

  public XmlParseException(final URI uri, final Throwable e) {
    super(MESSAGE_PARSING_FAILED + uri + " " + e, e);
  }

  public XmlParseException(final InputStream in, final Throwable e) {
    super(MESSAGE_PARSING_FAILED + in + " " + e, e);
  }

  public XmlParseException(final Reader reader, final Throwable e) {
    super(MESSAGE_PARSING_FAILED + reader + " " + e, e);
  }

  public XmlParseException(final File file, final String message) {
    super(MESSAGE_PARSING_FAILED + file + " " + message);
  }

  public XmlParseException(final URL url, final String message) {
    super(MESSAGE_PARSING_FAILED + url + " " + message);
  }

  public XmlParseException(final URI uri, final String message) {
    super(MESSAGE_PARSING_FAILED + uri + " " + message);
  }

  public XmlParseException(final InputStream in, final String message) {
    super(MESSAGE_PARSING_FAILED + in + " " + message);
  }
}
