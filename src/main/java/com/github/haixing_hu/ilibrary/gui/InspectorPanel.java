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
