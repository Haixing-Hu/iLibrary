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
import com.github.haixing_hu.ilibrary.action.view.columns.SelectColumnForAction;
import com.github.haixing_hu.ilibrary.action.view.columns.SelectColumnsAction;
import com.github.haixing_hu.ilibrary.gui.BasicBalloonWindow;
import com.github.haixing_hu.ilibrary.model.FieldType;
import com.github.haixing_hu.swt.action.ActionEx;

/**
 * The window for selecting the displayed columns.
 *
 * @author Haixing Hu
 */
public class SelectColumnsWindow extends BasicBalloonWindow implements KeySuffix {

  public static final String ID = "dialog.select-columns";

  public SelectColumnsWindow(Application application) {
    super(application);
    createContents(application);
  }

  private void createContents(Application application) {
    final Composite contents = getContents();
    final AppConfig config = application.getConfig();
    final ActionManager am = application.getActionManager();
    final BaseAction colAction = (BaseAction) am.get(SelectColumnsAction.ID);
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

    for (final FieldType col : FieldType.values()) {
      final String id = SelectColumnForAction.getActionId(col);
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
