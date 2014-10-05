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
package com.github.haixing_hu.ilibrary.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.view.HideInspectorAction;
import com.github.haixing_hu.ilibrary.action.view.HideNavigatorAction;
import com.github.haixing_hu.ilibrary.action.view.HidePreviewAction;
import com.github.haixing_hu.ilibrary.action.view.ShowInspectorAction;
import com.github.haixing_hu.ilibrary.action.view.ShowNavigatorAction;
import com.github.haixing_hu.ilibrary.action.view.ShowPreviewAction;
import com.github.haixing_hu.ilibrary.gui.MainContent;
import com.github.haixing_hu.ilibrary.state.ApplicationState;
import com.github.haixing_hu.ilibrary.state.InspectorTab;
import com.github.haixing_hu.ilibrary.state.Page;
import com.github.haixing_hu.javafx.action.ActionManager;

/**
 * The controller used to control the layout of the application
 *
 * @author Haixing Hu
 */
public class LayoutController {

  private final Application application;
  private final Logger logger;


  public LayoutController(final Application application) {
    this.application = application;
    logger = LoggerFactory.getLogger(LayoutController.class);
  }

  public void update() {
    updatePage();
    updateNavigatorVisible();
    updateInspectorVisible();
    updateInspectorTab();
    updatePreviewVisible();
  }

  public void setPage(Page page) {
    final ApplicationState state = application.getState();
    if (state.getPage() == page) {
      return;
    }
    logger.info("Switch to page: {}", page);
    state.setPage(page);
    updatePage();
    updateInspectorTab();
    switch (page) {
      case LIBRARY:
      case TAGS:
      case AUTHORS:
      case SOURCES:
        final ExplorerController controller = application.getExplorerController();
        controller.update();
        break;
      default:
        break;
    }
  }

  private void updatePage() {
    logger.debug("Updating page.");
    final Page[] pages = Page.values();
    final ActionManager am = application.getActionManager();
    for (final Page page : pages) {
      am.setSelected(page.actionId(), false);
    }
    final ApplicationState state = application.getState();
    final Page page = state.getPage();
    am.setSelected(page.actionId(), true);
    final MainContent content = application.findNodeById(MainContent.ID);
    content.switchToPage(page);
  }

  public void setNavigatorVisible(boolean visible) {
    final ApplicationState state = application.getState();
    logger.info("Set navigator visibles: {}", visible);
    state.setNavigatorVisible(visible);
    updateNavigatorVisible();
  }

  private void updateNavigatorVisible() {
    logger.debug("Updating navigator visibles.");
    final ApplicationState state = application.getState();
    final boolean visible = state.isNavigatorVisible();
    final ActionManager am = application.getActionManager();
    if (visible) {
      am.hide(ShowNavigatorAction.ID);
      am.show(HideNavigatorAction.ID);
    } else {
      am.show(ShowNavigatorAction.ID);
      am.hide(HideNavigatorAction.ID);
    }
    //  all page panel has the same navigator visibility
    final MainContent content = application.findNodeById(MainContent.ID);
    content.setNavigatorVisible(visible);
  }

  public void setInspectorVisible(boolean visible) {
    final ApplicationState state = application.getState();
    logger.info("Set inspector visibles: {}", visible);
    state.setInspectorVisible(visible);
    updateInspectorVisible();
  }

  private void updateInspectorVisible() {
    logger.debug("Updating insepctor visibles.");
    final ApplicationState state = application.getState();
    final boolean visible = state.isInspectorVisible();
    final ActionManager am = application.getActionManager();
    if (visible) {
      am.hide(ShowInspectorAction.ID);
      am.show(HideInspectorAction.ID);
    } else {
      am.show(ShowInspectorAction.ID);
      am.hide(HideInspectorAction.ID);
    }
    //  all page panel has the same navigator visibility
    final MainContent content = application.findNodeById(MainContent.ID);
    content.setInspectorVisible(visible);
  }

  public void setInspectorTab(InspectorTab tab) {
    final ApplicationState state = application.getState();
    logger.info("Set inspector tab: {}", tab);
    state.setInspectorTab(tab);
    updateInspectorTab();
  }

  private void updateInspectorTab() {
    logger.debug("Updating insepctor tab.");
    final ActionManager am = application.getActionManager();
    for (final InspectorTab tab : InspectorTab.values()) {
      am.setSelected(tab.actionId(), false);
    }
    final ApplicationState state = application.getState();
    final InspectorTab tab = state.getInspectorTab();
    if ((state.getPage() == Page.SEARCH) && (tab != InspectorTab.ACTIVITY)) {
      //  special treatment for search page, since it has only OVERVIEW and
      //  ACTIVITY inspector tabs
      am.setSelected(InspectorTab.OVERVIEW.actionId(), true);
      state.setInspectorTab(InspectorTab.OVERVIEW);
    } else {
      am.setSelected(tab.actionId(), true);
    }
    final MainContent content = application.findNodeById(MainContent.ID);
    content.swtichToInspectorTab(tab);
  }

  public void setPreviewVisible(boolean visible) {
    final ApplicationState state = application.getState();
    logger.info("Set preview visibles: {}", visible);
    state.setPreviewVisible(visible);
    updatePreviewVisible();
  }

  private void updatePreviewVisible() {
    logger.debug("Updating preview visibles.");
    final ApplicationState state = application.getState();
    final boolean visible = state.isPreviewVisible();
    final ActionManager am = application.getActionManager();
    if (visible) {
      am.hide(ShowPreviewAction.ID);
      am.show(HidePreviewAction.ID);
    } else {
      am.show(ShowPreviewAction.ID);
      am.hide(HidePreviewAction.ID);
    }
    //  all page panel has the same navigator visibility
    final MainContent content = application.findNodeById(MainContent.ID);
    content.setPreviewVisible(visible);
  }
}
