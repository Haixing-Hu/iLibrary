/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.window;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to close all tabs.
 *
 * @author Haixing Hu
 */
public class CloseAllTabsAction extends BaseAction {

  public CloseAllTabsAction(Application application) {
    super(application);
  }

  @Override
  public String getKey() {
    return "action.window.close-all-tabs";
  }

}
