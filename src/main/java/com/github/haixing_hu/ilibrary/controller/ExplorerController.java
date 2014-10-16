/*
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
 */package com.github.haixing_hu.ilibrary.controller;
import java.util.Set;

import javafx.collections.ObservableList;
import javafx.scene.control.ButtonBase;

import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.StyleClass;
import com.github.haixing_hu.ilibrary.action.edit.annotation.AnnotateHighlightAction;
import com.github.haixing_hu.ilibrary.action.edit.annotation.AnnotateNoteAction;
import com.github.haixing_hu.ilibrary.action.edit.annotation.AnnotateSelectionAction;
import com.github.haixing_hu.ilibrary.action.edit.annotation.AnnotateStrikethroughAction;
import com.github.haixing_hu.ilibrary.action.edit.annotation.AnnotateUnderlineAction;
import com.github.haixing_hu.ilibrary.action.view.browse.BrowseAsColumnsAction;
import com.github.haixing_hu.ilibrary.action.view.browse.BrowseAsCoverFlowAction;
import com.github.haixing_hu.ilibrary.action.view.browse.BrowseAsIconsAction;
import com.github.haixing_hu.ilibrary.action.view.browse.BrowseAsListAction;
import com.github.haixing_hu.ilibrary.action.view.browse.BrowseModeAction;
import com.github.haixing_hu.ilibrary.action.view.columns.ColumnOfAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FileFilterAllAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FileFilterHasFileAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FileFilterNoFileAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FlagFilterAllAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FlagFilterFlaggedAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FlagFilterUnflaggedAction;
import com.github.haixing_hu.ilibrary.action.view.filter.SetFiltersAction;
import com.github.haixing_hu.ilibrary.action.view.filter.ReadFilterAllAction;
import com.github.haixing_hu.ilibrary.action.view.filter.ReadFilterHasReadAction;
import com.github.haixing_hu.ilibrary.action.view.filter.ReadFilterReadingAction;
import com.github.haixing_hu.ilibrary.action.view.filter.ReadFilterToReadAction;
import com.github.haixing_hu.ilibrary.action.view.filter.ReadFilterUnreadAction;
import com.github.haixing_hu.ilibrary.action.view.filter.TypeFilterAllAction;
import com.github.haixing_hu.ilibrary.action.view.filter.TypeFilterOfAction;
import com.github.haixing_hu.ilibrary.action.view.sort.SortAction;
import com.github.haixing_hu.ilibrary.action.view.sort.SortByColumnOfAction;
import com.github.haixing_hu.ilibrary.action.view.sort.SortByDefaultColumnAction;
import com.github.haixing_hu.ilibrary.action.view.sort.SortOrderAscAction;
import com.github.haixing_hu.ilibrary.action.view.sort.SortOrderDescAction;
import com.github.haixing_hu.ilibrary.gui.ContentPanel;
import com.github.haixing_hu.ilibrary.gui.MainContent;
import com.github.haixing_hu.ilibrary.gui.document.DocumentExplorerPanel;
import com.github.haixing_hu.ilibrary.model.DocumentType;
import com.github.haixing_hu.ilibrary.model.Column;
import com.github.haixing_hu.ilibrary.model.FileStatus;
import com.github.haixing_hu.ilibrary.model.FlagStatus;
import com.github.haixing_hu.ilibrary.model.ReadStatus;
import com.github.haixing_hu.ilibrary.state.AnnotateMode;
import com.github.haixing_hu.ilibrary.state.ApplicationState;
import com.github.haixing_hu.ilibrary.state.BrowseMode;
import com.github.haixing_hu.ilibrary.state.Page;
import com.github.haixing_hu.ilibrary.state.SortOrder;
import com.github.haixing_hu.javafx.action.ActionManager;
import com.github.haixing_hu.javafx.action.IAction;

/**
 * The controller used to control the library related business logic.
 *
 * @author Haixing Hu
 */
public class ExplorerController {

  private final Application application;
  private final Logger logger;


  public ExplorerController(final Application application) {
    this.application = application;
    logger = LoggerFactory.getLogger(ExplorerController.class);
  }

  public void update() {
    updateBrowseMode();
    updateFlagStatusFilters();
    updateReadStatusFilters();
    updateDocumentTypeFilters();
    updateFileStatusFilters();
    updateSetFiltersActionSelectedProperty();
    updateColumns();
    updateSortColumn();
    updateSortOrder();
    filterDocuments();
  }

