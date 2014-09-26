/******************************************************************************
 *
 * Copyright (c) 2014  Haixing Hu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy oimport com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseAction;
import com.github.haixing_hu.swt.action.IActionManager;
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
import com.github.haixing_hu.swt.action.IActionManager;

/**
 * The action to mark the selected documents as unflagged.
 *
 * @author Haixing Hu
 */
public class MarkUnflaggedAction extends BaseAction {

  public static final String KEY = LibraryAction.KEY + ".mark-unflagged";

  public MarkUnflaggedAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }
}
