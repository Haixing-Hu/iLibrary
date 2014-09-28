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

package com.github.haixing_hu.ilibrary.action.edit;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseDropDownAction;
import com.github.haixing_hu.ilibrary.action.edit.annotate.AnnotateAction;
import com.github.haixing_hu.ilibrary.action.edit.copy.CopyAsAction;
import com.github.haixing_hu.swt.action.IActionManager;
import com.github.haixing_hu.swt.toolbar.Separator;

/**
 * The action to show the drop down menu of editing related actions.
 *
 * @author Haixing Hu
 */
public class EditAction extends BaseDropDownAction {

  public static final String ID = "action.edit";

  private static final String SUB_ACTIONS[] = {
    UndoAction.ID,
    RedoAction.ID,
    Separator.ID,
    CutAction.ID,
    CopyAction.ID,
    CopyAsAction.ID,
    PasteAction.ID,
    DeleteAction.ID,
    SelectAllAction.ID,
    Separator.ID,
    AnnotateAction.ID,
    Separator.ID,
    FontAction.ID,
    StyleAction.ID,
    Separator.ID,
    FindAction.ID,
    FindPreviousAction.ID,
    FindNextAction.ID,
    Separator.ID,
    PreferencesAction.ID,
  };

  public EditAction(Application application, IActionManager actionManager) {
    super(ID, application, actionManager, SUB_ACTIONS);
  }

}
