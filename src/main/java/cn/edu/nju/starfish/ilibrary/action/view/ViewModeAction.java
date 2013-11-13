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
 * The action to switch the view modes.
 *
 * @author Haixing Hu
 */
public class ViewModeAction extends BaseDropDownAction {

  public static final String KEY = ViewAction.KEY + ".view-mode";

  private static final String[] SUB_ACTIONS = {
      ViewModeAllAction.KEY,
      ViewModeInspectorAction.KEY,
      ViewModePreviewAction.KEY,
      ViewModeNoneAction.KEY,
  };

  public ViewModeAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager, SUB_ACTIONS);
  }

}
