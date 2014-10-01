/*
 * Copyright (C) 2014 Haixing Hu
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.github.haixing_hu.ilibrary.action2.view;

import javafx.event.ActionEvent;

import com.github.haixing_hu.ilibrary.Application2;
import com.github.haixing_hu.ilibrary.action2.BaseAction;
import com.github.haixing_hu.ilibrary.control.LayoutController;
import com.github.haixing_hu.javafx.action.ActionOption;

/**
 * The action to hide the navigator panel.
 *
 * @author Haixing Hu
 */
public class HideNavigatorAction extends BaseAction {

  public static final String ID = ViewAction.ID + ".hide-navigator";

  public HideNavigatorAction(Application2 application) {
    super(ID, application, ActionOption.DEFAULT | ActionOption.HIDE_MENU_ITEM_GRAPHIC);
  }

  @Override
  public void handle(ActionEvent event) {
    final LayoutController controller = application.getLayoutController();
    controller.setNavigatorVisible(false);
  }

}
