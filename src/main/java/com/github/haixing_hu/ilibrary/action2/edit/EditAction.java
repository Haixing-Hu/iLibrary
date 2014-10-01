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

package com.github.haixing_hu.ilibrary.action2.edit;

import com.github.haixing_hu.ilibrary.Application2;
import com.github.haixing_hu.ilibrary.action2.BaseActionGroup;
import com.github.haixing_hu.ilibrary.action2.edit.copy.CopyAsAction;
import com.github.haixing_hu.javafx.action.ActionManager;
import com.github.haixing_hu.javafx.action.SeparatorAction;

/**
 * The action to show the drop down menu of editing related actions.
 *
 * @author Haixing Hu
 */
public class EditAction extends BaseActionGroup {

  public static final String ID = "action.edit";

  public EditAction(Application2 application) {
    super(ID, application);
    final ActionManager am = application.getActionManager();

    addSubAction(am, new UndoAction(application));
    addSubAction(am, new RedoAction(application));
    addSubAction(am, new SeparatorAction());
    addSubAction(am, new CutAction(application));
    addSubAction(am, new CopyAsAction(application));
    addSubAction(am, new PasteAction(application));
    addSubAction(am, new DeleteAction(application));
    addSubAction(am, new SeparatorAction());
    addSubAction(am, new FontAction(application));
    addSubAction(am, new StyleAction(application));
    addSubAction(am, new SeparatorAction());
    addSubAction(am, new FindAction(application));
    addSubAction(am, new FindPreviousAction(application));
    addSubAction(am, new FindNextAction(application));
    addSubAction(am, new SeparatorAction());
    addSubAction(am, new PreferencesAction(application));
  }

}
