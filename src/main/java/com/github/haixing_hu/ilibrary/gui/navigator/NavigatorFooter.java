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

import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.action.ActionManager;
import com.github.haixing_hu.ilibrary.action.file.NewCollectionAction;
import com.github.haixing_hu.ilibrary.action.library.ManageCollectionAction;
import com.github.haixing_hu.swt.utils.SWTResourceManager;

/**
 * The footer of the navigator panel.
 *
 * @author Haixing Hu
 */
public class NavigatorFooter extends Composite {

  public static final String KEY = "footer";

  private final Application application;
  private ToolBarManager toolBarManager;
  private Composite corner;
  private final int height;

  /**
   * Creates a status line.
   *
   * @param application
   *    the application.
   * @param parent
   *    the parent of the new status line.
   * @param style
   *    the style of the new status line.
   */
  public NavigatorFooter(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
    final AppConfig config = application.getConfig();
    height = config.getInt(KEY + KeySuffix.HEIGHT);
    createContents();
  }

  private void createContents() {
    final AppConfig config = application.getConfig();
    final FormLayout layout = new FormLayout();
    layout.spacing = 0;
    layout.marginTop = 0;
    layout.marginBottom = 0;
    layout.marginLeft = 0;
    layout.marginRight = 0;
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    layout.spacing = 0;
    this.setLayout(layout);

    final String background = config.getString(KEY + KeySuffix.BACKGROUND_IMAGE);
    final Image img = SWTResourceManager.getImage(this.getClass(), background);
    this.setBackgroundImage(img);

    toolBarManager = new ToolBarManager(SWT.FLAT);
    final ActionManager am = application.getActionManager();
    toolBarManager.add(am.get(NewCollectionAction.KEY));
    toolBarManager.add(am.get(ManageCollectionAction.KEY));
    toolBarManager.createControl(this);
    final ToolBar toolBar = toolBarManager.getControl();

    final String toolbar_background = config.getString(KEY + KeySuffix.TOOLBAR + KeySuffix.BACKGROUND_IMAGE);
    final Image toolbar_img = SWTResourceManager.getImage(this.getClass(), toolbar_background);
    toolBar.setBackgroundImage(toolbar_img);

    corner = new Composite(this, SWT.NONE);

    final String cornerBackground = config.getString(KEY + KeySuffix.CORNER + KeySuffix.BACKGROUND_IMAGE);
    final Image cornerBackgroundImg = SWTResourceManager.getImage(this.getClass(), cornerBackground);
    corner.setBackgroundImage(cornerBackgroundImg);

    final int toolbarTop = config.getInt(KEY + KeySuffix.TOOLBAR + KeySuffix.TOP);
    final FormData fd_toolBar = new FormData();
    fd_toolBar.left = new FormAttachment(0);
    fd_toolBar.right = new FormAttachment(corner);
    fd_toolBar.top = new FormAttachment(0, toolbarTop);
    toolBar.setLayoutData(fd_toolBar);

    final int cornerWidth = config.getInt(KEY + KeySuffix.CORNER + KeySuffix.WIDTH);
    final FormData fd_corner = new FormData();
    fd_corner.left = new FormAttachment(100, - cornerWidth);
    fd_corner.top = new FormAttachment(0);
    fd_corner.right = new FormAttachment(100);
    fd_corner.bottom = new FormAttachment(100);
    corner.setLayoutData(fd_corner);
  }


  /**
   * Gets the height of this status line.
   *
   * @return the height of this status line.
   */
  public int getHeight() {
    return height;
  }
}
