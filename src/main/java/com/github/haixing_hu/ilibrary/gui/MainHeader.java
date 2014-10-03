/*
 * Copyright (C) 2014 Haixing Hu
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
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
