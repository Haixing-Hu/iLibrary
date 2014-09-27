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

package com.github.haixing_hu.ilibrary.action.view.sort;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseCheckBoxAction;
import com.github.haixing_hu.ilibrary.state.SortOrder;
import com.github.haixing_hu.swt.action.IActionManager;

/**
 * The action to set the sorting order to "asc".
 *
 * @author Haixing Hu
 */
public class SortOrderAscAction extends BaseCheckBoxAction {

  public static final String KEY = SortAction.KEY + ".order.asc";

  /**
   * Constructs a {@link SortOrderAscAction}.
   *
   * @param application
   *          the application.
   * @param actionManager
   *          the action manager.
   */
  public SortOrderAscAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
    this.setShowImage(false);
  }

  @Override
  public void run() {
    application.setSortOrder(SortOrder.ASC);
  }
}
