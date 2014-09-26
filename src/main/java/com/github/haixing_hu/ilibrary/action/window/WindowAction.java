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

package com.github.haixing_hu.ilibrary.action.window;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseDropDownAction;
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
import com.github.haixing_hu.swt.action.IActionManager;

/**
 * The action to show the drop down menu of window related actions.
 *
 * @author Haixing Hu
 */
public class WindowAction extends BaseDropDownAction {

  public static final String KEY = "action.window";

  private static final String SUB_ACTIONS[] = {
    MinimizeAction.KEY,
    MinimizeAllAction.KEY,
    MaximizeAction.KEY,
    SEPARATOR_KEY,
    PageSearchAction.KEY,
    PageLibraryAction.KEY,
    PageTagsAction.KEY,
    PageAuthorsAction.KEY,
    PageSourcesAction.KEY,
    PageReaderAction.KEY,
    SEPARATOR_KEY,
    CycleTabsAction.KEY,
    PreviousTabAction.KEY,
    NextTabAction.KEY,
    SEPARATOR_KEY,
    CloseTabAction.KEY,
    CloseAllTabsAction.KEY,
  };

  public WindowAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager, SUB_ACTIONS);
  }
}
