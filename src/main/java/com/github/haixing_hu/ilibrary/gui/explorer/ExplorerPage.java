/******************************************************************************
 *
 * Copyright (c) 2014  Haixing Hu
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Haixing Hu (https://github.com/Haixing-Hu/) - Initial implementation and API.
 *
 ******************************************************************************/

package com.github.haixing_hu.ilibrary.gui.explorer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Sash;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.gui.AuthorsPage;
import com.github.haixing_hu.ilibrary.gui.LibraryPage;
import com.github.haixing_hu.ilibrary.gui.MainWindow;
import com.github.haixing_hu.ilibrary.gui.BasicPage;
import com.github.haixing_hu.ilibrary.gui.SourcesPage;
import com.github.haixing_hu.ilibrary.gui.TagsPage;
import com.github.haixing_hu.ilibrary.gui.inspector.InspectorPanel;
import com.github.haixing_hu.ilibrary.gui.navigator.NavigatorPanel;
import com.github.haixing_hu.ilibrary.gui.preview.PreviewPanel;
import com.github.haixing_hu.ilibrary.state.InspectorTab;

/**
 * The {@link ExplorerPage} class is the base class for all pages in which
 * the user explores the documents in some way.
 *
 * @author Haixing Hu
 * @see {@link LibraryPage}
 * @see {@link TagsPage}
 * @see {@link AuthorsPage}
 * @see {@link SourcesPage}
 */
public abstract class ExplorerPage extends BasicPage  {

  protected final Application application;
  private final int sashWidth;
  private final Color sashColor;
  private final NavigatorPanel navigator;
  private final Sash sash;
  private final ExplorerPanel explorer;

  public ExplorerPage(Application application, Composite parent, String title) {
    super(application, parent);
    this.application = application;
    final AppConfig config = application.getConfig();
    final String sashKey = MainWindow.KEY + KeySuffix.SASH + KeySuffix.VERTICAL;
    sashWidth = config.getInt(sashKey + KeySuffix.WIDTH);
    sashColor = config.getColor(sashKey + KeySuffix.COLOR);
    navigator = new NavigatorPanel(application, this, title);
    sash = new Sash(this, SWT.VERTICAL | SWT.BORDER);
    explorer  = new ExplorerPanel(application, this);
    layoutContents();
    configSash();
  }

  private void layoutContents() {
    final FormLayout layout = new FormLayout();
    layout.marginTop = 0;
    layout.marginBottom = 0;
    layout.marginLeft = 0;
    layout.marginRight = 0;
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    layout.spacing = 0;
    setLayout(layout);

    //  configure the layout data
    final FormData fd_navigator = new FormData();
    fd_navigator.top = new FormAttachment(0);
    fd_navigator.bottom = new FormAttachment(100);
    fd_navigator.left = new FormAttachment(0);
    fd_navigator.right = new FormAttachment(sash);
    navigator.setLayoutData(fd_navigator);

    final int navigatorWidth = navigator.getDefaultWidth();

    final FormData fd_sash = new FormData();
    fd_sash.top = new FormAttachment(0);
    fd_sash.bottom = new FormAttachment(100);
    fd_sash.left = new FormAttachment(0, navigatorWidth);
    fd_sash.right = new FormAttachment(0, navigatorWidth + sashWidth);
    sash.setLayoutData(fd_sash);

    final FormData fd_browser = new FormData();
    fd_browser.top = new FormAttachment(0);
    fd_browser.bottom = new FormAttachment(100);
    fd_browser.left = new FormAttachment(sash);
    fd_browser.right = new FormAttachment(100);
    explorer.setLayoutData(fd_browser);
  }

  private void configSash() {
    if (sashColor != null) {
      sash.setForeground(sashColor);
      sash.setBackground(sashColor);
    }
    sash.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent event) {
        int width = event.x;
        width = Math.max(width, navigator.getMinWidth());
        width = Math.min(width, navigator.getMaxWidth());
        final Rectangle rect = sash.getParent().getClientArea();
        final InspectorPanel inspector = explorer.getInspector();
        final int minBrowserWidth = explorer.getMinWidth();
        final int maxBrowserWidth = explorer.getMaxWidth();
        final int inspectorWidth = inspector.getBounds().width;
        width = Math.min(width, rect.width - minBrowserWidth - inspectorWidth);
        width = Math.max(width, rect.width - maxBrowserWidth - inspectorWidth);
        // it's important to modify the event
        event.x = width;
        if (event.detail != SWT.DRAG) {
          application.setNavigatorWidth(width);
        }
      }
    });
  }

  /**
   * Gets the navigator panel.
   *
   * @return the navigator panel.
   */
  public NavigatorPanel getNavigator() {
    return navigator;
  }

  /**
   * Gets the explorer panel.
   *
   * @return the explorer panel.
   */
  public ExplorerPanel getExplorer() {
    return explorer;
  }

  /**
   * Gets the inspector panel.
   *
   * @return the inspector panel.
   */
  public InspectorPanel getInspector() {
    return explorer.getInspector();
  }

  /**
   * Gets the preview panel.
   *
   * @return the preview panel.
   */
  public PreviewPanel getPreview() {
    return explorer.getPreview();
  }

  /**
   * Gets the tool bar on the footer.
   *
   * @return the tool bar on the footer.
   */
  public ExplorerFooterToolBar getFooterToolBar() {
    return explorer.getFooterToolBar();
  }

  @Override
  public void setNavigatorWidth(int width) {
    final FormData fd_sash = (FormData) sash.getLayoutData();
    if (width <= 0) {
      fd_sash.left = new FormAttachment(0);
      fd_sash.right = new FormAttachment(0);
    } else {
      fd_sash.left = new FormAttachment(0, width);
      fd_sash.right = new FormAttachment(0, width + sashWidth);
    }
    this.layout();
  }

  @Override
  public void setInspectorWidth(int width) {
    explorer.setInspectorWidth(width);
  }

  @Override
  public void setPreviewHeight(int height) {
    explorer.setPreviewHeight(height);
  }

  @Override
  public void setInspectorTab(InspectorTab tab) {
    explorer.setInspectorTab(tab);
  }

  /**
   * Set the visibility of an action on the tool bar of this page.
   *
   * <b>NOTE:</b> After calling this function, the {@link #update(true)}
   * or {@link #updateAll(true)} must be called in order to rebuild all
   * the tool items created by the tool bar.
   *
   * @param id
   *          the ID of the action whose visibility is to be set.
   * @param visible
   *          the visibility to be set.
   */
  @Override
  public void setToolBarActionVisibility(String id, boolean visible) {
    final ExplorerFooterToolBar toolBar = this.getFooterToolBar();
    toolBar.setActionVisibility(id, visible);
  }

  /**
   * Updates the tool bar.
   *
   * @param force
   *    true means update even if not dirty, and false for normal incremental updating.
   */
  @Override
  public void updateToolBar(boolean force) {
    final ExplorerFooterToolBar toolBar = this.getFooterToolBar();
    toolBar.updateToolBar(force);
  }
}
