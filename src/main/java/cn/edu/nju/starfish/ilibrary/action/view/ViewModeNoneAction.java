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
 * The action to hide both the inspector panel and preview panel.
 *
 * @author Haixing Hu
 */
public class ViewModeNoneAction extends BaseAction {

  public static final String KEY = ViewModeAction.KEY + ".none";

  public ViewModeNoneAction(Application application) {
    super(application, KEY);
  }

  @Override
  public void run() {
    //  hide the inspector panel
    final MainWindow mainWindow = application.getMainWindow();
    final InspectorPanel inspector = mainWindow.getInspectorPanel();
    inspector.hide();
    //  hide the preview panel
    final PreviewPanel preview = mainWindow.getPreviewPanel();
    preview.hide();
    //  hide the "hide inspector" menu item and "hide preview" menu item
    //  show the "show inspector" menu item and "show preview" menu item
    final MainMenuBar menuBar = mainWindow.getMenuBarManager();
    final BaseMenu viewMenu = menuBar.getViewMenu();
    viewMenu.hideItem(HideInspectorAction.KEY);
    viewMenu.hideItem(HidePreviewAction.KEY);
    viewMenu.showItem(ShowInspectorAction.KEY);
    viewMenu.showItem(ShowPreviewAction.KEY);
    viewMenu.update(true);
    //  set the image of the "view mode" action to "view mode none" action's image
    final ActionManager am = application.getActionManager();
    final Action viewModeAction = am.getAction(ViewModeAction.KEY);
    final Action viewModeNoneAction = am.getAction(ViewModeNoneAction.KEY);
    viewModeAction.setImageDescriptor(viewModeNoneAction.getImageDescriptor());
  }
}
