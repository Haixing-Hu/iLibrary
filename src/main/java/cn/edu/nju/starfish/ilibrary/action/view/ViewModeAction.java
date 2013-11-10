/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to switch the view modes.
 *
 * @author Haixing Hu
 */
public class ViewModeAction extends BaseAction {

  public static final String KEY = "action.view.view-mode";

  public ViewModeAction(Application application) {
    super(application, KEY);
  }

}
