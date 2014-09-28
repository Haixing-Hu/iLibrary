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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.ActionManager;
import com.github.haixing_hu.ilibrary.action.view.inspector.InspectorInfoTabAction;
import com.github.haixing_hu.ilibrary.action.view.inspector.InspectorNotesTabAction;
import com.github.haixing_hu.ilibrary.action.view.inspector.InspectorOverviewTabAction;
import com.github.haixing_hu.ilibrary.action.view.inspector.InspectorReviewsTabAction;
import com.github.haixing_hu.ilibrary.gui.BasicHeader;
import com.github.haixing_hu.swt.action.ActionUtils;

/**
 * The header of the inspector tab folder.
 *
 * @author Haixing Hu
 */
public final class InspectorHeader extends BasicHeader {

  public static final String ID = InspectorPanel.ID + ".header";

  private static final String ACTION_IDS[] = {
    InspectorOverviewTabAction.ID,
    InspectorInfoTabAction.ID,
    InspectorNotesTabAction.ID,
    InspectorReviewsTabAction.ID,
  };

  public InspectorHeader(final Application application, final Composite parent) {
    super(application, parent, ID, SWT.LEFT);
    initialize();
  }

  @Override
  protected Control createControl() {
    final ToolBarManager tm = new ToolBarManager(SWT.FLAT | SWT.NO_FOCUS);
    final ActionManager am = application.getActionManager();
    ActionUtils.addActions(tm, am, ACTION_IDS);
    tm.createControl(this);
    return tm.getControl();
  }
}
