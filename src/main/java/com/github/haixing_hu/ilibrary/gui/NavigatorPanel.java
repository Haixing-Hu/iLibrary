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
