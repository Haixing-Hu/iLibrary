/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;
import cn.edu.nju.starfish.ilibrary.state.ApplicationState;
import cn.edu.nju.starfish.ilibrary.state.ViewMode;

/**
 * The action to show the inspector panel.
 *
 * @author Haixing Hu
 */
public class ShowInspectorAction extends BaseAction {

  public static final String KEY = ViewAction.KEY + ".show-inspector";

  public ShowInspectorAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

  @Override
  public void run() {
    logger.info("Show the inspector.");
    final ApplicationState state = application.getState();
    int mode = state.getViewMode();
    mode |= ViewMode.INSPECTOR;
    ViewMode.update(application, mode);
  }
}
