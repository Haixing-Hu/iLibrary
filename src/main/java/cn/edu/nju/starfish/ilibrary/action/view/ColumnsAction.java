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
 * The action to select the columns to display in the grid table.
 *
 * @author Haixing Hu
 */
public class ColumnsAction extends BaseAction {

  public static final String KEY = ViewAction.KEY + ".columns";

  public ColumnsAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

}
