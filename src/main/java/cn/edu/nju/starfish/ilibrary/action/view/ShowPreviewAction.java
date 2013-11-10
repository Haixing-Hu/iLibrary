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
    final InspectorPanel inspector = mainWindow.getInspectorPanel();
    final PreviewPanel preview = mainWindow.getPreviewPanel();
    preview.show();
    //  hide this menu item and show the "hide preview" menu item
    final MainMenuBar menuBar = mainWindow.getMenuBarManager();
    final BaseMenu viewMenu = menuBar.getViewMenu();
    viewMenu.hideItem(KEY);
    viewMenu.showItem(HidePreviewAction.KEY);
    viewMenu.update(true);
    //  update the image of the "view mode" action
    final ActionManager am = application.getActionManager();
    final Action viewModeAction = am.getAction(ViewModeAction.KEY);
    final Action action;
    if (inspector.isHidden()) {
      action = am.getAction(ViewModePreviewAction.KEY);
    } else {
      action = am.getAction(ViewModeAllAction.KEY);
    }
    viewModeAction.setImageDescriptor(action.getImageDescriptor());
  }
}
