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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.Application2;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.StyleClass;

/**
 * The inspector panel.
 *
 * @author Haixing Hu
 */
public abstract class InspectorPanel extends VBox implements KeySuffix {

  public static final String STYLE_CLASS = "inspector-panel";

  public static final String OVERVIEW_BUTTON_ID = "button-overview";

  public static final String INFO_BUTTON_ID = "button-info";

  public static final String NOTES_BUTTON_ID = "button-notes";

  public static final String REVIEWS_BUTTON_ID = "button-reviews";

  public static final String HIDE_INCPECTOR_BUTTON_ID = "button-hide-inspector";

  public InspectorPanel(final Application2 application) {
    super();
    final Logger logger = LoggerFactory.getLogger(InspectorPanel.class);
    logger.trace("Craeting {}", InspectorPanel.class);
    getStyleClass().add(STYLE_CLASS);
    logger.trace("Creating inspector header.");
    createHeader(application);
    logger.trace("Setting inspector tree.");
    createContent(application);
    logger.trace("Creating navigator footer.");
    createFooter(application);
  }

  private void createHeader(Application2 application) {
    final HBox header = new HBox();
    header.getStyleClass().addAll(StyleClass.HEADER, StyleClass.TOOLBAR,
        StyleClass.ALIGN_CENTER_LEFT);
    addHeaderButtons(application, header);
    VBox.setVgrow(header, Priority.NEVER);
    getChildren().add(header);
  }

  private void createContent(Application2 application) {
    final StackPane content = new StackPane();
    addContentPages(application, content);
    VBox.setVgrow(content, Priority.ALWAYS);
    getChildren().add(content);
  }

  private void createFooter(Application2 application) {
    final HBox footer = new HBox();
    footer.getStyleClass().addAll(StyleClass.FOOTER,
        StyleClass.ALIGN_CENTER_LEFT);
    VBox.setVgrow(footer, Priority.NEVER);
    getChildren().add(footer);
    final Button hideInspectorButton = new Button();
    hideInspectorButton.setId(HIDE_INCPECTOR_BUTTON_ID);
    footer.getChildren().add(hideInspectorButton);
  }

  /**
   * Adds buttons to the header of this inspector panel.
   *
   * @param application
   *          the current application.
   * @param header
   *          the header of this inspector panel.
   */
  protected abstract void addHeaderButtons(Application2 application, HBox header);

  /**
   * Adds pages to contents stack pane of this inspector panel.
   *
   * @param application
   *          the current application.
   * @param contentÏ
   *          the content stack pane of this inspector panel.
   */
  protected abstract void addContentPages(Application2 application, StackPane content);
}
