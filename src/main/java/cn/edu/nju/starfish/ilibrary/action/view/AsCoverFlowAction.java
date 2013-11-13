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
 * The action to view as cover flow.
 *
 * @author Haixing Hu
 */
public class AsCoverFlowAction extends BaseAction {

  public static final String KEY = ViewAction.KEY + ".as-cover-flow";

  public AsCoverFlowAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

}
