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

package com.github.haixing_hu.ilibrary.action.file;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseDropDownAction;
import com.github.haixing_hu.ilibrary.gui.widget.IActionManager;

/**
 * The action to create a new item.
 *
 * @author Haixing Hu
 */
public class NewAction extends BaseDropDownAction {

  public static final String KEY = FileAction.KEY + ".new";

  private static final String SUB_ACTIONS[] = {
    NewArticleDocumentAction.KEY,
    NewBookDocumentAction.KEY,
    NewReferenceDocumentAction.KEY,
    NewLawDocumentAction.KEY,
    NewMediaDocumentAction.KEY,
    SEPARATOR_KEY,
    NewAuthorAction.KEY,
    NewPeriodicalAction.KEY,
    NewConferenceAction.KEY,
    NewInstituteAction.KEY,
    NewWebsiteAction.KEY,
  };

  public NewAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager, SUB_ACTIONS);
  }

}
