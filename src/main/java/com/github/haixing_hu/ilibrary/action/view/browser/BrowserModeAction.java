/******************************************************************************
 *
 * Copyright (c) 2014  Haixing Hu
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Haixing Hu (https://github.com/Haixing-Hu/) - Initial implementation and API.
 *
 ******************************************************************************/

package com.github.haixing_hu.ilibrary.action.view.browser;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseDropDownAction;
import com.github.haixing_hu.ilibrary.action.view.ViewAction;
import com.github.haixing_hu.swt.action.IActionManager;

/**
 * The action of switching the browser mode.
 *
 * @author Haixing Hu
 */
public class BrowserModeAction extends BaseDropDownAction {

  public static final String ID = ViewAction.ID + ".browser-mode";

  private static final String[] SUB_ACTIONS = {
      AsListAction.ID,
      AsColumnsAction.ID,
      AsIconsAction.ID,
      AsCoverFlowAction.ID,
  };

  public BrowserModeAction(Application application, IActionManager actionManager) {
    super(ID, application, actionManager, SUB_ACTIONS);
  }

}