  /**
   * Sets the browser mode
   *
   * @param mode
   *          the new browser mode.
   */
  public void setBrowseMode(BrowseMode mode) {
    final ApplicationState state = application.getState();
    logger.info("Set the browsing mode to: {}", mode);
    state.setBrowseMode(mode);
    updateBrowseMode();
  }

  private void updateBrowseMode() {
    logger.debug("Updating the browsing mode.");
    final ApplicationState state = application.getState();
    final ActionManager am = application.getActionManager();
    final IAction asList = am.get(BrowseAsListAction.ID);
    final IAction asColumns = am.get(BrowseAsColumnsAction.ID);
    final IAction asIcons = am.get(BrowseAsIconsAction.ID);
    final IAction asCoverFlow = am.get(BrowseAsCoverFlowAction.ID);
    asList.setSelected(false);
    asColumns.setSelected(false);
    asIcons.setSelected(false);
    asCoverFlow.setSelected(false);
    final BrowseMode mode = state.getBrowseMode();
    final String buttonStyleClass;
    switch (mode) {
    case LIST:
      asList.setSelected(true);
      buttonStyleClass = BrowseAsListAction.BUTTON_CLASS;
      break;
    case COLUMNS:
      asColumns.setSelected(true);
      buttonStyleClass = BrowseAsColumnsAction.BUTTON_CLASS;
      break;
    case ICONS:
      asIcons.setSelected(true);
      buttonStyleClass = BrowseAsIconsAction.BUTTON_CLASS;
      break;
    case COVER_FLOW:
      asCoverFlow.setSelected(true);
      buttonStyleClass = BrowseAsCoverFlowAction.BUTTON_CLASS;
      break;
    default:
      logger.error("Unknown browse mode: ", mode);
      return;
    }
    final MainContent mainContent = application.findNodeById(MainContent.ID);
    final ContentPanel content = mainContent.getCurrentContent();
    final ButtonBase browseModeButton = content.findNodeByClass(BrowseModeAction.BUTTON_CLASS);
    if (browseModeButton != null) {
      //  change the icon of the browse mode button
      final ObservableList<String> styleClass = browseModeButton.getStyleClass();
      styleClass.remove(BrowseAsListAction.BUTTON_CLASS);
      styleClass.remove(BrowseAsColumnsAction.BUTTON_CLASS);
      styleClass.remove(BrowseAsIconsAction.BUTTON_CLASS);
      styleClass.remove(BrowseAsCoverFlowAction.BUTTON_CLASS);
      styleClass.add(buttonStyleClass);
    }
    //  TODO: change the browser mode
    final DocumentExplorerPanel explorer = content.findNodeByClass(DocumentExplorerPanel.STYLE_CLASS);
    if (explorer != null) {
      explorer.setBrowseMode(mode);
    }
  }

  /**
   * Sets the annotate mode.
   *
   * @param mode
   *          the mode to be set.
   */
  public void setAnnotateMode(AnnotateMode mode) {
    final ApplicationState state = application.getState();
    logger.info("Set the annotate mode to: {}", mode);
    state.setAnnotateMode(mode);
    updateAnnotateMode();
  }

  private void updateAnnotateMode() {
    logger.debug("Updating the annotate mode.");
    final ApplicationState state = application.getState();
    final ActionManager am = application.getActionManager();
    final IAction selection = am.get(AnnotateSelectionAction.ID);
    final IAction highlight = am.get(AnnotateHighlightAction.ID);
    final IAction underline = am.get(AnnotateUnderlineAction.ID);
    final IAction strikethrough = am.get(AnnotateStrikethroughAction.ID);
    final IAction note = am.get(AnnotateNoteAction.ID);
    final AnnotateMode mode = state.getAnnotateMode();
    selection.setSelected(false);
    highlight.setSelected(false);
    underline.setSelected(false);
    strikethrough.setSelected(false);
    note.setSelected(false);
    switch (mode) {
    case SELECTION:
      selection.setSelected(true);
      break;
    case HIGHLIGHT:
      highlight.setSelected(true);
      break;
    case UNDERLINE:
      underline.setSelected(true);
      break;
    case STRIKETHORUGH:
      strikethrough.setSelected(true);
      break;
    case NOTE:
      note.setSelected(true);
      break;
    default:
      logger.error("Unknown annotate mode: ", mode);
      return;
    }
    //  TODO
  }

