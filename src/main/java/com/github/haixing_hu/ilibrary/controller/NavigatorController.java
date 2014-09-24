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

package com.github.haixing_hu.ilibrary.controller;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TreeItem;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.ActionManager;
import com.github.haixing_hu.ilibrary.action.view.HideNavigatorAction;
import com.github.haixing_hu.ilibrary.action.view.ShowNavigatorAction;
import com.github.haixing_hu.ilibrary.action.view.ViewAction;
import com.github.haixing_hu.ilibrary.gui.MainWindow;
import com.github.haixing_hu.ilibrary.gui.navigator.NavigatorTreeNode;
import com.github.haixing_hu.ilibrary.state.ApplicationState;
import com.github.haixing_hu.swt.action.DropDownAction;

/**
 * The controller of the navigator panel.
 *
 * @author Haixing Hu
 */
public class NavigatorController  extends BaseController {

  /**
   * Constructs a {@link NavigatorController}.
   *
   * @param application
   *          the application.
   */
  public NavigatorController(Application application) {
    super(application);
  }

  /**
   * Sets the navigator's visibility
   *
   * @param visible
   *          <code>true</code> to set the navigator visible; <code>false</code>
   *          otherwise.
   */
  public void setVisible(boolean visible) {
    logger.info("Sets the visible of navigator to: {}", visible);
    final ActionManager am = application.getActionManager();
    final MainWindow win = application.getMainWindow();
    final DropDownAction viewAction = (DropDownAction) am.get(ViewAction.KEY);
    if (visible) {
      viewAction.showSubAction(HideNavigatorAction.KEY);
      viewAction.hideSubAction(ShowNavigatorAction.KEY);
      viewAction.update(true);
      win.showNavigator();
    } else {
      viewAction.hideSubAction(HideNavigatorAction.KEY);
      viewAction.showSubAction(ShowNavigatorAction.KEY);
      viewAction.update(true);
      win.hideNavigator();
    }
    // set the state
    final ApplicationState state = application.getState();
    state.setNavigatorVisible(visible);
  }

  public void onSelectNode(SelectionEvent event) {
    final TreeItem item = (TreeItem) event.item;
    if (item != null) {
      final NavigatorTreeNode node = (NavigatorTreeNode) item.getData();
      logger.info("Select the navigator node: {}", node.getKey());
      //    TODO
    }
  }

}
