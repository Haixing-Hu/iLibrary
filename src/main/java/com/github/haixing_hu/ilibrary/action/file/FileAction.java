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

package com.github.haixing_hu.ilibrary.action.file;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseDropDownAction;
import com.github.haixing_hu.ilibrary.action.file.collection.NewCollectionAction;
import com.github.haixing_hu.ilibrary.action.file.document.NewAction;
import com.github.haixing_hu.swt.action.IActionManager;
import com.github.haixing_hu.swt.toolbar.Separator;

/**
 * The action to show the drop down menu of file related actions.
 *
 * @author Haixing Hu
 */
public class FileAction extends BaseDropDownAction {

  public static final String ID = "action.file";

  private static final String SUB_ACTIONS[] = {
    NewLibraryAction.ID,
    OpenLibraryAction.ID,
    CloseLibraryAction.ID,
    Separator.ID,
    NewAction.ID,
    NewCollectionAction.ID,
    OpenURLAction.ID,
    Separator.ID,
    ImportAction.ID,
    ExportAction.ID,
    Separator.ID,
    PageSetupAction.ID,
    PrintAction.ID,
    Separator.ID,
    QuitAction.ID,
  };

  public FileAction(Application application, IActionManager actionManager) {
    super(ID, application, actionManager, SUB_ACTIONS);
  }

}
