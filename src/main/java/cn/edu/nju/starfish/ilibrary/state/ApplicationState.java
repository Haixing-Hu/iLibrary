/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.state;

import org.apache.commons.configuration.Configuration;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.panel.InspectorPanel;
import cn.edu.nju.starfish.ilibrary.gui.panel.NavigatorPanel;
import cn.edu.nju.starfish.ilibrary.gui.panel.PreviewPanel;


/**
 * A object used to store the internal state of the application.
 *
 * @author Haixing Hu
 */
public final class ApplicationState {

  private final Application application;
  private int viewMode;
  private FlagFilter flagFilter;
  private ReadFilter readFilter;
  private TypeFilter typeFilter;
  private AttachmentFilter attachmentFilter;
  private int navigatorWidth;
  private boolean navigatorHide;
  private int inspectorWidth;
  private boolean inspectorHide;
  private int previewHeight;
  private boolean previewHide;

  public ApplicationState(Application application, Configuration config) {
    this.application = application;
    viewMode = ViewMode.ALL;
    flagFilter = FlagFilter.ALL;
    readFilter = ReadFilter.ALL;
    typeFilter = TypeFilter.ALL;
    attachmentFilter = AttachmentFilter.ALL;
    navigatorWidth = config.getInt(NavigatorPanel.KEY + ".width.default");
    navigatorHide = false;
    inspectorWidth = config.getInt(InspectorPanel.KEY + ".width.default");
    inspectorHide = false;
    previewHeight = config.getInt(PreviewPanel.KEY + ".height.default");
    previewHide = false;
  }

  /**
   * Synchronize the state with the application.
   */
  public void sync() {
    ViewMode.update(application, viewMode);
    FlagFilter.update(application, flagFilter);
    ReadFilter.update(application, readFilter);
    TypeFilter.update(application, typeFilter);
    AttachmentFilter.update(application, attachmentFilter);
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
   * Gets the flag filter.
   *
   * @return the flag filter.
   */
  public FlagFilter getFlagFilter() {
    return flagFilter;
  }

  /**
   * Sets the flag filter.
   *
   * @param flagFilter the new flag filter to set.
   */
  public void setFlagFilter(FlagFilter flagFilter) {
    this.flagFilter = flagFilter;
  }

  /**
   * Gets the read filter.
   *
   * @return the read filter.
   */
  public ReadFilter getReadFilter() {
    return readFilter;
  }

  /**
   * Sets the read filter.
   *
   * @param readFilter the new read filter to set.
   */
  public void setReadFilter(ReadFilter readFilter) {
    this.readFilter = readFilter;
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
   * Gets the attachment filter.
   *
   * @return the attachment filter.
   */
  public AttachmentFilter getAttachmentFilter() {
    return attachmentFilter;
  }

  /**
   * Sets the attachment filter.
   *
   * @param attachmentFilter the new attachment filter to set.
   */
  public void setAttachmentFilter(AttachmentFilter attachmentFilter) {
    this.attachmentFilter = attachmentFilter;
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

}
