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

package com.github.haixing_hu.ilibrary.action.file.collection;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseActionGroup;
import com.github.haixing_hu.ilibrary.action.file.FileAction;
import com.github.haixing_hu.javafx.action.ActionManager;

/**
 * The action to create a new collection.
 *
 * @author Haixing Hu
 */
public class NewCollectionAction extends BaseActionGroup {

  public static final String ID = FileAction.ID + ".new-collection";

  public static final String BUTTON_CLASS = "button-new-collection";

  public NewCollectionAction(Application application) {
    super(ID, application);
    styleClass.add(BUTTON_CLASS);
    final ActionManager am = application.getActionManager();
    addSubAction(am, new NewNormalCollectionAction(application));
    addSubAction(am, new NewSmartCollectionAction(application));
    addSubAction(am, new NewCollectionFromSelectionAction(application));
  }
}
