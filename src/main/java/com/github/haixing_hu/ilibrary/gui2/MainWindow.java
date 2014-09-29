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
package com.github.haixing_hu.ilibrary.gui2;

import com.github.haixing_hu.ilibrary.AppConfig;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * The scene representing the main window of the application.
 *
 * @author Haixing Hu
 */
public class MainWindow extends VBox {

  public static final String ID = "window";

  public static final String STYLE_CLASS = "main-window";

  private final MainHeader header;
  private final MainContent content;

  public MainWindow(final AppConfig config) {
    super();
    this.setId("main-window");

    header = new MainHeader(config);
    content = new MainContent(config);
    VBox.setVgrow(header, Priority.NEVER);
    VBox.setVgrow(content, Priority.ALWAYS);
    this.getChildren().addAll(header, content);
  }

  public MainHeader getHeader() {
    return header;
  }

  public MainContent getContent() {
    return content;
  }

}
