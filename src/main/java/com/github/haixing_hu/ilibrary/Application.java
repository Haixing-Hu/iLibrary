/******************************************************************************
 *
 * Copyright (c) 2014  Haixing Hu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package com.github.haixing_hu.ilibrary;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import com.github.haixing_hu.ilibrary.action.ActionManager;
import com.github.haixing_hu.ilibrary.controller.DocumentTabController;
import com.github.haixing_hu.ilibrary.controller.InspectorController;
import com.github.haixing_hu.ilibrary.controller.LibraryTabController;
import com.github.haixing_hu.ilibrary.controller.MainPanelController;
import com.github.haixing_hu.ilibrary.controller.NavigatorController;
import com.github.haixing_hu.ilibrary.gui.MainWindow;
import com.github.haixing_hu.ilibrary.state.ApplicationState;
import com.github.haixing_hu.swt.utils.SWTResourceManager;

/**
 * The main class of the application.
 *
 * @author Haixing Hu
 */
public final class Application {

  public static final String CONTEXT_FILE = "applicationContext.xml";

  private final AppConfig config;
  private final ApplicationState state;
  private final ActionManager actionManager;
  private final MainWindow mainWindow;
  private final NavigatorController navigatorController;
  private final MainPanelController mainPanelController;
  private final InspectorController inspectorController;
  private final LibraryTabController libraryTabController;
  private final DocumentTabController documentTabController;

  /**
   * Constructs an application.
   */
  public Application() {
    config = new AppConfig(CONTEXT_FILE);
    state = new ApplicationState(config);
    actionManager = new ActionManager(this);
    mainWindow = new MainWindow(this);
    navigatorController = new NavigatorController(this);
    mainPanelController = new MainPanelController(this);
    inspectorController = new InspectorController(this);
    libraryTabController = new LibraryTabController(this);
    documentTabController = new DocumentTabController(this);
//    //  adjust the Mac OS X Cococa UI
//    if (SystemUtils.IS_OS_MAC) {
//      NsApplication nsApp = new DefaultNsApplication();
//      nsApp.addApplicationListener(new CococaApplicationListener(this));
//      nsApp.addAboutMenuItem();
//      nsApp.addPreferencesMenuItem();
//    }
  }

  /**
   * Synchronize the application states and the application UI.
   */
  private void syncState() {
    navigatorController.setVisible(state.isNavigatorVisible());
    mainPanelController.setViewMode(state.getViewMode());
    inspectorController.switchToTab(state.getInspectorTab());
    libraryTabController.setFlagFilter(state.getFlagFilter());
    libraryTabController.setReadFilter(state.getReadStatusFilter());
    libraryTabController.setTypeFilter(state.getTypeFilter());
    libraryTabController.setAttachmentFilter(state.getFileStatusFilter());
    documentTabController.setAnnotateMode(state.getAnnotateMode());
  }

  /**
   * Runs this application.
   */
  public void run() {
    mainWindow.create();
    syncState();
    mainWindow.setBlockOnOpen(true);
    mainWindow.open();
    final Display display = Display.getCurrent();
    if (display != null) {
      //  if the program is terminated by external command (i.e., press CMD+Q in Mac),
      //  the display could be null.
      SWTResourceManager.dispose();
      display.dispose();
    }
  }


  /**
   * Displays an error message dialog indicating that the specified function has
   * not been implemented yet.
   *
   * @param key the key of the action.
   */
  public void displayUnimplementedError(String key) {
    final String title = config.getMessage("message.error");
    final String message = config.getMessage("message.error.unimplemented-function")
        + ": " + key;
    MessageDialog.openError(mainWindow.getShell(), title, message);
  }

  /**
   * Gets the action manager of this application.
   *
   * @return the action manager of this application.
   */
  public ActionManager getActionManager() {
    return actionManager;
  }

  /**
   * Gets the configuration of this application.
   *
   * @return the configuration of this application.
   */
  public AppConfig getConfig() {
    return config;
  }

  /**
   * Gets the internal state of this application.
   *
   * @return the internal state of this application.
   */
  public ApplicationState getState() {
    return state;
  }

  /**
   * Gets the main window of this application.
   *
   * @return the main window of this application.
   */
  public MainWindow getMainWindow() {
    return mainWindow;
  }

  /**
   * Gets the navigator controller.
   *
   * @return the navigator controller.
   */
  public NavigatorController getNavigatorController() {
    return navigatorController;
  }

  /**
   * Gets the main panel controller.
   *
   * @return the main panel controller.
   */
  public MainPanelController getMainPanelController() {
    return mainPanelController;
  }

  /**
   * Gets the inspector panel controller.
   *
   * @return the inspector panel controller.
   */
  public InspectorController getInspectorController() {
    return inspectorController;
  }

  /**
   * Gets the library tab controller.
   *
   * @return the library tab controller.
   */
  public LibraryTabController getLibraryTabController() {
    return libraryTabController;
  }

  /**
   * Gets the document tab controller.
   *
   * @return the document tab controller.
   */
  public DocumentTabController getDocumentTabController() {
    return documentTabController;
  }

  /**
   * Launch the application.
   *
   * @param args
   *   The command line arguments.
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    final Application app = new Application();
    try {
      app.run();
    } catch (final Throwable t) {
      t.printStackTrace();
    }
  }
}
