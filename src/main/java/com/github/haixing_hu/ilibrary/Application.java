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

import javax.annotation.Nullable;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.action.ActionManager;
import com.github.haixing_hu.ilibrary.action.BaseAction;
import com.github.haixing_hu.ilibrary.action.BaseDropDownAction;
import com.github.haixing_hu.ilibrary.action.edit.annotate.AnnotateAction;
import com.github.haixing_hu.ilibrary.action.edit.annotate.AnnotateHighlightAction;
import com.github.haixing_hu.ilibrary.action.edit.annotate.AnnotateNoteAction;
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
import com.github.haixing_hu.ilibrary.action.view.columns.SelectColumnForAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterDocumentTypeAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterDocumentTypeAllAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterDocumentTypeForAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterFileStatusAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterFileStatusAllAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterFileStatusHasFileAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterFileStatusNoFileAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterFlagStatusAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterFlagStatusAllAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterFlagStatusFlaggedAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterFlagStatusUnflaggedAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterReadStatusAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterReadStatusAllAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterReadStatusHasReadAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterReadStatusReadingAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterReadStatusToReadAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterReadStatusUnreadAction;
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
import com.github.haixing_hu.ilibrary.action.view.sort.SortAction;
import com.github.haixing_hu.ilibrary.action.view.sort.SortByColumnForAction;
import com.github.haixing_hu.ilibrary.action.view.sort.SortByDefaultColumnAction;
import com.github.haixing_hu.ilibrary.action.view.sort.SortOrderAscAction;
import com.github.haixing_hu.ilibrary.action.view.sort.SortOrderDescAction;
import com.github.haixing_hu.ilibrary.action.window.WindowAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageAuthorsAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageLibraryAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageReaderAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageSearchAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageSourcesAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageTagsAction;
import com.github.haixing_hu.ilibrary.gui.MainWindow;
import com.github.haixing_hu.ilibrary.model.DocumentTemplate;
import com.github.haixing_hu.ilibrary.model.DocumentType;
import com.github.haixing_hu.ilibrary.model.FieldType;
import com.github.haixing_hu.ilibrary.model.FileStatus;
import com.github.haixing_hu.ilibrary.model.FlagStatus;
import com.github.haixing_hu.ilibrary.model.ReadStatus;
import com.github.haixing_hu.ilibrary.state.AnnotateMode;
import com.github.haixing_hu.ilibrary.state.ApplicationState;
import com.github.haixing_hu.ilibrary.state.BrowserMode;
import com.github.haixing_hu.ilibrary.state.InspectorTab;
import com.github.haixing_hu.ilibrary.state.LayoutMode;
import com.github.haixing_hu.ilibrary.state.Page;
import com.github.haixing_hu.ilibrary.state.SortOrder;
import com.github.haixing_hu.swt.action.ActionEx;
import com.github.haixing_hu.swt.action.DropDownAction;
import com.github.haixing_hu.swt.utils.SWTResourceManager;
import com.github.haixing_hu.swt.window.Dialog;

/**
 * The main class of the application.
 *
 * @author Haixing Hu
 */
public final class Application implements MessageKey, KeySuffix {

  public static final String CONTEXT_FILE = "applicationContext.xml";

  public static final String ID = "app";

  private final Logger logger;
  private final AppConfig config;
  private final ApplicationState state;
  private final ActionManager am;
  private final MainWindow mainWindow;

  /**
   * Constructs an application.
   */
  public Application() {
    logger = LoggerFactory.getLogger(Application.class);
    config = new AppConfig(CONTEXT_FILE);
    state = new ApplicationState();
    am = new ActionManager(this);
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
    state.load(config);
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
    updateNavigatorWidth();
    updateNavigatorVisibility();
    updateInspectorWidth();
    updatePreviewHeight();
    updateLayoutMode();
    updateInspectorTab();
    updateBrowserMode();
    updateAnnotateMode();
    updatePage();
  }

  /**
   * Displays an error message dialog indicating that the specified function has
   * not been implemented yet.
   *
   * @param key the key of the action.
   */
  public void displayUnimplementedError(String key) {
    final String title = config.getMessage(ERROR);
    final String message = config.getMessage(ERROR_UNIMPLEMENTED)
        + ": " + key;
    Dialog.error(title, message);
  }

