/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.help;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;

/**
 * The action to send a feedback to the author.
 *
 * @author Haixing Hu
 */
public class FeedbackAction extends BaseAction {

  public static final String KEY = HelpAction.KEY + ".feedback";

  public FeedbackAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }
}
