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

package com.github.haixing_hu.ilibrary.action.window.tab;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseAction;
import com.github.haixing_hu.ilibrary.action.window.WindowAction;
import com.github.haixing_hu.swt.action.IActionManager;

/**
 * The action to switch to the next tab.
 *
 * @author Haixing Hu
 */
public class NextTabAction extends BaseAction {

  public static final String ID = WindowAction.ID + ".next-tab";

  public NextTabAction(Application application, IActionManager actionManager) {
    super(ID, application, actionManager);
  }
}
