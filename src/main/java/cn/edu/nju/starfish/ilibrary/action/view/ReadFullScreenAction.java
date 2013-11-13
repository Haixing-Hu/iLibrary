/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;

/**
 * The action to read the document in the full screen.
 *
 * @author Haixing Hu
 */
public class ReadFullScreenAction extends BaseAction {

  public static final String KEY = ViewAction.KEY + ".read-full-screen";

  public ReadFullScreenAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }
}
