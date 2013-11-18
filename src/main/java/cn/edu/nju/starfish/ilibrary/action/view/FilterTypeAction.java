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
 * The action to filter documents by their types.
 *
 * @author Haixing Hu
 */
public class FilterTypeAction extends BaseDropDownAction {

  public static final String KEY = ViewAction.KEY + ".filter.type";

  private static final String SUB_ACTIONS[] = {
    FilterTypeAllAction.KEY,
    FilterTypeArticleAction.KEY,
    FilterTypeBookAction.KEY,
    FilterTypeReportAction.KEY,
    FilterTypePatentAction.KEY,
    FilterTypeMediaAction.KEY,
  };

  public FilterTypeAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager, SUB_ACTIONS);
  }
}
