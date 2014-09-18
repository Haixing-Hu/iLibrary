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

package com.github.haixing_hu.ilibrary.action.help;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseDropDownAction;
import com.github.haixing_hu.swt.action.IActionManager;

/**
 * The action to show the drop down menu of helping related actions.
 *
 * @author Haixing Hu
 */
public class HelpAction extends BaseDropDownAction {

  public static final String KEY = "action.help";

  private static final String SUB_ACTIONS[] = {
    ManualAction.KEY,
    FaqAction.KEY,
    WebsiteAction.KEY,
    FeedbackAction.KEY,
    SEPARATOR_KEY,
    AboutAction.KEY,
  };

  public HelpAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager, SUB_ACTIONS);
  }

}
