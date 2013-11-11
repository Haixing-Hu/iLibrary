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
 * The action to show only the preview panel.
 *
 * @author Haixing Hu
 */
public class ViewModePreviewAction extends BaseAction {

  public static final String KEY = ViewModeAction.KEY + ".preview";

  public ViewModePreviewAction(Application application) {
    super(application, KEY, IAction.AS_CHECK_BOX);
  }

  @Override
  public void run() {
    ViewMode.update(application, ViewMode.PREVIEW);
  }
}
