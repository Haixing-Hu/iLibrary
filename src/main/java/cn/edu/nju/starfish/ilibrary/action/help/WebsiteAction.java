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
 * The action to visit the website of the application.
 *
 * @author Haixing Hu
 */
public class WebsiteAction extends BaseAction {

  public static final String KEY = HelpAction.KEY + ".website";

  public WebsiteAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }
}
