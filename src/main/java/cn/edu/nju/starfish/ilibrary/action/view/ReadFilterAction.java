/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseDropDownAction;

/**
 * The action to filter documents by their read status.
 *
 * @author Haixing Hu
 */
public class ReadFilterAction extends BaseDropDownAction {

  public static final String KEY = "action.view.filter.read";

  private static final String SUB_ACTIONS[] = {
    ReadFilterAllAction.KEY,
    ReadFilterUnreadAction.KEY,
    ReadFilterReadingAction.KEY,
    ReadFilterHasReadAction.KEY,
  };

  public ReadFilterAction(Application application) {
    super(application, KEY, SUB_ACTIONS);
  }
}
