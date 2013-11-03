/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.window;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to switch to the next tab.
 *
 * @author Haixing Hu
 */
public class NextTabAction extends BaseAction {

  public NextTabAction(Application application) {
    super(application);
  }

  @Override
  public String getKey() {
    return "action.window.next-tab";
  }

}
