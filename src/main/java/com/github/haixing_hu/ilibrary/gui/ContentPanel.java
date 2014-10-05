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

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.state.Page;

import static com.github.haixing_hu.ilibrary.StyleClass.*;

/**
 * The panel of main contents.
 *
 * @author Haixing Hu
 */
public abstract class ContentPanel extends BasicPanel  {

  public static final String STYLE_CLASS = "content-panel";

  protected final Page page;
  protected final Label statusLine;

  public ContentPanel(final Application application, Page page) {
    super(application);
    this.page = page;
    statusLine = new Label();
    getStyleClass().add(STYLE_CLASS);
  }

  @Override
  protected final void configFooter() {
    final HBox leftToolBar = new HBox();
    leftToolBar.getStyleClass().addAll(TOOLBAR, ALIGN_CENTER_LEFT);
    configFooterLeftToolBar(leftToolBar);

    final HBox centerToolBar = new HBox();
    centerToolBar.getStyleClass().addAll(TOOLBAR, ALIGN_CENTER);
    centerToolBar.getChildren().add(statusLine);

    final HBox rightToolBar = new HBox();
    rightToolBar.getStyleClass().addAll(TOOLBAR, ALIGN_CENTER_RIGHT);
    configFooterRightToolBar(rightToolBar);

    HBox.setHgrow(leftToolBar, Priority.NEVER);
    HBox.setHgrow(centerToolBar, Priority.ALWAYS);
    HBox.setHgrow(rightToolBar, Priority.NEVER);
    footer.getChildren().addAll(leftToolBar, centerToolBar, rightToolBar);
  }

  protected abstract void configFooterLeftToolBar(HBox toolBar);

  protected abstract void configFooterRightToolBar(HBox toolBar);

  public final void setStatusLineMessage(String message) {
    statusLine.setText(message);
  }

  public abstract void setPreviewVisible(boolean visible);
}
