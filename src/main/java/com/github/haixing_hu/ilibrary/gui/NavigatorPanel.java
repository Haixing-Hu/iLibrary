/*
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
 */package com.github.haixing_hu.ilibrary.gui;

import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.StyleClass;
import com.github.haixing_hu.ilibrary.action.view.HideNavigatorAction;
import com.github.haixing_hu.ilibrary.state.Page;
import com.github.haixing_hu.javafx.action.ActionManager;
import com.github.haixing_hu.lang.EnumUtils;

/**
 * The navigator panel.
 *
 * @author Haixing Hu
 */
public abstract class NavigatorPanel extends BasicPanel {

  public static final String STYLE_CLASS = "navigator-panel";

  public static final String ADD_BUTTON_CLASS = "button-add";

  public static final String MANAGE_BUTTON_CLASS = "button-manage";

  protected final Page page;

  public NavigatorPanel(final Application application, Page page) {
    super(application);
    this.page = page;
    init();
  }

  @Override
  protected final void configHeader() {
    final AppConfig config = application.getConfig();
    final String pageId = EnumUtils.getShortName(page);
    final String title = config.getTitle(pageId);
    final Label titleLabel = new Label(title);
    titleLabel.getStyleClass().addAll(StyleClass.TITLE, StyleClass.PAGE_TITLE);
    header.getChildren().add(titleLabel);
  }

  @Override
  protected final void configFooter() {
    final ActionManager am = application.getActionManager();

    final HBox footerLeft = new HBox();
    footerLeft.getStyleClass().addAll(StyleClass.TOOLBAR, StyleClass.ALIGN_CENTER_LEFT);
    HBox.setHgrow(footerLeft, Priority.ALWAYS);
    footer.getChildren().add(footerLeft);

    configFooterLeftToolBar(footerLeft);

    final HBox footerRight = new HBox();
    footerRight.getStyleClass().addAll(StyleClass.TOOLBAR, StyleClass.ALIGN_CENTER_RIGHT);
    HBox.setHgrow(footerRight, Priority.NEVER);
    footer.getChildren().add(footerRight);
    final ButtonBase hideNavigatorButton = am.createButton(HideNavigatorAction.ID);
    footerRight.getChildren().add(hideNavigatorButton);
  }

  protected abstract void configFooterLeftToolBar(HBox toolBar);
}
