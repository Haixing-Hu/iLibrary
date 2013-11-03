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

  public AboutAction(Application application) {
    super(application);
  }

  @Override
  public String getKey() {
    return "action.help.about";
  }

}
