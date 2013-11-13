/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.navigator;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

/**
 * The model of nodes in the navigator tree.
 *
 * @author Haixing Hu
 */
public final class NavigatorTreeNode {

  public static final String KEY = NavigatorTree.KEY + ".node"; //  "window.navigator.tree.node"

  public static final String ROOT_NAME = "navigator";

  public static final String COLLECTIONS_KEY = ROOT_NAME + ".collections";

  public static final String SMART_ATTRIBUTE = "smart";

  private static final Logger LOGGER =
      LoggerFactory.getLogger(NavigatorTreeNode.class);

  private final String key;
  private final boolean smart;
  private final Element domElement;
  private final NavigatorTreeNode parent;
  private final List<NavigatorTreeNode> children;

  public NavigatorTreeNode(Element domElement, @Nullable NavigatorTreeNode parent) {
    this.domElement = domElement;
    final String attr = domElement.getAttribute(SMART_ATTRIBUTE);
    this.smart = Boolean.TRUE.toString().equalsIgnoreCase(attr);
    this.parent = parent;
    this.children = new LinkedList<NavigatorTreeNode>();
    if (parent == null) {
      this.key = ROOT_NAME + "." + domElement.getNodeName();
    } else {
      this.key = parent.getKey() + "." + domElement.getNodeName();
      parent.getChildren().add(this);
    }
    LOGGER.debug("Build a NavigatorTreeNode with key: {}", this.key);
  }

  /**
   * Gets the key.
   *
   * @return the key.
   */
  public String getKey() {
    return key;
  }

  /**
   * Gets the smart.
   *
   * @return the smart.
   */
  public boolean isSmart() {
    return smart;
  }

  /**
   * Gets the DOM element.
   *
   * @return the DOM element.
   */
  public Element getDomElement() {
    return domElement;
  }

  /**
   * Gets the parent.
   *
   * @return the parent.
   */
  public NavigatorTreeNode getParent() {
    return parent;
  }

  /**
   * Gets the children.
   *
   * @return the children.
   */
  public List<NavigatorTreeNode> getChildren() {
    return children;
  }
}
