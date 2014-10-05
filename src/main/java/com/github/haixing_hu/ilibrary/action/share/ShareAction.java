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

package com.github.haixing_hu.ilibrary.action.share;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseActionGroup;
import com.github.haixing_hu.ilibrary.action.file.ExportAction;
import com.github.haixing_hu.javafx.action.ActionManager;
import com.github.haixing_hu.javafx.action.SeparatorAction;

/**
 * The action to show the drop down menu of sharing related actions.
 *
 * @author Haixing Hu
 */
public class ShareAction extends BaseActionGroup {

  public static final String ID = "action.share";

  public static final String BUTTON_CLASS = "button-share";

  public ShareAction(Application application) {
    super(ID, application);
    styleClass.add(BUTTON_CLASS);
    final ActionManager am = application.getActionManager();
    addSubAction(am, new TwitterAction(application));
    addSubAction(am, new FacebookAction(application));
    addSubAction(am, new GooglePlusAction(application));
    addSubAction(am, new SinaAction(application));
    addSubAction(am, new TencentAction(application));
    addSubAction(am, new SeparatorAction());
    addSubAction(am, new EmailAction(application));
    addSubAction(am, new SeparatorAction());
    add(am.get(ExportAction.ID));
  }

}
