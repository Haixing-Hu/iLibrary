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
package com.github.haixing_hu.ilibrary.action.edit.annotation;

import javafx.event.ActionEvent;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseAction;
import com.github.haixing_hu.ilibrary.state.AnnotateMode;

/**
 * The action to switch to the text selection mode.
 *
 * @author Haixing Hu
 */
public class AnnotateSelectionAction extends BaseAction {

  public static final String ID = AnnotateAction.ID + ".selection";

  public static final String BUTTON_CLASS = "button-selection";

  public AnnotateSelectionAction(Application application) {
    super(ID, application, TOGGLE);
    styleClass.add(BUTTON_CLASS);
  }

  @Override
  public void handle(ActionEvent event) {
    application.getExplorerController().setAnnotateMode(AnnotateMode.SELECTION);
  }
}
