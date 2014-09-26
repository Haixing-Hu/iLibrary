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

package com.github.haixing_hu.ilibrary.action.view.browser;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseAction;
import com.github.haixing_hu.ilibrary.state.BrowserMode;
import com.github.haixing_hu.swt.action.IActionManager;

/**
 * The action to view the documents as a list.
 *
 * @author Haixing Hu
 */
public class AsListAction extends BaseAction {

  public static final String KEY = BrowserModeAction.KEY + ".as-list";

  public AsListAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

  @Override
  public void run() {
    application.setBrowserMode(BrowserMode.LIST);
  }
}
