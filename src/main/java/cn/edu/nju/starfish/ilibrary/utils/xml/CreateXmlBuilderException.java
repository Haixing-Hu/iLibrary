/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.utils.xml;

/**
 * Thrown to indicate an error occurred while creating the XML document builder.
 *
 * @author Haixing Hu
 */
public class CreateXmlBuilderException extends XmlException {

  private static final long serialVersionUID = 7422489284067686642L;

  private static final String MESSAGE_CREATE_BUILDER_FAILED =
    "An error occurs while creating the XML document builder. ";

  public CreateXmlBuilderException() {
    super(MESSAGE_CREATE_BUILDER_FAILED);
  }

  public CreateXmlBuilderException(String message) {
    super(message);
  }

  public CreateXmlBuilderException(Throwable e) {
    super(MESSAGE_CREATE_BUILDER_FAILED + e, e);
  }

  public CreateXmlBuilderException(String message, Throwable e) {
    super(message, e);
  }
}
