/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.utils.xml;

/**
 * Thrown to indicate an XML serialization error.
 *
 * @author Haixing Hu
 */
public class XmlSerializationException extends XmlException {

  private static final long serialVersionUID = 5384515309927497843L;

  public XmlSerializationException() {
    super();
  }

  public XmlSerializationException(final String message) {
    super(message);
  }

  public XmlSerializationException(final Throwable e) {
    super(e);
  }

  public XmlSerializationException(final String message, final Throwable e) {
    super(message, e);
  }
}
