/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.library;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;

/**
 * The action to open the URL of the selected document in the external browser.
 *
 * @author Haixing Hu
 */
public class OpenUrlInBrowserAction extends BaseAction {

  public static final String KEY = LibraryAction.KEY + ".open-url-in-browser";

  public OpenUrlInBrowserAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

}
