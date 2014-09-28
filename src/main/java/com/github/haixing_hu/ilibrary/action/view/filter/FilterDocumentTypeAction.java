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

import java.util.ArrayList;
import java.util.List;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseDropDownAction;
import com.github.haixing_hu.ilibrary.action.view.ViewAction;
import com.github.haixing_hu.ilibrary.model.DocumentType;
import com.github.haixing_hu.swt.action.IActionManager;

/**
 * The action to filter documents by their types.
 *
 * @author Haixing Hu
 */
public class FilterDocumentTypeAction extends BaseDropDownAction {

  public static final String ID = ViewAction.ID + ".filter.type";

  public FilterDocumentTypeAction(Application application,
      IActionManager actionManager) {
    super(ID, application, actionManager, getSubactionIds());
  }

  private static String[] getSubactionIds() {
    final List<String> ids = new ArrayList<String>();
    ids.add(FilterDocumentTypeAllAction.ID);
    for (final DocumentType type : DocumentType.values()) {
      final String id = FilterDocumentTypeForAction.getActionId(type);
      ids.add(id);
    }
    return ids.toArray(new String[0]);
  }
}
