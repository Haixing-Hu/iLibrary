/*
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
 */
package com.github.haixing_hu.ilibrary.action.view.filter;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseActionGroup;
import com.github.haixing_hu.javafx.action.ActionManager;

/**
 * The action to filter documents by their file status.
 *
 * @author Haixing Hu
 */
public class FileFilterAction extends BaseActionGroup {

  public static final String ID = FilterAction.ID + ".file";

  public FileFilterAction(Application application) {
    super(ID, application);
    final ActionManager am = application.getActionManager();
    addSubAction(am, new FileFilterAllAction(application));
    addSubAction(am, new FileFilterHasFileAction(application));
    addSubAction(am, new FileFilterNoFileAction(application));
  }
}
