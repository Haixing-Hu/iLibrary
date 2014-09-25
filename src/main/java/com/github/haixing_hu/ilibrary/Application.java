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

package com.github.haixing_hu.ilibrary;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.action.ActionManager;
import com.github.haixing_hu.ilibrary.action.edit.AnnotateAction;
import com.github.haixing_hu.ilibrary.action.edit.AnnotateHighlightAction;
import com.github.haixing_hu.ilibrary.action.edit.AnnotateSelectionAction;
import com.github.haixing_hu.ilibrary.action.edit.AnnotateStrikethroughAction;
import com.github.haixing_hu.ilibrary.action.edit.AnnotateUnderlineAction;
import com.github.haixing_hu.ilibrary.action.view.FilterFileStatusAction;
import com.github.haixing_hu.ilibrary.action.view.FilterFileStatusAllAction;
import com.github.haixing_hu.ilibrary.action.view.FilterFileStatusHasFileAction;
import com.github.haixing_hu.ilibrary.action.view.FilterFileStatusNoFileAction;
import com.github.haixing_hu.ilibrary.action.view.FilterFlagStatusAction;
import com.github.haixing_hu.ilibrary.action.view.FilterFlagStatusAllAction;
import com.github.haixing_hu.ilibrary.action.view.FilterFlagStatusFlaggedAction;
import com.github.haixing_hu.ilibrary.action.view.FilterFlagStatusUnflaggedAction;
import com.github.haixing_hu.ilibrary.action.view.FilterReadStatusAction;
import com.github.haixing_hu.ilibrary.action.view.FilterReadStatusAllAction;
import com.github.haixing_hu.ilibrary.action.view.FilterReadStatusHasReadAction;
import com.github.haixing_hu.ilibrary.action.view.FilterReadStatusReadingAction;
import com.github.haixing_hu.ilibrary.action.view.FilterReadStatusToReadAction;
import com.github.haixing_hu.ilibrary.action.view.FilterReadStatusUnreadAction;
import com.github.haixing_hu.ilibrary.action.view.FilterTypeAction;
import com.github.haixing_hu.ilibrary.action.view.FilterTypeAllAction;
import com.github.haixing_hu.ilibrary.action.view.FilterTypeArticleAction;
import com.github.haixing_hu.ilibrary.action.view.FilterTypeBookAction;
import com.github.haixing_hu.ilibrary.action.view.FilterTypeLawAction;
import com.github.haixing_hu.ilibrary.action.view.FilterTypeMediaAction;
import com.github.haixing_hu.ilibrary.action.view.FilterTypeReferenceAction;
import com.github.haixing_hu.ilibrary.action.view.HideInspectorAction;
import com.github.haixing_hu.ilibrary.action.view.HideNavigatorAction;
import com.github.haixing_hu.ilibrary.action.view.HidePreviewAction;
import com.github.haixing_hu.ilibrary.action.view.ShowInspectorAction;
import com.github.haixing_hu.ilibrary.action.view.ShowNavigatorAction;
import com.github.haixing_hu.ilibrary.action.view.ShowPreviewAction;
import com.github.haixing_hu.ilibrary.action.view.ViewAction;
import com.github.haixing_hu.ilibrary.action.view.ViewModeAction;
import com.github.haixing_hu.ilibrary.action.view.ViewModeAllAction;
import com.github.haixing_hu.ilibrary.action.view.ViewModeInspectorAction;
import com.github.haixing_hu.ilibrary.action.view.ViewModeNoneAction;
import com.github.haixing_hu.ilibrary.action.view.ViewModePreviewAction;
import com.github.haixing_hu.ilibrary.action.window.InspectorInfoTabAction;
import com.github.haixing_hu.ilibrary.action.window.InspectorNotesTabAction;
import com.github.haixing_hu.ilibrary.action.window.InspectorOverviewTabAction;
import com.github.haixing_hu.ilibrary.action.window.InspectorReviewsTabAction;
import com.github.haixing_hu.ilibrary.action.window.PageAuthorsAction;
import com.github.haixing_hu.ilibrary.action.window.PageLibraryAction;
import com.github.haixing_hu.ilibrary.action.window.PageReaderAction;
import com.github.haixing_hu.ilibrary.action.window.PageSearchAction;
import com.github.haixing_hu.ilibrary.action.window.PageSourcesAction;
import com.github.haixing_hu.ilibrary.action.window.PageTagsAction;
import com.github.haixing_hu.ilibrary.action.window.WindowAction;
import com.github.haixing_hu.ilibrary.gui.MainWindow;
import com.github.haixing_hu.ilibrary.gui.Page;
import com.github.haixing_hu.ilibrary.state.AnnotateMode;
import com.github.haixing_hu.ilibrary.state.ApplicationState;
import com.github.haixing_hu.ilibrary.state.FileStatusFilter;
import com.github.haixing_hu.ilibrary.state.FlagStatusFilter;
import com.github.haixing_hu.ilibrary.state.InspectorTab;
import com.github.haixing_hu.ilibrary.state.ReadStatusFilter;
import com.github.haixing_hu.ilibrary.state.TypeFilter;
import com.github.haixing_hu.ilibrary.state.ViewMode;
import com.github.haixing_hu.swt.action.ActionEx;
import com.github.haixing_hu.swt.action.DropDownAction;
import com.github.haixing_hu.swt.utils.SWTResourceManager;

