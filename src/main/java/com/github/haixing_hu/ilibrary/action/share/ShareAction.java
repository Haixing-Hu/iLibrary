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
import com.github.haixing_hu.ilibrary.action.BaseDropDownAction;
import com.github.haixing_hu.ilibrary.action.file.ExportAction;
import com.github.haixing_hu.swt.action.IActionManager;
import com.github.haixing_hu.swt.toolbar.Separator;

/**
 * The action to show the drop down menu of sharing related actions.
 *
 * @author Haixing Hu
 */
public class ShareAction extends BaseDropDownAction {

  public static final String ID = "action.share";

  private static final String SUB_ACTIONS[] = {
    TwitterAction.ID,
    FacebookAction.ID,
    GooglePlusAction.ID,
    SinaAction.ID,
    TencentAction.ID,
    Separator.ID,
    EmailAction.ID,
    Separator.ID,
    ExportAction.ID,
  };

  public ShareAction(Application application, IActionManager actionManager) {
    super(ID, application, actionManager, SUB_ACTIONS);
  }

}
