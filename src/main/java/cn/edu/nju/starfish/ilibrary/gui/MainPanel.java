/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.configuration.Configuration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.inspector.InspectorPanel;
import cn.edu.nju.starfish.ilibrary.gui.library.LibraryTab;
import cn.edu.nju.starfish.ilibrary.gui.viewer.ViewerTab;
import cn.edu.nju.starfish.ilibrary.state.ApplicationState;
import cn.edu.nju.starfish.ilibrary.utils.SWTUtils;

/**
 * The tab folder in the main panel.
 *
 * @author Haixing Hu
 */
public final class MainPanel extends CTabFolder {

  public static final String KEY = MainWindow.KEY + ".main";   //  "window.main"

  private final Application application;
  private LibraryTab libraryTab;
  private List<ViewerTab> viewerTabs;

  public MainPanel(Application application, Composite parent) {
    //  IMPORTANT: in order to remove the margin of the tab folder, the
    //  style must be set to FLAT
    super(parent, SWT.FLAT);
    this.application = application;
    configAppearance();
    createContents();
  }

  /**
   * Configures the appearance of this tab folder.
   */
  private void configAppearance() {
    final Configuration config = application.getConfig();
    final String path = config.getString(KEY + ".selection-background");
    final Image img = SWTUtils.loadImage(path);
    this.setSelectionBackground(img);
    final Color color = SWTUtils.parseRGB(config.getString(KEY + ".background.color"));
    this.setBackground(color);
    this.marginHeight = 0;
    this.marginWidth = 0;
    //this.setSimple(false);
  }

  /**
   * Creates the contents of this tab folder.
   */
  private void createContents() {
    libraryTab = new LibraryTab(application, this);
    viewerTabs = new LinkedList<ViewerTab>();
    this.setSelection(libraryTab);
    //  FIXME: debug code
    viewerTabs.add(new ViewerTab(application, this));
  }

  /**
   * Gets the library tab.
   *
   * @return the library tab.
   */
  public LibraryTab getLibraryTab() {
    return libraryTab;
  }

  /**
   * Gets the list of viewer tab.
   *
   * @return the list of viewer tab.
   */
  public List<ViewerTab> getViewerTabs() {
    return viewerTabs;
  }

  @Override
  public MainPanelTab getSelection() {
    return (MainPanelTab) super.getSelection();
  }

  /**
   * Gets the inspector panel on the current tab.
   *
   * @return
   */
  public InspectorPanel getInspector() {
    final MainPanelTab item = this.getSelection();
    return item.getInspector();
  }

  /**
   * Sets the width of the inspector panels on all tabs.
   *
   * @param width
   *    the with to be set.
   * @return
   *    the actual width after setting.
   */
  public final int setInspectorWidth(int width) {
    //  sets the width of inspector panels on all tabs
    width = ((MainPanelTab) libraryTab).getAllowedInspectorWidth(width);
    for (final CTabItem item : this.getItems()) {
      final MainPanelTab mi = (MainPanelTab) item;
      mi.setInspectorWidth(width);
    }
    final ApplicationState state = application.getState();
    state.setInspectorWidth(width);
    return width;
  }

  /**
   * Hides the inspector panel.
   */
  public final void hideInspector() {
    final ApplicationState state = application.getState();
    if (! state.isInspectorHide()) {
      //  hides inspector panels on all tabs
      for (final CTabItem item : this.getItems()) {
        final MainPanelTab mi = (MainPanelTab) item;
        mi.hideInspector();
      }
      state.setInspectorHide(true);
    }
  }

  /**
   * Shows the inspector panel.
   */
  public final void showInspector() {
    final ApplicationState state = application.getState();
    if (state.isInspectorHide()) {
      final int width = state.getInspectorWidth();
      //  shows inspector panels on all tabs
      for (final CTabItem item : this.getItems()) {
        final MainPanelTab mi = (MainPanelTab) item;
        mi.showInspector(width);
      }
      state.setInspectorHide(false);
    }
  }
}
