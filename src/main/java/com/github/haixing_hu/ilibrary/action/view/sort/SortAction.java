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

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseActionGroup;
import com.github.haixing_hu.ilibrary.action.view.ViewAction;
import com.github.haixing_hu.ilibrary.model.FieldType;
import com.github.haixing_hu.javafx.action.ActionManager;
import com.github.haixing_hu.javafx.action.IAction;
import com.github.haixing_hu.javafx.action.SeparatorAction;

/**
 * The action to set the sorting order of the documents.
 *
 * @author Haixing Hu
 */
public class SortAction extends BaseActionGroup {

  public static final String ID = ViewAction.ID + ".sort";

  public static final String BUTTON_CLASS = "button-sort";

  public SortAction(Application application) {
    super(ID, application);
    styleClass.add(BUTTON_CLASS);
    final ActionManager am = application.getActionManager();
    addSubAction(am, new SortOrderAscAction(application));
    addSubAction(am, new SortOrderDescAction(application));
    addSubAction(am, new SeparatorAction());
    addSubAction(am, new SortByDefaultColumnAction(application));
    for (final FieldType col : FieldType.values()) {
      final IAction action = new  SortByColumnOfAction(col, application);
      addSubAction(am, action);
    }
  }
}
