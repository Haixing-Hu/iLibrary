/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.state;

import org.apache.commons.configuration.Configuration;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.KeySuffix;
import cn.edu.nju.starfish.ilibrary.gui.inspector.InspectorPanel;
import cn.edu.nju.starfish.ilibrary.gui.library.LibraryPanelPreview;
import cn.edu.nju.starfish.ilibrary.gui.navigator.NavigatorPanel;


/**
 * A object used to store the internal state of the application.
 *
 * @author Haixing Hu
 */
public final class ApplicationState {

  private final Application application;
  private AnnotateMode annotateMode;
  private int viewMode;
  private boolean navigatorVisible;
  private FlagStatusFilter flagStatusFilter;
  private ReadStatusFilter readStatusFilter;
  private TypeFilter typeFilter;
  private FileStatusFilter fileStatusFilter;
  private int navigatorWidth;
  private boolean navigatorHide;
  private int inspectorWidth;
  private boolean inspectorHide;
  private int previewHeight;
  private boolean previewHide;
  private InspectorTab inspectorTab;

  public ApplicationState(Application application, Configuration config) {
    this.application = application;
    annotateMode = AnnotateMode.SELECTION;
    viewMode = ViewMode.ALL;
    navigatorVisible = true;
    flagStatusFilter = FlagStatusFilter.ALL;
    readStatusFilter = ReadStatusFilter.ALL;
    typeFilter = TypeFilter.ALL;
    fileStatusFilter = FileStatusFilter.ALL;
    navigatorWidth = config.getInt(NavigatorPanel.KEY + KeySuffix.DEFAULT_WIDTH);
    navigatorHide = false;
    inspectorWidth = config.getInt(InspectorPanel.KEY + KeySuffix.DEFAULT_WIDTH);
    inspectorHide = false;
    previewHeight = config.getInt(LibraryPanelPreview.KEY + KeySuffix.DEFAULT_HEIGHT);
    previewHide = false;
    inspectorTab = InspectorTab.INFO;
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

  /**
   * Tests whether the navigator is visible.
   *
   * @return <code>true</code> if the navigator is visible; <code>false</code>
   *         otherwise.
   */
  public boolean isNavigatorVisible() {
    return navigatorVisible;
  }

  /**
   * Sets the navigator visibility.
   *
   * @param visibility
   *         <code>true</code> if the navigator is visible; <code>false</code>
   *         otherwise.
   */
  public void setNavigatorVisible(boolean visible) {
    this.navigatorVisible = visible;
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
   * @param navigatorWidth the new navigatorWidth to set.
   */
  public void setNavigatorWidth(int navigatorWidth) {
    this.navigatorWidth = navigatorWidth;
  }

  /**
   * Gets the navigatorHide.
   *
   * @return the navigatorHide.
   */
  public boolean isNavigatorHide() {
    return navigatorHide;
  }

  /**
   * Sets the navigatorHide.
   *
   * @param navigatorHide the new navigatorHide to set.
   */
  public void setNavigatorHide(boolean navigatorHide) {
    this.navigatorHide = navigatorHide;
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
   * @param inspectorWidth the new inspectorWidth to set.
   */
  public void setInspectorWidth(int inspectorWidth) {
    this.inspectorWidth = inspectorWidth;
  }

  /**
   * Gets the inspectorHide.
   *
   * @return the inspectorHide.
   */
  public boolean isInspectorHide() {
    return inspectorHide;
  }

  /**
   * Sets the inspectorHide.
   *
   * @param inspectorHide the new inspectorHide to set.
   */
  public void setInspectorHide(boolean inspectorHide) {
    this.inspectorHide = inspectorHide;
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
   * @param previewHeight the new previewHeight to set.
   */
  public void setPreviewHeight(int previewHeight) {
    this.previewHeight = previewHeight;
  }

  /**
   * Gets the previewHide.
   *
   * @return the previewHide.
   */
  public boolean isPreviewHide() {
    return previewHide;
  }

  /**
   * Sets the previewHide.
   *
   * @param previewHide the new previewHide to set.
   */
  public void setPreviewHide(boolean previewHide) {
    this.previewHide = previewHide;
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
   * @param inspectorTab the new inspector tab to set.
   */
  public void setInspectorTab(InspectorTab inspectorTab) {
    this.inspectorTab = inspectorTab;
  }

}
