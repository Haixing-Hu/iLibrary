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
import com.github.haixing_hu.swt.action.IActionManager;

/**
 * The action to show the drop down menu of file related actions.
 *
 * @author Haixing Hu
 */
public class FileAction extends BaseDropDownAction {

  public static final String KEY = "action.file";

  private static final String SUB_ACTIONS[] = {
    NewAction.KEY,
    NewCollectionAction.KEY,
    NewLibraryAction.KEY,
    OpenLibraryAction.KEY,
    CloseLibraryAction.KEY,
    SEPARATOR_KEY,
    ImportAction.KEY,
    ExportAction.KEY,
    SEPARATOR_KEY,
    PageSetupAction.KEY,
    PrintAction.KEY,
    SEPARATOR_KEY,
    QuitAction.KEY,
  };

  public FileAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager, SUB_ACTIONS);
  }

}
