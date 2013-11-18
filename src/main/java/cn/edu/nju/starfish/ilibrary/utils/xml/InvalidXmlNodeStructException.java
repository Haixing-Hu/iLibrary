/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.utils.xml;

import org.w3c.dom.Node;

/**
 * Thrown when an XML node has invalid structure.
 *
 * @author Haixing Hu
 */
public class InvalidXmlNodeStructException extends XmlException {

  private static final long serialVersionUID = 5339788239653270934L;

  private final Node node;

  public InvalidXmlNodeStructException(final Node node) {
    super(formatMessage(node));
    this.node = node;
  }

  public InvalidXmlNodeStructException(final Node node, final String message) {
    super(formatMessage(node) + message);
    this.node = node;
  }

  public Node getNode() {
    return node;
  }

  public static String formatMessage(final Node node) {
    return "Invalid XML node structure. The actual XML node is:\n"
        + XmlUtils.toString(node);
  }

}
