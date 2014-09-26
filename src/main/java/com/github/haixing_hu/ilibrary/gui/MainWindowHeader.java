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

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.window.page.PageAuthorsAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageLibraryAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageReaderAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageSearchAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageSourcesAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageTagsAction;
import com.github.haixing_hu.ilibrary.gui.util.ActionListToolBarCreator;

/**
 * The header of main window.
 *
 * @author Haixing Hu
 */
public class MainWindowHeader extends BasicHeader {

  public static final String KEY = MainWindow.KEY + ".header";

  private static final String ACTION_KEYS[] = {
    PageSearchAction.KEY,
    PageLibraryAction.KEY,
    PageTagsAction.KEY,
    PageAuthorsAction.KEY,
    PageSourcesAction.KEY,
    PageReaderAction.KEY,
  };

  public MainWindowHeader(Application application, Composite parent) {
    super(application, parent, KEY,
        new ActionListToolBarCreator(application, ACTION_KEYS), SWT.CENTER);
  }
}
