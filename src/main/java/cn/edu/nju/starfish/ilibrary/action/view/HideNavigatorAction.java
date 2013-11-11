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
import cn.edu.nju.starfish.ilibrary.gui.navigator.NavigatorPanel;

/**
 * The action to hide the navigator panel.
 *
 * @author Haixing Hu
 */
public class HideNavigatorAction extends BaseAction {

  public static final String KEY = "action.view.hide-navigator";

  public HideNavigatorAction(Application application) {
    super(application, KEY);
  }

  @Override
  public void run() {
    //  hide the navigator panel
    final MainWindow mainWindow = application.getMainWindow();
    final NavigatorPanel navigator = mainWindow.getNavigatorPanel();
    navigator.hide();
    //  hide this menu item and show the "show navigator" menu item
    final MainMenuBar menuBar = mainWindow.getMenuBarManager();
    final BaseMenu viewMenu = menuBar.getViewMenu();
    viewMenu.hideItem(KEY);
    viewMenu.showItem(ShowNavigatorAction.KEY);
    viewMenu.update(true);
  }
}
