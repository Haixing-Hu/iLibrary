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

package com.github.haixing_hu.ilibrary.action.view;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseCheckBoxAction;
import com.github.haixing_hu.ilibrary.controller.LibraryTabController;
import com.github.haixing_hu.ilibrary.gui.widget.IActionManager;
import com.github.haixing_hu.ilibrary.state.ReadStatusFilter;

/**
 * The action to filter documents which are under reading.
 *
 * @author Haixing Hu
 */
public class FilterReadStatusReadingAction extends BaseCheckBoxAction {

  public static final String KEY = FilterReadStatusAction.KEY + ".reading";

  public FilterReadStatusReadingAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

  @Override
  public void run() {
    final LibraryTabController controller = application.getLibraryTabController();
    controller.setReadFilter(ReadStatusFilter.READING);
  }

}
