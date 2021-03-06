/*
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
 */package com.github.haixing_hu.ilibrary;

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
  public void start(Stage stage) throws Exception {
    scene.getStylesheets().add(config.getStylesheet());
    menuBar.prefWidthProperty().bind(stage.widthProperty());
    stage.setScene(scene);
    stage.setWidth(config.getInt(ID + KeySuffix.WIDTH));
    stage.setHeight(config.getInt(ID + KeySuffix.HEIGHT));
    stage.setMinWidth(config.getInt(ID + KeySuffix.MIN_WIDTH));
    stage.setMinHeight(config.getInt(ID + KeySuffix.MIN_HEIGHT));
    stage.setTitle(config.getAppName() + " " + config.getAppVersion());

    state.load(config);
    syncState();
    stage.show();
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
