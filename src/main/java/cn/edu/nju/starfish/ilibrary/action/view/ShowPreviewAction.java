/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;
import cn.edu.nju.starfish.ilibrary.state.ApplicationState;
import cn.edu.nju.starfish.ilibrary.state.ViewMode;

/**
 * The action to show the preview panel.
 *
 * @author Haixing Hu
 */
public class ShowPreviewAction extends BaseAction {

  public static final String KEY = "action.view.show-preview";

  public ShowPreviewAction(Application application) {
    super(application, KEY);
  }

  @Override
  public void run() {
    final ApplicationState state = application.getState();
    int mode = state.getViewMode();
    mode |= ViewMode.PREVIEW;
    ViewMode.update(application, mode);
  }
}
