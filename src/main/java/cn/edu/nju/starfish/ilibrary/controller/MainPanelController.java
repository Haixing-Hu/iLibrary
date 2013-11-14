/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.controller;

import org.eclipse.swt.custom.CTabFolderEvent;
import org.eclipse.swt.events.SelectionEvent;

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
import cn.edu.nju.starfish.ilibrary.gui.MainPanelTab;
import cn.edu.nju.starfish.ilibrary.gui.MainWindow;
import cn.edu.nju.starfish.ilibrary.gui.library.LibraryTab;
import cn.edu.nju.starfish.ilibrary.gui.widget.Action;
import cn.edu.nju.starfish.ilibrary.gui.widget.DropDownAction;
import cn.edu.nju.starfish.ilibrary.state.ApplicationState;
import cn.edu.nju.starfish.ilibrary.state.ViewMode;

/**
 * The controller of the main panel.
 *
 * @author Haixing Hu
 */
public class MainPanelController extends BaseController {

  /**
   * Constructs a {@link MainPanelController}.
   *
   * @param application
   *          the application.
   */
  public MainPanelController(Application application) {
    super(application);
  }

  /**
   * Sets the view mode.
   *
   * @param mode
   *      the new view mode.
   */
  public void setViewMode(int mode) {
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
    case ViewMode.NONE:
      logger.info("Set the view mode to: {}", ViewMode.NONE);
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
    case ViewMode.INSPECTOR:
      logger.info("Set the view mode to: {}", ViewMode.INSPECTOR);
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
    case ViewMode.PREVIEW:
      logger.info("Set the view mode to: {}", ViewMode.PREVIEW);
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
    case ViewMode.ALL:
      logger.info("Set the view mode to: {}", ViewMode.ALL);
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
      logger.error("Unknown view mode: {}", mode);
      break;
    }
  }

  /**
   * Handle the event on switching to a tab.
   *
   * @param event
   *    the event object.
   */
  public void onSwithTab(SelectionEvent event) {
    final MainPanelTab tab = (MainPanelTab) event.item;
    logger.info("Switch to tab: {}", tab.getId());
    //  TODO
  }

  /**
   * Handle the event on closing a tab.
   *
   * @param event
   *    the event object.
   */
  public void onCloseTab(CTabFolderEvent event) {
    final MainPanelTab tab = (MainPanelTab) event.item;
    logger.info("Close tab: {}", tab.getId());
    //  TODO
  }
}
