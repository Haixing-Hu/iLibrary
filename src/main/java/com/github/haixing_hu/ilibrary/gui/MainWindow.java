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
package com.github.haixing_hu.ilibrary.gui;

import javafx.scene.Node;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.Application;

/**
 * The scene representing the main window of the application.
 *
 * @author Haixing Hu
 */
public class MainWindow extends VBox implements NodeLookup {

  public static final String ID = "main-window";

  private final MainHeader header;
  private final MainContent content;

  public MainWindow(final Application application, MenuBar menuBar) {
    super();
    final Logger logger = LoggerFactory.getLogger(MainWindow.class);
    logger.trace("Craeting {}", MainWindow.class);
    setId(ID);
    header = new MainHeader(application);
    content = new MainContent(application);
    VBox.setVgrow(header, Priority.NEVER);
    VBox.setVgrow(content, Priority.ALWAYS);
    getChildren().addAll(menuBar, header, content);
  }

  /**
   * Gets the header.
   *
   * @return the header.
   */
  public MainHeader getHeader() {
    return header;
  }

  /**
   * Gets the content.
   *
   * @return the content.
   */
  public MainContent getContent() {
    return content;
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T extends Node> T findNodeById(String nodeId) {
    return (T) lookup('#' + nodeId);
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends Node> T findNodeByClass(String nodeClass) {
    return (T) lookup('.' + nodeClass);
  }
}
