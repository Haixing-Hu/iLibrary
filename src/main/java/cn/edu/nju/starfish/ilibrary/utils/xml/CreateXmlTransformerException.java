/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.utils.xml;

/**
 * Thrown to indicate an error occurred while creating the XML transformer.
 *
 * @author Haixing Hu
 */
public class CreateXmlTransformerException extends XmlException {

  private static final long serialVersionUID = 3650270261620726147L;

  private static final String MESSAGE_CREATE_TRANSFORMER_FAILED =
    "An error occurs while creating the XML transformer. ";

  public CreateXmlTransformerException() {
    super(MESSAGE_CREATE_TRANSFORMER_FAILED);
  }

  public CreateXmlTransformerException(String message) {
    super(message);
  }

  public CreateXmlTransformerException(Throwable e) {
    super(MESSAGE_CREATE_TRANSFORMER_FAILED + e, e);
  }

  public CreateXmlTransformerException(String message, Throwable e) {
    super(message, e);
  }
}
