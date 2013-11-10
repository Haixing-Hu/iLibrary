/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to select the columns to display in the grid table.
 *
 * @author Haixing Hu
 */
public class ColumnsAction extends BaseAction {

  public static final String KEY = "action.view.columns";

  public ColumnsAction(Application application) {
    super(application, KEY);
  }

}
