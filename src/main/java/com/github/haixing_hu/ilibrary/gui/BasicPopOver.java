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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.javafx.control.popover.PopOver;

/**
 * The base class for pop over windows.
 *
 * @author Haixing Hu
 */
public abstract class BasicPopOver extends PopOver {

  protected final Logger logger;
  protected final Application application;

  public BasicPopOver(Application application) {
    super();
    logger = LoggerFactory.getLogger(getClass());
    this.application = application;
    setDetachable(false);
    setAutoHide(true);
    setAutoFix(true);
    setHideOnEscape(true);
    setConsumeAutoHidingEvents(false);
    final Node contentNode = createContent();
    setContentNode(contentNode);
  }

  /**
   * Creates the content node.
   *
   * @return the content node for this pop over window.
   */
  protected abstract Node createContent();
}