/**
 * The main class of the application.
 *
 * @author Haixing Hu
 */
public final class Application {

  public static final String CONTEXT_FILE = "applicationContext.xml";

  private final Logger logger;
  private final AppConfig config;
  private final ApplicationState state;
  private final ActionManager actionManager;
  private final MainWindow mainWindow;

  /**
   * Constructs an application.
   */
  public Application() {
    logger = LoggerFactory.getLogger(Application.class);
    config = new AppConfig(CONTEXT_FILE);
    state = new ApplicationState(config);
    actionManager = new ActionManager(this);
    mainWindow = new MainWindow(this);
//    //  adjust the Mac OS X Cococa UI
//    if (SystemUtils.IS_OS_MAC) {
//      NsApplication nsApp = new DefaultNsApplication();
//      nsApp.addApplicationListener(new CococaApplicationListener(this));
//      nsApp.addAboutMenuItem();
//      nsApp.addPreferencesMenuItem();
//    }
  }

  /**
   * Runs this application.
   */
  public void run() {
    mainWindow.create();
    syncState();
    mainWindow.setBlockOnOpen(true);
    mainWindow.open();
    final Display display = Display.getCurrent();
    if (display != null) {
      //  if the program is terminated by external command (i.e., press CMD+Q in Mac),
      //  the display could be null.
      SWTResourceManager.dispose();
      display.dispose();
    }
  }


  /**
   * Synchronize the application states and the application UI.
   */
  private void syncState() {
    logger.info("Synchronizing the applicatino state ...");
    this.setNavigatorWidth(state.getNavigatorWidth());
    this.setNavigatorVisible(state.isNavigatorVisible());
    this.setInspectorWidth(state.getInspectorWidth());
    this.setPreviewHeight(state.getPreviewHeight());
    this.setViewMode(state.getViewMode());
    this.setInspectorTab(state.getInspectorTab());
    this.setFlagStatusFilter(state.getFlagFilter());
    this.setReadStatusFilter(state.getReadStatusFilter());
    this.setTypeFilter(state.getTypeFilter());
    this.setFileStatusFilter(state.getFileStatusFilter());
    this.setAnnotateMode(state.getAnnotateMode());
    this.setPage(state.getPage());
  }

  /**
   * Displays an error message dialog indicating that the specified function has
   * not been implemented yet.
   *
   * @param key the key of the action.
   */
  public void displayUnimplementedError(String key) {
    final String title = config.getMessage("message.error");
    final String message = config.getMessage("message.error.unimplemented-function") + ": " + key;
    MessageDialog.openError(mainWindow.getShell(), title, message);
  }

  /**
   * Gets the action manager of this application.
   *
   * @return the action manager of this application.
   */
  public ActionManager getActionManager() {
    return actionManager;
  }

  /**
   * Gets the configuration of this application.
   *
   * @return the configuration of this application.
   */
  public AppConfig getConfig() {
    return config;
  }

