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

package com.github.haixing_hu.ilibrary.gui;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabFolder2Adapter;
import org.eclipse.swt.custom.CTabFolderEvent;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.ApplicationConfig;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.controller.MainPanelController;
import com.github.haixing_hu.ilibrary.gui.document.DocumentTab;
import com.github.haixing_hu.ilibrary.gui.inspector.InspectorPanel;
import com.github.haixing_hu.ilibrary.gui.library.LibraryTab;
import com.github.haixing_hu.ilibrary.state.ApplicationState;
import com.github.haixing_hu.swt.utils.SWTResourceManager;

/**
 * The main panel, which is a tab folder.
 *
 * @author Haixing Hu
 */
public final class MainPanel extends CTabFolder {

  public static final String KEY = MainWindow.KEY + ".main";   //  "window.main"

  private final Application application;
  private LibraryTab libraryTab;
  private List<DocumentTab> documentTabs;

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
    final ApplicationConfig config = ApplicationConfig.getInstance();
    final String path = config.getString(KEY + KeySuffix.SELECTION + KeySuffix.BACKGROUND_IMAGE);
    final Image img = SWTResourceManager.getImage(this.getClass(), path);
    this.setSelectionBackground(img);
    final String rgb = config.getString(KEY + KeySuffix.BACKGROUND_COLOR);
    final Color color = SWTResourceManager.getColor(rgb);
    this.setBackground(color);
    this.marginHeight = 0;
    this.marginWidth = 0;
    //this.setSimple(false);
  }

  /**
   * Creates the contents of this tab folder.
   */
  private void createContents() {
    //  register event listener
    final MainPanelController controller = application.getMainPanelController();
    this.addSelectionListener(new SelectionListener() {
      @Override
      public void widgetSelected(SelectionEvent event) {
        controller.onSwithTab(event);
      }
      @Override
      public void widgetDefaultSelected(SelectionEvent event) {
        controller.onSwithTab(event);
      }
    });
    this.addCTabFolder2Listener(new CTabFolder2Adapter() {
      @Override
      public void close(CTabFolderEvent event) {
        controller.onCloseTab(event);
      }
    });
    //  create tab
    libraryTab = new LibraryTab(application, this);
    documentTabs = new LinkedList<DocumentTab>();
    this.setSelection(libraryTab);
    //  FIXME: debug code
    documentTabs.add(new DocumentTab(application, this));
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
   * Gets the list of document tabs.
   *
   * @return the list of document tabs.
   */
  public List<DocumentTab> getDocumentTabs() {
    return documentTabs;
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
