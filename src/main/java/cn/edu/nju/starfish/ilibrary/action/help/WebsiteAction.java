/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.help;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to visit the website of the application.
 *
 * @author Haixing Hu
 */
public class WebsiteAction extends BaseAction {

  public WebsiteAction(Application application) {
    super(application);
  }

  @Override
  public String getKey() {
    return "action.help.website";
  }

}
