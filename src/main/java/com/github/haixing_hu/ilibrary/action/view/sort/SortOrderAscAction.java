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
package com.github.haixing_hu.ilibrary.action.view.sort;

import javafx.event.ActionEvent;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseAction;
import com.github.haixing_hu.ilibrary.state.SortOrder;

/**
 * The action to set the sorting order to "asc".
 *
 * @author Haixing Hu
 */
public class SortOrderAscAction extends BaseAction {

  public static final String ID = SortAction.ID + ".order.asc";

  public static final String BUTTON_CLASS = "button-sort-asc";

  /**
   * Constructs a {@link SortOrderAscAction}.
   *
   * @param application
   *          the application.
   * @param actionManager
   *          the action manager.
   */
  public SortOrderAscAction(Application application) {
    super(ID, application, TOGGLE);
  }

  @Override
  public void handle(ActionEvent event) {
    application.getExplorerController().setSortOrder(SortOrder.ASC);
  }
}
