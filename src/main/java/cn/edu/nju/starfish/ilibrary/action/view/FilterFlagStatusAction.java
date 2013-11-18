/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseDropDownAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;

/**
 * The action to filter documents by their flag status.
 *
 * @author Haixing Hu
 */
public class FilterFlagStatusAction extends BaseDropDownAction {

  public static final String KEY = ViewAction.KEY + ".filter.flag";

  private static final String SUB_ACTIONS[] = {
    FilterFlagStatusAllAction.KEY,
    FilterFlagStatusFlaggedAction.KEY,
    FilterFlagStatusUnflaggedAction.KEY,
  };

  public FilterFlagStatusAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager, SUB_ACTIONS);
  }
}
