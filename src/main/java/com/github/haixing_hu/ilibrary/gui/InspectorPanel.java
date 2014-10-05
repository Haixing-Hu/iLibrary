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
import javafx.scene.layout.Pane;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.view.HideInspectorAction;
import com.github.haixing_hu.ilibrary.state.InspectorTab;
import com.github.haixing_hu.ilibrary.state.Page;
import com.github.haixing_hu.javafx.action.ActionManager;
import com.github.haixing_hu.javafx.pane.CardPane;

/**
 * The inspector panel.
 *
 * @author Haixing Hu
 */
public abstract class InspectorPanel extends BasicPanel {

  public static final String STYLE_CLASS = "inspector-panel";

  protected final Page page;

  public InspectorPanel(final Application application, Page page) {
    super(application);
    this.page = page;
    getStyleClass().add(STYLE_CLASS);
    init();
  }

  @Override
  protected final Pane createContent() {
    return new CardPane();
  }

  /**
   * Configures the footer.
   */
  @Override
  protected final void configFooter() {
    final ActionManager am = application.getActionManager();
    final ButtonBase hideInspectorButton = am.createButton(HideInspectorAction.ID);
    footer.getChildren().add(hideInspectorButton);
  }

  /**
   * Switches this inspector panel to a specified tab.
   *
   * @param tab
   *          the tab to be switched to.
   */
  public abstract void switchToTab(InspectorTab tab);

  /**
   * Gets the content.
   *
   * @return the content.
   */
  @Override
  public CardPane getContent() {
    return (CardPane) content;
  }
}
