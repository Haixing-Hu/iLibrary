/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.edit;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;

/**
 * The action to redo the last operation.
 *
 * @author Haixing Hu
 */
public class RedoAction extends BaseAction {
  public static final String KEY = EditAction.KEY + ".redo";

  public RedoAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

}
