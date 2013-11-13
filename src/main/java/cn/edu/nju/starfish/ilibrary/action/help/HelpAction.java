/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.help;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseDropDownAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;

/**
 * The action to show the drop down menu of helping related actions.
 *
 * @author Haixing Hu
 */
public class HelpAction extends BaseDropDownAction {

  public static final String KEY = "action.help";

  private static final String SUB_ACTIONS[] = {
    ManualAction.KEY,
    FaqAction.KEY,
    WebsiteAction.KEY,
    FeedbackAction.KEY,
    SEPARATOR_KEY,
    AboutAction.KEY,
  };

  public HelpAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager, SUB_ACTIONS);
  }

}
