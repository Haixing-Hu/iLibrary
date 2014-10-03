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

package com.github.haixing_hu.ilibrary.action.view.filter;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseActionGroup;
import com.github.haixing_hu.ilibrary.action.view.ViewAction;
import com.github.haixing_hu.ilibrary.model.DocumentType;
import com.github.haixing_hu.javafx.action.ActionManager;
import com.github.haixing_hu.javafx.action.IAction;

/**
 * The action to filter documents by their types.
 *
 * @author Haixing Hu
 */
public class FilterDocumentTypeAction extends BaseActionGroup {

  public static final String ID = ViewAction.ID + ".filter.type";

  public FilterDocumentTypeAction(Application application) {
    super(ID, application);
    final ActionManager am = application.getActionManager();
    addSubAction(am, new FilterDocumentTypeAllAction(application));
    for (final DocumentType type : DocumentType.values()) {
      final IAction action = new FilterDocumentTypeForAction(type, application);
      addSubAction(am, action);
    }
  }
}
