/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;
import cn.edu.nju.starfish.ilibrary.controller.MainPanelController;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;
import cn.edu.nju.starfish.ilibrary.state.ApplicationState;
import cn.edu.nju.starfish.ilibrary.state.ViewMode;

/**
 * The action to show the preview panel.
 *
 * @author Haixing Hu
 */
public class ShowPreviewAction extends BaseAction {

  public static final String KEY = ViewAction.KEY + ".show-preview";

  public ShowPreviewAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

  @Override
  public void run() {
    final ApplicationState state = application.getState();
    int mode = state.getViewMode();
    mode |= ViewMode.PREVIEW;
    final MainPanelController controller = application.getMainPanelController();
    controller.setViewMode(mode);
  }
}
