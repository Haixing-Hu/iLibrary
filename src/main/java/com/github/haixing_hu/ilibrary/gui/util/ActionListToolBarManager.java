/******************************************************************************
 *
 * Copyright (c) 2013  Haixing Hu
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

package com.github.haixing_hu.ilibrary.gui.util;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.ActionManager;

/**
 * A tool bar manager which holds actions in an action ID list.
 *
 * @author Haixing Hu
 */
public class ActionListToolBarManager extends ToolBarManager {

  /**
   * Constructs an {@link ActionListToolBarManager}.
   *
   * @param application
   *          the application.
   * @param actionKeys
   *          the array of keys of actions to be hold in the new tool bar
   *          manager.
   */
  public ActionListToolBarManager(Application application, String[] actionKeys) {
    super(SWT.FLAT | SWT.NO_FOCUS);
    final ActionManager am = application.getActionManager();
    for (final String key : actionKeys) {
      if (key.equals(Separator.class.getName())) {
        this.add(new Separator());
      } else {
        final IAction action = am.get(key);
        this.add(action);
      }
    }
  }
}