  /**
   * Gets the internal state of this application.
   *
   * @return the internal state of this application.
   */
  public ApplicationState getState() {
    return state;
  }

  /**
   * Gets the main window of this application.
   *
   * @return the main window of this application.
   */
  public MainWindow getMainWindow() {
    return mainWindow;
  }

  /**
   * Sets the width of the navigator panel.
   *
   * @param width
   *          the width to be set. If it is less than or equal to 0, the
   *          function will hide the navigator panel.
   */
  public void setNavigatorWidth(int width) {
    if (width <= 0) {
      setNavigatorVisible(false);
    } else {
      logger.debug("Sets the navigator panel width to: {}", width);
      mainWindow.setNavigatorWidth(width);
      state.setNavigatorWidth(width);
      if (! state.isNavigatorVisible()) {
        final DropDownAction viewAction = (DropDownAction) actionManager.get(ViewAction.KEY);
        viewAction.showSubAction(HideNavigatorAction.KEY);
        viewAction.hideSubAction(ShowNavigatorAction.KEY);
        viewAction.update(true);
        state.setNavigatorVisible(true);
      }
    }
  }

  /**
   * Sets the navigator panel's visibility.
   *
   * @param visible
   *          <code>true</code> to set the navigator panel visible;
   *          <code>false</code> otherwise.
   */
  public void setNavigatorVisible(boolean visible) {
    logger.info("Sets the visible of navigator panel to: {}", visible);
    final DropDownAction viewAction = (DropDownAction) actionManager.get(ViewAction.KEY);
    if (visible) {
      viewAction.showSubAction(HideNavigatorAction.KEY);
      viewAction.hideSubAction(ShowNavigatorAction.KEY);
      viewAction.update(true);
      final int width = state.getNavigatorWidth();
      mainWindow.setNavigatorWidth(width);
    } else {
      viewAction.hideSubAction(HideNavigatorAction.KEY);
      viewAction.showSubAction(ShowNavigatorAction.KEY);
      viewAction.update(true);
      mainWindow.setNavigatorWidth(0);
    }
    mainWindow.setToolBarActionVisibility(HideNavigatorAction.KEY, visible);
    mainWindow.setToolBarActionVisibility(ShowNavigatorAction.KEY, (! visible));
    mainWindow.updateToolBar(true);
    state.setNavigatorVisible(visible);
  }

  /**
   * Sets the width of the inspector panel.
   *
   * @param width
   *          the width to be set. If it is less than or equal to 0, the
   *          function will hide the inspector panel.
   */
  public void setInspectorWidth(int width) {
    if (width <= 0) {
      setInspectorVisible(false);
    } else {
      logger.debug("Sets the inspector panel width to: {}", width);
      mainWindow.setInspectorWidth(width);
      state.setInspectorWidth(width);
      final int mode = state.getViewMode();
      if ((mode & ViewMode.INSPECTOR) == 0) {
        updateViewMode(mode | ViewMode.INSPECTOR);
      }
    }
  }

  /**
   * Sets the inspector panel's visibility.
   *
   * @param visible
   *          <code>true</code> to set the inspector panel visible;
   *          <code>false</code> otherwise.
   */
  public void setInspectorVisible(boolean visible) {
    logger.info("Sets the visible of inspector panel to: {}", visible);
    final int mode = state.getViewMode();
    if (visible) {
      mainWindow.setInspectorWidth(state.getInspectorWidth());
      updateViewMode(mode | ViewMode.INSPECTOR);
    } else {
      mainWindow.setInspectorWidth(0);
      updateViewMode(mode & (~ ViewMode.INSPECTOR));
    }
  }


