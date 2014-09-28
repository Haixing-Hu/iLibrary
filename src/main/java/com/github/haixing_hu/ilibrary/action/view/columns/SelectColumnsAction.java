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

package com.github.haixing_hu.ilibrary.action.view.columns;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.ExplorerToolBarBalloonWindowAction;
import com.github.haixing_hu.ilibrary.action.view.ViewAction;
import com.github.haixing_hu.ilibrary.gui.explorer.SelectColumnsWindow;
import com.github.haixing_hu.swt.action.IActionManager;
import com.github.haixing_hu.swt.window.BalloonWindow;

/**
 * The action for selecting displayed columns.
 *
 * @author Haixing Hu
 */
public class SelectColumnsAction extends ExplorerToolBarBalloonWindowAction {

  public static final String ID = ViewAction.ID + ".columns";

  public SelectColumnsAction(Application application,
      IActionManager actionManager) {
    super(ID, application, actionManager);
  }

  @Override
  protected BalloonWindow createBalloonWindow() {
    return new SelectColumnsWindow(application);
  }
}