  /**
   * Clears the flag status filters, in order to display documents with all
   * possible flag status.
   */
  public void clearFlagStatusFilters() {
    logger.info("Clears the flag status filters.");
    final ApplicationState state = application.getState();
    final Set<FlagStatus> filters = state.getFlagStatusFilters();
    filters.clear();
    updateFlagStatusFilters();
    updateSetFiltersActionSelectedProperty();
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
    final ApplicationState state = application.getState();
    final Set<FlagStatus> filters = state.getFlagStatusFilters();
    filters.clear();
    filters.add(value);
    updateFlagStatusFilters();
    updateSetFiltersActionSelectedProperty();
    filterDocuments();
  }

  private void updateFlagStatusFilters() {
    final ApplicationState state = application.getState();
    final ActionManager am = application.getActionManager();
    final IAction all = am.get(FlagFilterAllAction.ID);
    final IAction flagged = am.get(FlagFilterFlaggedAction.ID);
    final IAction unflagged = am.get(FlagFilterUnflaggedAction.ID);
    all.setSelected(false);
    flagged.setSelected(false);
    unflagged.setSelected(false);
    final Set<FlagStatus> filters = state.getFlagStatusFilters();
    logger.debug("Updating the flag status filters: {}", filters);
    if (filters.isEmpty() || (filters.size() == FlagStatus.values().length)) {
      all.setSelected(true);
      filters.clear();
    } else {
      for (final FlagStatus value : filters) {
        switch (value) {
        case FLAGGED:
          flagged.setSelected(true);
          break;
        case UNFLAGGED:
          unflagged.setSelected(true);
          break;
        default:
          logger.error("Unknown flag status: {}", value);
          return;
        }
      }
    }
  }

  /**
   * Clears the read status filters, in order to display documents with all
   * possible read status.
   */
  public void clearReadStatusFilters() {
    logger.info("Clears the read status filters.");
    final ApplicationState state = application.getState();
    final Set<ReadStatus> filters = state.getReadStatusFilters();
    filters.clear();
    updateReadStatusFilters();
    updateSetFiltersActionSelectedProperty();
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
    final ApplicationState state = application.getState();
    final Set<ReadStatus> filters = state.getReadStatusFilters();
    filters.add(value);
    updateReadStatusFilters();
    updateSetFiltersActionSelectedProperty();
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
    final ApplicationState state = application.getState();
    final Set<ReadStatus> filters = state.getReadStatusFilters();
    filters.remove(value);
    updateReadStatusFilters();
    updateSetFiltersActionSelectedProperty();
    filterDocuments();
  }

  private void updateReadStatusFilters() {
    final ApplicationState state = application.getState();
    final ActionManager am = application.getActionManager();
    //  TODO: set the filter in the document list table
    final IAction all = am.get(ReadFilterAllAction.ID);
    final IAction unread = am.get(ReadFilterUnreadAction.ID);
    final IAction toread = am.get(ReadFilterToReadAction.ID);
    final IAction reading = am.get(ReadFilterReadingAction.ID);
    final IAction hasRead = am.get(ReadFilterHasReadAction.ID);
    all.setSelected(false);
    unread.setSelected(false);
    toread.setSelected(false);
    reading.setSelected(false);
    hasRead.setSelected(false);
    final Set<ReadStatus> filters = state.getReadStatusFilters();
    logger.debug("Updating the read status filters: {}", filters);
    if (filters.isEmpty() || (filters.size() == ReadStatus.values().length)) {
      all.setSelected(true);
      filters.clear();
    } else {
      for (final ReadStatus value : filters) {
        switch (value) {
        case UNREAD:
          unread.setSelected(true);
          break;
        case TO_READ:
          toread.setSelected(true);
          break;
        case READING:
          reading.setSelected(true);
          break;
        case HAS_READ:
          hasRead.setSelected(true);
          break;
        default:
          logger.error("Unknown flag status: {}", value);
          return;
        }
      }
    }
  }

  /**
   * Clears the document type filters, in order to display documents with all
   * possible document types.
   */
  public void clearDocumentTypeFilters() {
    logger.info("Clears the document type filters.");
    final ApplicationState state = application.getState();
    final Set<DocumentType> filters = state.getDocumentTypeFilters();
    filters.clear();
    updateDocumentTypeFilters();
    updateSetFiltersActionSelectedProperty();
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
    final ApplicationState state = application.getState();
    final Set<DocumentType> filters = state.getDocumentTypeFilters();
    filters.add(value);
    updateDocumentTypeFilters();
    updateSetFiltersActionSelectedProperty();
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
    final ApplicationState state = application.getState();
    final Set<DocumentType> filters = state.getDocumentTypeFilters();
    filters.remove(value);
    updateDocumentTypeFilters();
    updateSetFiltersActionSelectedProperty();
    filterDocuments();
  }

