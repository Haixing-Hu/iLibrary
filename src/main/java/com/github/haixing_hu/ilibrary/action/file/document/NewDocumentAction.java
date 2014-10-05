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

/**
 * The action to create a new document.
 *
 * @author Haixing Hu
 */
public class NewDocumentAction extends BaseActionGroup {

  public static final String ID = FileAction.ID + ".new-document";

  public static final String BUTTON_ID = "button-new-document";

  public NewDocumentAction(Application application) {
    super(ID, application);
    styleClass.add(BUTTON_ID);
    final ActionManager am = application.getActionManager();
    for (final DocumentType type : DocumentType.values()) {
      final IAction action = new NewDocumentForTypeAction(type, application);
      addSubAction(am, action);
    }
  }
}