  /**
   * Sets the tab folder of the inspector panel on all pages to the specified
   * tab.
   *
   * @param tab
   *          the tab to be switched to.
   */
  public void setInspectorTab(InspectorTab tab) {
    logger.info("Switch inspector tab to: {}", tab);
    final DropDownAction windowAction = (DropDownAction) actionManager.get(WindowAction.KEY);
    final ActionEx infoTabAction = actionManager.get(InspectorInfoTabAction.KEY);
    final ActionEx notesTabAction = actionManager.get(InspectorNotesTabAction.KEY);
    final ActionEx reviewsTabAction = actionManager.get(InspectorReviewsTabAction.KEY);
    final ActionEx filesTabAction = actionManager.get(InspectorOverviewTabAction.KEY);
    switch (tab) {
    case INFO:
      infoTabAction.setChecked(true);
      notesTabAction.setChecked(false);
      reviewsTabAction.setChecked(false);
      filesTabAction.setChecked(false);
      break;
    case NOTES:
      infoTabAction.setChecked(false);
      notesTabAction.setChecked(true);
      reviewsTabAction.setChecked(false);
      filesTabAction.setChecked(false);
      break;
    case REVIEWS:
      infoTabAction.setChecked(false);
      notesTabAction.setChecked(false);
      reviewsTabAction.setChecked(true);
      filesTabAction.setChecked(false);
      break;
    case OVERVIEW:
      infoTabAction.setChecked(false);
      notesTabAction.setChecked(false);
      reviewsTabAction.setChecked(false);
      filesTabAction.setChecked(true);
      break;
    default:
      logger.error("Unknown inspector tab: {}", tab);
      break;
    }
    windowAction.update(true);
    mainWindow.setInspectorTab(tab);
    state.setInspectorTab(tab);
  }


  /**
   * Sets the height of the preview panel.
   *
   * @param height
   *          the height to be set. If it is less than or equal to 0, the
   *          function will hide the preview panel.
   */
  public void setPreviewHeight(int height) {
    if (height <= 0) {
      setPreviewVisible(false);
    } else {
      logger.debug("Sets the preview panel height to: {}", height);
      mainWindow.setPreviewHeight(height);
      state.setPreviewHeight(height);
      final int mode = state.getViewMode();
      if ((mode & ViewMode.PREVIEW) == 0) {
        updateViewMode(mode | ViewMode.PREVIEW);
      }
    }
  }

  /**
   * Sets the preview panel's visibility.
   *
   * @param visible
   *          <code>true</code> to set the preview panel visible;
   *          <code>false</code> otherwise.
   */
  public void setPreviewVisible(boolean visible) {
    logger.info("Sets the visible of preview panel to: {}", visible);
    final int mode = state.getViewMode();
    if (visible) {
      mainWindow.setPreviewHeight(state.getPreviewHeight());
      updateViewMode(mode | ViewMode.PREVIEW);
    } else {
      mainWindow.setPreviewHeight(0);
      updateViewMode(mode & (~ ViewMode.PREVIEW));
    }
  }

  /**
   * Sets the view mode.
   *
   * @param mode
   *      the new view mode.
   */
  public void setViewMode(int mode) {
    logger.info("Set the view mode to: {}", mode);
    switch (mode) {
    case ViewMode.NONE:
      //  hide the inspector panel and preview panel
      mainWindow.setInspectorWidth(0);
      mainWindow.setPreviewHeight(0);
      break;
    case ViewMode.INSPECTOR:
      //  show the inspector panel and hide the preview panel
      mainWindow.setInspectorWidth(state.getInspectorWidth());
      mainWindow.setPreviewHeight(0);
      break;
    case ViewMode.PREVIEW:
      //  hide the inspector panel and show the preview panel
      mainWindow.setInspectorWidth(0);
      mainWindow.setPreviewHeight(state.getPreviewHeight());
      break;
    case ViewMode.ALL:
      //  show the inspector panel and the preview panel
      mainWindow.setInspectorWidth(state.getInspectorWidth());
      mainWindow.setPreviewHeight(state.getPreviewHeight());
      break;
    default:
      logger.error("Unknown view mode: {}", mode);
      break;
    }
    updateViewMode(mode);
  }

