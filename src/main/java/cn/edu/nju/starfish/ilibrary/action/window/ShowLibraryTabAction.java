/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.window;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;

/**
 * The action to switch to the library tab.
 *
 * @author Haixing Hu
 */
public class ShowLibraryTabAction extends BaseAction {

  public static final String KEY = WindowAction.KEY + ".library";

  public ShowLibraryTabAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }
}
