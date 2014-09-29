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

package com.github.haixing_hu.ilibrary.action.file.document;

import java.util.ArrayList;
import java.util.List;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseDropDownAction;
import com.github.haixing_hu.ilibrary.action.file.FileAction;
import com.github.haixing_hu.ilibrary.model.DocumentType;
import com.github.haixing_hu.swt.action.IActionManager;
import com.github.haixing_hu.swt.toolbar.Separator;

/**
 * The action to create a new item.
 *
 * @author Haixing Hu
 */
public class NewAction extends BaseDropDownAction {

  public static final String ID = FileAction.ID + ".new";

  private static final String SUB_ACTIONS[] = {
    Separator.ID,
    NewAuthorAction.ID,
    NewPeriodicalAction.ID,
    NewConferenceAction.ID,
    NewInstituteAction.ID,
    NewWebSiteAction.ID,
  };

  public NewAction(Application application, IActionManager actionManager) {
    super(ID, application, actionManager, getSubactionIds());
  }

  private static String[] getSubactionIds() {
    final List<String> ids = new ArrayList<String>();
    for (final DocumentType type : DocumentType.values()) {
      final String id = NewDocumentAction.getActionId(type);
      ids.add(id);
    }
    for (final String id : SUB_ACTIONS) {
      ids.add(id);
    }
    return ids.toArray(new String[0]);
  }

}