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

package com.github.haixing_hu.ilibrary.gui.explorer;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.action.share.ShareAction;
import com.github.haixing_hu.ilibrary.action.view.HidePreviewAction;
import com.github.haixing_hu.ilibrary.action.view.ShowInspectorAction;
import com.github.haixing_hu.ilibrary.action.view.ShowNavigatorAction;
import com.github.haixing_hu.ilibrary.action.view.ShowPreviewAction;
import com.github.haixing_hu.ilibrary.gui.util.ActionListToolBarManager;
import com.github.haixing_hu.swt.action.ActionEx;

/**
 * The tool bar in the footer of the explorer panel.
 *
 * @author Haixing Hu
 */
public class ExplorerFooterToolBar extends Composite {

  private static final String LEFT_ACTION_KEYS[] = {
    ShowNavigatorAction.KEY,
    HidePreviewAction.KEY,
    ShowPreviewAction.KEY,
  };

  private static final String RGIHT_ACTION_KEYS[] = {
    ShareAction.KEY,
    ShowInspectorAction.KEY,
  };

  private final Logger logger;
  private final Application application;
  private final ToolBarManager leftToolBar;
  private final CLabel statusLine;
  private final ToolBarManager rightToolBar;
  private final Color backgroundColor;

  public ExplorerFooterToolBar(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.logger = LoggerFactory.getLogger(this.getClass());
    this.application = application;
    leftToolBar = new ActionListToolBarManager(application, LEFT_ACTION_KEYS);
    leftToolBar.createControl(this);
    statusLine = new CLabel(this, SWT.NONE);
    rightToolBar = new ActionListToolBarManager(application, RGIHT_ACTION_KEYS);
    rightToolBar.createControl(this);
    final AppConfig config = application.getConfig();
    backgroundColor = config.getColor(ExplorerFooter.KEY + KeySuffix.BACKGROUND_COLOR);
    layoutContents();
  }

  private void layoutContents() {
    final GridLayout layout = new GridLayout(3, false);
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    this.setLayout(layout);

    final GridData gd_left = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    leftToolBar.getControl().setLayoutData(gd_left);

    final GridData gd_center = new GridData(SWT.CENTER, SWT.CENTER, true, false);
    statusLine.setLayoutData(gd_center);

    final GridData gd_right = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
    rightToolBar.getControl().setLayoutData(gd_right);

    if (backgroundColor != null) {
      this.setBackground(backgroundColor);
      leftToolBar.getControl().setBackground(backgroundColor);
      statusLine.setBackground(backgroundColor);
      rightToolBar.getControl().setBackground(backgroundColor);
    }
  }

  public void setMessage(String message) {
    statusLine.setText(message);
  }

  /**
   * Set the visibility of an action on this tool bar.
   *
   * <b>NOTE:</b> After calling this function, the {@link #update(true)}
   * or {@link #updateAll(true)} must be called in order to rebuild all
   * the tool items created by this tool bar.
   *
   * @param id
   *          the ID of the action whose visibility is to be set.
   * @param visible
   *          the visibility to be set.
   */
  public void setActionVisibility(String id, boolean visible) {
    //  first, set the visibility for the action
    final ActionEx action = application.getActionManager().get(id);
    if (action == null) {
      logger.error("Cannot found the sub-action: {}", id);
      return;
    }
    action.setVisible(visible);
    //  then, set the visibility for the contribution items
    IContributionItem item = leftToolBar.find(id);
    if (item != null) {
      item.setVisible(visible);
    } else {
      item = rightToolBar.find(id);
      if (item != null) {
        item.setVisible(visible);
      }
    }
  }

  /**
   * Updates the tool bar.
   *
   * @param force
   *    true means update even if not dirty, and false for normal incremental updating.
   */
  public void updateToolBar(boolean force) {
    leftToolBar.update(force);
    rightToolBar.update(force);
  }
}
