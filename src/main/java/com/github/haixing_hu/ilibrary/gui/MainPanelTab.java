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

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Sash;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.ApplicationConfig;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.gui.inspector.InspectorPanel;
import com.github.haixing_hu.swt.utils.SWTResourceManager;

/**
 * The base class for the tabs of the main panel.
 *
 * @author Haixing Hu
 */
public abstract class MainPanelTab extends CTabItem {

  public static final String KEY = MainPanel.KEY + ".tab";  //  "window.main.tab"

  protected final Application application;
  protected final String id;
  protected final int minPanelWidth;
  protected final int maxPanelWidth;
  private final int sashWidth;
  private final Color sashColor;
  protected final CTabFolder parent;
  protected final Composite container;
  protected final Composite panel;
  protected final Sash sash;
  protected final InspectorPanel inspector;

  /**
   * Constructs a new tab item.
   *
   * @param application
   *          the application.
   * @param id
   *          the ID of the new tab item.
   * @param parent
   *          the parent of the new tab item.
   * @param style
   *          the style of the new tab item.
   * @param panelCreator
   *          the creator used to create a panel.
   */
  public MainPanelTab(Application application, String id, CTabFolder parent,
      int style, PanelCreator panelCreator) {
    super(parent, style);
    this.application = application;
    this.id = id;
    final ApplicationConfig config = ApplicationConfig.getInstance();
    this.minPanelWidth = config.getInt(KEY + KeySuffix.PANEL + KeySuffix.MIN_WIDTH);  // "window.main.tab.panel.min-width"
    this.maxPanelWidth = config.getInt(KEY + KeySuffix.PANEL + KeySuffix.MAX_WIDTH);  // "window.main.tab.panel.max-width"
    this.sashWidth = config.getInt(KEY + KeySuffix.SASH + KeySuffix.WIDTH);           // "window.main.tab.sash.width"
    final String colorRgb = config.getString(KEY + KeySuffix.SASH + KeySuffix.COLOR); // "window.main.tab.sash.color"
    this.sashColor = SWTResourceManager.getColor(colorRgb);

    this.parent = parent;
    this.container = new Composite(parent, SWT.NONE);
    this.panel = panelCreator.create(application, container);
    this.sash = new Sash(container, SWT.VERTICAL | SWT.BORDER | SWT.SMOOTH);
    this.inspector = new InspectorPanel(application, container);
    this.setControl(container);
    this.setText("   " + config.getTitle(id) + "   ");
    this.layoutContents();
    this.configSash();
  }

  /**
   * Layouts the contents of this tab item.
   */
  private final void layoutContents() {
    //  set layout
    final FormLayout layout = new FormLayout();
    layout.marginLeft = 0;
    layout.marginRight = 0;
    layout.marginTop = 0;
    layout.marginBottom = 0;
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    layout.spacing = 0;
    container.setLayout(layout);

    final FormData fd_panel = new FormData();
    fd_panel.left = new FormAttachment(0);
    fd_panel.right = new FormAttachment(sash);
    fd_panel.top = new FormAttachment(0);
    fd_panel.bottom = new FormAttachment(100);
    panel.setLayoutData(fd_panel);

    final int inspectorWidth = inspector.getDefaultWidth();

    final FormData fd_sash = new FormData();
    fd_sash.left = new FormAttachment(100, - inspectorWidth - sashWidth);
    fd_sash.right = new FormAttachment(100, - inspectorWidth);
    fd_sash.top = new FormAttachment(0);
    fd_sash.bottom = new FormAttachment(100);
    sash.setLayoutData(fd_sash);

    final FormData fd_inspector = new FormData();
    fd_inspector.left = new FormAttachment(sash);
    fd_inspector.right = new FormAttachment(100);
    fd_inspector.top = new FormAttachment(0);
    fd_inspector.bottom = new FormAttachment(100);
    inspector.setLayoutData(fd_inspector);
  }

  /**
   * Configures the sash if necessary.
   * <p>
   * The default implementation does nothing.
   */
  private final void configSash() {
    sash.setForeground(sashColor);
    sash.setBackground(sashColor);
    //  configures the inspector sash
    sash.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent event) {
        final Rectangle rect = sash.getParent().getClientArea();
        final int delta =  rect.width - sashWidth;
        int newWidth = delta - event.x;
        final MainPanel mainPanel = application.getMainWindow().getMainPanel();
        newWidth = mainPanel.setInspectorWidth(newWidth);
        // it's important to modify the event
        event.x = delta - newWidth;
      }
    });
  }


  /**
   * Calculates the allowed width of the inspector panel.
   *
   * @param width
   *          the with to be set.
   * @return the allowed width.
   */
  int getAllowedInspectorWidth(int width) {
    final Rectangle rect = sash.getParent().getClientArea();
    width = Math.max(width, inspector.getMinWidth());
    width = Math.min(width, inspector.getMaxWidth());
    width = Math.min(width, rect.width - minPanelWidth);
    return width;
  }

  /**
   * Sets the width of the inspector on this panel.
   * <p>
   * <b>NOTE: </b> the function will NOT check the limit of the new width.
   *
   * @param newWidth
   *          the new width to be set.
   */
  void setInspectorWidth(int newWidth) {
    final FormData fd_sash = (FormData) sash.getLayoutData();
    fd_sash.left = new FormAttachment(100, - newWidth - sashWidth);
    fd_sash.right = new FormAttachment(100, - newWidth);
    sash.getParent().layout();
  }

  /**
   * Hides the inspector panel.
   */
  final void hideInspector() {
    final FormData fd = (FormData) sash.getLayoutData();
    fd.left = new FormAttachment(100);
    fd.right = new FormAttachment(100);
    container.layout();
  }

  /**
   * Shows the inspector panel.
   *
   * @param width
   *          the width of the inspector panel.
   */
  final void showInspector(int width) {
    final FormData fd = (FormData) sash.getLayoutData();
    fd.left = new FormAttachment(100, - width - sashWidth);
    fd.right = new FormAttachment(100, - width);
    sash.getParent().layout();
  }

  /**
   * Gets the ID.
   *
   * @return the ID.
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the panel.
   *
   * @return the panel.
   */
  public Composite getPanel() {
    return panel;
  }

  /**
   * Gets the inspector.
   *
   * @return the inspector.
   */
  public final InspectorPanel getInspector() {
    return inspector;
  }

  /**
   * Gets the minimum allowed width of the panel in this tab item.
   *
   * @return the minimum allowed width of the panel in this tab item.
   */
  public int getMinPanelWidth() {
    return minPanelWidth;
  }

  /**
   * Gets the maximum allowed width of the panel in this tab item.
   *
   * @return the maximum allowed width of the panel in this tab item.
   */
  public int getMaxPanelWidth() {
    return maxPanelWidth;
  }
}
