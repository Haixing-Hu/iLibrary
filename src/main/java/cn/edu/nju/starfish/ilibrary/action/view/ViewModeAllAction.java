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
 * The action to show both inspector panel and preview panel.
 *
 * @author Haixing Hu
 */
public class ViewModeAllAction extends BaseAction {

  public static final String KEY = ViewModeAction.KEY + ".all";

  public ViewModeAllAction(Application application) {
    super(application, KEY);
  }

  @Override
  public void run() {
    //  show the inspector panel
    final MainWindow mainWindow = application.getMainWindow();
    final InspectorPanel inspector = mainWindow.getInspectorPanel();
    inspector.show();
    //  show the preview panel
    final PreviewPanel preview = mainWindow.getPreviewPanel();
    preview.show();
    //  hide the "show inspector" menu item and "show preview" menu item
    //  show the "hide inspector" menu item and "hide preview" menu item
    final MainMenuBar menuBar = mainWindow.getMenuBarManager();
    final BaseMenu viewMenu = menuBar.getViewMenu();
    viewMenu.hideItem(ShowInspectorAction.KEY);
    viewMenu.hideItem(ShowPreviewAction.KEY);
    viewMenu.showItem(HideInspectorAction.KEY);
    viewMenu.showItem(HidePreviewAction.KEY);
    viewMenu.update(true);
    //  set the image of the "view mode" action to "view mode all" action's image
    final ActionManager am = application.getActionManager();
    final Action viewModeAction = am.getAction(ViewModeAction.KEY);
    final Action viewModeAllAction = am.getAction(ViewModeAllAction.KEY);
    viewModeAction.setImageDescriptor(viewModeAllAction.getImageDescriptor());
  }
}
