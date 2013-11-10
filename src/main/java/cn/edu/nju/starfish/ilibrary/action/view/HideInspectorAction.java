/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;
import cn.edu.nju.starfish.ilibrary.gui.MainWindow;
import cn.edu.nju.starfish.ilibrary.gui.menu.BaseMenu;
import cn.edu.nju.starfish.ilibrary.gui.menu.MainMenuBar;
import cn.edu.nju.starfish.ilibrary.gui.panel.InspectorPanel;

/**
 * The action to hide the inspector panel.
 *
 * @author Haixing Hu
 */
public class HideInspectorAction extends BaseAction {

  public static final String KEY = "action.view.hide-inspector";

  public HideInspectorAction(Application application) {
    super(application, KEY);
  }

  @Override
  public void run() {
    //  hide the inspector panel
    MainWindow mainWindow = application.getMainWindow();
    InspectorPanel inspector = mainWindow.getInspectorPanel();
    inspector.hide();
    //  hide this menu item and show the "show inspector" menu item
    final MainMenuBar menuBar = mainWindow.getMenuBarManager();
    final BaseMenu viewMenu = menuBar.getViewMenu();
    viewMenu.hideItem(KEY);
    viewMenu.showItem(ShowInspectorAction.KEY);
    viewMenu.update(true);
  }
}
