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

  public CycleTabsAction(Application application) {
    super(application);
  }

  @Override
  public String getKey() {
    return "action.window.cycle-tabs";
  }

}
