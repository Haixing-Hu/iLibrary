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
import com.github.haixing_hu.ilibrary.action.BaseActionGroup;
import com.github.haixing_hu.ilibrary.action.view.ViewAction;
import com.github.haixing_hu.javafx.action.ActionManager;

/**
 * The action of switching the browser mode.
 *
 * @author Haixing Hu
 */
public class BrowserModeAction extends BaseActionGroup {

  public static final String ID = ViewAction.ID + ".browser-mode";

  public BrowserModeAction(Application application) {
    super(ID, application);
    final ActionManager am = application.getActionManager();
    addSubAction(am, new AsListAction(application));
    addSubAction(am, new AsColumnsAction(application));
    addSubAction(am, new AsIconsAction(application));
    addSubAction(am, new AsCoverFlowAction(application));
  }

}
