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
