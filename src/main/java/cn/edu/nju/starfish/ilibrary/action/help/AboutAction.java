/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.help;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to display the about dialog.
 *
 * @author Haixing Hu
 */
public class AboutAction extends BaseAction {

  public static final String KEY = "action.help.about";

  public AboutAction(Application application) {
    super(application, KEY);
  }
}