  private void updateDocumentTypeFilters() {
    final ApplicationState state = application.getState();
    final ActionManager am = application.getActionManager();
    am.setSelected(TypeFilterAllAction.ID, false);
    for (final DocumentType type : DocumentType.values()) {
      final String id = TypeFilterOfAction.getActionId(type);
      am.setSelected(id, false);
      logger.debug("clear selected for {}, {}", type, id);
    }
    final Set<DocumentType> filters = state.getDocumentTypeFilters();
    logger.debug("Updating the document type filters: {}", filters);
    if (filters.isEmpty() || (filters.size() == DocumentType.values().length)) {
      am.setSelected(TypeFilterAllAction.ID, true);
      filters.clear();
    } else {
      for (final DocumentType type : filters) {
        final String id = TypeFilterOfAction.getActionId(type);
        am.setSelected(id, true);
      }
    }
  }

  /**
   * Clears the file status filters, in order to display documents with all
   * possible file status.
   */
  public void clearFileStatusFilters() {
    logger.info("Clears the file status filters.");
    final ApplicationState state = application.getState();
    final Set<FileStatus> filters = state.getFileStatusFilters();
    filters.clear();
    updateFileStatusFilters();
    updateSetFiltersActionSelectedProperty();
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
    final ApplicationState state = application.getState();
    final Set<FileStatus> filters = state.getFileStatusFilters();
    filters.clear();
    filters.add(value);
    updateFileStatusFilters();
    updateSetFiltersActionSelectedProperty();
    filterDocuments();
  }

  private void updateFileStatusFilters() {
    final ApplicationState state = application.getState();
    final ActionManager am = application.getActionManager();
    final IAction all = am.get(FileFilterAllAction.ID);
    final IAction has_file = am.get(FileFilterHasFileAction.ID);
    final IAction no_file = am.get(FileFilterNoFileAction.ID);
    all.setSelected(false);
    has_file.setSelected(false);
    no_file.setSelected(false);
    final Set<FileStatus> filters = state.getFileStatusFilters();
    logger.debug("Updating the file status filters: {}", filters);
    if (filters.isEmpty() || (filters.size() == FileStatus.values().length)) {
      all.setSelected(true);
      filters.clear();
    } else {
      for (final FileStatus value : filters) {
        switch (value) {
        case HAS_FILE:
          has_file.setSelected(true);
          break;
        case NO_FILE:
          no_file.setSelected(true);
          break;
        default:
          logger.error("Unknown file status filter: ", value);
          return;
        }
      }
    }
  }

  private void updateSetFiltersActionSelectedProperty() {
    logger.debug("Updating the selected property of the FilterAction.");
    final ApplicationState state = application.getState();
    final ActionManager am = application.getActionManager();
    final IAction action = am.get(SetFiltersAction.ID);
    final Set<FlagStatus> flagFilters = state.getFlagStatusFilters();
    if (! flagFilters.isEmpty()) {
      action.setSelected(true);
      return;
    }
    final Set<ReadStatus> readFilters = state.getReadStatusFilters();
    if (! readFilters.isEmpty()) {
      action.setSelected(true);
      return;
    }
    final Set<DocumentType> typeFilters = state.getDocumentTypeFilters();
    if (! typeFilters.isEmpty()) {
      action.setSelected(true);
      return;
    }
    final Set<FileStatus> fileFilters = state.getFileStatusFilters();
    if (! fileFilters.isEmpty()) {
      action.setSelected(true);
      return;
    }
    action.setSelected(false);
  }

