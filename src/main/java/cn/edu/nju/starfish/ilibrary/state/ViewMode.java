/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.ActionManager;
import cn.edu.nju.starfish.ilibrary.action.view.HideInspectorAction;
import cn.edu.nju.starfish.ilibrary.action.view.HidePreviewAction;
import cn.edu.nju.starfish.ilibrary.action.view.ShowInspectorAction;
import cn.edu.nju.starfish.ilibrary.action.view.ShowPreviewAction;
import cn.edu.nju.starfish.ilibrary.action.view.ViewAction;
import cn.edu.nju.starfish.ilibrary.action.view.ViewModeAction;
import cn.edu.nju.starfish.ilibrary.action.view.ViewModeAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.ViewModeInspectorAction;
import cn.edu.nju.starfish.ilibrary.action.view.ViewModeNoneAction;
import cn.edu.nju.starfish.ilibrary.action.view.ViewModePreviewAction;
import cn.edu.nju.starfish.ilibrary.gui.MainPanel;
import cn.edu.nju.starfish.ilibrary.gui.MainWindow;
import cn.edu.nju.starfish.ilibrary.gui.library.LibraryTab;
import cn.edu.nju.starfish.ilibrary.gui.widget.Action;
import cn.edu.nju.starfish.ilibrary.gui.widget.DropDownAction;

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
    final ApplicationState state = application.getState();
    final MainWindow mainWindow = application.getMainWindow();
    final MainPanel mainPanel = mainWindow.getMainPanel();
    final LibraryTab libraryTab = (LibraryTab) mainPanel.getItem(0);
    final ActionManager am = application.getActionManager();
    final DropDownAction viewAction = (DropDownAction) am.get(ViewAction.KEY);
    final Action viewModeAction = am.get(ViewModeAction.KEY);
    final Action mode_all = am.get(ViewModeAllAction.KEY);
    final Action mode_inspector = am.get(ViewModeInspectorAction.KEY);
    final Action mode_preview = am.get(ViewModePreviewAction.KEY);
    final Action mode_none = am.get(ViewModeNoneAction.KEY);
    switch (mode) {
    case NONE:
      mainPanel.hideInspector();
      libraryTab.hidePreview();
      //  change the menu items
      viewAction.showSubAction(ShowInspectorAction.KEY);
      viewAction.showSubAction(ShowPreviewAction.KEY);
      viewAction.hideSubAction(HideInspectorAction.KEY);
      viewAction.hideSubAction(HidePreviewAction.KEY);
      viewAction.update(true);
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
      mainPanel.showInspector();
      libraryTab.hidePreview();
      // change the menu items
      viewAction.showSubAction(HideInspectorAction.KEY);
      viewAction.showSubAction(ShowPreviewAction.KEY);
      viewAction.hideSubAction(ShowInspectorAction.KEY);
      viewAction.hideSubAction(HidePreviewAction.KEY);
      viewAction.update(true);
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
      mainPanel.hideInspector();
      libraryTab.showPreview();
      // change the menu items
      viewAction.showSubAction(ShowInspectorAction.KEY);
      viewAction.showSubAction(HidePreviewAction.KEY);
      viewAction.hideSubAction(HideInspectorAction.KEY);
      viewAction.hideSubAction(ShowPreviewAction.KEY);
      viewAction.update(true);
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
      mainPanel.showInspector();
      libraryTab.showPreview();
      // change the menu items
      viewAction.showSubAction(HideInspectorAction.KEY);
      viewAction.showSubAction(HidePreviewAction.KEY);
      viewAction.hideSubAction(ShowInspectorAction.KEY);
      viewAction.hideSubAction(ShowPreviewAction.KEY);
      viewAction.update(true);
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
