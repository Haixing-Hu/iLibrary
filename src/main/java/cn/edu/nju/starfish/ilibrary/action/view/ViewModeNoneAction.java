/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import org.eclipse.jface.action.IAction;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;
import cn.edu.nju.starfish.ilibrary.state.ViewMode;

/**
 * The action to hide both the inspector panel and preview panel.
 *
 * @author Haixing Hu
 */
public class ViewModeNoneAction extends BaseAction {

  public static final String KEY = ViewModeAction.KEY + ".none";

  public ViewModeNoneAction(Application application) {
    super(application, KEY, IAction.AS_CHECK_BOX);
  }

  @Override
  public void run() {
    logger.info("Set the view mode to NONE");
    ViewMode.update(application, ViewMode.NONE);
  }
}
