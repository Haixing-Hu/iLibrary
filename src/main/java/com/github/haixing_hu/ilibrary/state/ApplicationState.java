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

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.gui.Page;
import com.github.haixing_hu.ilibrary.gui.inspector.InspectorPanel;
import com.github.haixing_hu.ilibrary.gui.navigator.NavigatorPanel;
import com.github.haixing_hu.ilibrary.gui.preview.PreviewPanel;


/**
 * A object used to store the internal state of the application.
 *
 * @author Haixing Hu
 */
public final class ApplicationState {

  private int page;
  private AnnotateMode annotateMode;
  private FlagStatusFilter flagStatusFilter;
  private ReadStatusFilter readStatusFilter;
  private TypeFilter typeFilter;
  private FileStatusFilter fileStatusFilter;
  private int navigatorWidth;
  private boolean navigatorVisible;
  private int inspectorWidth;
  private int previewHeight;
  private InspectorTab inspectorTab;
  private int viewMode;

  public ApplicationState(AppConfig config) {
    page = Page.LIBRARY;
    annotateMode = AnnotateMode.SELECTION;
    flagStatusFilter = FlagStatusFilter.ALL;
    readStatusFilter = ReadStatusFilter.ALL;
    typeFilter = TypeFilter.ALL;
    fileStatusFilter = FileStatusFilter.ALL;
    navigatorWidth = config.getInt(NavigatorPanel.KEY + KeySuffix.DEFAULT_WIDTH);
    navigatorVisible = true;
    inspectorWidth = config.getInt(InspectorPanel.KEY + KeySuffix.DEFAULT_WIDTH);
    previewHeight = config.getInt(PreviewPanel.KEY + KeySuffix.DEFAULT_HEIGHT);
    inspectorTab = InspectorTab.INFO;
    viewMode = ViewMode.ALL;
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
   * Gets the flag status filter.
   *
   * @return the flag status filter.
   */
  public FlagStatusFilter getFlagFilter() {
    return flagStatusFilter;
  }

  /**
   * Sets the flag status filter.
   *
   * @param flagStatusFilter the new flag status filter to set.
   */
  public void setFlagStatusFilter(FlagStatusFilter flagStatusFilter) {
    this.flagStatusFilter = flagStatusFilter;
  }

  /**
   * Gets the read status filter.
   *
   * @return the read status filter.
   */
  public ReadStatusFilter getReadStatusFilter() {
    return readStatusFilter;
  }

  /**
   * Sets the read status filter.
   *
   * @param readStatusFilter the new read status filter to set.
   */
  public void setReadStatusFilter(ReadStatusFilter readStatusFilter) {
    this.readStatusFilter = readStatusFilter;
  }

  /**
   * Gets the type filter.
   *
   * @return the type filter.
   */
  public TypeFilter getTypeFilter() {
    return typeFilter;
  }

  /**
   * Sets the type filter.
   *
   * @param typeFilter the new type filter to set.
   */
  public void setTypeFilter(TypeFilter typeFilter) {
    this.typeFilter = typeFilter;
  }

  /**
   * Gets the file status filter.
   *
   * @return the file status filter.
   */
  public FileStatusFilter getFileStatusFilter() {
    return fileStatusFilter;
  }

  /**
   * Sets the file status filter.
   *
   * @param fileStatusFilter the new file status filter to set.
   */
  public void setFileStatusFilter(FileStatusFilter fileStatusFilter) {
    this.fileStatusFilter = fileStatusFilter;
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
    this.navigatorWidth = width;
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
    this.navigatorVisible = visible;
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
    this.inspectorWidth = width;
  }

  /**
   * Gets the visibility of the inspector panel.
   *
   * @return <code>true</code> if the inspector panel is visible;
   *         <code>false</code> otherwise.
   */
  public boolean isInspectorVisible() {
    return (viewMode & ViewMode.INSPECTOR) != 0;
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
    this.previewHeight = height;
  }

  /**
   * Gets the visibility of the preview panel.
   *
   * @return <code>true</code> if the preview panel is visible;
   *         <code>false</code> otherwise.
   */
  public boolean isPreviewVisible() {
    return (viewMode & ViewMode.PREVIEW) != 0;
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
    this.inspectorTab = tab;
  }

  /**
   * Gets the view mode.
   *
   * @return the view mode.
   */
  public int getViewMode() {
    return viewMode;
  }

  /**
   * Sets the view mode.
   *
   * @param viewMode the new view mode to set.
   */
  public void setViewMode(int viewMode) {
    this.viewMode = viewMode;
  }

}