  /**
   * Gets the action manager of this application.
   *
   * @return the action manager of this application.
   */
  public ActionManager getActionManager() {
    return am;
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
   * Gets the shell of the application.
   *
   * @return
   *    the shell of the application.
   */
  public Shell getShell() {
    return mainWindow.getShell();
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
   * Sets the current page of the application.
   *
   * @param page
   *    the id of the page.
   */
  public void setPage(Page page) {
    if (state.getPage() == page) {
      return;
    }
    logger.info("Set the page to: {}", page);
    state.setPage(page);
    updatePage();
  }

  private void updatePage() {
    final DropDownAction windowAction = (DropDownAction) am.get(WindowAction.ID);
    final ActionEx searchPageAction = am.get(PageSearchAction.ID);
    final ActionEx libraryPageAction = am.get(PageLibraryAction.ID);
    final ActionEx tagsPageAction = am.get(PageTagsAction.ID);
    final ActionEx authorsPageAction = am.get(PageAuthorsAction.ID);
    final ActionEx sourcesPageAction = am.get(PageSourcesAction.ID);
    final ActionEx readerPageAction = am.get(PageReaderAction.ID);
    searchPageAction.setChecked(false);
    libraryPageAction.setChecked(false);
    tagsPageAction.setChecked(false);
    authorsPageAction.setChecked(false);
    sourcesPageAction.setChecked(false);
    readerPageAction.setChecked(false);
    final Page page = state.getPage();
    switch (page) {
    case SEARCH:
      searchPageAction.setChecked(true);
      break;
    case LIBRARY:
      libraryPageAction.setChecked(true);
      break;
    case TAGS:
      tagsPageAction.setChecked(true);
      break;
    case AUTHORS:
      authorsPageAction.setChecked(true);
      break;
    case SOURCES:
      sourcesPageAction.setChecked(true);
      break;
    case READER:
      readerPageAction.setChecked(true);
      break;
    default:
      logger.error("Unknown page: ", page);
      return;
    }
    windowAction.update(true);
    mainWindow.setPage(page);

    //  update the page related states
    updateFlagStatusFilters();
    updateReadStatusFilters();
    updateTypeFilters();
    updateFileStatusFilters();
    updateFilterActionIcon();
    updateColumns();
    updateSortColumn();
    updateSortOrder();
    updateSortActionIcon();
    filterDocuments();
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
    final DropDownAction viewAction = (DropDownAction) am.get(ViewAction.ID);
    final boolean visible = state.isNavigatorVisible();
    if (visible) {
      viewAction.showSubAction(HideNavigatorAction.ID);
      viewAction.hideSubAction(ShowNavigatorAction.ID);
      viewAction.update(true);
      mainWindow.setNavigatorWidth(state.getNavigatorWidth());
    } else {
      viewAction.hideSubAction(HideNavigatorAction.ID);
      viewAction.showSubAction(ShowNavigatorAction.ID);
      viewAction.update(true);
      mainWindow.setNavigatorWidth(0);
    }
    mainWindow.setToolBarActionVisibility(HideNavigatorAction.ID, visible);
    mainWindow.setToolBarActionVisibility(ShowNavigatorAction.ID, (! visible));
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
    final DropDownAction previewAction = (DropDownAction) am.get(PreviewAction.ID);
    final DropDownAction inspectorAction = (DropDownAction) am.get(InspectorAction.ID);
    final DropDownAction viewModeAction = (DropDownAction) am.get(LayoutModeAction.ID);
    final ActionEx modeAll = am.get(LayoutModeAllAction.ID);
    final ActionEx modeInspector = am.get(LayoutModeInspectorOnlyAction.ID);
    final ActionEx modePreview = am.get(LayoutModePreviewOnlyAction.ID);
    final ActionEx modeNone = am.get(LayoutModeNoneAction.ID);

    modeAll.setChecked(false);
    modeInspector.setChecked(false);
    modePreview.setChecked(false);
    modeNone.setChecked(false);
    final int mode = state.getLayoutMode();
    switch (mode) {
    case LayoutMode.NONE:
      //  change the menu items
      inspectorAction.showSubAction(ShowInspectorAction.ID);
      inspectorAction.hideSubAction(HideInspectorAction.ID);
      previewAction.showSubAction(ShowPreviewAction.ID);
      previewAction.hideSubAction(HidePreviewAction.ID);
      //  change the tool bar items
      mainWindow.setToolBarActionVisibility(ShowInspectorAction.ID, true);
      mainWindow.setToolBarActionVisibility(HideInspectorAction.ID, false);
      mainWindow.setToolBarActionVisibility(ShowPreviewAction.ID, true);
      mainWindow.setToolBarActionVisibility(HidePreviewAction.ID, false);
      //  change the action's checking state
      modeNone.setChecked(true);
      viewModeAction.setImageDescriptor(modeNone.getImageDescriptor());
      //  hide the inspector panel and preview panel
      mainWindow.setInspectorWidth(0);
      mainWindow.setPreviewHeight(0);
      break;
    case LayoutMode.INSPECTOR:
      //  change the menu items
      inspectorAction.hideSubAction(ShowInspectorAction.ID);
      inspectorAction.showSubAction(HideInspectorAction.ID);
      previewAction.showSubAction(ShowPreviewAction.ID);
      previewAction.hideSubAction(HidePreviewAction.ID);
      //  change the tool bar items
      mainWindow.setToolBarActionVisibility(ShowInspectorAction.ID, false);
      mainWindow.setToolBarActionVisibility(HideInspectorAction.ID, true);
      mainWindow.setToolBarActionVisibility(ShowPreviewAction.ID, true);
      mainWindow.setToolBarActionVisibility(HidePreviewAction.ID, false);
      //  change the action's checking state
      modeInspector.setChecked(true);
      viewModeAction.setImageDescriptor(modeInspector.getImageDescriptor());
      //  show the inspector panel and hide the preview panel
      mainWindow.setInspectorWidth(state.getInspectorWidth());
      mainWindow.setPreviewHeight(0);
      break;
    case LayoutMode.PREVIEW:
      //  change the menu items
      inspectorAction.showSubAction(ShowInspectorAction.ID);
      inspectorAction.hideSubAction(HideInspectorAction.ID);
      previewAction.hideSubAction(ShowPreviewAction.ID);
      previewAction.showSubAction(HidePreviewAction.ID);
      //  change the tool bar items
      mainWindow.setToolBarActionVisibility(ShowInspectorAction.ID, true);
      mainWindow.setToolBarActionVisibility(HideInspectorAction.ID, false);
      mainWindow.setToolBarActionVisibility(ShowPreviewAction.ID, false);
      mainWindow.setToolBarActionVisibility(HidePreviewAction.ID, true);
      //  change the action's checking state
      modePreview.setChecked(true);
      viewModeAction.setImageDescriptor(modePreview.getImageDescriptor());
      //  hide the inspector panel and show the preview panel
      mainWindow.setInspectorWidth(0);
      mainWindow.setPreviewHeight(state.getPreviewHeight());
      break;
    case LayoutMode.ALL:
      //  change the menu items
      inspectorAction.hideSubAction(ShowInspectorAction.ID);
      inspectorAction.showSubAction(HideInspectorAction.ID);
      previewAction.hideSubAction(ShowPreviewAction.ID);
      previewAction.showSubAction(HidePreviewAction.ID);
      //  change the tool bar items
      mainWindow.setToolBarActionVisibility(ShowInspectorAction.ID, false);
      mainWindow.setToolBarActionVisibility(HideInspectorAction.ID, true);
      mainWindow.setToolBarActionVisibility(ShowPreviewAction.ID, false);
      mainWindow.setToolBarActionVisibility(HidePreviewAction.ID, true);
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
    final DropDownAction windowAction = (DropDownAction) am.get(WindowAction.ID);
    final ActionEx infoTabAction = am.get(InspectorInfoTabAction.ID);
    final ActionEx notesTabAction = am.get(InspectorNotesTabAction.ID);
    final ActionEx reviewsTabAction = am.get(InspectorReviewsTabAction.ID);
    final ActionEx filesTabAction = am.get(InspectorOverviewTabAction.ID);
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
    final DropDownAction view = (DropDownAction) am.get(ViewAction.ID);
    final DropDownAction browserMode = (DropDownAction) am.get(BrowserModeAction.ID);
    final BaseAction asList = (BaseAction) am.get(AsListAction.ID);
    final BaseAction asColumns = (BaseAction) am.get(AsColumnsAction.ID);
    final BaseAction asIcons = (BaseAction) am.get(AsIconsAction.ID);
    final BaseAction asCoverFlow = (BaseAction) am.get(AsCoverFlowAction.ID);
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
    final DropDownAction annotate = (DropDownAction) am.get(AnnotateAction.ID);
    final BaseAction selection = (BaseAction) am.get(AnnotateSelectionAction.ID);
    final BaseAction highlight = (BaseAction) am.get(AnnotateHighlightAction.ID);
    final BaseAction underline = (BaseAction) am.get(AnnotateUnderlineAction.ID);
    final BaseAction strikethrough = (BaseAction) am.get(AnnotateStrikethroughAction.ID);
    final BaseAction note = (BaseAction) am.get(AnnotateNoteAction.ID);
    final AnnotateMode mode = state.getAnnotateMode();
    selection.setChecked(false);
    highlight.setChecked(false);
    underline.setChecked(false);
    strikethrough.setChecked(false);
    note.setChecked(false);
    switch (mode) {
    case SELECTION:
      selection.setChecked(true);
      break;
    case HIGHLIGHT:
      highlight.setChecked(true);
      break;
    case UNDERLINE:
      underline.setChecked(true);
      break;
    case STRIKETHORUGH:
      strikethrough.setChecked(true);
      break;
    case NOTE:
      note.setChecked(true);
      break;
    default:
      logger.error("Unknown annotate mode: ", mode);
      return;
    }
    annotate.update(true);
    //  TODO
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
    updateFilterActionIcon();
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
    updateFilterActionIcon();
    filterDocuments();
  }

  private void updateFlagStatusFilters() {
    final DropDownAction flagFilter = (DropDownAction)
        am.get(FilterFlagStatusAction.ID);
    final ActionEx all = am.get(FilterFlagStatusAllAction.ID);
    final ActionEx flagged = am.get(FilterFlagStatusFlaggedAction.ID);
    final ActionEx unflagged = am.get(FilterFlagStatusUnflaggedAction.ID);
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
    updateFilterActionIcon();
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
    updateFilterActionIcon();
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
    updateFilterActionIcon();
    filterDocuments();
  }

  private void updateReadStatusFilters() {
    //  TODO: set the filter in the document list table
    final DropDownAction filterAction =
        (DropDownAction) am.get(FilterReadStatusAction.ID);
    final ActionEx all = am.get(FilterReadStatusAllAction.ID);
    final ActionEx unread = am.get(FilterReadStatusUnreadAction.ID);
    final ActionEx toread = am.get(FilterReadStatusToReadAction.ID);
    final ActionEx reading = am.get(FilterReadStatusReadingAction.ID);
    final ActionEx hasRead = am.get(FilterReadStatusHasReadAction.ID);
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
  public void clearDocumentTypeFilters() {
    logger.info("Clears the document type filters.");
    final Set<DocumentType> filters = state.getDocumentTypeFilters();
    filters.clear();
    updateTypeFilters();
    updateFilterActionIcon();
    filterDocuments();
  }

  /**
   * Add a document type to the document type filters.
   *
   * @param value
   *          the value of document type to be added to the filters.
   */
  public void addDocumentTypeFilter(DocumentType value) {
    logger.info("Adds {} to the document type filters.", value);
    final Set<DocumentType> filters = state.getDocumentTypeFilters();
    filters.add(value);
    updateTypeFilters();
    updateFilterActionIcon();
    filterDocuments();
  }

  /**
   * Removes a document type from the document type filters.
   *
   * @param value
   *          the value of document type to be removed from the filters.
   */
  public void removeDocumentTypeFilter(DocumentType value) {
    logger.info("Removes {} from the document type filters.", value);
    final Set<DocumentType> filters = state.getDocumentTypeFilters();
    filters.remove(value);
    updateTypeFilters();
    updateFilterActionIcon();
    filterDocuments();
  }

  private void updateTypeFilters() {
    final DropDownAction filterAction = (DropDownAction) am.get(FilterDocumentTypeAction.ID);
    final ActionEx all = am.get(FilterDocumentTypeAllAction.ID);
    all.setChecked(false);
    for (final DocumentType type : DocumentType.values()) {
      final String id = FilterDocumentTypeForAction.getActionId(type);
      final ActionEx action = am.get(id);
      action.setChecked(false);
    }
    final Set<DocumentType> filters = state.getDocumentTypeFilters();
    logger.info("Updating document type filters: {}", filters);
    if (filters.isEmpty() || (filters.size() == DocumentType.values().length)) {
      all.setChecked(true);
      filters.clear();
    } else {
      for (final DocumentType type : filters) {
        final String id = FilterDocumentTypeForAction.getActionId(type);
        final ActionEx action = am.get(id);
        action.setChecked(true);
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
    updateFilterActionIcon();
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
    updateFilterActionIcon();
    filterDocuments();
  }

  private void updateFileStatusFilters() {
    final DropDownAction filterAction =
        (DropDownAction) am.get(FilterFileStatusAction.ID);
    final ActionEx all = am.get(FilterFileStatusAllAction.ID);
    final ActionEx has_file = am.get(FilterFileStatusHasFileAction.ID);
    final ActionEx no_file = am.get(FilterFileStatusNoFileAction.ID);
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

  private void updateFilterActionIcon() {
    logger.debug("Updating the icon of the FilterAction.");
    final BaseAction filterAction = (BaseAction) am.get(FilterAction.ID);
    filterAction.setChecked(false);
    final Set<FlagStatus> flagFilters = state.getFlagStatusFilters();
    if (! flagFilters.isEmpty()) {
      filterAction.setChecked(true);
      return;
    }
    final Set<ReadStatus> readFilters = state.getReadStatusFilters();
    if (! readFilters.isEmpty()) {
      filterAction.setChecked(true);
      return;
    }
    final Set<DocumentType> typeFilters = state.getDocumentTypeFilters();
    if (! typeFilters.isEmpty()) {
      filterAction.setChecked(true);
      return;
    }
    final Set<FileStatus> fileFilters = state.getFileStatusFilters();
    if (! fileFilters.isEmpty()) {
      filterAction.setChecked(true);
      return;
    }
  }

  private void filterDocuments() {
    logger.info("Filtering documents ...");
    //  TODO
  }

  /**
   * Adds a column of table viewer on the document explorer.
   *
   * @param column
   *    the column to be added.
   */
  public void addColumn(FieldType column) {
    logger.info("Adds a column {}.", column);
    final Set<FieldType> columns = state.getColumns();
    columns.add(column);
    //  note that even if the column has already been contained, we should still
    //  update the columns, in order to make the GUI components consistent.
    updateColumns();
  }

  /**
   * Removes a column of table viewer on the document explorer.
   *
   * @param column
   *    the column to be added.
   */
  public void removeColumn(FieldType column) {
    logger.info("Removes a column {}.", column);
    final Set<FieldType> columns = state.getColumns();
    columns.remove(column);
    //  note that even if the column has not been contained, we should still
    //  update the columns, in order to make the GUI components consistent.
    updateColumns();
  }

  /**
   * Updates the columns of table viewer on the document explorer.
   */
  private void updateColumns() {
    final Set<FieldType> columns = state.getColumns();
    final Page page = state.getPage();
    logger.debug("Updating columns for page {}: {}", page, columns);
    //  update the menu actions
    final DropDownAction sortByAction = (DropDownAction) am.get(SortAction.ID);
    for (final FieldType col : FieldType.values()) {
      final String columnActionId = SelectColumnForAction.getActionId(col);
      final ActionEx columnAction = am.get(columnActionId);
      columnAction.setChecked(false);
      final String sortByColumnId = SortByColumnForAction.getActionId(col);
      sortByAction.hideSubAction(sortByColumnId);
    }
    for (final FieldType col : columns) {
      final String columnActionId = SelectColumnForAction.getActionId(col);
      final ActionEx columnAction = am.get(columnActionId);
      columnAction.setChecked(true);
      final String sortByColumnId = SortByColumnForAction.getActionId(col);
      sortByAction.showSubAction(sortByColumnId);
    }
    final FieldType sortColumn = state.getSortColumn();
    if (sortColumn != null) {
      final String id = SortByColumnForAction.getActionId(sortColumn);
      sortByAction.showSubAction(id);
    }
    sortByAction.update(true);
    //  TODO: update the columns in the table viewer
  }

  /**
   * Sets the sorting column for the current page.
   *
   * @param column
   *          the sorting column to be set for the current page. A null value
   *          indicates no sorting column is specified and thus sorts in the
   *          default column.
   */
  public void setSortColumn(@Nullable FieldType column) {
    logger.info("Sets sort column: {}", column);
    state.setSortColumn(column);
    updateSortColumn();
    updateSortActionIcon();
  }

  private void updateSortColumn() {
    final Page page = state.getPage();
    final FieldType column = state.getSortColumn();
    logger.debug("Updating the sorting column for the page {}: {}", page, column);
    final ActionEx sortByNone = am.get(SortByDefaultColumnAction.ID);
    sortByNone.setChecked(false);
    for (final FieldType col : FieldType.values()) {
      final String id = SortByColumnForAction.getActionId(col);
      final ActionEx action = am.get(id);
      action.setChecked(false);
    }
    if (column == null) {
      sortByNone.setChecked(true);
    } else {
      final String id = SortByColumnForAction.getActionId(column);
      final ActionEx action = am.get(id);
      action.setChecked(true);
    }
    final DropDownAction sortBy = (DropDownAction) am.get(SortAction.ID);
    sortBy.update(true);
    sortDocuments();
  }

  /**
   * Sets the sorting order for the current page.
   *
   * @param order
   *    the sorting order for the current page.
   */
  public void setSortOrder(SortOrder order) {
    logger.info("Sets sort order: {}", order);
    state.setSortOrder(order);
    updateSortOrder();
    updateSortActionIcon();
  }

  private void updateSortOrder() {
    final SortOrder order = state.getSortOrder();
    logger.debug("Updating the sorting order {}.", order);
    final ActionEx sortOrderAsc = am.get(SortOrderAscAction.ID);
    final ActionEx sortOrderDesc = am.get(SortOrderDescAction.ID);
    sortOrderAsc.setChecked(false);
    sortOrderDesc.setChecked(false);
    switch (order) {
    case ASC:
      sortOrderAsc.setChecked(true);
      break;
    case DESC:
      sortOrderDesc.setChecked(true);
      break;
    default:
      logger.error("Unknown sorting order: {}", order);
      return;
    }
    final DropDownAction sortBy = (DropDownAction) am.get(SortAction.ID);
    sortBy.update(true);
    sortDocuments();
  }

  private void updateSortActionIcon() {
    logger.debug("Updating the icon of the SortAction.");
    final BaseDropDownAction sortAction = (BaseDropDownAction) am.get(SortAction.ID);
    final BaseAction sortAscAction = (BaseAction) am.get(SortOrderAscAction.ID);
    final BaseAction sortDescAction = (BaseAction) am.get(SortOrderDescAction.ID);
    final SortOrder order = state.getSortOrder();
    switch (order) {
    case ASC:
      sortAction.setIcon(sortAscAction.getIcon());
      sortAction.setActiveIcon(sortAscAction.getActiveIcon());
      break;
    case DESC:
    default:
      sortAction.setIcon(sortDescAction.getIcon());
      sortAction.setActiveIcon(sortDescAction.getActiveIcon());
      break;
    }
    final FieldType sortColumn = state.getSortColumn();
    sortAction.setChecked(sortColumn != null);
  }

  /**
   * Sorts the documents in the table viewer.
   */
  private void sortDocuments() {
    logger.info("Sorting documents...");
    //  TODO
  }

  /**
   * Creates a new document.
   *
   * @param template
   *    the document template.
   */
  public void newDocument(DocumentTemplate template) {
    logger.info("Creating a new document from template '{}'.", template.getName());
    //  TODO
  }

  /**
   * Creates a new author.
   */
  public void newAuthor() {
    logger.info("Creating a new author.");
    //  TODO
  }

  /**
   * Creates a new conference.
   */
  public void newConference() {
    logger.info("Creating a new conference.");
    //  TODO
  }

  /**
   * Creates a new institute.
   */
  public void newInstitute() {
    logger.info("Creating a new institute.");
    //  TODO
  }

  /**
   * Creates a new periodical.
   */
  public void newPeriodical() {
    logger.info("Creating a new periodical");
    //  TODO
  }

  /**
   * Creates a new publisher.
   */
  public void newPublisher() {
    logger.info("Creating a new publisher");
    //  TODO
  }

  /**
   * Creates a new web site.
   */
  public void newWebSite() {
    logger.info("Creating a new  web site");
    //  TODO
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
