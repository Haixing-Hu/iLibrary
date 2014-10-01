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
package com.github.haixing_hu.ilibrary.gui2;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application2;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.StyleClass;
import com.github.haixing_hu.ilibrary.state.Page;
import com.github.haixing_hu.lang.EnumUtils;

/**
 * The navigator panel.
 *
 * @author Haixing Hu
 */
public class NavigatorPanel extends VBox implements KeySuffix {

  public static final String STYLE_CLASS = "navigator-panel";

  public static final String HIDE_NAVIGATOR_BUTTON_ID = "button-hide-navigator";

  public static final String ADD_BUTTON_ID = "button-add";

  public static final String MANAGE_BUTTON_ID = "button-manage";

  public NavigatorPanel(final Application2 application, Page page, TreeView<String> tree) {
    super();
    final Logger logger = LoggerFactory.getLogger(NavigatorPanel.class);
    logger.trace("Craeting {}", NavigatorPanel.class);
    getStyleClass().add(STYLE_CLASS);
    logger.trace("Creating navigator header.");
    createHeader(application, page);
    logger.trace("Setting navigator tree.");
    setTreeView(application, page, tree);
    logger.trace("Creating navigator footer.");
    createFooter(application, page);
  }

  private void createHeader(Application2 application, Page page) {
    final AppConfig config = application.getConfig();
    final String pageId = EnumUtils.getShortName(page);
    final HBox header = new HBox();
    header.getStyleClass().addAll(StyleClass.HEADER, StyleClass.TOOLBAR,
        StyleClass.ALIGN_CENTER_LEFT);
    final Label pageTitle = new Label(config.getMessage(pageId + TITLE));
    pageTitle.getStyleClass().addAll(StyleClass.TITLE, StyleClass.PAGE_TITLE);
    header.getChildren().add(pageTitle);
    VBox.setVgrow(header, Priority.NEVER);
    getChildren().add(header);
  }

  private void setTreeView(Application2 application, Page page, TreeView<String> tree) {
    tree.getStyleClass().add(StyleClass.TREE_VIEW);
    VBox.setVgrow(tree, Priority.ALWAYS);
    getChildren().add(tree);
  }

  private void createFooter(Application2 application, Page page) {
    final HBox footer = new HBox();
    footer.getStyleClass().addAll(StyleClass.FOOTER);
    VBox.setVgrow(footer, Priority.NEVER);
    getChildren().add(footer);

    final HBox footerLeft = new HBox();
    footerLeft.getStyleClass().addAll(StyleClass.TOOLBAR,
        StyleClass.ALIGN_CENTER_LEFT);
    HBox.setHgrow(footerLeft, Priority.ALWAYS);
    footer.getChildren().add(footerLeft);

    final Button addButton = new Button();
    addButton.setId(ADD_BUTTON_ID);
    footerLeft.getChildren().add(addButton);

    final Button manageButton = new Button();
    manageButton.setId(MANAGE_BUTTON_ID);
    footerLeft.getChildren().add(manageButton);

    final HBox footerRight = new HBox();
    footerRight.getStyleClass().addAll(StyleClass.TOOLBAR,
        StyleClass.ALIGN_CENTER_RIGHT);
    HBox.setHgrow(footerRight, Priority.NEVER);
    footer.getChildren().add(footerRight);

    final Button hideNavigatorButton = new Button();
    hideNavigatorButton.setId(HIDE_NAVIGATOR_BUTTON_ID);
    footerRight.getChildren().add(hideNavigatorButton);
  }
}
