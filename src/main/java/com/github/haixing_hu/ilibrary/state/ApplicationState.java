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

package com.github.haixing_hu.ilibrary.state;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Nullable;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.action.view.columns.SelectColumnsAction;
import com.github.haixing_hu.ilibrary.action.view.sort.SortAction;
import com.github.haixing_hu.ilibrary.model.DocumentType;
import com.github.haixing_hu.ilibrary.model.FieldType;
import com.github.haixing_hu.ilibrary.model.FileStatus;
import com.github.haixing_hu.ilibrary.model.FlagStatus;
import com.github.haixing_hu.ilibrary.model.ReadStatus;
import com.github.haixing_hu.lang.EnumUtils;

import static com.github.haixing_hu.ilibrary.KeySuffix.*;


/**
 * A object used to store the internal state of the application.
 *
 * @author Haixing Hu
 */
public final class ApplicationState {

  private final Logger logger;
  private Page page;
  private AnnotateMode annotateMode;
  private BrowserMode browserMode;
  private boolean navigatorVisible;
  private boolean inspectorVisible;
  private boolean previewVisible;
  private InspectorTab inspectorTab;
  private int layoutMode;

  private final Set<FlagStatus> allFlagStatusFilters[];
  private final Set<ReadStatus> allReadStatusFilters[];
  private final Set<DocumentType> allDocumentTypeFilters[];
  private final Set<FileStatus> allFileStatusFilters[];
  private final Set<FieldType> allColumns[];
  private final FieldType allSortColumn[];
  private final SortOrder allSortOrder[];

  @SuppressWarnings("unchecked")
  public ApplicationState() {
    logger = LoggerFactory.getLogger(ApplicationState.class);
    page = Page.LIBRARY;
    annotateMode = AnnotateMode.SELECTION;
    browserMode = BrowserMode.COLUMNS;
    navigatorVisible = true;
    inspectorVisible = true;
    previewVisible = true;
    inspectorTab = InspectorTab.OVERVIEW;
    layoutMode = LayoutMode.ALL;
    allFlagStatusFilters = new Set[Page.TOTAL];
    allReadStatusFilters = new Set[Page.TOTAL];
    allDocumentTypeFilters = new Set[Page.TOTAL];
    allFileStatusFilters = new Set[Page.TOTAL];
    allColumns = new Set[Page.TOTAL];
    allSortColumn = new FieldType[Page.TOTAL];
    allSortOrder = new SortOrder[Page.TOTAL];
    for (int i = 0; i < Page.TOTAL; ++i) {
      allFlagStatusFilters[i] = new HashSet<FlagStatus>();
      allReadStatusFilters[i] = new HashSet<ReadStatus>();
      allDocumentTypeFilters[i] = new HashSet<DocumentType>();
      allFileStatusFilters[i] = new HashSet<FileStatus>();
      allColumns[i] = new HashSet<FieldType>();
      allSortColumn[i] = null;
      allSortOrder[i] = SortOrder.ASC;
    }
  }

  /**
   * Loads the application state from a configuration.
   *
   * @param config
   *    an application configuration.
   */
  public void load(AppConfig config) {
    loadNavigatorVisible(config);
    loadInspectorTab(config);
    loadLayoutMode(config);
    loadBrowserMode(config);
    loadFlagStatusFilters(config);
    loadReadStatusFilters(config);
    loadTypeFilters(config);
    loadFileStatusFilters(config);
    loadDisplayColumns(config);
    loadSortingColumn(config);
    loadSortOrder(config);
  }


  private void loadNavigatorVisible(AppConfig config) {
    //  FIXME
    navigatorVisible = true;
  }

  private void loadInspectorTab(AppConfig config) {
    //  FIXME: load from configuration
    inspectorTab = InspectorTab.OVERVIEW;
  }

  private void loadLayoutMode(AppConfig config) {
    //  FIXME: load from configuration
    layoutMode = LayoutMode.ALL;
  }

  private void loadBrowserMode(AppConfig config) {
    //  FIXME
    browserMode = BrowserMode.COLUMNS;
  }

  private void loadFlagStatusFilters(AppConfig config) {
    //  TODO
    for (int i = 0; i < allSortColumn.length; ++i) {
      allFlagStatusFilters[i].clear();
    }
  }

  private void loadReadStatusFilters(AppConfig config) {
    //  TODO
    for (int i = 0; i < allSortColumn.length; ++i) {
      allReadStatusFilters[i].clear();
    }
  }

  private void loadTypeFilters(AppConfig config) {
    //  TODO
    for (int i = 0; i < allSortColumn.length; ++i) {
      allDocumentTypeFilters[i].clear();
    }
  }

  private void loadFileStatusFilters(AppConfig config) {
    //  TODO
    for (int i = 0; i < allSortColumn.length; ++i) {
      allFileStatusFilters[i].clear();
    }
  }

