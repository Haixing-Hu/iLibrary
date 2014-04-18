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

package com.github.haixing_hu.ilibrary.gui.inspector;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.wb.swt.SWTResourceManager;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.ApplicationConfig;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.action.ActionManager;
import com.github.haixing_hu.ilibrary.gui.navigator.NavigatorFooter;

/**
 * The footer of the tab pages on the inspector panel.
 *
 * @author Haixing Hu
 */
public class InspectorTabFooter extends Composite {

  public static final String KEY = "footer";

  protected final Application application;
  protected final String[] actionKeys;
  protected Composite corner;
  protected Composite fill;
  protected ToolBarManager toolBarManager;
  protected final int height;

  /**
   * Creates a status line.
   *
   * @param application
   *    the application.
   * @param parent
   *    the parent of the new status line.
   * @param actionKeys
   *    the array of keys of the action to be placed in the tool bar.
   */
  public InspectorTabFooter(Application application, Composite parent, String[] actionKeys) {
    super(parent, SWT.NONE);
    this.application = application;
    this.actionKeys = actionKeys;
    final ApplicationConfig config = ApplicationConfig.getInstance();
    height = config.getInt(KEY + KeySuffix.HEIGHT);
    createContents();
  }

  private void createContents() {
    final ApplicationConfig config = ApplicationConfig.getInstance();
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

    final String statuslineBg = config.getString(KEY + KeySuffix.BACKGROUND_IMAGE);
    final Image statuslineBgImg = SWTResourceManager.getImage(NavigatorFooter.class, statuslineBg);
    this.setBackgroundImage(statuslineBgImg);

    toolBarManager = new ToolBarManager(SWT.FLAT);
    final ActionManager am = application.getActionManager();
    if (actionKeys != null) {
      for (final String key : actionKeys) {
        final IAction action = am.get(key);
        toolBarManager.add(action);
      }
    }
    toolBarManager.createControl(this);
    final ToolBar toolBar = toolBarManager.getControl();

    final String toolbarBg = config.getString(KEY + KeySuffix.TOOLBAR + KeySuffix.BACKGROUND_IMAGE);
    final Image toolbarBgImg = SWTResourceManager.getImage(NavigatorFooter.class, toolbarBg);
    toolBar.setBackgroundImage(toolbarBgImg);

    fill = new Composite(this, SWT.NONE);
    fill.setBackgroundImage(statuslineBgImg);

    corner = new Composite(this, SWT.NONE);
    final String cornerBackground = config.getString(KEY + KeySuffix.CORNER + KeySuffix.BACKGROUND_IMAGE);
    final Image cornerBackgroundImg = SWTResourceManager.getImage(InspectorTabFooter.class, cornerBackground);
    corner.setBackgroundImage(cornerBackgroundImg);

    final int cornerWidth = config.getInt(KEY + KeySuffix.CORNER + KeySuffix.WIDTH);
    final FormData fd_corner = new FormData();
    fd_corner.left = new FormAttachment(0);
    fd_corner.right = new FormAttachment(0, cornerWidth);
    fd_corner.top = new FormAttachment(0);
    fd_corner.bottom = new FormAttachment(100);
    corner.setLayoutData(fd_corner);

    final FormData fd_fill = new FormData();
    fd_fill.left = new FormAttachment(corner);
    fd_fill.right = new FormAttachment(toolBar);
    fd_fill.top = new FormAttachment(0);
    fd_fill.bottom = new FormAttachment(100);
    fill.setLayoutData(fd_fill);

    final int toolbarTop = config.getInt(KEY + KeySuffix.TOOLBAR + KeySuffix.TOP);
    final FormData fd_toolBar = new FormData();
    //fd_toolBar.left = new FormAttachment(corner);
    fd_toolBar.right = new FormAttachment(100);
    fd_toolBar.top = new FormAttachment(0, toolbarTop);
    toolBar.setLayoutData(fd_toolBar);
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
