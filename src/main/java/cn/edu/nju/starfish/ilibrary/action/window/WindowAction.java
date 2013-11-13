/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.window;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseDropDownAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;

/**
 * The action to show the drop down menu of window related actions.
 *
 * @author Haixing Hu
 */
public class WindowAction extends BaseDropDownAction {

  public static final String KEY = "action.window";

  private static final String SUB_ACTIONS[] = {
    MinimizeAction.KEY,
    MinimizeAllAction.KEY,
    MaximizeAction.KEY,
    SEPARATOR_KEY,
    ShowLibraryTabAction.KEY,
    ShowInfoTabAction.KEY,
    ShowNotesTabAction.KEY,
    ShowReviewsTabAction.KEY,
    ShowFilesTabAction.KEY,
    SEPARATOR_KEY,
    CycleTabsAction.KEY,
    PreviousTabAction.KEY,
    NextTabAction.KEY,
    SEPARATOR_KEY,
    CloseTabAction.KEY,
    CloseAllTabsAction.KEY,
  };

  public WindowAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager, SUB_ACTIONS);
  }
}
