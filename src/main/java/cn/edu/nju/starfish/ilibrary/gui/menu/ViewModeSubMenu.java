/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.menu;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.ActionManager;
import cn.edu.nju.starfish.ilibrary.action.view.ViewModeAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.ViewModeInspectorAction;
import cn.edu.nju.starfish.ilibrary.action.view.ViewModeNoneAction;
import cn.edu.nju.starfish.ilibrary.action.view.ViewModePreviewAction;

/**
 * The "view mode" sub-menu.
 *
 * @author Haixing Hu
 */
public class ViewModeSubMenu extends BaseMenu {

  public static final String KEY = "action.view.view-mode";

  public ViewModeSubMenu(Application application) {
    super(application, KEY);
    final ActionManager am = application.getActionManager();
    this.add(am.getAction(ViewModeAllAction.KEY));
    this.add(am.getAction(ViewModeInspectorAction.KEY));
    this.add(am.getAction(ViewModePreviewAction.KEY));
    this.add(am.getAction(ViewModeNoneAction.KEY));
  }

}
