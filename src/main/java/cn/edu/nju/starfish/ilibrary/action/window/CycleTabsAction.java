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
 * The action to cycle between tabs.
 *
 * @author Haixing Hu
 */
public class CycleTabsAction extends BaseAction {

  public static final String KEY = WindowAction.KEY + ".cycle-tabs";

  public CycleTabsAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }
}
