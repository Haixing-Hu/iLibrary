/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseCheckBoxAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;
import cn.edu.nju.starfish.ilibrary.state.ViewMode;

/**
 * The action to hide both the inspector panel and preview panel.
 *
 * @author Haixing Hu
 */
public class ViewModeNoneAction extends BaseCheckBoxAction {

  public static final String KEY = ViewModeAction.KEY + ".none";

  public ViewModeNoneAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

  @Override
  public void run() {
    logger.info("Set the view mode to NONE");
    ViewMode.update(application, ViewMode.NONE);
  }
}
