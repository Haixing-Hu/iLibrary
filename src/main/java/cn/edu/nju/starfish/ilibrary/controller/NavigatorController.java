/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.controller;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TreeItem;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.ActionManager;
import cn.edu.nju.starfish.ilibrary.action.view.HideNavigatorAction;
import cn.edu.nju.starfish.ilibrary.action.view.ShowNavigatorAction;
import cn.edu.nju.starfish.ilibrary.action.view.ViewAction;
import cn.edu.nju.starfish.ilibrary.gui.MainWindow;
import cn.edu.nju.starfish.ilibrary.gui.navigator.NavigatorTreeNode;
import cn.edu.nju.starfish.ilibrary.gui.widget.DropDownAction;
import cn.edu.nju.starfish.ilibrary.state.ApplicationState;

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
    final NavigatorTreeNode node = (NavigatorTreeNode) item.getData();
    logger.info("Select the navigator node: {}", node.getKey());
    //  TODO
  }

}