  private void loadDisplayColumns(AppConfig config) {
    final String key = SelectColumnsAction.ID + DEFAULT;
    final String[] values = config.getStringArray(key);
    for (final String value : values) {
      final FieldType col = EnumUtils.forName(value, true, true, FieldType.class);
      if (col == null) {
        logger.error("Invalid column name: {}", value);
      } else {
        for (final Set<FieldType> cols : allColumns) {
          cols.add(col);
        }
      }
    }
  }

  private void loadSortingColumn(AppConfig config) {
    final String key = SortAction.ID + COLUMN + DEFAULT;
    final String value = config.getString(key);
    if (StringUtils.isEmpty(value)) {
      setAllSortColumns(null);
    } else {
      final FieldType col = EnumUtils.forName(value, true, true, FieldType.class);
      if (col == null) {
        logger.error("Invalid column name: {}", value);
        setAllSortColumns(null);
      } else {
        setAllSortColumns(col);
      }
    }
  }

  private void loadSortOrder(AppConfig config) {
    final String key = SortAction.ID + ORDER + DEFAULT;
    final String value = config.getString(key);
    if (StringUtils.isEmpty(value)) {
      return;
    }
    final SortOrder order = EnumUtils.forName(value, true, true, SortOrder.class);
    if (order != null) {
      setAllSortOrders(order);
    }
  }

  /**
   * Gets the page.
   *
   * @return the page.
   */
  public Page getPage() {
    return page;
  }

  /**
   * Sets the page.
   *
   * @param page the new page to set.
   */
  public void setPage(Page page) {
    this.page = page;
  }

  /**
   * Gets the annotate mode.
   *
   * @return the annotate mode.
   */
  public AnnotateMode getAnnotateMode() {
    return annotateMode;
  }

  /**
   * Sets the annotate mode.
   *
   * @param annotateMode the new annotate mode to set.
   */
  public void setAnnotateMode(AnnotateMode annotateMode) {
    this.annotateMode = annotateMode;
  }

  /**
   * Gets the browser mode.
   *
   * @return the browser mode.
   */
  public BrowserMode getBrowserMode() {
    return browserMode;
  }

  /**
   * Sets the browser mode.
   *
   * @param browserMode the new browser mode to set.
   */
  public void setBrowserMode(BrowserMode browserMode) {
    this.browserMode = browserMode;
  }

  /**
   * Gets the visibility of the navigator panel.
   *
   * @return <code>true</code> if the navigator panel is visibles;
   *         <code>false</code> otherwise.
   */
  public boolean isNavigatorVisible() {
    return navigatorVisible;
  }

  /**
   * Sets the visibility of the navigator panel.
   *
   * @return <code>true</code> if the navigator panel is set to visibles;
   *         <code>false</code> otherwise.
   */
  public void setNavigatorVisible(boolean visible) {
    navigatorVisible = visible;
  }

  /**
   * Gets the visibility of the inspector panel.
   *
   * @return <code>true</code> if the inspector panel is visibles;
   *         <code>false</code> otherwise.
   */
  public boolean isInspectorVisible() {
    return inspectorVisible;
  }

  /**
   * Sets the visibility of the inspector panel.
   *
   * @return <code>true</code> if the preview panel is set to visibles;
   *         <code>false</code> otherwise.
   */
  public void setInspectorVisible(boolean visible) {
    inspectorVisible = visible;
  }

  /**
   * Gets the visibility of the preview panel.
   *
   * @return <code>true</code> if the preview panel is visibles;
   *         <code>false</code> otherwise.
   */
  public boolean isPreviewVisible() {
    return previewVisible;
  }

  /**
   * Sets the visibility of the preview panel.
   *
   * @return <code>true</code> if the preview panel is set to visibles;
   *         <code>false</code> otherwise.
   */
  public void setPreviewVisible(boolean visible) {
    previewVisible = visible;
  }

  /**
   * Gets the inspector tab.
   *
   * @return the inspector tab.
   */
  public InspectorTab getInspectorTab() {
    return inspectorTab;
  }

  /**
   * Sets the inspector tab.
   *
   * @param tab the new inspector tab to set.
   */
  public void setInspectorTab(InspectorTab tab) {
    inspectorTab = tab;
  }

  /**
   * Gets the layout mode.
   *
   * @return the layout mode.
   */
  public int getLayoutMode() {
    return layoutMode;
  }

  /**
   * Sets the layout mode.
   *
   * @param mode the new layout mode to set.
   */
  public void setLayoutMode(int mode) {
    layoutMode = mode;
  }

