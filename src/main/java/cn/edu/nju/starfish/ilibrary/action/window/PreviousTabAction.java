/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.window;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to switch to the previous tab.
 *
 * @author Haixing Hu
 */
public class PreviousTabAction extends BaseAction {

  public static final String KEY = "action.window.previous-tab";

  public PreviousTabAction(Application application) {
    super(application, KEY);
  }
}
