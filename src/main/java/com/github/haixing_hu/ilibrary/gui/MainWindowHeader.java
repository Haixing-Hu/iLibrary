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

package com.github.haixing_hu.ilibrary.gui;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.action.ActionManager;
import com.github.haixing_hu.ilibrary.action.window.page.PageAuthorsAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageLibraryAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageReaderAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageSearchAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageSourcesAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageTagsAction;
import com.github.haixing_hu.swt.toolbar.Fill;

/**
 * The header of main window.
 *
 * @author Haixing Hu
 */
public class MainWindowHeader extends BasicHeader implements KeySuffix {

  public static final String ID = MainWindow.ID + ".header";

  private static final String ACTION_IDS[] = {
    PageSearchAction.ID,
    PageLibraryAction.ID,
    PageTagsAction.ID,
    PageAuthorsAction.ID,
    PageSourcesAction.ID,
    PageReaderAction.ID,
  };

  public MainWindowHeader(Application application, Composite parent) {
    super(application, parent, ID, SWT.CENTER);
    initialize();
  }

  @Override
  protected Control createControl() {
    final AppConfig config = application.getConfig();
    final int spacing = config .getInt(ID + CONTROL + HORIZONTAL_SPACING);
    final ToolBarManager tm = new ToolBarManager(SWT.FLAT | SWT.NO_FOCUS);
    final ActionManager am = application.getActionManager();
    for (int i = 0; i < ACTION_IDS.length; ++i) {
      if (i > 0) {
        tm.add(new Fill(spacing));
      }
      final String id = ACTION_IDS[i];
      final IAction action = am.get(id);
      tm.add(action);
    }
    tm.createControl(this);
    return tm.getControl();
  }
}
