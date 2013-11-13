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
 * The action to view the document in the actual size.
 *
 * @author Haixing Hu
 */
public class ActualSizeAction extends BaseAction {

  public static final String KEY = ViewAction.KEY + ".actual-size";

  public ActualSizeAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

}
