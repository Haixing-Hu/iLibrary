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

package com.github.haixing_hu.ilibrary.gui.preview;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.gui.VBoxBase;

/**
 * The preview panel
 *
 * @author Haixing Hu
 */
public class PreviewPanel extends VBoxBase {

  public static final String STYLE_CLASS = "preview-panel";

  public static final String HEADER_STYLE_CLASS = "preview-panel-header";

  public static final String URL_FIELD_STYLE_CLASS = "preview-panel-url";

  private final HBox header;
  private final Region content;
  private final TextField urlField;

  public PreviewPanel(Application application) {
    super(application);
    //getStyleClass().add(STYLE_CLASS);
    header = createHeader();
    content = createContent();
    urlField = new TextField();
    urlField.getStyleClass().add(URL_FIELD_STYLE_CLASS);

    VBox.setVgrow(header, Priority.NEVER);
    VBox.setVgrow(content, Priority.ALWAYS);
    getChildren().addAll(header, content);
    init();
  }

  private void init() {
    configHeader();
    configContent();
  }

  private HBox createHeader() {
    final HBox header = new HBox();
    header.getStyleClass().addAll(STYLE_CLASS, HEADER_STYLE_CLASS);
    return header;
  }

  private Region createContent() {
    final Pane pane = new Pane();
    pane.getStyleClass().add(STYLE_CLASS);
    //  TODO
    return pane;
  }

  private void configHeader() {
//    final ActionManager am = application.getActionManager();
//
//    final HBox leftToolBar = new HBox();
//    leftToolBar.getStyleClass().addAll(STYLE_CLASS, TOOLBAR, ALIGN_CENTER_LEFT);
//    final ButtonBase preview = am.createButton(PreviewAction.ID);
//    leftToolBar.getChildren().add(preview);
//
//    final HBox centerToolBar = new HBox();
//    centerToolBar.getStyleClass().addAll(STYLE_CLASS, TOOLBAR, ALIGN_CENTER);
//    centerToolBar.getChildren().add(urlField);
//
//    final HBox rightToolBar = new HBox();
//    rightToolBar.getStyleClass().addAll(STYLE_CLASS, TOOLBAR, ALIGN_CENTER_RIGHT);
//    final ButtonBase backward = am.createButton(BackwardAction.ID);
//    final ButtonBase forward = am.createButton(ForwardAction.ID);
//    rightToolBar.getChildren().addAll(backward, forward);
//
//    HBox.setHgrow(leftToolBar, Priority.NEVER);
//    HBox.setHgrow(centerToolBar, Priority.ALWAYS);
//    HBox.setHgrow(rightToolBar, Priority.NEVER);
//    header.getChildren().addAll(leftToolBar, centerToolBar, rightToolBar);
  }

  private void configContent() {
    //  TODO
  }

  public void setUrl(String url) {
    urlField.setText(url);
  }
}
