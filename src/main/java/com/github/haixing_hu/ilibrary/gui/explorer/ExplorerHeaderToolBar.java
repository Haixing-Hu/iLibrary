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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.action.ActionManager;
import com.github.haixing_hu.ilibrary.action.view.browser.BrowserModeAction;
import com.github.haixing_hu.swt.action.ActionEx;

/**
 * The tool bar on the header of an explorer page.
 *
 * @author Haixing Hu
 */
public class ExplorerHeaderToolBar extends Composite {

  public static final String KEY = ExplorerHeader.KEY + KeySuffix.CONTROL;

  public static final String FILTER_LABEL_KEY = ExplorerHeader.KEY + ".view";

  public static final String SORT_LABEL_KEY = ExplorerHeader.KEY +  ".sort-by";

  private final ToolBarManager toolBar;
  private final Label filterLabel;
  private final Text filterBox;
  private final Label sortLabel;
  private final Text sortBox;
  private final Text searchBox;
  private final Color backgroundColor;
  private final Image backgroundImage;

  public ExplorerHeaderToolBar(Application application, Composite parent) {
    super(parent, SWT.NONE);
    toolBar = new ToolBarManager(SWT.FLAT | SWT.NO_FOCUS);
    final ActionManager am = application.getActionManager();
    final ActionEx browserModeAction = am.get(BrowserModeAction.KEY);
    toolBar.add(browserModeAction);
    toolBar.createControl(this);
    final AppConfig config = application.getConfig();
    filterLabel = new Label(this, SWT.NONE);
    filterLabel.setText(config.getMessage(FILTER_LABEL_KEY));
    filterBox = new Text(this, SWT.BORDER); //  FIXME
    sortLabel = new Label(this, SWT.NONE);
    sortLabel.setText(config.getMessage(SORT_LABEL_KEY));
    sortBox = new Text(this, SWT.BORDER);   //  FIXME
    searchBox = new Text(this, SWT.SEARCH | SWT.ICON_CANCEL | SWT.ICON_SEARCH);       //  FIXME

    backgroundColor = config.getColor(KEY + KeySuffix.BACKGROUND_COLOR);
    backgroundImage = config.getImage(this.getClass(), KEY + KeySuffix.BACKGROUND_IMAGE);
    layoutContents();
  }

  private void layoutContents() {
    final GridLayout layout = new GridLayout(6, false);
    layout.horizontalSpacing = 15;
    layout.marginWidth = 5;
    setLayout(layout);

    final GridData fd_toolbar = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    toolBar.getControl().setLayoutData(fd_toolbar);

    final GridData fd_filterlabel = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    filterLabel.setLayoutData(fd_filterlabel);

    final GridData fd_filterbox = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    filterBox.setLayoutData(fd_filterbox);

    final GridData fd_sortlabel = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    sortLabel.setLayoutData(fd_sortlabel);

    final GridData fd_sortbox = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    sortBox.setLayoutData(fd_sortbox);

    final GridData fd_searchbox = new GridData(SWT.FILL, SWT.CENTER, true, false);
    searchBox.setLayoutData(fd_searchbox);

    if (backgroundColor != null) {
      setBackground(backgroundColor);
      toolBar.getControl().setBackground(backgroundColor);
      filterLabel.setBackground(backgroundColor);
      //filterBox.setBackground(backgroundColor);
      sortLabel.setBackground(backgroundColor);
      //sortBox.setBackground(backgroundColor);
      //searchBox.setBackground(backgroundColor);
    }
    if (backgroundImage != null) {
      setBackgroundImage(backgroundImage);
      toolBar.getControl().setBackgroundImage(backgroundImage);
      filterLabel.setBackgroundImage(backgroundImage);
      //filterBox.setBackgroundImage(backgroundImage);
      sortLabel.setBackgroundImage(backgroundImage);
      //sortBox.setBackgroundImage(backgroundImage);
    }
  }
}
