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
 * The action to maximize the current window.
 *
 * @author Haixing Hu
 */
public class MaximizeAction extends BaseAction {

  public static final String KEY = WindowAction.KEY + ".maximize";

  public MaximizeAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

}
