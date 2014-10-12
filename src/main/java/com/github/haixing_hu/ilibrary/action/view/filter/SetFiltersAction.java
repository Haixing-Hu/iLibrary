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
import javafx.scene.control.ButtonBase;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseAction;
import com.github.haixing_hu.ilibrary.action.view.ViewAction;
import com.github.haixing_hu.ilibrary.gui.ContentPanel;
import com.github.haixing_hu.ilibrary.gui.MainContent;
import com.github.haixing_hu.ilibrary.gui.document.SetFiltersPopOver;

/**
 * The action to filter documents
 *
 * @author Haixing Hu
 */
public class SetFiltersAction extends BaseAction {

  public static final String ID = ViewAction.ID + ".set-filters";

  public static final String BUTTON_CLASS = "button-set-filters";

  public SetFiltersAction(Application application) {
    super(ID, application, TOGGLE);
    styleClass.add(BUTTON_CLASS);
  }

  @Override
  public void handle(ActionEvent event) {
    final MainContent mainContent = application.findNodeById(MainContent.ID);
    final ContentPanel content = mainContent.getCurrentContent();
    final ButtonBase button = content.findNodeByClass(BUTTON_CLASS);
    if (button != null) {
      final SetFiltersPopOver win = new SetFiltersPopOver(application);
      win.show(button);
    }
  }
}
