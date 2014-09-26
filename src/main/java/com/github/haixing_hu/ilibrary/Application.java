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

import java.util.Set;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.action.ActionManager;
import com.github.haixing_hu.ilibrary.action.BaseAction;
import com.github.haixing_hu.ilibrary.action.edit.annotate.AnnotateAction;
import com.github.haixing_hu.ilibrary.action.edit.annotate.AnnotateHighlightAction;
import com.github.haixing_hu.ilibrary.action.edit.annotate.AnnotateSelectionAction;
import com.github.haixing_hu.ilibrary.action.edit.annotate.AnnotateStrikethroughAction;
import com.github.haixing_hu.ilibrary.action.edit.annotate.AnnotateUnderlineAction;
import com.github.haixing_hu.ilibrary.action.view.HideNavigatorAction;
import com.github.haixing_hu.ilibrary.action.view.ShowNavigatorAction;
import com.github.haixing_hu.ilibrary.action.view.ViewAction;
import com.github.haixing_hu.ilibrary.action.view.browser.AsColumnsAction;
import com.github.haixing_hu.ilibrary.action.view.browser.AsCoverFlowAction;
import com.github.haixing_hu.ilibrary.action.view.browser.AsIconsAction;
import com.github.haixing_hu.ilibrary.action.view.browser.AsListAction;
import com.github.haixing_hu.ilibrary.action.view.browser.BrowserModeAction;
import com.github.haixing_hu.ilibrary.action.view.filterfile.FilterFileStatusAction;
import com.github.haixing_hu.ilibrary.action.view.filterfile.FilterFileStatusAllAction;
import com.github.haixing_hu.ilibrary.action.view.filterfile.FilterFileStatusHasFileAction;
import com.github.haixing_hu.ilibrary.action.view.filterfile.FilterFileStatusNoFileAction;
import com.github.haixing_hu.ilibrary.action.view.filterflag.FilterFlagStatusAction;
import com.github.haixing_hu.ilibrary.action.view.filterflag.FilterFlagStatusAllAction;
import com.github.haixing_hu.ilibrary.action.view.filterflag.FilterFlagStatusFlaggedAction;
import com.github.haixing_hu.ilibrary.action.view.filterflag.FilterFlagStatusUnflaggedAction;
import com.github.haixing_hu.ilibrary.action.view.filterread.FilterReadStatusAction;
import com.github.haixing_hu.ilibrary.action.view.filterread.FilterReadStatusAllAction;
import com.github.haixing_hu.ilibrary.action.view.filterread.FilterReadStatusHasReadAction;
import com.github.haixing_hu.ilibrary.action.view.filterread.FilterReadStatusReadingAction;
import com.github.haixing_hu.ilibrary.action.view.filterread.FilterReadStatusToReadAction;
import com.github.haixing_hu.ilibrary.action.view.filterread.FilterReadStatusUnreadAction;
import com.github.haixing_hu.ilibrary.action.view.filtertype.FilterTypeAction;
import com.github.haixing_hu.ilibrary.action.view.filtertype.FilterTypeAllAction;
import com.github.haixing_hu.ilibrary.action.view.filtertype.FilterTypeArticleAction;
import com.github.haixing_hu.ilibrary.action.view.filtertype.FilterTypeBookAction;
import com.github.haixing_hu.ilibrary.action.view.filtertype.FilterTypeLegalAction;
import com.github.haixing_hu.ilibrary.action.view.filtertype.FilterTypeMediaAction;
import com.github.haixing_hu.ilibrary.action.view.filtertype.FilterTypeReferenceAction;
import com.github.haixing_hu.ilibrary.action.view.inspector.HideInspectorAction;
import com.github.haixing_hu.ilibrary.action.view.inspector.InspectorAction;
import com.github.haixing_hu.ilibrary.action.view.inspector.InspectorInfoTabAction;
import com.github.haixing_hu.ilibrary.action.view.inspector.InspectorNotesTabAction;
import com.github.haixing_hu.ilibrary.action.view.inspector.InspectorOverviewTabAction;
import com.github.haixing_hu.ilibrary.action.view.inspector.InspectorReviewsTabAction;
import com.github.haixing_hu.ilibrary.action.view.inspector.ShowInspectorAction;
import com.github.haixing_hu.ilibrary.action.view.layout.LayoutModeAction;
import com.github.haixing_hu.ilibrary.action.view.layout.LayoutModeAllAction;
import com.github.haixing_hu.ilibrary.action.view.layout.LayoutModeInspectorOnlyAction;
import com.github.haixing_hu.ilibrary.action.view.layout.LayoutModeNoneAction;
import com.github.haixing_hu.ilibrary.action.view.layout.LayoutModePreviewOnlyAction;
import com.github.haixing_hu.ilibrary.action.view.preview.HidePreviewAction;
import com.github.haixing_hu.ilibrary.action.view.preview.PreviewAction;
import com.github.haixing_hu.ilibrary.action.view.preview.ShowPreviewAction;
import com.github.haixing_hu.ilibrary.action.window.WindowAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageAuthorsAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageLibraryAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageReaderAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageSearchAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageSourcesAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageTagsAction;
import com.github.haixing_hu.ilibrary.gui.MainWindow;
import com.github.haixing_hu.ilibrary.gui.Page;
import com.github.haixing_hu.ilibrary.model.DocumentType;
import com.github.haixing_hu.ilibrary.model.FileStatus;
import com.github.haixing_hu.ilibrary.model.FlagStatus;
import com.github.haixing_hu.ilibrary.model.ReadStatus;
import com.github.haixing_hu.ilibrary.state.AnnotateMode;
import com.github.haixing_hu.ilibrary.state.ApplicationState;
import com.github.haixing_hu.ilibrary.state.BrowserMode;
import com.github.haixing_hu.ilibrary.state.InspectorTab;
import com.github.haixing_hu.ilibrary.state.LayoutMode;
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
      display.dispose();
    }
    SWTResourceManager.dispose();
  }

  /**
   * Synchronize the application states and the application UI.
   */
  private void syncState() {
    logger.info("Synchronizing the applicatino state ...");
    updatePage();
    updateNavigatorWidth();
    updateNavigatorVisibility();
    updateInspectorWidth();
    updatePreviewHeight();
    updateLayoutMode();
    updateInspectorTab();
    updateBrowserMode();
    updateAnnotateMode();
    updateFlagStatusFilters();
    updateReadStatusFilters();
    updateTypeFilters();
    updateFileStatusFilters();
    filterDocuments();
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
      state.setNavigatorWidth(width);
      updateNavigatorWidth();
    }
  }

  private void updateNavigatorWidth() {
    final int width = state.getNavigatorWidth();
    mainWindow.setNavigatorWidth(width);
    if (! state.isNavigatorVisible()) {
      state.setNavigatorVisible(true);
      updateNavigatorVisibility();
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
    if (state.isNavigatorVisible() == visible) {
      return;
    }
    logger.info("Sets the visible of navigator panel to: {}", visible);
    state.setNavigatorVisible(visible);
    updateNavigatorVisibility();
  }

  private void updateNavigatorVisibility() {
    final DropDownAction viewAction = (DropDownAction) actionManager.get(ViewAction.KEY);
    final boolean visible = state.isNavigatorVisible();
    if (visible) {
      viewAction.showSubAction(HideNavigatorAction.KEY);
      viewAction.hideSubAction(ShowNavigatorAction.KEY);
      viewAction.update(true);
      mainWindow.setNavigatorWidth(state.getNavigatorWidth());
    } else {
      viewAction.hideSubAction(HideNavigatorAction.KEY);
      viewAction.showSubAction(ShowNavigatorAction.KEY);
      viewAction.update(true);
      mainWindow.setNavigatorWidth(0);
    }
    mainWindow.setToolBarActionVisibility(HideNavigatorAction.KEY, visible);
    mainWindow.setToolBarActionVisibility(ShowNavigatorAction.KEY, (! visible));
    mainWindow.updateToolBar(true);
  }

  /**
   * Sets the width of the inspector panel.
   *
   * @param width
   *          the width to be set. If it is less than or equal to 0, the
   *          function will hide the inspector panel.
   */
  public void setInspectorWidth(int width) {
    if (state.getInspectorWidth() == width) {
      return;
    }
    if (width <= 0) {
      setInspectorVisible(false);
    } else {
      logger.debug("Sets the inspector panel width to: {}", width);
      state.setInspectorWidth(width);
      updateInspectorWidth();
    }
  }

  private void updateInspectorWidth() {
    final int width = state.getInspectorWidth();
    mainWindow.setInspectorWidth(width);
    final int mode = state.getLayoutMode();
    if ((mode & LayoutMode.INSPECTOR) == 0) {
      state.setLayoutMode(mode | LayoutMode.INSPECTOR);
      updateLayoutMode();
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
    if (state.isInspectorVisible() == visible) {
      return;
    }
    logger.info("Sets the visible of inspector panel to: {}", visible);
    final int mode = state.getLayoutMode();
    if (visible) {
      state.setLayoutMode(mode | LayoutMode.INSPECTOR);
    } else {
      state.setLayoutMode(mode & (~ LayoutMode.INSPECTOR));
    }
    updateLayoutMode();
  }


  /**
   * Sets the height of the preview panel.
   *
   * @param height
   *          the height to be set. If it is less than or equal to 0, the
   *          function will hide the preview panel.
   */
  public void setPreviewHeight(int height) {
    if (state.getPreviewHeight() == height) {
      return;
    }
    if (height <= 0) {
      setPreviewVisible(false);
    } else {
      logger.debug("Sets the preview panel height to: {}", height);
      state.setPreviewHeight(height);
      updatePreviewHeight();
    }
  }

  private void updatePreviewHeight() {
    final int height = state.getPreviewHeight();
    mainWindow.setPreviewHeight(height);
    final int mode = state.getLayoutMode();
    if ((mode & LayoutMode.PREVIEW) == 0) {
      state.setLayoutMode(mode | LayoutMode.PREVIEW);
      updateLayoutMode();
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
    if (state.isPreviewVisible() == visible) {
      return;
    }
    logger.info("Sets the visible of preview panel to: {}", visible);
    final int mode = state.getLayoutMode();
    if (visible) {
      state.setLayoutMode(mode | LayoutMode.PREVIEW);
    } else {
      state.setLayoutMode(mode & (~ LayoutMode.PREVIEW));
    }
    updateLayoutMode();
  }

  /**
   * Sets the layout mode.
   *
   * @param mode
   *      the new layout mode.
   */
  public void setLayoutMode(int mode) {
    if (state.getLayoutMode() == mode) {
      return;
    }
    logger.info("Set the layout mode to: {}", mode);
    state.setLayoutMode(mode);
    updateLayoutMode();
  }

  private void updateLayoutMode() {
    final DropDownAction previewAction = (DropDownAction) actionManager.get(PreviewAction.KEY);
    final DropDownAction inspectorAction = (DropDownAction) actionManager.get(InspectorAction.KEY);
    final DropDownAction viewModeAction = (DropDownAction) actionManager.get(LayoutModeAction.KEY);
    final ActionEx modeAll = actionManager.get(LayoutModeAllAction.KEY);
    final ActionEx modeInspector = actionManager.get(LayoutModeInspectorOnlyAction.KEY);
    final ActionEx modePreview = actionManager.get(LayoutModePreviewOnlyAction.KEY);
    final ActionEx modeNone = actionManager.get(LayoutModeNoneAction.KEY);

    modeAll.setChecked(false);
    modeInspector.setChecked(false);
    modePreview.setChecked(false);
    modeNone.setChecked(false);
    final int mode = state.getLayoutMode();
    switch (mode) {
    case LayoutMode.NONE:
      //  change the menu items
      inspectorAction.showSubAction(ShowInspectorAction.KEY);
      inspectorAction.hideSubAction(HideInspectorAction.KEY);
      previewAction.showSubAction(ShowPreviewAction.KEY);
      previewAction.hideSubAction(HidePreviewAction.KEY);
      //  change the tool bar items
      mainWindow.setToolBarActionVisibility(ShowInspectorAction.KEY, true);
      mainWindow.setToolBarActionVisibility(HideInspectorAction.KEY, false);
      mainWindow.setToolBarActionVisibility(ShowPreviewAction.KEY, true);
      mainWindow.setToolBarActionVisibility(HidePreviewAction.KEY, false);
      //  change the action's checking state
      modeNone.setChecked(true);
      viewModeAction.setImageDescriptor(modeNone.getImageDescriptor());
      //  hide the inspector panel and preview panel
      mainWindow.setInspectorWidth(0);
      mainWindow.setPreviewHeight(0);
      break;
    case LayoutMode.INSPECTOR:
      //  change the menu items
      inspectorAction.hideSubAction(ShowInspectorAction.KEY);
      inspectorAction.showSubAction(HideInspectorAction.KEY);
      previewAction.showSubAction(ShowPreviewAction.KEY);
      previewAction.hideSubAction(HidePreviewAction.KEY);
      //  change the tool bar items
      mainWindow.setToolBarActionVisibility(ShowInspectorAction.KEY, false);
      mainWindow.setToolBarActionVisibility(HideInspectorAction.KEY, true);
      mainWindow.setToolBarActionVisibility(ShowPreviewAction.KEY, true);
      mainWindow.setToolBarActionVisibility(HidePreviewAction.KEY, false);
      //  change the action's checking state
      modeInspector.setChecked(true);
      viewModeAction.setImageDescriptor(modeInspector.getImageDescriptor());
      //  show the inspector panel and hide the preview panel
      mainWindow.setInspectorWidth(state.getInspectorWidth());
      mainWindow.setPreviewHeight(0);
      break;
    case LayoutMode.PREVIEW:
      //  change the menu items
      inspectorAction.showSubAction(ShowInspectorAction.KEY);
      inspectorAction.hideSubAction(HideInspectorAction.KEY);
      previewAction.hideSubAction(ShowPreviewAction.KEY);
      previewAction.showSubAction(HidePreviewAction.KEY);
      //  change the tool bar items
      mainWindow.setToolBarActionVisibility(ShowInspectorAction.KEY, true);
      mainWindow.setToolBarActionVisibility(HideInspectorAction.KEY, false);
      mainWindow.setToolBarActionVisibility(ShowPreviewAction.KEY, false);
      mainWindow.setToolBarActionVisibility(HidePreviewAction.KEY, true);
      //  change the action's checking state
      modePreview.setChecked(true);
      viewModeAction.setImageDescriptor(modePreview.getImageDescriptor());
      //  hide the inspector panel and show the preview panel
      mainWindow.setInspectorWidth(0);
      mainWindow.setPreviewHeight(state.getPreviewHeight());
      break;
    case LayoutMode.ALL:
      //  change the menu items
      inspectorAction.hideSubAction(ShowInspectorAction.KEY);
      inspectorAction.showSubAction(HideInspectorAction.KEY);
      previewAction.hideSubAction(ShowPreviewAction.KEY);
      previewAction.showSubAction(HidePreviewAction.KEY);
      //  change the tool bar items
      mainWindow.setToolBarActionVisibility(ShowInspectorAction.KEY, false);
      mainWindow.setToolBarActionVisibility(HideInspectorAction.KEY, true);
      mainWindow.setToolBarActionVisibility(ShowPreviewAction.KEY, false);
      mainWindow.setToolBarActionVisibility(HidePreviewAction.KEY, true);
      //  change the action's checking state
      modeAll.setChecked(true);
      viewModeAction.setImageDescriptor(modeAll.getImageDescriptor());
      //  show the inspector panel and the preview panel
      mainWindow.setInspectorWidth(state.getInspectorWidth());
      mainWindow.setPreviewHeight(state.getPreviewHeight());
      break;
    default:
      logger.error("Unknown view mode: {}", mode);
      return;
    }
    viewModeAction.update(true);
    inspectorAction.update(true);
    previewAction.update(true);
    mainWindow.updateToolBar(true);
  }

  /**
   * Sets the tab folder of the inspector panel on all pages to the specified
   * tab.
   *
   * @param tab
   *          the tab to be switched to.
   */
  public void setInspectorTab(InspectorTab tab) {
    if (state.getInspectorTab() == tab) {
      return;
    }
    logger.info("Switch inspector tab to: {}", tab);
    state.setInspectorTab(tab);
    updateInspectorTab();
  }

  private void updateInspectorTab() {
    final DropDownAction windowAction = (DropDownAction) actionManager.get(WindowAction.KEY);
    final ActionEx infoTabAction = actionManager.get(InspectorInfoTabAction.KEY);
    final ActionEx notesTabAction = actionManager.get(InspectorNotesTabAction.KEY);
    final ActionEx reviewsTabAction = actionManager.get(InspectorReviewsTabAction.KEY);
    final ActionEx filesTabAction = actionManager.get(InspectorOverviewTabAction.KEY);
    infoTabAction.setChecked(false);
    notesTabAction.setChecked(false);
    reviewsTabAction.setChecked(false);
    filesTabAction.setChecked(false);
    final InspectorTab tab = state.getInspectorTab();
    switch (tab) {
    case INFO:
      infoTabAction.setChecked(true);
      break;
    case NOTES:
      notesTabAction.setChecked(true);
      break;
    case REVIEWS:
      reviewsTabAction.setChecked(true);
      break;
    case OVERVIEW:
      filesTabAction.setChecked(true);
      break;
    default:
      logger.error("Unknown inspector tab: {}", tab);
      break;
    }
    windowAction.update(true);
    mainWindow.setInspectorTab(tab);
  }

  /**
   * Sets the browser mode
   *
   * @param mode
   *          the new browser mode.
   */
  public void setBrowserMode(BrowserMode mode) {
    if (state.getBrowserMode() == mode) {
      return;
    }
    logger.info("Set the browser mode to: {}", mode);
    state.setBrowserMode(mode);
    updateBrowserMode();
  }

  private void updateBrowserMode() {
    final DropDownAction view = (DropDownAction) actionManager.get(ViewAction.KEY);
    final DropDownAction browserMode = (DropDownAction) actionManager.get(BrowserModeAction.KEY);
    final BaseAction asList = (BaseAction) actionManager.get(AsListAction.KEY);
    final BaseAction asColumns = (BaseAction) actionManager.get(AsColumnsAction.KEY);
    final BaseAction asIcons = (BaseAction) actionManager.get(AsIconsAction.KEY);
    final BaseAction asCoverFlow = (BaseAction) actionManager.get(AsCoverFlowAction.KEY);
    asList.setChecked(false);
    asColumns.setChecked(false);
    asIcons.setChecked(false);
    asCoverFlow.setChecked(false);
    final BrowserMode mode = state.getBrowserMode();
    switch (mode) {
    case LIST:
      asList.setChecked(true);
      browserMode.setImageDescriptor(asList.getActiveIcon());
      break;
    case COLUMNS:
      asColumns.setChecked(true);
      browserMode.setImageDescriptor(asColumns.getActiveIcon());
      break;
    case ICONS:
      asIcons.setChecked(true);
      browserMode.setImageDescriptor(asIcons.getActiveIcon());
      break;
    case COVER_FLOW:
      asCoverFlow.setChecked(true);
      browserMode.setImageDescriptor(asCoverFlow.getActiveIcon());
      break;
    default:
      logger.error("Unknown browser mode: ", mode);
      return;
    }
    view.update(true);
    browserMode.update(true);
    //  TODO: change the browser mode
  }

  /**
   * Clears the flag status filters, in order to display documents with all
   * possible flag status.
   */
  public void clearFlagStatusFilters() {
    logger.info("Clears the flag status filters.");
    final Set<FlagStatus> filters = state.getFlagStatusFilters();
    filters.clear();
    updateFlagStatusFilters();
    filterDocuments();
  }

  /**
   * Sets flag status filters to contains a single flag status.
   *
   * @param value
   *          the single flag status to be sets to the filters.
   */
  public void setFlagStatusFilter(FlagStatus value) {
    logger.info("Sets the flag status filters to: {}", value);
    final Set<FlagStatus> filters = state.getFlagStatusFilters();
    filters.clear();
    filters.add(value);
    updateFlagStatusFilters();
    filterDocuments();
  }

  private void updateFlagStatusFilters() {
    final DropDownAction flagFilter = (DropDownAction)
        actionManager.get(FilterFlagStatusAction.KEY);
    final ActionEx all = actionManager.get(FilterFlagStatusAllAction.KEY);
    final ActionEx flagged = actionManager.get(FilterFlagStatusFlaggedAction.KEY);
    final ActionEx unflagged = actionManager.get(FilterFlagStatusUnflaggedAction.KEY);
    all.setChecked(false);
    flagged.setChecked(false);
    unflagged.setChecked(false);
    final Set<FlagStatus> filters = state.getFlagStatusFilters();
    logger.info("Updating flag status filters: {}", filters);
    if (filters.isEmpty() || (filters.size() == FlagStatus.values().length)) {
      all.setChecked(true);
      filters.clear();
    } else {
      for (final FlagStatus value : filters) {
        switch (value) {
        case FLAGGED:
          flagged.setChecked(true);
          break;
        case UNFLAGGED:
          unflagged.setChecked(true);
          break;
        default:
          logger.error("Unknown flag status: {}", value);
          return;
        }
      }
    }
    flagFilter.update(true);
  }

  /**
   * Clears the read status filters, in order to display documents with all
   * possible read status.
   */
  public void clearReadStatusFilters() {
    logger.info("Clears the read status filters.");
    final Set<ReadStatus> filters = state.getReadStatusFilters();
    filters.clear();
    updateReadStatusFilters();
    filterDocuments();
  }

  /**
   * Add a read status to the read status filters.
   *
   * @param value
   *          the value of read status to be added to the filters.
   */
  public void addReadStatusFilter(ReadStatus value) {
    logger.info("Adds {} to the read status filters.", value);
    final Set<ReadStatus> filters = state.getReadStatusFilters();
    filters.add(value);
    updateReadStatusFilters();
    filterDocuments();
  }

  /**
   * Removes a read status from the read status filters.
   *
   * @param value
   *          the value of read status to be removed from the filters.
   */
  public void removeReadStatusFilter(ReadStatus value) {
    logger.info("Removes {} from the read status filters.", value);
    final Set<ReadStatus> filters = state.getReadStatusFilters();
    filters.remove(value);
    updateReadStatusFilters();
    filterDocuments();
  }

  private void updateReadStatusFilters() {
    //  TODO: set the filter in the document list table
    final DropDownAction filterAction =
        (DropDownAction) actionManager.get(FilterReadStatusAction.KEY);
    final ActionEx all = actionManager.get(FilterReadStatusAllAction.KEY);
    final ActionEx unread = actionManager.get(FilterReadStatusUnreadAction.KEY);
    final ActionEx toread = actionManager.get(FilterReadStatusToReadAction.KEY);
    final ActionEx reading = actionManager.get(FilterReadStatusReadingAction.KEY);
    final ActionEx hasRead = actionManager.get(FilterReadStatusHasReadAction.KEY);
    all.setChecked(false);
    unread.setChecked(false);
    toread.setChecked(false);
    reading.setChecked(false);
    hasRead.setChecked(false);
    final Set<ReadStatus> filters = state.getReadStatusFilters();
    logger.info("Updating read status filters: {}", filters);
    if (filters.isEmpty() || (filters.size() == ReadStatus.values().length)) {
      all.setChecked(true);
      filters.clear();
    } else {
      for (final ReadStatus value : filters) {
        switch (value) {
        case UNREAD:
          unread.setChecked(true);
          break;
        case TO_READ:
          toread.setChecked(true);
          break;
        case READING:
          reading.setChecked(true);
          break;
        case HAS_READ:
          hasRead.setChecked(true);
          break;
        default:
          logger.error("Unknown flag status: {}", value);
          return;
        }
      }
    }
    filterAction.update(true);
  }

  /**
   * Clears the document type filters, in order to display documents with all
   * possible document types.
   */
  public void clearTypeStatusFilters() {
    logger.info("Clears the document type filters.");
    final Set<DocumentType> filters = state.getTypeFilters();
    filters.clear();
    updateTypeFilters();
    filterDocuments();
  }

  /**
   * Add a document type to the document type filters.
   *
   * @param value
   *          the value of document type to be added to the filters.
   */
  public void addTypeStatusFilter(DocumentType value) {
    logger.info("Adds {} to the document type filters.", value);
    final Set<DocumentType> filters = state.getTypeFilters();
    filters.add(value);
    updateTypeFilters();
    filterDocuments();
  }

  /**
   * Removes a document type from the document type filters.
   *
   * @param value
   *          the value of document type to be removed from the filters.
   */
  public void removeTypeStatusFilter(DocumentType value) {
    logger.info("Removes {} from the document type filters.", value);
    final Set<DocumentType> filters = state.getTypeFilters();
    filters.remove(value);
    updateTypeFilters();
    filterDocuments();
  }

  private void updateTypeFilters() {
    final DropDownAction filterAction = (DropDownAction) actionManager.get(FilterTypeAction.KEY);
    final ActionEx all = actionManager.get(FilterTypeAllAction.KEY);
    final ActionEx article = actionManager.get(FilterTypeArticleAction.KEY);
    final ActionEx book = actionManager.get(FilterTypeBookAction.KEY);
    final ActionEx reference = actionManager.get(FilterTypeReferenceAction.KEY);
    final ActionEx legal = actionManager.get(FilterTypeLegalAction.KEY);
    final ActionEx media = actionManager.get(FilterTypeMediaAction.KEY);
    all.setChecked(false);
    article.setChecked(false);
    book.setChecked(false);
    reference.setChecked(false);
    legal.setChecked(false);
    media.setChecked(false);
    final Set<DocumentType> filters = state.getTypeFilters();
    logger.info("Updating document type filters: {}", filters);
    if (filters.isEmpty() || (filters.size() == DocumentType.values().length)) {
      all.setChecked(true);
      filters.clear();
    } else {
      for (final DocumentType value : filters) {
        switch (value) {
        case ARTICLE:
          article.setChecked(true);
          break;
        case BOOK:
          book.setChecked(true);
          break;
        case REFERENCE:
          reference.setChecked(true);
          break;
        case LEGAL:
          legal.setChecked(true);
          break;
        case MEDIA:
          media.setChecked(true);
          break;
        default:
          logger.error("Unknown document type filter: {}", value);
          return;
        }
      }
    }
    filterAction.update(true);
  }


  /**
   * Clears the file status filters, in order to display documents with all
   * possible file status.
   */
  public void clearFileStatusFilters() {
    logger.info("Clears the file status filters.");
    final Set<FileStatus> filters = state.getFileStatusFilters();
    filters.clear();
    updateFileStatusFilters();
    filterDocuments();
  }

  /**
   * Sets the file status filters to contains a single file status.
   *
   * @param value
   *          the single file status to be set to the filters.
   */
  public void setFileStatusFilter(FileStatus value) {
    logger.info("Sets the file status filters to {}.", value);
    final Set<FileStatus> filters = state.getFileStatusFilters();
    filters.clear();
    filters.add(value);
    updateFileStatusFilters();
    filterDocuments();
  }

  private void updateFileStatusFilters() {
    final DropDownAction filterAction =
        (DropDownAction) actionManager.get(FilterFileStatusAction.KEY);
    final ActionEx all = actionManager.get(FilterFileStatusAllAction.KEY);
    final ActionEx has_file = actionManager.get(FilterFileStatusHasFileAction.KEY);
    final ActionEx no_file = actionManager.get(FilterFileStatusNoFileAction.KEY);
    all.setChecked(false);
    has_file.setChecked(false);
    no_file.setChecked(false);
    final Set<FileStatus> filters = state.getFileStatusFilters();
    logger.info("Updating file status filters: {}", filters);
    if (filters.isEmpty() || (filters.size() == FileStatus.values().length)) {
      all.setChecked(true);
      filters.clear();
    } else {
      for (final FileStatus value : filters) {
        switch (value) {
        case HAS_FILE:
          has_file.setChecked(true);
          break;
        case NO_FILE:
          no_file.setChecked(true);
          break;
        default:
          logger.error("Unknown file status filter: ", value);
          return;
        }
      }
    }
    filterAction.update(true);
  }

  private void filterDocuments() {
    logger.info("Filtering documents ...");
    //  TODO
  }

  /**
   * Sets the annotate mode.
   *
   * @param mode
   *          the mode to be set.
   */
  public void setAnnotateMode(AnnotateMode mode) {
    if (state.getAnnotateMode() == mode) {
      return;
    }
    logger.info("Set the annotate mode to: {}", mode);
    state.setAnnotateMode(mode);
    updateAnnotateMode();
  }

  private void updateAnnotateMode() {
    final DropDownAction annotate = (DropDownAction) actionManager.get(AnnotateAction.KEY);
    final ActionEx selection = actionManager.get(AnnotateSelectionAction.KEY);
    final ActionEx highlight = actionManager.get(AnnotateHighlightAction.KEY);
    final ActionEx underline = actionManager.get(AnnotateUnderlineAction.KEY);
    final ActionEx strikethrough = actionManager.get(AnnotateStrikethroughAction.KEY);
    final AnnotateMode mode = state.getAnnotateMode();
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
    //  TODO
  }

  /**
   * Sets the current page of the application.
   *
   * @param page
   *    the id of the page.
   */
  public void setPage(int page) {
    if (state.getPage() == page) {
      return;
    }
    logger.info("Set the page to: {}", page);
    state.setPage(page);
    updatePage();
  }

  private void updatePage() {
    final DropDownAction windowAction = (DropDownAction) actionManager.get(WindowAction.KEY);
    final ActionEx searchPageAction = actionManager.get(PageSearchAction.KEY);
    final ActionEx libraryPageAction = actionManager.get(PageLibraryAction.KEY);
    final ActionEx tagsPageAction = actionManager.get(PageTagsAction.KEY);
    final ActionEx authorsPageAction = actionManager.get(PageAuthorsAction.KEY);
    final ActionEx sourcesPageAction = actionManager.get(PageSourcesAction.KEY);
    final ActionEx readerPageAction = actionManager.get(PageReaderAction.KEY);
    searchPageAction.setChecked(false);
    libraryPageAction.setChecked(false);
    tagsPageAction.setChecked(false);
    authorsPageAction.setChecked(false);
    sourcesPageAction.setChecked(false);
    readerPageAction.setChecked(false);
    final int page = state.getPage();
    switch (page) {
    case Page.SEARCH:
      searchPageAction.setChecked(true);
      break;
    case Page.LIBRARY:
      libraryPageAction.setChecked(true);
      break;
    case Page.TAGS:
      tagsPageAction.setChecked(true);
      break;
    case Page.AUTHORS:
      authorsPageAction.setChecked(true);
      break;
    case Page.SOURCES:
      sourcesPageAction.setChecked(true);
      break;
    case Page.READER:
      readerPageAction.setChecked(true);
      break;
    default:
      logger.error("Unknown page: ", page);
      return;
    }
    windowAction.update(true);
    mainWindow.setPage(page);
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
