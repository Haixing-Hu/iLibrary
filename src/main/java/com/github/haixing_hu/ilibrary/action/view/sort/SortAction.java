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

import java.util.ArrayList;
import java.util.List;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseDropDownAction;
import com.github.haixing_hu.ilibrary.action.view.ViewAction;
import com.github.haixing_hu.ilibrary.model.FieldType;
import com.github.haixing_hu.swt.action.IActionManager;

/**
 * The action to set the sorting order of the documents.
 *
 * @author Haixing Hu
 */
public class SortAction extends BaseDropDownAction {

  public static final String KEY = ViewAction.KEY + ".sort";

  private static final String DEFAULT_SUBACTION_KEYS[] = {
    SortOrderAscAction.KEY,
    SortOrderDescAction.KEY,
    SEPARATOR_KEY,
    SortByDefaultColumnAction.KEY,
  };

  public SortAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager, getSubactionIds());
  }

  private static String[] getSubactionIds() {
    final List<String> ids = new ArrayList<String>();
    for (final String id : DEFAULT_SUBACTION_KEYS) {
      ids.add(id);
    }
    for (final FieldType col : FieldType.values()) {
      final String id = SortByColumnAction.getActionId(col);
      ids.add(id);
    }
    return ids.toArray(new String[0]);
  }
}
