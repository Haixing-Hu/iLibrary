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
package com.github.haixing_hu.ilibrary.gui2.navigator;

import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
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

  public NavigatorPanel(final Application2 application, Page page, TreeView<String> tree) {
    super();
    final Logger logger = LoggerFactory.getLogger(NavigatorPanel.class);
    logger.trace("Craeting {}", NavigatorPanel.class);
    getStyleClass().add(STYLE_CLASS);

    final AppConfig config = application.getConfig();
    final String pageId = EnumUtils.getShortName(page);
    final ObservableList<Node> children = this.getChildren();

    logger.trace("Creating navigator header.");
    final HBox header = new HBox();
    header.getStyleClass().addAll(StyleClass.HEADER, StyleClass.TOOLBAR);
    final Label pageTitle = new Label(config.getMessage(pageId + TITLE));
    pageTitle.getStyleClass().addAll(StyleClass.TITLE, StyleClass.PAGE_TITLE);
    header.getChildren().add(pageTitle);
    VBox.setVgrow(header, Priority.NEVER);
    children.add(header);
    final Separator sep1 = new Separator(Orientation.HORIZONTAL);
    sep1.setPrefHeight(1);
    children.add(sep1);


    logger.trace("Setting navigator footer.");
    tree.getStyleClass().add(StyleClass.TREE_VIEW);
    VBox.setVgrow(tree, Priority.ALWAYS);
    children.add(tree);

    final Separator sep2 = new Separator(Orientation.HORIZONTAL);
    sep2.setPrefHeight(1);
    children.add(sep2);
    logger.trace("Creating navigator footer.");
    final HBox footer = new HBox();
    footer.getStyleClass().addAll(StyleClass.FOOTER, StyleClass.TOOLBAR);
    VBox.setVgrow(footer, Priority.NEVER);
    children.add(footer);
  }
}