  /**
   * Adds a column of table viewer on the document explorer.
   *
   * @param column
   *    the column to be added.
   */
  public void addColumn(Column column) {
    logger.info("Adds a column {}.", column);
    final ApplicationState state = application.getState();
    final Set<Column> columns = state.getColumns();
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
  public void removeColumn(Column column) {
    logger.info("Removes a column {}.", column);
    final ApplicationState state = application.getState();
    final Set<Column> columns = state.getColumns();
    columns.remove(column);
    //  note that even if the column has not been contained, we should still
    //  update the columns, in order to make the GUI components consistent.
    updateColumns();
  }

  /**
   * Updates the columns of table viewer on the document explorer.
   */
  private void updateColumns() {
    final ApplicationState state = application.getState();
    final ActionManager am = application.getActionManager();
    final Set<Column> columns = state.getColumns();
    final Page page = state.getPage();
    logger.debug("Updating the columns for page {}: {}", page, columns);
    //  update the menu actions
    for (final Column col : Column.values()) {
      final String columnActionId = ColumnOfAction.getActionId(col);
      final String sortByColumnId = SortByColumnOfAction.getActionId(col);
      if (columns.contains(col)) {
        am.setSelected(columnActionId, true);
        am.show(sortByColumnId);
      } else {
        am.setSelected(columnActionId, false);
        am.hide(sortByColumnId);
      }
    }
    final Column sortColumn = state.getSortColumn();
    if (sortColumn != null) {
      final String sortByColumnId = SortByColumnOfAction.getActionId(sortColumn);
      am.show(sortByColumnId);
    }
    updateDocumentTableView();
  }

  /**
   * Sets the sorting column for the current page.
   *
   * @param column
   *          the sorting column to be set for the current page. A null value
   *          indicates no sorting column is specified and thus sorts in the
   *          default column.
   */
  public void setSortColumn(@Nullable Column column) {
    logger.info("Sets sort column: {}", column);
    final ApplicationState state = application.getState();
    state.setSortColumn(column);
    updateSortColumn();
    sortDocuments();
  }

  private void updateSortColumn() {
    final ApplicationState state = application.getState();
    final ActionManager am = application.getActionManager();
    final Page page = state.getPage();
    final Column column = state.getSortColumn();
    logger.debug("Updating the sorting column for the page {}: {}", page, column);
    final IAction sortByDefault = am.get(SortByDefaultColumnAction.ID);
    for (final Column col : Column.values()) {
      final String id = SortByColumnOfAction.getActionId(col);
      am.setSelected(id, false);
    }
    if (column == null) {
      sortByDefault.setSelected(true);
    } else {
      final String id = SortByColumnOfAction.getActionId(column);
      am.setSelected(id, true);
      sortByDefault.setSelected(false);
    }
    final MainContent mainContent = application.findNodeById(MainContent.ID);
    final ContentPanel content = mainContent.getCurrentContent();
    final ButtonBase sortButton = content.findNodeByClass(SortAction.BUTTON_CLASS);
    if (sortButton != null) {
      sortButton.pseudoClassStateChanged(StyleClass.ACTIVE, column != null);
    }
  }

  /**
   * Sets the sorting order for the current page.
   *
   * @param order
   *    the sorting order for the current page.
   */
  public void setSortOrder(SortOrder order) {
    logger.info("Sets sort order: {}", order);
    final ApplicationState state = application.getState();
    state.setSortOrder(order);
    updateSortOrder();
    sortDocuments();
  }

  private void updateSortOrder() {
    final ApplicationState state = application.getState();
    final ActionManager am = application.getActionManager();
    final SortOrder order = state.getSortOrder();
    logger.debug("Updating the sorting order {}.", order);
    final IAction sortOrderAsc = am.get(SortOrderAscAction.ID);
    final IAction sortOrderDesc = am.get(SortOrderDescAction.ID);
    sortOrderAsc.setSelected(false);
    sortOrderDesc.setSelected(false);
    final String newStyleClass;
    switch (order) {
    case ASC:
      sortOrderAsc.setSelected(true);
      newStyleClass = SortOrderAscAction.BUTTON_CLASS;
      break;
    case DESC:
      sortOrderDesc.setSelected(true);
      newStyleClass = SortOrderDescAction.BUTTON_CLASS;
      break;
    default:
      logger.error("Unknown sorting order: {}", order);
      return;
    }
    final MainContent mainContent = application.findNodeById(MainContent.ID);
    final ContentPanel content = mainContent.getCurrentContent();
    final ButtonBase sortButton = content.findNodeByClass(SortAction.BUTTON_CLASS);
    if (sortButton != null) {
      //  change the icon of the sort order button
      final ObservableList<String> styleClass = sortButton.getStyleClass();
      styleClass.remove(SortOrderAscAction.BUTTON_CLASS);
      styleClass.remove(SortOrderDescAction.BUTTON_CLASS);
      styleClass.add(newStyleClass);
    }
  }

  /**
   * Filters the documents.
   */
  private void filterDocuments() {
    logger.info("Filtering documents ...");
    //  TODO
  }

  /**
   * Sorts the documents.
   */
  private void sortDocuments() {
    logger.info("Sorting documents...");
    //  TODO
  }

  private void updateDocumentTableView() {
    logger.info("Updating the document table view.");
    //  TODO
  }
}
