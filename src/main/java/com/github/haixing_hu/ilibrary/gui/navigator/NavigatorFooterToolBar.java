/******************************************************************************
 *
 * Copyright (c) 2013  Haixing Hu
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
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.action.ActionManager;
import com.github.haixing_hu.ilibrary.action.file.collection.NewCollectionAction;
import com.github.haixing_hu.ilibrary.action.library.collection.ManageCollectionAction;
import com.github.haixing_hu.ilibrary.action.view.HideNavigatorAction;
import com.github.haixing_hu.swt.action.ActionUtils;

/**
 * The tool bar on the footer of the navigator panel.
 *
 * @author Haixing Hu
 */
public class NavigatorFooterToolBar extends Composite {

  private static final String LEFT_ACTION_KEYS[] = {
    NewCollectionAction.ID,
    ManageCollectionAction.ID,
  };

  private static final String RGIHT_ACTION_KEYS[] = {
    HideNavigatorAction.ID,
  };

  private final ToolBarManager leftToolBar;
  private final Label centerSpace;
  private final ToolBarManager rightToolBar;
  private final Color backgroundColor;

  public NavigatorFooterToolBar(Application application, Composite parent) {
    super(parent, SWT.NONE);
    final ActionManager am = application.getActionManager();
    leftToolBar = new ToolBarManager(SWT.FLAT | SWT.NO_FOCUS);
    ActionUtils.addActions(leftToolBar, am, LEFT_ACTION_KEYS);
    leftToolBar.createControl(this);
    centerSpace = new Label(this, SWT.NONE);
    rightToolBar = new ToolBarManager(SWT.FLAT | SWT.NO_FOCUS);
    ActionUtils.addActions(rightToolBar, am, RGIHT_ACTION_KEYS);
    rightToolBar.createControl(this);
    final AppConfig config = application.getConfig();
    backgroundColor = config.getColor(NavigatorFooter.ID
        + KeySuffix.CONTROL + KeySuffix.BACKGROUND_COLOR);
    layoutContents();
   }

   private void layoutContents() {
     final GridLayout layout = new GridLayout(3, false);
     layout.marginHeight = 0;
     layout.marginWidth = 0;
     setLayout(layout);

     final GridData gd_left = new GridData(SWT.LEFT, SWT.CENTER, false, false);
     leftToolBar.getControl().setLayoutData(gd_left);

     final GridData gd_center = new GridData(SWT.CENTER, SWT.CENTER, true, false);
     centerSpace.setLayoutData(gd_center);

     final GridData gd_right = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
     rightToolBar.getControl().setLayoutData(gd_right);

     if (backgroundColor != null) {
       setBackground(backgroundColor);
       leftToolBar.getControl().setBackground(backgroundColor);
       centerSpace.setBackground(backgroundColor);
       rightToolBar.getControl().setBackground(backgroundColor);
     }
   }

}
