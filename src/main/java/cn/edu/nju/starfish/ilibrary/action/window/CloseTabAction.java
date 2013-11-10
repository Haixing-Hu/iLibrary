/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.window;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to close the current tab.
 *
 * @author Haixing Hu
 */
public class CloseTabAction extends BaseAction {

  public static final String KEY = "action.window.close-tab";

  public CloseTabAction(Application application) {
    super(application, KEY);
  }

}