  /**
   * Updates to the new view mode, changing the states of actions according to
   * the new view mode.
   *
   * @param mode
   *      the new view mode.
   */
  private void updateViewMode(int mode) {
    final DropDownAction viewAction = (DropDownAction) actionManager.get(ViewAction.KEY);
    final DropDownAction viewModeAction = (DropDownAction) actionManager.get(ViewModeAction.KEY);
    final ActionEx modeAll = actionManager.get(ViewModeAllAction.KEY);
    final ActionEx modeInspector = actionManager.get(ViewModeInspectorAction.KEY);
    final ActionEx modePreview = actionManager.get(ViewModePreviewAction.KEY);
    final ActionEx modeNone = actionManager.get(ViewModeNoneAction.KEY);
    switch (mode) {
    case ViewMode.NONE:
      //  change the menu items
      viewAction.showSubAction(ShowInspectorAction.KEY);
      viewAction.hideSubAction(HideInspectorAction.KEY);
      viewAction.showSubAction(ShowPreviewAction.KEY);
      viewAction.hideSubAction(HidePreviewAction.KEY);
      //  change the tool bar items
      mainWindow.setToolBarActionVisibility(ShowInspectorAction.KEY, true);
      mainWindow.setToolBarActionVisibility(HideInspectorAction.KEY, false);
      mainWindow.setToolBarActionVisibility(ShowPreviewAction.KEY, true);
      mainWindow.setToolBarActionVisibility(HidePreviewAction.KEY, false);
      //  change the action's checking state
      modeAll.setChecked(false);
      modeInspector.setChecked(false);
      modePreview.setChecked(false);
      modeNone.setChecked(true);
      viewModeAction.setImageDescriptor(modeNone.getImageDescriptor());
      break;
    case ViewMode.INSPECTOR:
      //  change the menu items
      viewAction.hideSubAction(ShowInspectorAction.KEY);
      viewAction.showSubAction(HideInspectorAction.KEY);
      viewAction.showSubAction(ShowPreviewAction.KEY);
      viewAction.hideSubAction(HidePreviewAction.KEY);
      //  change the tool bar items
      mainWindow.setToolBarActionVisibility(ShowInspectorAction.KEY, false);
      mainWindow.setToolBarActionVisibility(HideInspectorAction.KEY, true);
      mainWindow.setToolBarActionVisibility(ShowPreviewAction.KEY, true);
      mainWindow.setToolBarActionVisibility(HidePreviewAction.KEY, false);
      //  change the action's checking state
      modeAll.setChecked(false);
      modeInspector.setChecked(true);
      modePreview.setChecked(false);
      modeNone.setChecked(false);
      viewModeAction.setImageDescriptor(modeInspector.getImageDescriptor());
      break;
    case ViewMode.PREVIEW:
      //  change the menu items
      viewAction.showSubAction(ShowInspectorAction.KEY);
      viewAction.hideSubAction(HideInspectorAction.KEY);
      viewAction.hideSubAction(ShowPreviewAction.KEY);
      viewAction.showSubAction(HidePreviewAction.KEY);
      //  change the tool bar items
      mainWindow.setToolBarActionVisibility(ShowInspectorAction.KEY, true);
      mainWindow.setToolBarActionVisibility(HideInspectorAction.KEY, false);
      mainWindow.setToolBarActionVisibility(ShowPreviewAction.KEY, false);
      mainWindow.setToolBarActionVisibility(HidePreviewAction.KEY, true);
      //  change the action's checking state
      modeAll.setChecked(false);
      modeInspector.setChecked(false);
      modePreview.setChecked(true);
      modeNone.setChecked(false);
      viewModeAction.setImageDescriptor(modePreview.getImageDescriptor());
      break;
    case ViewMode.ALL:
      //  change the menu items
      viewAction.hideSubAction(ShowInspectorAction.KEY);
      viewAction.showSubAction(HideInspectorAction.KEY);
      viewAction.hideSubAction(ShowPreviewAction.KEY);
      viewAction.showSubAction(HidePreviewAction.KEY);
      //  change the tool bar items
      mainWindow.setToolBarActionVisibility(ShowInspectorAction.KEY, false);
      mainWindow.setToolBarActionVisibility(HideInspectorAction.KEY, true);
      mainWindow.setToolBarActionVisibility(ShowPreviewAction.KEY, false);
      mainWindow.setToolBarActionVisibility(HidePreviewAction.KEY, true);
      //  change the action's checking state
      modeAll.setChecked(true);
      modeInspector.setChecked(false);
      modePreview.setChecked(false);
      modeNone.setChecked(false);
      viewModeAction.setImageDescriptor(modeAll.getImageDescriptor());
      break;
    default:
      logger.error("Unknown view mode: {}", mode);
      return;
    }
    viewModeAction.update(true);
    viewAction.update(true);
    mainWindow.updateToolBar(true);
    state.setViewMode(mode);
  }

