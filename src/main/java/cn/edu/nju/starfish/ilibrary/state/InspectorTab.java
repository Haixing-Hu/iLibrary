/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.state;

import org.eclipse.swt.custom.StackLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.ActionManager;
import cn.edu.nju.starfish.ilibrary.action.ui.FilesTabAction;
import cn.edu.nju.starfish.ilibrary.action.ui.InfoTabAction;
import cn.edu.nju.starfish.ilibrary.action.ui.NotesTabAction;
import cn.edu.nju.starfish.ilibrary.action.ui.ReviewsTabAction;
import cn.edu.nju.starfish.ilibrary.gui.MainPanel;
import cn.edu.nju.starfish.ilibrary.gui.MainPanelTab;
import cn.edu.nju.starfish.ilibrary.gui.MainWindow;
import cn.edu.nju.starfish.ilibrary.gui.inspector.FilesTab;
import cn.edu.nju.starfish.ilibrary.gui.inspector.InspectorPanel;
import cn.edu.nju.starfish.ilibrary.gui.inspector.InspectorTabFolder;
import cn.edu.nju.starfish.ilibrary.gui.inspector.NoteTab;
import cn.edu.nju.starfish.ilibrary.gui.inspector.NotesTab;
import cn.edu.nju.starfish.ilibrary.gui.inspector.ReviewsTab;
import cn.edu.nju.starfish.ilibrary.gui.widget.Action;

/**
 * The enumeration of tabs of the inspector panel.
 *
 * @author Haixing Hu
 */
public enum InspectorTab {

  INFO,

  NOTES,

  REVIEWS,

  FILES;

  private static final Logger LOGGER = LoggerFactory.getLogger(InspectorTab.class);

  /**
   * Switches to the tab.
   *
   * @param application
   *          the application.
   * @param tab
   *          the tab to be switched to.
   */
  public static void update(Application application, InspectorTab tab) {
    final MainWindow mainWindow = application.getMainWindow();
    final MainPanel mainPanel = mainWindow.getMainPanel();
    final MainPanelTab tabItem = mainPanel.getSelection();
    final InspectorPanel inspector = tabItem.getInspector();
    final InspectorTabFolder tabFolder = inspector.getTabFolder();
    final StackLayout stackLayout = tabFolder.getStackLayout();
    final NoteTab infoTab = tabFolder.getInfoTab();
    final NotesTab notesTab = tabFolder.getNotesTab();
    final ReviewsTab reviewsTab = tabFolder.getReviewsTab();
    final FilesTab filesTab = tabFolder.getFilesTab();
    final ActionManager am = application.getActionManager();
    final Action infoTabAction = am.get(InfoTabAction.KEY);
    final Action notesTabAction = am.get(NotesTabAction.KEY);
    final Action reviewsTabAction = am.get(ReviewsTabAction.KEY);
    final Action filesTabAction = am.get(FilesTabAction.KEY);
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
      LOGGER.error("Unknown inspector tab: {}", tab);
      break;
    }
    final ApplicationState state = application.getState();
    state.setInspectorTab(tab);
  }
}
