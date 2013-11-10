/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import org.eclipse.jface.action.Action;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.ActionManager;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;
import cn.edu.nju.starfish.ilibrary.gui.MainWindow;
import cn.edu.nju.starfish.ilibrary.gui.menu.BaseMenu;
import cn.edu.nju.starfish.ilibrary.gui.menu.MainMenuBar;
import cn.edu.nju.starfish.ilibrary.gui.panel.InspectorPanel;
import cn.edu.nju.starfish.ilibrary.gui.panel.PreviewPanel;

/**
 * The action to show the inspector panel.
 *
 * @author Haixing Hu
 */
public class ShowInspectorAction extends BaseAction {

  public static final String KEY = "action.view.show-inspector";

  public ShowInspectorAction(Application application) {
    super(application, KEY);
  }

  @Override
  public void run() {
    //  show the inspector panel
    final MainWindow mainWindow = application.getMainWindow();
    final InspectorPanel inspector = mainWindow.getInspectorPanel();
    final PreviewPanel preview = mainWindow.getPreviewPanel();
    inspector.show();
    //  hide this menu item and show the "hide inspector" menu item
    final MainMenuBar menuBar = mainWindow.getMenuBarManager();
    final BaseMenu viewMenu = menuBar.getViewMenu();
    viewMenu.hideItem(KEY);
    viewMenu.showItem(HideInspectorAction.KEY);
    viewMenu.update(true);
    //  update the image of the "view mode" action
    final ActionManager am = application.getActionManager();
    final Action viewModeAction = am.getAction(ViewModeAction.KEY);
    final Action action;
    if (preview.isHidden()) {
      action = am.getAction(ViewModeInspectorAction.KEY);
    } else {
      action = am.getAction(ViewModeAllAction.KEY);
    }
    viewModeAction.setImageDescriptor(action.getImageDescriptor());
  }
}
