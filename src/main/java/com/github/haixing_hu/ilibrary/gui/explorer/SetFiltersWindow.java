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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ToolBar;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.action.ActionManager;
import com.github.haixing_hu.ilibrary.action.BaseAction;
import com.github.haixing_hu.ilibrary.action.BaseDropDownAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterDocumentTypeAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterFileStatusAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterFlagStatusAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterReadStatusAction;
import com.github.haixing_hu.ilibrary.gui.BasicBalloonWindow;
import com.github.haixing_hu.swt.action.ActionEx;

/**
 * The balloon window used to set the filters.
 *
 * @author Haixing Hu
 */
public class SetFiltersWindow extends BasicBalloonWindow implements KeySuffix {

  public static final String ID = "dialog.set-filters";

  public SetFiltersWindow(Application application) {
    super(application);
    createContents(application);
  }

  private void createContents(Application application) {
    final Composite contents = getContents();
    final AppConfig config = application.getConfig();
    final ActionManager am = application.getActionManager();
    final BaseAction colAction = (BaseAction) am.get(FilterAction.ID);
    setTitle(colAction.getTitle());
    final int perLine = config.getInt(ID + COLUMNS);
    final GridLayout layout = new GridLayout(perLine, true);
    layout.horizontalSpacing = config.getInt(ID + HORIZONTAL_SPACING);;
    layout.verticalSpacing = config.getInt(ID + VERTICAL_SPACING);
    layout.marginWidth = 0;
    layout.marginHeight = 0;
    contents.setLayout(layout);

    final Label separator = new Label(contents, SWT.HORIZONTAL | SWT.SEPARATOR);
    final GridData gd_sep = new GridData(GridData.FILL_HORIZONTAL);
    gd_sep.horizontalSpan = perLine;
    separator.setLayoutData(gd_sep);
    addSelectionControl(separator);

    addActions(application,
        (BaseDropDownAction) am.get(FilterFlagStatusAction.ID));
    addActions(application,
        (BaseDropDownAction) am.get(FilterReadStatusAction.ID));
    addActions(application,
        (BaseDropDownAction) am.get(FilterDocumentTypeAction.ID));
    addActions(application,
        (BaseDropDownAction) am.get(FilterFileStatusAction.ID));
  }

  private void addActions(Application application,
      BaseDropDownAction parentAction) {
    final Composite contents = getContents();
    final AppConfig config = application.getConfig();
    final ActionManager am = application.getActionManager();
    final int perLine = config.getInt(ID + COLUMNS);

    final Label titleLabel = new Label(contents, SWT.LEFT);
    titleLabel.setText(parentAction.getTitle());
    final Color color = config.getColor(Application.ID + FONT + HEAVY + COLOR);
    titleLabel.setForeground(color);
    final GridData gd_title = new GridData(SWT.LEFT, SWT.CENTER,
        false, false, perLine, 1);
    titleLabel.setLayoutData(gd_title);
    addSelectionControl(titleLabel);

    for (final String id : parentAction.getSubActionIds()) {
      final ActionEx action = am.get(id);
      final ToolBarManager tm = new ToolBarManager(SWT.FLAT | SWT.NO_FOCUS);
      tm.add(action);
      final ToolBar toolBar = tm.createControl(contents);
      final GridData gd = new GridData(SWT.LEFT, SWT.CENTER, false, false);
      toolBar.setLayoutData(gd);
      addSelectionControl(toolBar);
    }
  }
}
