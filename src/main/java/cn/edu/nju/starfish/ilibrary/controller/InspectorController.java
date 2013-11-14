/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.controller;

import org.eclipse.swt.custom.StackLayout;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.ActionManager;
import cn.edu.nju.starfish.ilibrary.action.ui.SwitchToFilesTabAction;
import cn.edu.nju.starfish.ilibrary.action.ui.SwitchToInfoTabAction;
import cn.edu.nju.starfish.ilibrary.action.ui.SwitchToNotesTabAction;
import cn.edu.nju.starfish.ilibrary.action.ui.SwitchToReviewsTabAction;
import cn.edu.nju.starfish.ilibrary.gui.MainPanel;
import cn.edu.nju.starfish.ilibrary.gui.MainPanelTab;
import cn.edu.nju.starfish.ilibrary.gui.MainWindow;
import cn.edu.nju.starfish.ilibrary.gui.inspector.FilesTab;
import cn.edu.nju.starfish.ilibrary.gui.inspector.InfoTab;
import cn.edu.nju.starfish.ilibrary.gui.inspector.InspectorPanel;
import cn.edu.nju.starfish.ilibrary.gui.inspector.InspectorTabFolder;
import cn.edu.nju.starfish.ilibrary.gui.inspector.NotesTab;
import cn.edu.nju.starfish.ilibrary.gui.inspector.ReviewsTab;
import cn.edu.nju.starfish.ilibrary.gui.widget.Action;
import cn.edu.nju.starfish.ilibrary.state.ApplicationState;
import cn.edu.nju.starfish.ilibrary.state.InspectorTab;

/**
 * The controller of the inspector panel.
 *
 * @author Haixing Hu
 */
public class InspectorController extends BaseController {

  /**
   * Constructs a {@link InspectorController}.
   *
   * @param application
   *          the application.
   */
  public InspectorController(Application application) {
    super(application);
  }


  /**
   * Switches to the tab.
   *
   * @param tab
   *          the tab to be switched to.
   */
  public void switchToTab(InspectorTab tab) {
    logger.info("Switch inspector tab to: {}", tab);
    final MainWindow mainWindow = application.getMainWindow();
    final MainPanel mainPanel = mainWindow.getMainPanel();
    final MainPanelTab tabItem = mainPanel.getSelection();
    final InspectorPanel inspector = tabItem.getInspector();
    final InspectorTabFolder tabFolder = inspector.getTabFolder();
    final StackLayout stackLayout = tabFolder.getStackLayout();
    final InfoTab infoTab = tabFolder.getInfoTab();
    final NotesTab notesTab = tabFolder.getNotesTab();
    final ReviewsTab reviewsTab = tabFolder.getReviewsTab();
    final FilesTab filesTab = tabFolder.getFilesTab();
    final ActionManager am = application.getActionManager();
    final Action infoTabAction = am.get(SwitchToInfoTabAction.KEY);
    final Action notesTabAction = am.get(SwitchToNotesTabAction.KEY);
    final Action reviewsTabAction = am.get(SwitchToReviewsTabAction.KEY);
    final Action filesTabAction = am.get(SwitchToFilesTabAction.KEY);
    switch (tab) {
    case INFO:
      stackLayout.topControl = infoTab;
      tabFolder.layout();
      infoTabAction.setChecked(true);
      notesTabAction.setChecked(false);
      reviewsTabAction.setChecked(false);
      filesTabAction.setChecked(false);
      break;
    case NOTES:
      stackLayout.topControl = notesTab;
      tabFolder.layout();
      infoTabAction.setChecked(false);
      notesTabAction.setChecked(true);
      reviewsTabAction.setChecked(false);
      filesTabAction.setChecked(false);
      break;
    case REVIEWS:
      stackLayout.topControl = reviewsTab;
      tabFolder.layout();
      infoTabAction.setChecked(false);
      notesTabAction.setChecked(false);
      reviewsTabAction.setChecked(true);
      filesTabAction.setChecked(false);
      break;
    case FILES:
      stackLayout.topControl = filesTab;
      tabFolder.layout();
      infoTabAction.setChecked(false);
      notesTabAction.setChecked(false);
      reviewsTabAction.setChecked(false);
      filesTabAction.setChecked(true);
      break;
    default:
      logger.error("Unknown inspector tab: {}", tab);
      break;
    }
    final ApplicationState state = application.getState();
    state.setInspectorTab(tab);
  }
}