  /**
   * Gets the flag status filters for the current page.
   * <p>
   * <b>NOTE:</b> the empty set means no filters, i.e., display documents with
   * all possible flag status.
   *
   * @return the flag status filters for the current page.
   */
  public Set<FlagStatus> getFlagStatusFilters() {
    return allFlagStatusFilters[page.ordinal()];
  }

//  /**
//   * Gets the flag status filters for all pages.
//   * <p>
//   * <b>NOTE:</b> the empty set means no filters, i.e., display documents with
//   * all possible flag status.
//   *
//   * @return the flag status filters for all pages.
//   */
//  public Set<FlagStatus>[] getAllFlagStatusFilters() {
//    return allFlagStatusFilters;
//  }

  /**
   * Gets the read status filters for the current page.
   * <p>
   * <b>NOTE:</b> the empty set means no filters, i.e., display documents with
   * all possible read status.
   *
   * @return the read status filters for the current page.
   */
  public Set<ReadStatus> getReadStatusFilters() {
    return allReadStatusFilters[page.ordinal()];
  }

//  /**
//   * Gets the read status filters for all pages.
//   * <p>
//   * <b>NOTE:</b> the empty set means no filters, i.e., display documents with
//   * all possible read status.
//   *
//   * @return the read status filters for all pages.
//   */
//  public Set<ReadStatus>[] getAllReadStatusFilters() {
//    return allReadStatusFilters;
//  }

  /**
   * Gets the document type filters for the current page.
   * <p>
   * <b>NOTE:</b> the empty set means no filters, i.e., display documents with
   * all possible document types.
   *
   * @return the document type filters for the current page.
   */
  public Set<DocumentType> getDocumentTypeFilters() {
    return allDocumentTypeFilters[page.ordinal()];
  }

//  /**
//   * Gets the document type filters for all pages.
//   * <p>
//   * <b>NOTE:</b> the empty set means no filters, i.e., display documents with
//   * all possible document types.
//   *
//   * @return the document type filters for all pages.
//   */
//  public Set<DocumentType>[] getAllDocumentTypeFilters() {
//    return allDocumentTypeFilters;
//  }

  /**
   * Gets the file status filters for the current page.
   * <p>
   * <b>NOTE:</b> the empty set means no filters, i.e., display documents with
   * all possible file status.
   *
   * @return the file status filters for the current page.
   */
  public Set<FileStatus> getFileStatusFilters() {
    return allFileStatusFilters[page.ordinal()];
  }

//  /**
//   * Gets the file status filters for all pages.
//   * <p>
//   * <b>NOTE:</b> the empty set means no filters, i.e., display documents with
//   * all possible file status.
//   *
//   * @return the file status filters for all pages.
//   */
//  public Set<FileStatus>[] getAllFileStatusFilters() {
//    return allFileStatusFilters;
//  }

  /**
   * Gets the the display columns for the current page.
   *
   * @return the display columns for the current page.
   */
  public Set<FieldType> getColumns() {
    return allColumns[page.ordinal()];
  }
//
//  /**
//   * Gets the display columns for all pages.
//   *
//   * @return the display columns for all pages.
//   */
//  public Set<FieldType>[] getAllColumns() {
//    return allColumns;
//  }

  /**
   * Gets the sorting column for the current page.
   *
   * @return the sorting column for the current page. A null value indicates no
   *         sorting column is specified and thus sorts in the default column.
   */
  public FieldType getSortColumn() {
    return allSortColumn[page.ordinal()];
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
    allSortColumn[page.ordinal()] = column;
  }
//
//  /**
//   * Gets the all sorting column.
//   *
//   * @return all sorting column for all pages. A null value indicates no sorting
//   *         column is specified and thus sorts in the default column.
//   */
//  public FieldType[] getAllSortColumns() {
//    return allSortColumn;
//  }

  /**
   * Sets the all sorting column.
   *
   * @param column
   *          the sorting column to be set for all pages. A null value indicates
   *          no sorting column is specified and thus sorts in the default
   *          column.
   */
  private void setAllSortColumns(@Nullable FieldType column) {
    for (int i = 0; i < allSortColumn.length; ++i) {
      allSortColumn[i] = column;
    }
  }

  /**
   * Gets the sorting order for the current page.
   *
   * @return the sorting order for the current page.
   */
  public SortOrder getSortOrder() {
    return allSortOrder[page.ordinal()];
  }

  /**
   * Sets the sorting order for the current page.
   *
   * @param order
   *          the sorting order to be set for the current page.
   */
  public void setSortOrder(SortOrder order) {
    allSortOrder[page.ordinal()] = order;
  }

//  /**
//   * Gets the all sorting order.
//   *
//   * @return all sorting order for all pages.
//   */
//  public SortOrder[] getAllSortOrders() {
//    return allSortOrder;
//  }

  /**
   * Sets the all sorting order.
   *
   * @param order
   *          the sorting order to be set for all pages.
   */
  private void setAllSortOrders(SortOrder order) {
    for (int i = 0; i < allSortOrder.length; ++i) {
      allSortOrder[i] = order;
    }
  }
}
