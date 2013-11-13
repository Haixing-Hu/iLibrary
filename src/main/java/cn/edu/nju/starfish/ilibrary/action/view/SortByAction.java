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
 * The action to set the sorting order of the documents.
 *
 * @author Haixing Hu
 */
public class SortByAction extends BaseAction {

  public static final String KEY = ViewAction.KEY + ".sort-by";

  public SortByAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }
}
