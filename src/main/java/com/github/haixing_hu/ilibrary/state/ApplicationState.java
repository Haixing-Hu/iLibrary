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

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.gui.Page;
import com.github.haixing_hu.ilibrary.gui.inspector.InspectorPanel;
import com.github.haixing_hu.ilibrary.gui.navigator.NavigatorPanel;
import com.github.haixing_hu.ilibrary.gui.preview.PreviewPanel;
import com.github.haixing_hu.ilibrary.model.DocumentType;
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
  private Set<FlagStatus> flagStatusFilters;
  private Set<ReadStatus> readStatusFilters;
  private Set<DocumentType> typeFilters;
  private Set<FileStatus> fileStatusFilters;
  private BrowserMode browserMode;
  private int navigatorWidth;
  private boolean navigatorVisible;
  private int inspectorWidth;
  private int previewHeight;
  private InspectorTab inspectorTab;
  private int layoutMode;

  public ApplicationState(AppConfig config) {
    page = Page.LIBRARY;
    annotateMode = AnnotateMode.SELECTION;
    flagStatusFilters = new HashSet<FlagStatus>();
    readStatusFilters = new HashSet<ReadStatus>();
    typeFilters = new HashSet<DocumentType>();
    fileStatusFilters = new HashSet<FileStatus>();
    browserMode = BrowserMode.COLUMNS;
    navigatorWidth = config.getInt(NavigatorPanel.KEY + KeySuffix.DEFAULT_WIDTH);
    navigatorVisible = true;
    inspectorWidth = config.getInt(InspectorPanel.KEY + KeySuffix.DEFAULT_WIDTH);
    previewHeight = config.getInt(PreviewPanel.KEY + KeySuffix.DEFAULT_HEIGHT);
    inspectorTab = InspectorTab.OVERVIEW;
    layoutMode = LayoutMode.ALL;
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
   * Sets the flag status filters.
   * <p>
   * <b>NOTE:</b> the empty set means no filters, i.e., display documents with
   * all possible flag status.
   *
   * @param flagStatusFilters the new flag status filters to set.
   */
  public void setFlagStatusFilters(Set<FlagStatus> flagStatusFilters) {
    this.flagStatusFilters = flagStatusFilters;
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
   * Sets the read status filters.
   * <p>
   * <b>NOTE:</b> the empty set means no filters, i.e., display documents with
   * all possible read status.
   *
   * @param readStatusFilters the new read status filters to set.
   */
  public void setReadStatusFilters(Set<ReadStatus> readStatusFilters) {
    this.readStatusFilters = readStatusFilters;
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
   * Sets the type filters.
   * <p>
   * <b>NOTE:</b> the empty set means no filters, i.e., display documents with
   * all possible document types.
   *
   * @param typeFilters the new type filters to set.
   */
  public void setTypeFilters(Set<DocumentType> typeFilters) {
    this.typeFilters = typeFilters;
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
   * Sets the file status filters.
   * <p>
   * <b>NOTE:</b> the empty set means no filters, i.e., display documents with
   * all possible file status.
   *
   * @param fileStatusFilters the new file status filters to set.
   */
  public void setFileStatusFilters(Set<FileStatus> fileStatusFilters) {
    this.fileStatusFilters = fileStatusFilters;
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

}
