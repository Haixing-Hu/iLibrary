/*
 * Copyright (C) 2014 Haixing Hu
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.github.haixing_hu.ilibrary;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.action.edit.EditAction;
import com.github.haixing_hu.ilibrary.action.file.FileAction;
import com.github.haixing_hu.ilibrary.action.help.HelpAction;
import com.github.haixing_hu.ilibrary.action.library.LibraryAction;
import com.github.haixing_hu.ilibrary.action.share.ShareAction;
import com.github.haixing_hu.ilibrary.action.view.ViewAction;
import com.github.haixing_hu.ilibrary.action.view.browse.BrowseModeAction;
import com.github.haixing_hu.ilibrary.action.view.columns.SelectColumnsAction;
import com.github.haixing_hu.ilibrary.action.view.filter.SetFiltersAction;
import com.github.haixing_hu.ilibrary.action.window.WindowAction;
import com.github.haixing_hu.ilibrary.controller.ExplorerController;
import com.github.haixing_hu.ilibrary.controller.LayoutController;
import com.github.haixing_hu.ilibrary.controller.ReaderController;
import com.github.haixing_hu.ilibrary.controller.SearchController;
import com.github.haixing_hu.ilibrary.gui.MainWindow;
import com.github.haixing_hu.ilibrary.gui.NodeLookup;
import com.github.haixing_hu.ilibrary.state.ApplicationState;
import com.github.haixing_hu.javafx.action.ActionManager;

/**
 * The main class of the application.
 *
 * @author Haixing Hu
 */
public class Application extends javafx.application.Application
    implements NodeLookup, MessageKey {

  public static final String CONTEXT_FILE = "applicationContext.xml";

  public static final String ID = "app";

  private final Logger logger;
  private final AppConfig config;
  private final ApplicationState state;
  private final ActionManager actionManager;
  private final LayoutController layoutController;
  private final ExplorerController explorerController;
  private final SearchController searchController;
  private final ReaderController readerController;
  private final MenuBar menuBar;
  private final MainWindow mainWindow;
  private final Scene scene;

  /**
   * Constructs an application.
   */
  public Application() {
    logger = LoggerFactory.getLogger(Application.class);
    config = new AppConfig(CONTEXT_FILE);
    state = new ApplicationState();
    actionManager = new ActionManager();
    createActions();
    layoutController = new LayoutController(this);
    explorerController = new ExplorerController(this);
    searchController = new SearchController(this);
    readerController = new ReaderController(this);
    menuBar = actionManager.createMenuBar(FileAction.ID, EditAction.ID,
        ViewAction.ID, LibraryAction.ID, ShareAction.ID, WindowAction.ID,
        HelpAction.ID);
    menuBar.setUseSystemMenuBar(true);
    mainWindow = new MainWindow(this, menuBar);
    scene = new Scene(mainWindow);
  }

  private void createActions() {
    actionManager.add(new FileAction(this));
    actionManager.add(new EditAction(this));
    actionManager.add(new ViewAction(this));
    actionManager.add(new LibraryAction(this));
    actionManager.add(new ShareAction(this));
    actionManager.add(new WindowAction(this));
    actionManager.add(new HelpAction(this));
    actionManager.add(new SelectColumnsAction(this));
    actionManager.add(new SetFiltersAction(this));
    actionManager.add(new BrowseModeAction(this));
  }

  public AppConfig getConfig() {
    return config;
  }

  public ApplicationState getState() {
    return state;
  }

  public ActionManager getActionManager() {
    return actionManager;
  }

  public LayoutController getLayoutController() {
    return layoutController;
  }

  public ExplorerController getExplorerController() {
    return explorerController;
  }

  public SearchController getSearchController() {
    return searchController;
  }

  public ReaderController getReaderController() {
    return readerController;
  }

  public MainWindow getMainWindow() {
    return mainWindow;
  }

  public Scene getScene() {
    return scene;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends Node> T findNodeById(String nodeId) {
    return (T) scene.lookup('#' + nodeId);
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends Node> T findNodeByClass(String nodeClass) {
    return (T) scene.lookup('.' + nodeClass);
  }

  /**
   * Displays an error message dialog indicating that the specified function has
   * not been implemented yet.
   *
   * @param key the key of the action.
   */
  public void displayUnimplementedError(String key) {
    final String message = config.getMessage(ERROR_UNIMPLEMENTED)
        + ": " + key;
    logger.error(message);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    scene.getStylesheets().add(config.getStylesheet());
    menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
    primaryStage.setScene(scene);
    primaryStage.setWidth(config.getInt(ID + KeySuffix.WIDTH));
    primaryStage.setHeight(config.getInt(ID + KeySuffix.HEIGHT));
    primaryStage.setMinWidth(config.getInt(ID + KeySuffix.MIN_WIDTH));
    primaryStage.setMinHeight(config.getInt(ID + KeySuffix.MIN_HEIGHT));
    primaryStage.setTitle(config.getAppName() + " " + config.getAppVersion());

    state.load(config);
    syncState();
    primaryStage.show();
  }

  private void syncState() {
    logger.info("Synchronizing the application state ...");
    layoutController.update();
    explorerController.update();
  }

  public static void main(String[] args) {
    launch(args);
  }

}
