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
 * The action to goto the specified page in the document.
 *
 * @author Haixing Hu
 */
public class GotoPageAction extends BaseAction {

  public static final String KEY = ViewAction.KEY + ".goto-page";

  public GotoPageAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

}
