/******************************************************************************
 *
 * Copyright (c) 2014  Haixing Hu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy oimport com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseAction;
 License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package com.github.haixing_hu.ilibrary.action.library.mark;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseAction;
import com.github.haixing_hu.ilibrary.action.library.LibraryAction;

/**
 * The action to mark the selected documents as unflagged.
 *
 * @author Haixing Hu
 */
public class MarkUnflaggedAction extends BaseAction {

  public static final String ID = LibraryAction.ID + ".mark-unflagged";

  public static final String BUTTON_CLASS = "button-mark-unflagged";

  public MarkUnflaggedAction(Application application) {
    super(ID, application);
    styleClass.add(BUTTON_CLASS);
  }
}
