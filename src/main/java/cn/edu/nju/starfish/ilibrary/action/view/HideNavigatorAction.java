/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;
import cn.edu.nju.starfish.ilibrary.state.NavigatorVisibility;

/**
 * The action to hide the navigator panel.
 *
 * @author Haixing Hu
 */
public class HideNavigatorAction extends BaseAction {

  public static final String KEY = ViewAction.KEY + ".hide-navigator";

  public HideNavigatorAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

  @Override
  public void run() {
    logger.info("Hide the navigator.");
    NavigatorVisibility.update(application, NavigatorVisibility.INVISIBLE);
  }
}