  /**
   * Sets the flag filter.
   *
   * @param filter
   *          the new flag filter.
   */
  public void setFlagStatusFilter(FlagStatusFilter filter) {
    logger.info("Set the flag status filter to: {}", filter);
    //  TODO: set the filter in the document list table
    final DropDownAction filterAction = (DropDownAction) actionManager.get(FilterFlagStatusAction.KEY);
    final ActionEx all = actionManager.get(FilterFlagStatusAllAction.KEY);
    final ActionEx flagged = actionManager.get(FilterFlagStatusFlaggedAction.KEY);
    final ActionEx unflagged = actionManager.get(FilterFlagStatusUnflaggedAction.KEY);
    switch (filter) {
    case FLAGGED:
      //  update action's checking status
      all.setChecked(false);
      flagged.setChecked(true);
      unflagged.setChecked(false);
      break;
    case UNFLAGGED:
      //  update action's checking status
      all.setChecked(false);
      flagged.setChecked(false);
      unflagged.setChecked(true);
      break;
    case ALL:
      //  update action's checking status
      all.setChecked(true);
      flagged.setChecked(false);
      unflagged.setChecked(false);
      break;
    default:
      logger.error("Unknown flag status filter: ", filter);
      return;
    }
    filterAction.update(true);
    state.setFlagStatusFilter(filter);
  }

  /**
   * Sets the document read status filter.
   *
   * @param filter
   *          the new document read status filter.
   */
  public void setReadStatusFilter(ReadStatusFilter filter) {
    logger.info("Set the read status filter to: {}", filter);
    //  TODO: set the filter in the document list table
    final DropDownAction filterAction = (DropDownAction) actionManager.get(FilterReadStatusAction.KEY);
    final ActionEx all = actionManager.get(FilterReadStatusAllAction.KEY);
    final ActionEx unread = actionManager.get(FilterReadStatusUnreadAction.KEY);
    final ActionEx toread = actionManager.get(FilterReadStatusToReadAction.KEY);
    final ActionEx reading = actionManager.get(FilterReadStatusReadingAction.KEY);
    final ActionEx hasRead = actionManager.get(FilterReadStatusHasReadAction.KEY);
    switch (filter) {
    case UNREAD:
      //  update action's checking status
      all.setChecked(false);
      unread.setChecked(true);
      toread.setChecked(false);
      reading.setChecked(false);
      hasRead.setChecked(false);
      break;
    case TO_READ:
      //  update action's checking status
      all.setChecked(false);
      unread.setChecked(false);
      toread.setChecked(true);
      reading.setChecked(false);
      hasRead.setChecked(false);
      break;
    case READING:
      //  update action's checking status
      all.setChecked(false);
      unread.setChecked(false);
      toread.setChecked(false);
      reading.setChecked(true);
      hasRead.setChecked(false);
      break;
    case HAS_READ:
      //  update action's checking status
      all.setChecked(false);
      unread.setChecked(false);
      toread.setChecked(false);
      reading.setChecked(false);
      hasRead.setChecked(true);
      break;
    case ALL:
      //  update action's checking status
      all.setChecked(true);
      unread.setChecked(false);
      toread.setChecked(false);
      reading.setChecked(false);
      hasRead.setChecked(false);
      break;
    default:
      logger.error("Unknown read status filter: ", filter);
      return;
    }
    filterAction.update(true);
    state.setReadStatusFilter(filter);
  }

