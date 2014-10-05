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

package com.github.haixing_hu.ilibrary.action.file.source;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseActionGroup;
import com.github.haixing_hu.ilibrary.action.file.FileAction;
import com.github.haixing_hu.javafx.action.ActionManager;

/**
 * The action to create a new document.
 *
 * @author Haixing Hu
 */
public class NewSourceAction extends BaseActionGroup {

  public static final String ID = FileAction.ID + ".new-source";

  public static final String BUTTON_ID = "button-new-source";

  public NewSourceAction(Application application) {
    super(ID, application);
    styleClass.add(BUTTON_ID);
    final ActionManager am = application.getActionManager();
    addSubAction(am, new NewPeriodicalAction(application));
    addSubAction(am, new NewConferenceAction(application));
    addSubAction(am, new NewInstituteAction(application));
    addSubAction(am, new NewPublisherAction(application));
    addSubAction(am, new NewWebSiteAction(application));
  }
}
