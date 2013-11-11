/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.state;

import org.eclipse.jface.action.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.ActionManager;
import cn.edu.nju.starfish.ilibrary.action.view.HideInspectorAction;
import cn.edu.nju.starfish.ilibrary.action.view.HidePreviewAction;
import cn.edu.nju.starfish.ilibrary.action.view.ShowInspectorAction;
import cn.edu.nju.starfish.ilibrary.action.view.ShowPreviewAction;
import cn.edu.nju.starfish.ilibrary.action.view.ViewModeAction;
import cn.edu.nju.starfish.ilibrary.action.view.ViewModeAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.ViewModeInspectorAction;
import cn.edu.nju.starfish.ilibrary.action.view.ViewModeNoneAction;
import cn.edu.nju.starfish.ilibrary.action.view.ViewModePreviewAction;
import cn.edu.nju.starfish.ilibrary.gui.MainWindow;
import cn.edu.nju.starfish.ilibrary.gui.inspector.InspectorPanel;
import cn.edu.nju.starfish.ilibrary.gui.main.PreviewPanel;
import cn.edu.nju.starfish.ilibrary.gui.menu.BaseMenu;
import cn.edu.nju.starfish.ilibrary.gui.menu.MainMenuBar;

/**
 * The enumeration of view mode states.
 *
 * @author Haixing Hu
 */
public final class ViewMode {

  public static final int NONE = 0;

  public static final int INSPECTOR = 0x01;

  public static final int PREVIEW = 0x02;

  public static final int ALL = INSPECTOR | PREVIEW;

  private static final Logger LOGGER = LoggerFactory.getLogger(ViewMode.class);

  /**
   * Updates the view mode.
   *
   * @param application
   *      the application.
   * @param mode
   *      the new view mode.
   */
  public static void update(Application application, int mode) {
    LOGGER.info("Changing view mode to: {}", mode);
    final ApplicationState state = application.getState();
    final MainWindow mainWindow = application.getMainWindow();
    final InspectorPanel inspector = mainWindow.getInspectorPanel();
    final PreviewPanel preview = mainWindow.getPreviewPanel();
    final MainMenuBar menuBar = mainWindow.getMenuBarManager();
    final BaseMenu viewMenu = menuBar.getViewMenu();
    final ActionManager am = application.getActionManager();
    final Action viewModeAction = am.getAction(ViewModeAction.KEY);
    final Action mode_all = am.getAction(ViewModeAllAction.KEY);
    final Action mode_inspector = am.getAction(ViewModeInspectorAction.KEY);
    final Action mode_preview = am.getAction(ViewModePreviewAction.KEY);
    final Action mode_none = am.getAction(ViewModeNoneAction.KEY);
    switch (mode) {
    case NONE:
      inspector.hide();
      preview.hide();
      //  change the menu items
      viewMenu.showItem(ShowInspectorAction.KEY);
      viewMenu.showItem(ShowPreviewAction.KEY);
      viewMenu.hideItem(HideInspectorAction.KEY);
      viewMenu.hideItem(HidePreviewAction.KEY);
      viewMenu.update(true);
      //  change the ViewModeAction icon
      viewModeAction.setImageDescriptor(mode_none.getImageDescriptor());
      //  change the action's checking state
      mode_all.setChecked(false);
      mode_inspector.setChecked(false);
      mode_preview.setChecked(false);
      mode_none.setChecked(true);
      //  change the state
      state.setViewMode(mode);
      break;
    case INSPECTOR:
      inspector.show();
      preview.hide();
      // change the menu items
      viewMenu.showItem(HideInspectorAction.KEY);
      viewMenu.showItem(ShowPreviewAction.KEY);
      viewMenu.hideItem(ShowInspectorAction.KEY);
      viewMenu.hideItem(HidePreviewAction.KEY);
      viewMenu.update(true);
      //  change the ViewModeAction icon
      viewModeAction.setImageDescriptor(mode_inspector.getImageDescriptor());
      //  change the action's checking state
      mode_all.setChecked(false);
      mode_inspector.setChecked(true);
      mode_preview.setChecked(false);
      mode_none.setChecked(false);
      // change the state
      state.setViewMode(mode);
      break;
    case PREVIEW:
      inspector.hide();
      preview.show();
      // change the menu items
      viewMenu.showItem(ShowInspectorAction.KEY);
      viewMenu.showItem(HidePreviewAction.KEY);
      viewMenu.hideItem(HideInspectorAction.KEY);
      viewMenu.hideItem(ShowPreviewAction.KEY);
      viewMenu.update(true);
      //  change the ViewModeAction icon
      viewModeAction.setImageDescriptor(mode_preview.getImageDescriptor());
      //  change the action's checking state
      mode_all.setChecked(false);
      mode_inspector.setChecked(false);
      mode_preview.setChecked(true);
      mode_none.setChecked(false);
      // change the state
      state.setViewMode(mode);
      break;
    case ALL:
      inspector.show();
      preview.show();
      // change the menu items
      viewMenu.showItem(HideInspectorAction.KEY);
      viewMenu.showItem(HidePreviewAction.KEY);
      viewMenu.hideItem(ShowInspectorAction.KEY);
      viewMenu.hideItem(ShowInspectorAction.KEY);
      viewMenu.update(true);
      //  change the ViewModeAction icon
      viewModeAction.setImageDescriptor(mode_all.getImageDescriptor());
      //  change the action's checking state
      mode_all.setChecked(true);
      mode_inspector.setChecked(false);
      mode_preview.setChecked(false);
      mode_none.setChecked(false);
      // change the state
      state.setViewMode(mode);
      break;
    default:
      LOGGER.error("Unknown view mode: {}", mode);
      break;
    }
  }
}
