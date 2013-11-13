/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.ActionManager;
import cn.edu.nju.starfish.ilibrary.action.view.HideNavigatorAction;
import cn.edu.nju.starfish.ilibrary.action.view.ShowNavigatorAction;
import cn.edu.nju.starfish.ilibrary.action.view.ViewAction;
import cn.edu.nju.starfish.ilibrary.gui.MainWindow;
import cn.edu.nju.starfish.ilibrary.gui.widget.DropDownAction;


/**
 * The enumeration of visibility of the navigator panel.
 *
 * @author Haixing Hu
 */
public enum NavigatorVisibility {

  /**
   * Indicates the navigator panel is visible.
   */
  VISIBLE,

  /**
   * Indicates the navigator panel is invisible.
   */
  INVISIBLE;


  private static final Logger LOGGER = LoggerFactory.getLogger(NavigatorVisibility.class);

  /**
   * Updates the navigator visibility
   *
   * @param application
   *          the application.
   * @param visibility
   *          the new visibility.
   */
  public static void update(Application application,
      NavigatorVisibility visibility) {
    final ActionManager am = application.getActionManager();
    final MainWindow win = application.getMainWindow();
    final DropDownAction viewAction = (DropDownAction) am.get(ViewAction.KEY);
    switch (visibility) {
    case VISIBLE:
      viewAction.showSubAction(HideNavigatorAction.KEY);
      viewAction.hideSubAction(ShowNavigatorAction.KEY);
      viewAction.update(true);
      win.showNavigator();
      break;
    case INVISIBLE:
      viewAction.hideSubAction(HideNavigatorAction.KEY);
      viewAction.showSubAction(ShowNavigatorAction.KEY);
      viewAction.update(true);
      win.hideNavigator();
      break;
    default:
      LOGGER.error("Unknown navigator visibility: ", visibility);
      return;
    }
    // set the state
    final ApplicationState state = application.getState();
    state.setNavigatorVisibility(visibility);
  }
}
