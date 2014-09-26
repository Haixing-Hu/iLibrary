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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.github.haixing_hu.ilibrary.gui.Page;
import com.github.haixing_hu.ilibrary.model.DocumentType;
import com.github.haixing_hu.ilibrary.model.FieldType;
import com.github.haixing_hu.ilibrary.model.FileStatus;
import com.github.haixing_hu.ilibrary.model.FlagStatus;
import com.github.haixing_hu.ilibrary.model.ReadStatus;


/**
 * A object used to store the internal state of the application.
 *
 * @author Haixing Hu
 */
public final class ApplicationState {

  private int page;
  private AnnotateMode annotateMode;
  private BrowserMode browserMode;
  private int navigatorWidth;
  private boolean navigatorVisible;
  private int inspectorWidth;
  private int previewHeight;
  private InspectorTab inspectorTab;
  private int layoutMode;

  private final Set<FlagStatus> flagStatusFilters;
  private final Set<ReadStatus> readStatusFilters;
  private final Set<DocumentType> typeFilters;
  private final Set<FileStatus> fileStatusFilters;
  private final List<FieldType> columns;

  public ApplicationState() {
    page = Page.LIBRARY;
    annotateMode = AnnotateMode.SELECTION;
    browserMode = BrowserMode.COLUMNS;
    navigatorWidth = 0;
    navigatorVisible = true;
    inspectorWidth = 0;
    previewHeight =0;
    inspectorTab = InspectorTab.OVERVIEW;
    layoutMode = LayoutMode.ALL;
    flagStatusFilters = new HashSet<FlagStatus>();
    readStatusFilters = new HashSet<ReadStatus>();
    typeFilters = new HashSet<DocumentType>();
    fileStatusFilters = new HashSet<FileStatus>();
    columns = new ArrayList<FieldType>();
  }

  /**
   * Gets the page.
   *
   * @return the page.
   */
  public int getPage() {
    return page;
  }

  /**
   * Sets the page.
   *
   * @param page the new page to set.
   */
  public void setPage(int page) {
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
   * Gets the navigatorWidth.
   *
   * @return the navigatorWidth.
   */
  public int getNavigatorWidth() {
    return navigatorWidth;
  }

  /**
   * Sets the navigatorWidth.
   *
   * @param width the new navigatorWidth to set.
   */
  public void setNavigatorWidth(int width) {
    navigatorWidth = width;
  }

  /**
   * Gets the visibility of the navigator panel.
   *
   * @return <code>true</code> if the navigator panel is visible;
   *         <code>false</code> otherwise.
   */
  public boolean isNavigatorVisible() {
    return navigatorVisible;
  }

  /**
   * Sets the visibility of the navigator panel.
   *
   * @return <code>true</code> if the navigator panel is set to visible;
   *         <code>false</code> otherwise.
   */
  public void setNavigatorVisible(boolean visible) {
    navigatorVisible = visible;
  }

  /**
   * Gets the inspectorWidth.
   *
   * @return the inspectorWidth.
   */
  public int getInspectorWidth() {
    return inspectorWidth;
  }

  /**
   * Sets the inspectorWidth.
   *
   * @param width the new inspectorWidth to set.
   */
  public void setInspectorWidth(int width) {
    inspectorWidth = width;
  }

  /**
   * Gets the visibility of the inspector panel.
   *
   * @return <code>true</code> if the inspector panel is visible;
   *         <code>false</code> otherwise.
   */
  public boolean isInspectorVisible() {
    return (layoutMode & LayoutMode.INSPECTOR) != 0;
  }

  /**
   * Gets the previewHeight.
   *
   * @return the previewHeight.
   */
  public int getPreviewHeight() {
    return previewHeight;
  }

  /**
   * Sets the previewHeight.
   *
   * @param height the new previewHeight to set.
   */
  public void setPreviewHeight(int height) {
    previewHeight = height;
  }

  /**
   * Gets the visibility of the preview panel.
   *
   * @return <code>true</code> if the preview panel is visible;
   *         <code>false</code> otherwise.
   */
  public boolean isPreviewVisible() {
    return (layoutMode & LayoutMode.PREVIEW) != 0;
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
   * Gets the flagStatusFilters.
   * <p>
   * <b>NOTE:</b> the empty set means no filters, i.e., display documents with
   * all possible flag status.
   *
   * @return the flagStatusFilters.
   */
  public Set<FlagStatus> getFlagStatusFilters() {
    return flagStatusFilters;
  }

  /**
   * Gets the read status filters.
   * <p>
   * <b>NOTE:</b> the empty set means no filters, i.e., display documents with
   * all possible read status.
   *
   * @return the read status filters.
   */
  public Set<ReadStatus> getReadStatusFilters() {
    return readStatusFilters;
  }

  /**
   * Gets the type filters.
   * <p>
   * <b>NOTE:</b> the empty set means no filters, i.e., display documents with
   * all possible document types.
   *
   * @return the type filters.
   */
  public Set<DocumentType> getTypeFilters() {
    return typeFilters;
  }

  /**
   * Gets the file status filters.
   * <p>
   * <b>NOTE:</b> the empty set means no filters, i.e., display documents with
   * all possible file status.
   *
   * @return the file status filters.
   */
  public Set<FileStatus> getFileStatusFilters() {
    return fileStatusFilters;
  }

  /**
   * Gets the columns.
   *
   * @return the columns.
   */
  public List<FieldType> getColumns() {
    return columns;
  }

}
