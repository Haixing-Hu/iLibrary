/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseCheckBoxAction;
import cn.edu.nju.starfish.ilibrary.controller.MainPanelController;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;
import cn.edu.nju.starfish.ilibrary.state.ViewMode;

/**
 * The action to show both inspector panel and preview panel.
 *
 * @author Haixing Hu
 */
public class ViewModeAllAction extends BaseCheckBoxAction {

  public static final String KEY = ViewModeAction.KEY + ".all";

  public ViewModeAllAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

  @Override
  public void run() {
    final MainPanelController controller = application.getMainPanelController();
    controller.setViewMode(ViewMode.ALL);
  }
}
