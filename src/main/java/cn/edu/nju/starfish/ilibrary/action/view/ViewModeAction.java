/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.ActionManager;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.SubMenuCreator;

/**
 * The action to switch the view modes.
 *
 * @author Haixing Hu
 */
public class ViewModeAction extends BaseAction {

  public static final String KEY = "action.view.view-mode";

  public ViewModeAction(Application application) {
    super(application, KEY, IAction.AS_DROP_DOWN_MENU);
    final ActionManager am = application.getActionManager();
    this.setMenuCreator(new SubMenuCreator(false, new Action[]{
        am.getAction(ViewModeAllAction.KEY),
        am.getAction(ViewModeInspectorAction.KEY),
        am.getAction(ViewModePreviewAction.KEY),
        am.getAction(ViewModeNoneAction.KEY),
    }));
  }

  @Override
  public void run() {
    //  do nothing. It is presented in order to override the super's behavior.
  }

}
