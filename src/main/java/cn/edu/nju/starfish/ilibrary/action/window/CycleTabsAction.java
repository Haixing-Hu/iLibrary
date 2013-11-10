/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.window;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to cycle between tabs.
 *
 * @author Haixing Hu
 */
public class CycleTabsAction extends BaseAction {

  public static final String KEY = "action.window.cycle-tabs";

  public CycleTabsAction(Application application) {
    super(application, KEY);
  }
}
