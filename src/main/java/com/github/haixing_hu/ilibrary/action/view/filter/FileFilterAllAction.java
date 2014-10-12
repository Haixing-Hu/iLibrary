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

import javafx.event.ActionEvent;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseAction;

/**
 * The action to filter documents with attachment status.
 *
 * @author Haixing Hu
 */
public class FileFilterAllAction extends BaseAction {

  public static final String ID = FileFilterAction.ID + ".all";

  public FileFilterAllAction(Application application) {
    super(ID, application, CHECKBOX_SHOW_TEXT);
  }

  @Override
  public void handle(ActionEvent event) {
    application.getExplorerController().clearFileStatusFilters();
  }
}
