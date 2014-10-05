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

package com.github.haixing_hu.ilibrary.gui.document;

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
public class DocumentInspectorPanel extends InspectorPanel {

  public DocumentInspectorPanel(Application application, Page page) {
    super(application, page);
  }

  @Override
  protected void configHeader() {
    final ActionManager am = application.getActionManager();
    for (final InspectorTab tab : InspectorTab.values()) {
      final ButtonBase button = am.createButton(tab.actionId());
      header.getChildren().add(button);
    }
  }

  @Override
  protected void configContent() {
    final Pane overview = new DocumentOverviewPanel(application);
    final Pane info = new DocumentInfoPanel(application);
    final Pane notes = new DocumentNotesPanel(application);
    final Pane activity = new DocumentActivityPanel(application);
    ((CardPane) content).addAllCards(overview, info, notes, activity);
  }

  /**
   * Switches this inspector panel to a specified tab.
   *
   * @param tab
   *          the tab to be switched to.
   */
  @Override
  public void switchToTab(InspectorTab tab) {
    ((CardPane) content).showCard(tab.ordinal());
  }
}