  /**
   * Sets the document type filter.
   *
   * @param filter the new document type filter.
   */
  public void setTypeFilter(TypeFilter filter) {
    logger.info("Set the document type filter to: {}", filter);
    //  TODO: set the filter in the document list table
    final DropDownAction filterAction = (DropDownAction) actionManager.get(FilterTypeAction.KEY);
    final ActionEx all = actionManager.get(FilterTypeAllAction.KEY);
    final ActionEx article = actionManager.get(FilterTypeArticleAction.KEY);
    final ActionEx book = actionManager.get(FilterTypeBookAction.KEY);
    final ActionEx report = actionManager.get(FilterTypeReferenceAction.KEY);
    final ActionEx patent = actionManager.get(FilterTypeLawAction.KEY);
    final ActionEx media = actionManager.get(FilterTypeMediaAction.KEY);
    switch (filter) {
    case ALL:
      all.setChecked(true);
      article.setChecked(false);
      book.setChecked(false);
      report.setChecked(false);
      patent.setChecked(false);
      media.setChecked(false);
      break;
    case ARTICLE:
      all.setChecked(false);
      article.setChecked(true);
      book.setChecked(false);
      report.setChecked(false);
      patent.setChecked(false);
      media.setChecked(false);
      break;
    case BOOK:
      all.setChecked(false);
      article.setChecked(false);
      book.setChecked(true);
      report.setChecked(false);
      patent.setChecked(false);
      media.setChecked(false);
      break;
    case REFERENCE:
      all.setChecked(false);
      article.setChecked(false);
      book.setChecked(false);
      report.setChecked(true);
      patent.setChecked(false);
      media.setChecked(false);
      break;
    case LAW:
      all.setChecked(false);
      article.setChecked(false);
      book.setChecked(false);
      report.setChecked(false);
      patent.setChecked(true);
      media.setChecked(false);
      break;
    case MEDIA:
      all.setChecked(false);
      article.setChecked(false);
      book.setChecked(false);
      report.setChecked(false);
      patent.setChecked(false);
      media.setChecked(true);
      break;
    default:
      logger.error("Unknown document type filter: {}", filter);
      return;
    }
    filterAction.update(true);
    state.setTypeFilter(filter);
  }

  /**
   * Sets the attachment filter.
   *
   * @param filter
   *          the new attachment filter.
   */
  public void setFileStatusFilter(FileStatusFilter filter) {
    logger.info("Set the file status filter to: {}", filter);
    //  TODO: set the filter in the document list table
    final DropDownAction filterAction = (DropDownAction) actionManager.get(FilterFileStatusAction.KEY);
    final ActionEx all = actionManager.get(FilterFileStatusAllAction.KEY);
    final ActionEx has_file = actionManager.get(FilterFileStatusHasFileAction.KEY);
    final ActionEx no_file = actionManager.get(FilterFileStatusNoFileAction.KEY);
    switch (filter) {
    case HAS_FILE:
      //  update action's checking status
      all.setChecked(false);
      has_file.setChecked(true);
      no_file.setChecked(false);
      break;
    case NO_FILE:
      //  update action's checking status
      all.setChecked(false);
      has_file.setChecked(false);
      no_file.setChecked(true);
      break;
    case ALL:
      //  update action's checking status
      all.setChecked(true);
      has_file.setChecked(false);
      no_file.setChecked(false);
      break;
    default:
      logger.error("Unknown file status filter: ", filter);
      return;
    }
    filterAction.update(true);
    state.setFileStatusFilter(filter);
  }

