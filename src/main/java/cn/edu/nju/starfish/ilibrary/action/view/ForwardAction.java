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
 * The action to go forward in the visiting history.
 *
 * @author Haixing Hu
 */
public class ForwardAction extends BaseAction {

  public static final String KEY = ViewAction.KEY + ".forward";

  public ForwardAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }
}
