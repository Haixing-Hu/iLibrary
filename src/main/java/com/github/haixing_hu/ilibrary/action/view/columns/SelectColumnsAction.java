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

import javafx.event.ActionEvent;
import javafx.scene.control.ButtonBase;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseAction;
import com.github.haixing_hu.ilibrary.action.view.ViewAction;
import com.github.haixing_hu.ilibrary.gui.ContentPanel;
import com.github.haixing_hu.ilibrary.gui.MainContent;
import com.github.haixing_hu.ilibrary.gui.document.SelectColumnsPopOver;

/**
 * The action for selecting displayed columns.
 *
 * @author Haixing Hu
 */
public class SelectColumnsAction extends BaseAction {

  public static final String ID = ViewAction.ID + ".select-columns";

  public static final String BUTTON_CLASS = "button-select-columns";

  public SelectColumnsAction(Application application) {
    super(ID, application, DIALOG);
    styleClass.add(BUTTON_CLASS);
  }

  @Override
  public void handle(ActionEvent event) {
    final MainContent mainContent = application.findNodeById(MainContent.ID);
    final ContentPanel content = mainContent.getCurrentContent();
    final ButtonBase button = content.findNodeByClass(BUTTON_CLASS);
    if (button != null) {
      final SelectColumnsPopOver win = new SelectColumnsPopOver(application);
      win.show(button);
    }
  }
}
