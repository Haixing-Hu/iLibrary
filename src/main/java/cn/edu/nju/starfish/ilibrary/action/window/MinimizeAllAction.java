/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.window;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to minimize all the windows.
 *
 * @author Haixing Hu
 */
public class MinimizeAllAction extends BaseAction {

  public static final String KEY = "action.window.minimize-all";

  public MinimizeAllAction(Application application) {
    super(application, KEY);
  }
}
