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

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseActionGroup;
import com.github.haixing_hu.ilibrary.action.file.FileAction;
import com.github.haixing_hu.ilibrary.model.DocumentType;
import com.github.haixing_hu.javafx.action.ActionManager;
import com.github.haixing_hu.javafx.action.IAction;
import com.github.haixing_hu.javafx.action.SeparatorAction;

/**
 * The action to create a new item.
 *
 * @author Haixing Hu
 */
public class NewAction extends BaseActionGroup {

  public static final String ID = FileAction.ID + ".new";

  public NewAction(Application application) {
    super(ID, application);
    final ActionManager am = application.getActionManager();
    for (final DocumentType type : DocumentType.values()) {
      final IAction action = new NewDocumentAction(type, application);
      addSubAction(am, action);
    }
    addSubAction(am, new SeparatorAction());
    addSubAction(am, new NewAuthorAction(application));
    addSubAction(am, new NewPeriodicalAction(application));
    addSubAction(am, new NewConferenceAction(application));
    addSubAction(am, new NewInstituteAction(application));
    addSubAction(am, new NewWebSiteAction(application));
  }
}
