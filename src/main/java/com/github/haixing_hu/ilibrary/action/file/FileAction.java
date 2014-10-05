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
import com.github.haixing_hu.ilibrary.action.BaseActionGroup;
import com.github.haixing_hu.ilibrary.action.file.collection.NewCollectionAction;
import com.github.haixing_hu.ilibrary.action.file.document.NewDocumentAction;
import com.github.haixing_hu.ilibrary.action.file.source.NewSourceAction;
import com.github.haixing_hu.javafx.action.ActionManager;
import com.github.haixing_hu.javafx.action.SeparatorAction;

/**
 * The action to show the drop down menu of file related actions.
 *
 * @author Haixing Hu
 */
public class FileAction extends BaseActionGroup {

  public static final String ID = "action.file";

  public FileAction(Application application) {
    super(ID, application);
    final ActionManager am = application.getActionManager();
    addSubAction(am, new NewLibraryAction(application));
    addSubAction(am, new OpenLibraryAction(application));
    addSubAction(am, new CloseLibraryAction(application));
    addSubAction(am, new SeparatorAction());
    addSubAction(am, new NewDocumentAction(application));
    addSubAction(am, new NewCollectionAction(application));
    addSubAction(am, new NewTagAction(application));
    addSubAction(am, new NewAuthorAction(application));
    addSubAction(am, new NewSourceAction(application));
    addSubAction(am, new OpenURLAction(application));
    addSubAction(am, new SeparatorAction());
    addSubAction(am, new ImportAction(application));
    addSubAction(am, new ExportAction(application));
    addSubAction(am, new SeparatorAction());
    addSubAction(am, new PageSetupAction(application));
    addSubAction(am, new PrintAction(application));
    addSubAction(am, new SeparatorAction());
    addSubAction(am, new QuitAction(application));
  }

}
