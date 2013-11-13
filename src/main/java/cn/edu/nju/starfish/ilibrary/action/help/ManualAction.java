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
 * The action to display the manual of the application.
 *
 * @author Haixing Hu
 */
public class ManualAction extends BaseAction {

  public static final String KEY = HelpAction.KEY + ".manual";

  public ManualAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

}
