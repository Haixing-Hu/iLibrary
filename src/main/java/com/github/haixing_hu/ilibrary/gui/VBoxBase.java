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
import javafx.scene.layout.VBox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.Application;

/**
 * The base class for subclass of {@link VBox}.
 *
 * @author Haixing Hu
 */
public class VBoxBase extends VBox implements NodeLookup {

  protected final Logger logger;
  protected final Application application;

  public VBoxBase(Application application) {
    logger = LoggerFactory.getLogger(getClass());
    this.application = application;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends Node> T findNodeById(String nodeId) {
    return (T) lookup('#' + nodeId);
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends Node> T findNodeByClass(String nodeClass) {
    return (T) lookup('.' + nodeClass);
  }
}
