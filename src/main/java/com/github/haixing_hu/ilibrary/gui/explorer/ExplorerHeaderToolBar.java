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


import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.action.ActionManager;
import com.github.haixing_hu.ilibrary.action.view.browser.BrowserModeAction;
import com.github.haixing_hu.ilibrary.action.view.columns.SelectColumnsAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterAction;
import com.github.haixing_hu.ilibrary.action.view.sort.SortAction;

/**
 * The tool bar on the header of an explorer page.
 *
 * @author Haixing Hu
 */
public class ExplorerHeaderToolBar extends Composite {

  public static final String ID = ExplorerHeader.ID + KeySuffix.CONTROL;

  public static final String FILTER_LABEL_KEY = ExplorerHeader.ID + ".view";

  public static final String SORT_LABEL_KEY = ExplorerHeader.ID +  ".sort.column";

  private final ToolBarManager toolBarManager;
  private final ToolBar toolBar;
  private final Text searchBox;
  private final Color backgroundColor;
  private final Image backgroundImage;

  public ExplorerHeaderToolBar(Application application, Composite parent) {
    super(parent, SWT.NONE);
    toolBarManager = new ToolBarManager(SWT.FLAT | SWT.NO_FOCUS);
    final ActionManager am = application.getActionManager();
    toolBarManager.add(am.get(BrowserModeAction.ID));
    toolBarManager.add(am.get(SelectColumnsAction.ID));
    toolBarManager.add(am.get(FilterAction.ID));
    toolBarManager.add(am.get(SortAction.ID));
    toolBarManager.createControl(this);
    toolBar = toolBarManager.getControl();
    final AppConfig config = application.getConfig();
    searchBox = new Text(this, SWT.SEARCH | SWT.ICON_CANCEL | SWT.ICON_SEARCH);       //  FIXME
    backgroundColor = config.getColor(ID + KeySuffix.BACKGROUND_COLOR);
    backgroundImage = config.getImage(this.getClass(), ID + KeySuffix.BACKGROUND_IMAGE);
    layoutContents();
  }

  private void layoutContents() {
    final GridLayout layout = new GridLayout(2, false);
    layout.horizontalSpacing = 15;
    layout.marginWidth = 5;
    setLayout(layout);

    final GridData fd_toolbar = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    toolBar.setLayoutData(fd_toolbar);

    final GridData fd_searchbox = new GridData(SWT.FILL, SWT.CENTER, true, false);
    searchBox.setLayoutData(fd_searchbox);

    if (backgroundColor != null) {
      setBackground(backgroundColor);
      toolBar.setBackground(backgroundColor);
    }
    if (backgroundImage != null) {
      setBackgroundImage(backgroundImage);
      toolBar.setBackgroundImage(backgroundImage);
    }
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
   * Gets the tool bar.
   *
   * @return the tool bar.
   */
  public ToolBar getToolBar() {
    return toolBar;
  }

  /**
   * Gets the search box.
   *
   * @return the search box.
   */
  public Text getSearchBox() {
    return searchBox;
  }


}
