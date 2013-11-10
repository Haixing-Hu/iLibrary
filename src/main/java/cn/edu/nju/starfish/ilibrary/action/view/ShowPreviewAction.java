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
import cn.edu.nju.starfish.ilibrary.gui.panel.LibraryTab;
import cn.edu.nju.starfish.ilibrary.gui.panel.MainPanel;
import cn.edu.nju.starfish.ilibrary.gui.panel.MainTabFolder;
import cn.edu.nju.starfish.ilibrary.gui.panel.PreviewPanel;

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
    //  show the preview panel
    final MainWindow mainWindow = application.getMainWindow();
    final MainPanel mainPanel = mainWindow.getMainPanel();
    final MainTabFolder tabFolder = mainPanel.getTabFolder();
    final LibraryTab libraryTab = tabFolder.getLibraryTab();
    final PreviewPanel previewPanel = libraryTab.getPreviewPanel();
    previewPanel.show();
    //  hide this menu item and show the "hide preview" menu item
    final MainMenuBar menuBar = mainWindow.getMenuBarManager();
    final BaseMenu viewMenu = menuBar.getViewMenu();
    viewMenu.hideItem(KEY);
    viewMenu.showItem(HidePreviewAction.KEY);
    viewMenu.update(true);
  }
}
