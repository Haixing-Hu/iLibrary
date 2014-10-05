/******************************************************************************
 *
 * Copyright (c) 2014  Haixing Hu
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Haixing Hu (https://github.com/Haixing-Hu/) - Initial implementation and API.
 *
 ******************************************************************************/

package com.github.haixing_hu.ilibrary.gui;

import javafx.scene.Node;

/**
 * An interface providing a convenient function to look up a node in the tree
 * of the panel.
 *
 * @author Haixing Hu
 */
public interface NodeLookup {

  /**
   * Finds a node by its ID in the tree of this object.
   *
   * @param <T>
   *    the type of returned node.
   * @param nodeId
   *    the ID of the node.
   * @return
   *    the node with the specified ID, or null if no such node.
   */
  public <T extends Node> T findNodeById(String nodeId);

  /**
   * Finds a node by its class in the tree of this object.
   *
   * @param <T>
   *    the type of returned node.
   * @param nodeClass
   *    the class of the node.
   * @return
   *    the node with the specified class, or null if no such node.
   */
  public <T extends Node> T findNodeByClass(String nodeClass);
}
