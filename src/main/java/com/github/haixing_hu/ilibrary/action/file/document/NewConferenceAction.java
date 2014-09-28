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
import com.github.haixing_hu.ilibrary.action.BaseAction;
import com.github.haixing_hu.swt.action.IActionManager;

/**
 * The action to create a new conference.
 *
 * @author Haixing Hu
 */
public class NewConferenceAction extends BaseAction {

  public static final String ID = NewAction.ID + ".conference";

  public NewConferenceAction(Application application, IActionManager actionManager) {
    super(ID, application, actionManager);
    this.setShowDialog(true);
  }

  @Override
  public void run() {
    application.newConference();
  }
}
