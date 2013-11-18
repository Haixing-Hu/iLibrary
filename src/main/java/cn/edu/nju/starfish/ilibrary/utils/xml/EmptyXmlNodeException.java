/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.utils.xml;

/**
 * Thrown when a XML node is empty.
 *
 * @author Haixing Hu
 */
public class EmptyXmlNodeException extends XmlException {

  private static final long serialVersionUID = - 1959147058166324842L;

  private final String tagName;

  public EmptyXmlNodeException(String tagName) {
    super(formatMessage(tagName));
    this.tagName = tagName;
  }

  public EmptyXmlNodeException(String tagName, String message) {
    super(formatMessage(tagName) + message);
    this.tagName = tagName;
  }

  public String getTagName() {
    return tagName;
  }

  public static String formatMessage(String tagName) {
    return "The node <" + tagName + "> should not be empty. ";
  }
}