  /**
   * Sets the annotate mode.
   *
   * @param mode
   *          the mode to be set.
   */
  public void setAnnotateMode(AnnotateMode mode) {
    logger.info("Set the annotate mode to: {}", mode);
    //  TODO: set the annotate mode
    final DropDownAction annotate = (DropDownAction) actionManager.get(AnnotateAction.KEY);
    final ActionEx selection = actionManager.get(AnnotateSelectionAction.KEY);
    final ActionEx highlight = actionManager.get(AnnotateHighlightAction.KEY);
    final ActionEx underline = actionManager.get(AnnotateUnderlineAction.KEY);
    final ActionEx strikethrough = actionManager.get(AnnotateStrikethroughAction.KEY);
    switch (mode) {
    case SELECTION:
      //  update action's checking status
      selection.setChecked(true);
      highlight.setChecked(false);
      underline.setChecked(false);
      strikethrough.setChecked(false);
      //  change the icon of the AnnotateAction
      annotate.setImageDescriptor(selection.getImageDescriptor());
      break;
    case HIGHLIGHT:
      //  update action's checking status
      selection.setChecked(false);
      highlight.setChecked(true);
      underline.setChecked(false);
      strikethrough.setChecked(false);
      //  change the icon of the AnnotateAction
      annotate.setImageDescriptor(highlight.getImageDescriptor());
      break;
    case UNDERLINE:
      //  update action's checking status
      selection.setChecked(false);
      highlight.setChecked(false);
      underline.setChecked(true);
      strikethrough.setChecked(false);
      //  change the icon of the AnnotateAction
      annotate.setImageDescriptor(underline.getImageDescriptor());
      break;
    case STRIKETHORUGH:
      selection.setChecked(false);
      highlight.setChecked(false);
      underline.setChecked(false);
      strikethrough.setChecked(true);
      //  change the icon of the AnnotateAction
      annotate.setImageDescriptor(strikethrough.getImageDescriptor());
      break;
    default:
      logger.error("Unknown annotate mode: ", mode);
      return;
    }
    annotate.update(true);
    state.setAnnotateMode(mode);
  }

  /**
   * Sets the current page of the application.
   *
   * @param page
   *    the id of the page.
   */
  public void setPage(int page) {
    logger.info("Set the page to: {}", page);
    final DropDownAction windowAction = (DropDownAction) actionManager.get(WindowAction.KEY);
    final ActionEx searchPageAction = actionManager.get(PageSearchAction.KEY);
    final ActionEx libraryPageAction = actionManager.get(PageLibraryAction.KEY);
    final ActionEx tagsPageAction = actionManager.get(PageTagsAction.KEY);
    final ActionEx authorsPageAction = actionManager.get(PageAuthorsAction.KEY);
    final ActionEx sourcesPageAction = actionManager.get(PageSourcesAction.KEY);
    final ActionEx readerPageAction = actionManager.get(PageReaderAction.KEY);
    switch (page) {
    case Page.SEARCH:
      searchPageAction.setChecked(true);
      libraryPageAction.setChecked(false);
      tagsPageAction.setChecked(false);
      authorsPageAction.setChecked(false);
      sourcesPageAction.setChecked(false);
      readerPageAction.setChecked(false);
      break;
    case Page.LIBRARY:
      searchPageAction.setChecked(false);
      libraryPageAction.setChecked(true);
      tagsPageAction.setChecked(false);
      authorsPageAction.setChecked(false);
      sourcesPageAction.setChecked(false);
      readerPageAction.setChecked(false);
      break;
    case Page.TAGS:
      searchPageAction.setChecked(false);
      libraryPageAction.setChecked(false);
      tagsPageAction.setChecked(true);
      authorsPageAction.setChecked(false);
      sourcesPageAction.setChecked(false);
      readerPageAction.setChecked(false);
      break;
    case Page.AUTHORS:
      searchPageAction.setChecked(false);
      libraryPageAction.setChecked(false);
      tagsPageAction.setChecked(false);
      authorsPageAction.setChecked(true);
      sourcesPageAction.setChecked(false);
      readerPageAction.setChecked(false);
      break;
    case Page.SOURCES:
      searchPageAction.setChecked(false);
      libraryPageAction.setChecked(false);
      tagsPageAction.setChecked(false);
      authorsPageAction.setChecked(false);
      sourcesPageAction.setChecked(true);
      readerPageAction.setChecked(false);
      break;
    case Page.READER:
      searchPageAction.setChecked(false);
      libraryPageAction.setChecked(false);
      tagsPageAction.setChecked(false);
      authorsPageAction.setChecked(false);
      sourcesPageAction.setChecked(false);
      readerPageAction.setChecked(true);
      break;
    default:
      logger.error("Unknown page: ", page);
      return;
    }
    windowAction.update(true);
    mainWindow.setPage(page);
    state.setPage(page);
  }

  /**
   * Launch the application.
   *
   * @param args
   *   The command line arguments.
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    final Application app = new Application();
    try {
      app.run();
    } catch (final Exception e) {
      e.printStackTrace();
      throw e;
    }
  }
}
