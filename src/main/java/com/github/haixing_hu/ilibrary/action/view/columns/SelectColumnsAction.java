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
import com.github.haixing_hu.ilibrary.action.BaseActionGroup;
import com.github.haixing_hu.ilibrary.action.view.ViewAction;
import com.github.haixing_hu.ilibrary.model.FieldType;
import com.github.haixing_hu.javafx.action.ActionManager;
import com.github.haixing_hu.javafx.action.IAction;

/**
 * The action for selecting displayed columns.
 *
 * @author Haixing Hu
 */
public class SelectColumnsAction extends BaseActionGroup {

  public static final String ID = ViewAction.ID + ".columns";

  public SelectColumnsAction(Application application) {
    super(ID, application);
    final ActionManager am = application.getActionManager();
    for (final FieldType col : FieldType.values()) {
      final IAction action = new SelectColumnForAction(col, application);
      addSubAction(am, action);
    }
  }
}
