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
 * The action to filter documents
 *
 * @author Haixing Hu
 */
public class FilterAction extends BaseDropDownAction {

  public static final String KEY = ViewAction.KEY + ".filter";

  private static final String SUB_ACTIONS_1[] = {
    FilterFlagStatusAllAction.KEY,
    FilterFlagStatusFlaggedAction.KEY,
    FilterFlagStatusUnflaggedAction.KEY,
    SEPARATOR_KEY,
    FilterReadStatusAllAction.KEY,
    FilterReadStatusUnreadAction.KEY,
    FilterReadStatusToReadAction.KEY,
    FilterReadStatusReadingAction.KEY,
    FilterReadStatusHasReadAction.KEY,
    SEPARATOR_KEY,
    FilterTypeAllAction.KEY,
  };

  private static final String SUB_ACTIONS_2[] = {
    SEPARATOR_KEY,
    FilterFileStatusAllAction.KEY,
    FilterFileStatusHasFileAction.KEY,
    FilterFileStatusNoFileAction.KEY,
  };

  public FilterAction(Application application,
      IActionManager actionManager) {
    super(KEY, application, actionManager, getSubactionIds());
  }

  private static String[] getSubactionIds() {
    final List<String> ids = new ArrayList<String>();
    for (final String id : SUB_ACTIONS_1) {
      ids.add(id);
    }
    for (final DocumentType type : DocumentType.values()) {
      final String id = FilterTypeForAction.getActionId(type);
      ids.add(id);
    }
    for (final String id : SUB_ACTIONS_2) {
      ids.add(id);
    }
    return ids.toArray(new String[0]);
  }
}
