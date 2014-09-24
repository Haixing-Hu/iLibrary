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

import org.eclipse.swt.custom.StackLayout;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.ActionManager;
import com.github.haixing_hu.ilibrary.action.ui.SwitchToFilesTabAction;
import com.github.haixing_hu.ilibrary.action.ui.SwitchToInfoTabAction;
import com.github.haixing_hu.ilibrary.action.ui.SwitchToNotesTabAction;
import com.github.haixing_hu.ilibrary.action.ui.SwitchToReviewsTabAction;
import com.github.haixing_hu.ilibrary.gui.MainWindow;
import com.github.haixing_hu.ilibrary.gui.inspector.FilesTab;
import com.github.haixing_hu.ilibrary.gui.inspector.InfoTab;
import com.github.haixing_hu.ilibrary.gui.inspector.InspectorPanel;
import com.github.haixing_hu.ilibrary.gui.inspector.InspectorTabFolder;
import com.github.haixing_hu.ilibrary.gui.inspector.NotesTab;
import com.github.haixing_hu.ilibrary.gui.inspector.ReviewsTab;
import com.github.haixing_hu.ilibrary.state.ApplicationState;
import com.github.haixing_hu.ilibrary.state.InspectorTab;
import com.github.haixing_hu.swt.action.ActionEx;

/**
 * The controller of the inspector panel.
 *
 * @author Haixing Hu
 */
public class InspectorController extends BaseController {

  /**
   * Constructs a {@link InspectorController}.
   *
   * @param application
   *          the application.
   */
  public InspectorController(Application application) {
    super(application);
  }


  /**
   * Switches to the tab.
   *
   * @param tab
   *          the tab to be switched to.
   */
  public void switchToTab(InspectorTab tab) {
    logger.info("Switch inspector tab to: {}", tab);
    final MainWindow mainWindow = application.getMainWindow();
    final MainPanel mainPanel = mainWindow.getMainPanel();
    final MainPanelTab tabItem = mainPanel.getSelection();
    final InspectorPanel inspector = tabItem.getInspector();
    final InspectorTabFolder tabFolder = inspector.getTabFolder();
    final StackLayout stackLayout = tabFolder.getStackLayout();
    final InfoTab infoTab = tabFolder.getInfoTab();
    final NotesTab notesTab = tabFolder.getNotesTab();
    final ReviewsTab reviewsTab = tabFolder.getReviewsTab();
    final FilesTab filesTab = tabFolder.getFilesTab();
    final ActionManager am = application.getActionManager();
    final ActionEx infoTabAction = am.get(SwitchToInfoTabAction.KEY);
    final ActionEx notesTabAction = am.get(SwitchToNotesTabAction.KEY);
    final ActionEx reviewsTabAction = am.get(SwitchToReviewsTabAction.KEY);
    final ActionEx filesTabAction = am.get(SwitchToFilesTabAction.KEY);
    switch (tab) {
    case INFO:
      stackLayout.topControl = infoTab;
      tabFolder.layout();
      infoTabAction.setChecked(true);
      notesTabAction.setChecked(false);
      reviewsTabAction.setChecked(false);
      filesTabAction.setChecked(false);
      break;
    case NOTES:
      stackLayout.topControl = notesTab;
      tabFolder.layout();
      infoTabAction.setChecked(false);
      notesTabAction.setChecked(true);
      reviewsTabAction.setChecked(false);
      filesTabAction.setChecked(false);
      break;
    case REVIEWS:
      stackLayout.topControl = reviewsTab;
      tabFolder.layout();
      infoTabAction.setChecked(false);
      notesTabAction.setChecked(false);
      reviewsTabAction.setChecked(true);
      filesTabAction.setChecked(false);
      break;
    case FILES:
      stackLayout.topControl = filesTab;
      tabFolder.layout();
      infoTabAction.setChecked(false);
      notesTabAction.setChecked(false);
      reviewsTabAction.setChecked(false);
      filesTabAction.setChecked(true);
      break;
    default:
      logger.error("Unknown inspector tab: {}", tab);
      break;
    }
    final ApplicationState state = application.getState();
    state.setInspectorTab(tab);
  }
}
