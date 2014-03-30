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

package com.github.haixing_hu.ilibrary.controller;

import org.eclipse.swt.custom.CTabFolderEvent;
import org.eclipse.swt.events.SelectionEvent;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.ActionManager;
import com.github.haixing_hu.ilibrary.action.view.HideInspectorAction;
import com.github.haixing_hu.ilibrary.action.view.HidePreviewAction;
import com.github.haixing_hu.ilibrary.action.view.ShowInspectorAction;
import com.github.haixing_hu.ilibrary.action.view.ShowPreviewAction;
import com.github.haixing_hu.ilibrary.action.view.ViewAction;
import com.github.haixing_hu.ilibrary.action.view.ViewModeAction;
import com.github.haixing_hu.ilibrary.action.view.ViewModeAllAction;
import com.github.haixing_hu.ilibrary.action.view.ViewModeInspectorAction;
import com.github.haixing_hu.ilibrary.action.view.ViewModeNoneAction;
import com.github.haixing_hu.ilibrary.action.view.ViewModePreviewAction;
import com.github.haixing_hu.ilibrary.gui.MainPanel;
import com.github.haixing_hu.ilibrary.gui.MainPanelTab;
import com.github.haixing_hu.ilibrary.gui.MainWindow;
import com.github.haixing_hu.ilibrary.gui.library.LibraryTab;
import com.github.haixing_hu.ilibrary.gui.widget.Action;
import com.github.haixing_hu.ilibrary.gui.widget.DropDownAction;
import com.github.haixing_hu.ilibrary.state.ApplicationState;
import com.github.haixing_hu.ilibrary.state.ViewMode;

/**
 * The controller of the main panel.
 *
 * @author Haixing Hu
 */
public class MainPanelController extends BaseController {

  /**
   * Constructs a {@link MainPanelController}.
   *
   * @param application
   *          the application.
   */
  public MainPanelController(Application application) {
    super(application);
  }

  /**
   * Sets the view mode.
   *
   * @param mode
   *      the new view mode.
   */
  public void setViewMode(int mode) {
    final ApplicationState state = application.getState();
    final MainWindow mainWindow = application.getMainWindow();
    final MainPanel mainPanel = mainWindow.getMainPanel();
    final LibraryTab libraryTab = (LibraryTab) mainPanel.getItem(0);
    final ActionManager am = application.getActionManager();
    final DropDownAction viewAction = (DropDownAction) am.get(ViewAction.KEY);
    final Action viewModeAction = am.get(ViewModeAction.KEY);
    final Action mode_all = am.get(ViewModeAllAction.KEY);
    final Action mode_inspector = am.get(ViewModeInspectorAction.KEY);
    final Action mode_preview = am.get(ViewModePreviewAction.KEY);
    final Action mode_none = am.get(ViewModeNoneAction.KEY);
    switch (mode) {
    case ViewMode.NONE:
      logger.info("Set the view mode to: {}", ViewMode.NONE);
      mainPanel.hideInspector();
      libraryTab.hidePreview();
      //  change the menu items
      viewAction.showSubAction(ShowInspectorAction.KEY);
      viewAction.showSubAction(ShowPreviewAction.KEY);
      viewAction.hideSubAction(HideInspectorAction.KEY);
      viewAction.hideSubAction(HidePreviewAction.KEY);
      viewAction.update(true);
      //  change the ViewModeAction icon
      viewModeAction.setImageDescriptor(mode_none.getImageDescriptor());
      //  change the action's checking state
      mode_all.setChecked(false);
      mode_inspector.setChecked(false);
      mode_preview.setChecked(false);
      mode_none.setChecked(true);
      //  change the state
      state.setViewMode(mode);
      break;
    case ViewMode.INSPECTOR:
      logger.info("Set the view mode to: {}", ViewMode.INSPECTOR);
      mainPanel.showInspector();
      libraryTab.hidePreview();
      // change the menu items
      viewAction.showSubAction(HideInspectorAction.KEY);
      viewAction.showSubAction(ShowPreviewAction.KEY);
      viewAction.hideSubAction(ShowInspectorAction.KEY);
      viewAction.hideSubAction(HidePreviewAction.KEY);
      viewAction.update(true);
      //  change the ViewModeAction icon
      viewModeAction.setImageDescriptor(mode_inspector.getImageDescriptor());
      //  change the action's checking state
      mode_all.setChecked(false);
      mode_inspector.setChecked(true);
      mode_preview.setChecked(false);
      mode_none.setChecked(false);
      // change the state
      state.setViewMode(mode);
      break;
    case ViewMode.PREVIEW:
      logger.info("Set the view mode to: {}", ViewMode.PREVIEW);
      mainPanel.hideInspector();
      libraryTab.showPreview();
      // change the menu items
      viewAction.showSubAction(ShowInspectorAction.KEY);
      viewAction.showSubAction(HidePreviewAction.KEY);
      viewAction.hideSubAction(HideInspectorAction.KEY);
      viewAction.hideSubAction(ShowPreviewAction.KEY);
      viewAction.update(true);
      //  change the ViewModeAction icon
      viewModeAction.setImageDescriptor(mode_preview.getImageDescriptor());
      //  change the action's checking state
      mode_all.setChecked(false);
      mode_inspector.setChecked(false);
      mode_preview.setChecked(true);
      mode_none.setChecked(false);
      // change the state
      state.setViewMode(mode);
      break;
    case ViewMode.ALL:
      logger.info("Set the view mode to: {}", ViewMode.ALL);
      mainPanel.showInspector();
      libraryTab.showPreview();
      // change the menu items
      viewAction.showSubAction(HideInspectorAction.KEY);
      viewAction.showSubAction(HidePreviewAction.KEY);
      viewAction.hideSubAction(ShowInspectorAction.KEY);
      viewAction.hideSubAction(ShowPreviewAction.KEY);
      viewAction.update(true);
      //  change the ViewModeAction icon
      viewModeAction.setImageDescriptor(mode_all.getImageDescriptor());
      //  change the action's checking state
      mode_all.setChecked(true);
      mode_inspector.setChecked(false);
      mode_preview.setChecked(false);
      mode_none.setChecked(false);
      // change the state
      state.setViewMode(mode);
      break;
    default:
      logger.error("Unknown view mode: {}", mode);
      break;
    }
  }

  /**
   * Handle the event on switching to a tab.
   *
   * @param event
   *    the event object.
   */
  public void onSwithTab(SelectionEvent event) {
    final MainPanelTab tab = (MainPanelTab) event.item;
    logger.info("Switch to tab: {}", tab.getId());
    //  TODO
  }

  /**
   * Handle the event on closing a tab.
   *
   * @param event
   *    the event object.
   */
  public void onCloseTab(CTabFolderEvent event) {
    final MainPanelTab tab = (MainPanelTab) event.item;
    logger.info("Close tab: {}", tab.getId());
    //  TODO
  }
}
