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

package com.github.haixing_hu.ilibrary.action.edit.annotate;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseCheckBoxAction;
import com.github.haixing_hu.ilibrary.state.AnnotateMode;
import com.github.haixing_hu.swt.action.IActionManager;

/**
 * The action to switch to the creating note mode.
 *
 * @author Haixing Hu
 */
public class AnnotateNoteAction extends BaseCheckBoxAction {

  public static final String ID = AnnotateAction.ID + ".note";

  public AnnotateNoteAction(Application application, IActionManager actionManager) {
    super(ID, application, actionManager);
  }

  @Override
  public void run() {
    application.setAnnotateMode(AnnotateMode.NOTE);
  }
}
