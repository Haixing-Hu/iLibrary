/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.utils.xml;

/**
 * Thrown when an error occurs while parsing an XML document.
 *
 * @author Haixing Hu
 */
public class XmlException extends Exception {

  private static final long serialVersionUID = -4430241858376962527L;

  public XmlException() {
    super();
  }

  public XmlException(String message) {
    super(message);
  }

  public XmlException(Throwable e) {
    super(e);
  }

  public XmlException(String message, Throwable e) {
    super(message, e);
  }
}
