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
public class TypeFilterAction extends BaseDropDownAction {

  public static final String KEY = "action.view.filter.type";

  private static final String SUB_ACTIONS[] = {
    TypeFilterAllAction.KEY,
    TypeFilterArticleAction.KEY,
    TypeFilterBookAction.KEY,
    TypeFilterReportAction.KEY,
    TypeFilterPatentAction.KEY,
    TypeFilterMediaAction.KEY,
  };

  public TypeFilterAction(Application application) {
    super(application, KEY, SUB_ACTIONS);
  }
}
