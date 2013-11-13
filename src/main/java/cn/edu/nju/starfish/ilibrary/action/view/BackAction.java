/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;

/**
 * The action to go back in the visiting history.
 *
 * @author Haixing Hu
 */
public class BackAction extends BaseAction {

  public static final String KEY = ViewAction.KEY + ".back";

  public BackAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }
}
