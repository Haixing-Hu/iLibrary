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

package com.github.haixing_hu.ilibrary.gui.navigator;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.gui.MainWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;

/**
 * The panel display the navigation tree.
 *
 * @author Haixing Hu
 */
public final class NavigatorPanel extends Composite {

  public static final String ID = MainWindow.ID + ".navigator";

  private final Application application;
  private final int defaultWidth;
  private final int minWidth;
  private final int maxWidth;
  private final int marginTop;
  private final Color backgroundColor;
  private final NavigatorHeader header;
  private final NavigatorTree tree;
  private final NavigatorFooter footer;

  /**
   * Constructs a {@link NavigatorPanel}.
   *
   * @param application
   *          the application the new panel belongs.
   * @param parent
   *          the parent of the new panel.
   * @param title
   *          the title of the page this navigator belongs to.
   */
  public NavigatorPanel(Application application, Composite parent, String title) {
    super(parent, SWT.NONE);
    this.application = application;
    final AppConfig config = application.getConfig();
    defaultWidth = config.getInt(ID + KeySuffix.DEFAULT_WIDTH);
    minWidth = config.getInt(ID + KeySuffix.MIN_WIDTH);
    maxWidth = config.getInt(ID + KeySuffix.MAX_WIDTH);
    marginTop = config.getInt(ID + KeySuffix.MARGIN_TOP);
    backgroundColor = config.getColor(ID + KeySuffix.BACKGROUND_COLOR);
    header = new NavigatorHeader(application, this, title);
    tree = new NavigatorTree(application, this);
    footer = new NavigatorFooter(application, this);
    layoutContents();
  }

  /**
   * Creates the contents of this panel.
   */
  private void layoutContents() {
    final FormLayout layout = new FormLayout();
    layout.marginTop = 0;
    layout.marginBottom = 0;
    layout.marginLeft = 0;
    layout.marginRight = 0;
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    layout.spacing = 0;
    this.setLayout(layout);

    final FormData fd_header = new FormData();
    fd_header.left = new FormAttachment(0);
    fd_header.right = new FormAttachment(100);
    fd_header.top = new FormAttachment(0);
    fd_header.bottom = new FormAttachment(0, header.getHeight());
    header.setLayoutData(fd_header);

    final FormData fd_tree = new FormData();
    fd_tree.left = new FormAttachment(0);
    fd_tree.right = new FormAttachment(100);
    fd_tree.top = new FormAttachment(0, header.getHeight() + this.marginTop);
    fd_tree.bottom = new FormAttachment(footer);
    tree.getControl().setLayoutData(fd_tree);

    final FormData fd_footer = new FormData();
    fd_footer.left = new FormAttachment(0);
    fd_footer.right = new FormAttachment(100);
    fd_footer.top = new FormAttachment(100, - footer.getHeight());
    fd_footer.bottom = new FormAttachment(100);
    footer.setLayoutData(fd_footer);

    if (backgroundColor != null) {
      this.setBackground(backgroundColor);
    }
  }

  /**
   * Gets the application.
   *
   * @return the application.
   */
  public Application getApplication() {
    return application;
  }


  /**
   * Gets the default width.
   *
   * @return the default width.
   */
  public int getDefaultWidth() {
    return defaultWidth;
  }

  /**
   * Gets the minimum width.
   *
   * @return the minimum width.
   */
  public int getMinWidth() {
    return minWidth;
  }

  /**
   * Gets the maximum width.
   *
   * @return the maximum width.
   */
  public int getMaxWidth() {
    return maxWidth;
  }

  /**
   * Gets the navigator tree.
   *
   * @return the navigator tree.
   */
  public NavigatorTree getTree() {
    return tree;
  }

  /**
   * Gets the footer.
   *
   * @return the footer.
   */
  public NavigatorFooter getFooter() {
    return footer;
  }


//  /**
//   * Set the visibility of an action on the tool bar of this page.
//   *
//   * <b>NOTE:</b> After calling this function, the {@link #update(true)}
//   * or {@link #updateAll(true)} must be called in order to rebuild all
//   * the tool items created by the tool bar.
//   *
//   * @param id
//   *          the ID of the action whose visibility is to be set.
//   * @param visible
//   *          the visibility to be set.
//   */
//  public void setToolBarActionVisibility(String id, boolean visible) {
//    final ExplorerFooterToolBar toolBar = this.getFooterToolBar();
//    toolBar.setActionVisibility(id, visible);
//  }
//
//  /**
//   * Updates the tool bar.
//   *
//   * @param force
//   *    true means update even if not dirty, and false for normal incremental updating.
//   */
//  public void updateToolBar(boolean force) {
//    final ExplorerFooterToolBar toolBar = this.getFooterToolBar();
//    toolBar.updateToolBar(force);
//  }
}
