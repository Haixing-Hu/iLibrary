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

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.ApplicationConfig;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.gui.MainWindow;
import com.github.haixing_hu.swt.utils.SWTResourceManager;

/**
 * The panel display the navigation tree.
 *
 * @author Haixing Hu
 */
public final class NavigatorPanel extends Composite {

  public static final String KEY = MainWindow.KEY + ".navigator";

  private final Application application;
  private final int defaultWidth;
  private final int minWidth;
  private final int maxWidth;
  private final int marginTop;
  private final String backgroundColor;
  private NavigatorTree tree;
  private NavigatorFooter footer;

  /**
   * Constructs a {@link NavigatorPanel}.
   *
   * @param application
   *          the application the new panel belongs.
   * @param parent
   *          the parent of the new panel.
   */
  public NavigatorPanel(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
    final ApplicationConfig config = ApplicationConfig.getInstance();
    defaultWidth = config.getInt(KEY + KeySuffix.DEFAULT_WIDTH);
    minWidth = config.getInt(KEY + KeySuffix.MIN_WIDTH);
    maxWidth = config.getInt(KEY + KeySuffix.MAX_WIDTH);
    marginTop = config.getInt(KEY + KeySuffix.MARGIN_TOP);
    backgroundColor = config.getString(KEY + KeySuffix.BACKGROUND_COLOR);
    createContents();
  }


  /**
   * Creates the contents of this panel.
   */
  private void createContents() {
    final FormLayout layout = new FormLayout();
    layout.marginTop = this.marginTop;
    layout.marginBottom = 0;
    layout.marginLeft = 0;
    layout.marginRight = 0;
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    layout.spacing = 0;
    this.setLayout(layout);

    final Color color = SWTResourceManager.getColor(backgroundColor);
    this.setBackground(color);

    tree = new NavigatorTree(application, this);
    footer = new NavigatorFooter(application, this);

    final FormData fd_navigatorTree = new FormData();
    fd_navigatorTree.left = new FormAttachment(0);
    fd_navigatorTree.top = new FormAttachment(0);
    fd_navigatorTree.right = new FormAttachment(100);
    fd_navigatorTree.bottom = new FormAttachment(footer);
    tree.getControl().setLayoutData(fd_navigatorTree);

    final FormData fd_statusLine = new FormData();
    fd_statusLine.left = new FormAttachment(0);
    fd_statusLine.top = new FormAttachment(100, - footer.getHeight());
    fd_statusLine.right = new FormAttachment(100);
    fd_statusLine.bottom = new FormAttachment(100);
    footer.setLayoutData(fd_statusLine);
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


}
