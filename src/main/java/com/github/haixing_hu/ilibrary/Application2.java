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
import javafx.stage.Stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.control.ExplorerController;
import com.github.haixing_hu.ilibrary.control.ReaderController;
import com.github.haixing_hu.ilibrary.control.SearchController;
import com.github.haixing_hu.ilibrary.gui2.MainWindow;
import com.github.haixing_hu.ilibrary.state.ApplicationState;

/**
 * The main class of the application.
 *
 * @author Haixing Hu
 */
public class Application2 extends javafx.application.Application {

  public static final String CONTEXT_FILE = "applicationContext.xml";

  public static final String ID = "app";

  private final Logger logger;
  private final AppConfig config;
  private final ApplicationState state;
  private final ExplorerController explorerControler;
  private final SearchController searchControler;
  private final ReaderController readerControler;
  private final MainWindow mainWindow;
  private final Scene scene;

  /**
   * Constructs an application.
   */
  public Application2() {
    logger = LoggerFactory.getLogger(Application.class);
    config = new AppConfig(CONTEXT_FILE);
    state = new ApplicationState();
    explorerControler = new ExplorerController(this);
    searchControler = new SearchController(this);
    readerControler = new ReaderController(this);
    mainWindow = new MainWindow(this);
    scene = new Scene(mainWindow);
  }

  public AppConfig getConfig() {
    return config;
  }

  public ApplicationState getState() {
    return state;
  }

  public ExplorerController getExplorerControler() {
    return explorerControler;
  }

  public SearchController getSearchControler() {
    return searchControler;
  }

  public ReaderController getReaderControler() {
    return readerControler;
  }

  public MainWindow getMainWindow() {
    return mainWindow;
  }

  public Scene getScene() {
    return scene;
  }

  private void syncState() {
    logger.info("Synchronizing the applicatino state ...");
//    explorerControler.updateNavigatorWidth();
//    explorerControler.updateNavigatorVisibility();
//    explorerControler.updateInspectorWidth();
//    explorerControler.updatePreviewHeight();
//    explorerControler.updateLayoutMode();
//    explorerControler.updateInspectorTab();

    //explorerControler.updateBrowserMode();
    explorerControler.updatePage();

    //readerControler.updateAnnotateMode();
  }

  /**
   * Finds a node in the tree of the scene of this application by its ID.
   *
   * @param <T>
   *    the type of returned node.
   * @param nodeId
   *    the ID of the node.
   * @return
   *    the node with the specified ID, or null if no such node.
   */
  @SuppressWarnings("unchecked")
  public <T extends Node> T findNode(String nodeId) {
    return (T) scene.lookup('#' + nodeId);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    scene.getStylesheets().add(config.getStylesheet());
    primaryStage.setScene(scene);
    mainWindow.layout();
    primaryStage.setWidth(config.getInt(ID + KeySuffix.WIDTH));
    primaryStage.setHeight(config.getInt(ID + KeySuffix.HEIGHT));
    primaryStage.setMinWidth(config.getInt(ID + KeySuffix.MIN_WIDTH));
    primaryStage.setMinHeight(config.getInt(ID + KeySuffix.MIN_HEIGHT));
    primaryStage.setTitle(config.getAppName() + " " + config.getAppVersion());
    syncState();
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}
