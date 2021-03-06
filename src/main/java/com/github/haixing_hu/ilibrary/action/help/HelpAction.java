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
package com.github.haixing_hu.ilibrary.action.help;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseActionGroup;
import com.github.haixing_hu.javafx.action.ActionManager;
import com.github.haixing_hu.javafx.action.SeparatorAction;

/**
 * The action to show the drop down menu of helping related actions.
 *
 * @author Haixing Hu
 */
public class HelpAction extends BaseActionGroup {

  public static final String ID = "action.help";

  public HelpAction(Application application) {
    super(ID, application);
    final ActionManager am = application.getActionManager();
    addSubAction(am, new ManualAction(application));
    addSubAction(am, new FaqAction(application));
    addSubAction(am, new WebsiteAction(application));
    addSubAction(am, new FeedbackAction(application));
    addSubAction(am, new SeparatorAction());
    addSubAction(am, new AboutAction(application));
  }

}
