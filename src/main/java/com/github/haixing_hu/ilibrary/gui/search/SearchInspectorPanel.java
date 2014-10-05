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

package com.github.haixing_hu.ilibrary.gui.search;

import javafx.scene.control.ButtonBase;
import javafx.scene.layout.Pane;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.gui.InspectorPanel;
import com.github.haixing_hu.ilibrary.state.InspectorTab;
import com.github.haixing_hu.ilibrary.state.Page;
import com.github.haixing_hu.javafx.action.ActionManager;
import com.github.haixing_hu.javafx.pane.CardPane;

/**
 * The inspector panel for displaying document information.
 *
 * @author Haixing Hu
 */
public class SearchInspectorPanel extends InspectorPanel {

  public SearchInspectorPanel(Application application) {
    super(application, Page.SEARCH);
  }

  @Override
  protected void configHeader() {
    final ActionManager am = application.getActionManager();
    final ButtonBase overview = am.createButton(InspectorTab.OVERVIEW.actionId());
    header.getChildren().add(overview);
    final ButtonBase activity = am.createButton(InspectorTab.ACTIVITY.actionId());
    header.getChildren().add(activity);
  }

  @Override
  protected void configContent() {
    final Pane overview = new SearchOverviewPanel(application);
    final Pane activity = new SearchActivityPanel(application);
    ((CardPane) content).addAllCards(overview, activity);
  }

  /**
   * Switches this inspector panel to a specified tab.
   *
   * @param tab
   *          the tab to be switched to.
   */
  @Override
  public void switchToTab(InspectorTab tab) {
    switch (tab) {
      case OVERVIEW:
        ((CardPane) content).showCard(0);
        break;
      case ACTIVITY:
        ((CardPane) content).showCard(1);
        break;
      default:
        ((CardPane) content).showCard(0);
        break;
    }
  }
}
