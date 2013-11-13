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
 * The action to find the specified text or the specified document.
 *
 * @author Haixing Hu
 */
public class FindAction extends BaseAction {
  public static final String KEY = EditAction.KEY + ".find";

  public FindAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

}
