/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.utils.xml;

/**
 * Thrown to indicate an error occurred while transforming the XML.
 *
 * @author Haixing Hu
 */
public class XmlTransformException extends XmlException {

  private static final long serialVersionUID = 1582261306326363474L;

  private static final String MESSAGE_TRANSFORM_FAILED = "Transforming the XML failed. ";

  public XmlTransformException() {
    super(MESSAGE_TRANSFORM_FAILED);
  }

  public XmlTransformException(String message) {
    super(message);
  }

  public XmlTransformException(Throwable t) {
    super(MESSAGE_TRANSFORM_FAILED + t.getMessage(), t);
  }

  public XmlTransformException(String message, Throwable t) {
    super(message, t);
  }
}
