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

/**
 * The action to show the navigator panel.
 *
 * @author Haixing Hu
 */
public class ShowNavigatorAction extends BaseAction {

  public static final String KEY = "action.view.show-navigator";

  public ShowNavigatorAction(Application application) {
    super(application, KEY);
  }

  @Override
  public void run() {
    //  show the navigator panel
    final MainWindow mainWindow = application.getMainWindow();
    mainWindow.showNavigator();
    //  hide this menu item and show the "hide navigator" menu item
    final MainMenuBar menuBar = mainWindow.getMenuBarManager();
    final BaseMenu viewMenu = menuBar.getViewMenu();
    viewMenu.hideItem(ShowNavigatorAction.KEY);
    viewMenu.showItem(HideNavigatorAction.KEY);
    viewMenu.update(true);
  }

}
