/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseDropDownAction;

/**
 * The action to switch the view modes.
 *
 * @author Haixing Hu
 */
public class ViewModeAction extends BaseDropDownAction {

  public static final String KEY = "action.view.view-mode";

  private static final String[] SUB_ACTIONS = {
      ViewModeAllAction.KEY,
      ViewModeInspectorAction.KEY,
      ViewModePreviewAction.KEY,
      ViewModeNoneAction.KEY,
  };

  public ViewModeAction(Application application) {
    super(application, KEY, SUB_ACTIONS);
  }

}
