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

package com.github.haixing_hu.ilibrary.action;


import org.eclipse.jface.action.IAction;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.swt.action.IActionManager;

/**
 * The base class for check box actions.
 *
 * @author Haixing Hu
 */
public class BaseCheckBoxAction extends BaseAction {

  /**
   * Constructs an action.
   *
   * @param id
   *          the ID of the new action.
   * @param application
   *          the application the new action belongs to.
   * @param actionManager
   *          the action manager, which is a map from the action's ID to the action.
   */
  public BaseCheckBoxAction(String id, Application application,
      IActionManager actionManager) {
    super(id, application, actionManager, IAction.AS_CHECK_BOX);
  }

}
