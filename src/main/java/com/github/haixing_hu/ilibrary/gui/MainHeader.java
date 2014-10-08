/******************************************************************************
 *
 * Copyright (c) 2014  Haixing Hu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/
package com.github.haixing_hu.ilibrary.gui;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.state.Page;
import com.github.haixing_hu.javafx.action.ActionManager;

/**
 * The header of the main window. 
 *
 * @author Haixing Hu
 */
public class MainHeader extends HBox implements KeySuffix, NodeLookup {

  public static final String ID = "main-header";

  public static final String TOOLBAR_ID = "main-toolbar";

  private final Logger logger;
  private final ToggleButton buttons[];

  public MainHeader(final Application application) {
    super();
    logger = LoggerFactory.getLogger(MainHeader.class);
    logger.trace("Craeting {}", MainHeader.class);
    setId(ID);
    final ObservableList<Node> children = getChildren();
    final ActionManager am = application.getActionManager();
    final Page[] pages = Page.values();
    buttons = new ToggleButton[pages.length];
    for (int i = 0; i < pages.length; ++i) {
      buttons[i] = (ToggleButton) am.createButton(pages[i].actionId());
      children.add(buttons[i]);
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T extends Node> T findNodeById(String nodeId) {
    return (T) lookup('#' + nodeId);
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends Node> T findNodeByClass(String nodeClass) {
    return (T) lookup('.' + nodeClass);
  }
}
