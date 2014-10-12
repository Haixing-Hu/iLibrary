/*
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
 */
package com.github.haixing_hu.ilibrary.action.window;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseActionGroup;
import com.github.haixing_hu.ilibrary.action.window.page.PageAuthorsAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageLibraryAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageReaderAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageSearchAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageSourcesAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageTagsAction;
import com.github.haixing_hu.ilibrary.action.window.tab.CloseAllTabsAction;
import com.github.haixing_hu.ilibrary.action.window.tab.CloseTabAction;
import com.github.haixing_hu.ilibrary.action.window.tab.CycleTabsAction;
import com.github.haixing_hu.ilibrary.action.window.tab.NextTabAction;
import com.github.haixing_hu.ilibrary.action.window.tab.PreviousTabAction;
import com.github.haixing_hu.javafx.action.ActionManager;
import com.github.haixing_hu.javafx.action.SeparatorAction;

/**
 * The action to show the drop down menu of window related actions.
 *
 * @author Haixing Hu
 */
public class WindowAction extends BaseActionGroup {

  public static final String ID = "action.window";

  public WindowAction(Application application) {
    super(ID, application);
    final ActionManager am = application.getActionManager();
    addSubAction(am, new MinimizeAction(application));
    addSubAction(am, new MinimizeAllAction(application));
    addSubAction(am, new MaximizeAction(application));
    addSubAction(am, new SeparatorAction());
    addSubAction(am, new PageSearchAction(application));
    addSubAction(am, new PageLibraryAction(application));
    addSubAction(am, new PageTagsAction(application));
    addSubAction(am, new PageAuthorsAction(application));
    addSubAction(am, new PageSourcesAction(application));
    addSubAction(am, new PageReaderAction(application));
    addSubAction(am, new SeparatorAction());
    addSubAction(am, new CycleTabsAction(application));
    addSubAction(am, new PreviousTabAction(application));
    addSubAction(am, new NextTabAction(application));
    addSubAction(am, new SeparatorAction());
    addSubAction(am, new CloseTabAction(application));
    addSubAction(am, new CloseAllTabsAction(application));
  }
}
