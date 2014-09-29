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

import com.github.haixing_hu.ilibrary.gui2.MainWindow;
import com.github.haixing_hu.ilibrary.state.ApplicationState;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

  /**
   * Constructs an application.
   */
  public Application2() {
    logger = LoggerFactory.getLogger(Application.class);
    config = new AppConfig(CONTEXT_FILE);
    state = new ApplicationState();
    System.out.println("create");
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    MainWindow root = new MainWindow(config);
    Scene scene = new Scene(root);
    scene.getStylesheets().add(config.getStylesheet());
    primaryStage.setScene(scene);
    primaryStage.setWidth(config.getInt(ID + KeySuffix.WIDTH));
    primaryStage.setHeight(config.getInt(ID + KeySuffix.HEIGHT));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}
