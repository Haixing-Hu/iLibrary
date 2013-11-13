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
 * The action to minimize all the windows.
 *
 * @author Haixing Hu
 */
public class MinimizeAllAction extends BaseAction {

  public static final String KEY = WindowAction.KEY + ".minimize-all";

  public MinimizeAllAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }
}
