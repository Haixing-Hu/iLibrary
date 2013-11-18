/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.utils.xml;

/**
 * Thrown when a required XML attribute is empty.
 *
 * @author Haixing Hu
 */
public class EmptyXmlAttributeException extends XmlException {

  private static final long serialVersionUID = - 4714885273534110209L;
  private final String tagName;
  private final String attributeName;

  public EmptyXmlAttributeException(String tagName, String attributeName) {
    super(formatMessage(tagName, attributeName));
    this.tagName = tagName;
    this.attributeName = attributeName;
  }

  public EmptyXmlAttributeException(String tagName, String attributeName, String message) {
    super(formatMessage(tagName, attributeName) + message);
    this.tagName = tagName;
    this.attributeName = attributeName;
  }

  public String getTagName() {
    return tagName;
  }

  public String getAttributeName() {
    return attributeName;
  }

  public static String formatMessage(String tagName, String attributeName) {
    return "The XML attribute '"
      + attributeName
      + "' of the node <"
      + tagName
      + "> should not be empty. ";
  }
}
