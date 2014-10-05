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

package com.github.haixing_hu.ilibrary.action.view.browse;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseActionGroup;
import com.github.haixing_hu.ilibrary.action.view.ViewAction;
import com.github.haixing_hu.javafx.action.ActionManager;

/**
 * The action of switching the browser mode.
 *
 * @author Haixing Hu
 */
public class BrowseModeAction extends BaseActionGroup {

  public static final String ID = ViewAction.ID + ".browse-mode";

  public static final String BUTTON_CLASS = "button-browse-mode";

  public BrowseModeAction(Application application) {
    super(ID, application);
    styleClass.add(BUTTON_CLASS);
   // setBindStyleClass(true);
    final ActionManager am = application.getActionManager();
//    addSubAction(am, new BrowseAsListAction(application));
//    addSubAction(am, new BrowseAsColumnsAction(application));
//    addSubAction(am, new BrowseAsIconsAction(application));
//    addSubAction(am, new BrowseAsCoverFlowAction(application));
    add(am.get(BrowseAsListAction.ID));
    add(am.get(BrowseAsColumnsAction.ID));
    add(am.get(BrowseAsIconsAction.ID));
    add(am.get(BrowseAsCoverFlowAction.ID));
  }

}
