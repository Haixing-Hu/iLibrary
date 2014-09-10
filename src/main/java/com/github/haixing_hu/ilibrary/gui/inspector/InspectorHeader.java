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

import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.ApplicationConfig;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.action.ActionManager;
import com.github.haixing_hu.ilibrary.action.ui.SwitchToFilesTabAction;
import com.github.haixing_hu.ilibrary.action.ui.SwitchToInfoTabAction;
import com.github.haixing_hu.ilibrary.action.ui.SwitchToNotesTabAction;
import com.github.haixing_hu.ilibrary.action.ui.SwitchToReviewsTabAction;
import com.github.haixing_hu.swt.utils.SWTResourceManager;

/**
 * The header of the inspector tab folder.
 *
 * @author Haixing Hu
 */
public final class InspectorHeader extends Composite {

  public static final String KEY = "header";

  private final Application application;
  private ToolBarManager toolBarManager;
  private final int height;
  private final int marginWidth;
  private final String backgroundImage;

  public InspectorHeader(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
    final ApplicationConfig config = ApplicationConfig.getInstance();
    height = config.getInt(KEY + KeySuffix.HEIGHT);
    marginWidth = config.getInt(KEY + KeySuffix.MARGIN_WIDTH);
    backgroundImage = config.getString(KEY + KeySuffix.BACKGROUND_IMAGE);
    createContents();
  }

  private void createContents() {
    final GridLayout layout = new GridLayout(1, true);
    layout.horizontalSpacing = 0;
    layout.verticalSpacing = 0;
    layout.marginLeft = 0;
    layout.marginTop = 0;
    layout.marginRight = 0;
    layout.marginBottom = 0;
    layout.marginHeight = 0;
    layout.marginWidth = marginWidth;
    this.setLayout(layout);

    final Image bg_img = SWTResourceManager.getImage(InspectorHeader.class, backgroundImage);
    this.setBackgroundImage(bg_img);

    toolBarManager = new ToolBarManager(SWT.FLAT);
    final ActionManager am = application.getActionManager();
    toolBarManager.add(am.get(SwitchToInfoTabAction.KEY));
    toolBarManager.add(am.get(SwitchToNotesTabAction.KEY));
    toolBarManager.add(am.get(SwitchToReviewsTabAction.KEY));
    toolBarManager.add(am.get(SwitchToFilesTabAction.KEY));
    toolBarManager.createControl(this);
    final ToolBar toolBar = toolBarManager.getControl();

    final GridData gd_toolBar = new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1);
    toolBar.setLayoutData(gd_toolBar);

    //  in order to be compatible on multi-platforms, we must set the
    //  background image on both this composite and the tool bar.
    toolBar.setBackgroundImage(bg_img);
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
   * Gets the tool bar manager.
   *
   * @return the tool bar manager.
   */
  public ToolBarManager getToolBarManager() {
    return toolBarManager;
  }

  /**
   * Gets the height.
   *
   * @return the height.
   */
  public int getHeight() {
    return height;
  }

}
