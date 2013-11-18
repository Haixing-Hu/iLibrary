/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.utils.xml;

/**
 * Thrown when an invalid XML node is encountered.
 *
 * @author Haixing Hu
 */
public class InvalidXmlNodeException extends XmlException {

  private static final long serialVersionUID = - 4918264574112298527L;

  private final String expected;
  private final String actual;

  public InvalidXmlNodeException(final String expected) {
    super(formatMessage(expected));
    this.expected = expected;
    this.actual = null;
  }

  public InvalidXmlNodeException(final String expected, final String actual) {
    super(formatMessage(expected, actual));
    this.expected = expected;
    this.actual = actual;
  }

  public InvalidXmlNodeException(final String expected, final String actual, final String message) {
    super(formatMessage(expected, actual) + message);
    this.expected = expected;
    this.actual = actual;
  }

  public String getExpcectedTagName() {
    return expected;
  }

  public String getActualTagName() {
    return actual;
  }

  public static String formatMessage(final String expected) {
    return "Expected node <" + expected + ">. ";
  }

  public static String formatMessage(final String expected, final String actual) {
    return "Expected node <" + expected
        + "> but the actual node is <" + actual + ">. ";
  }
}
