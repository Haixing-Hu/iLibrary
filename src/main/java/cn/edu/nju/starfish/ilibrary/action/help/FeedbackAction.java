/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.help;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to send a feedback to the author.
 *
 * @author Haixing Hu
 */
public class FeedbackAction extends BaseAction {
  public static final String KEY = "action.help.feedback";

  public FeedbackAction(Application application) {
    super(application, KEY);
  }
}
