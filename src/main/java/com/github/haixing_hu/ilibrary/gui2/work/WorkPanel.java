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
package com.github.haixing_hu.ilibrary.gui2.work;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.gui.MainWindow;
import javafx.scene.layout.VBox;

/**
 * The library panel.
 *
 * @author Haixing Hu
 */
public class WorkPanel extends VBox {

  public static final String ID = MainWindow.ID + ".work";

  public static final String STYLE_CLASS = "work";

  public WorkPanel(final AppConfig config) {
    super();
    this.getStyleClass().add("work-area");

    /*
    final int defaultWidth = config.getInt(ID + DEFAULT_WIDTH);
    final int minWidth = config.getInt(ID + MIN_WIDTH);
    this.setPrefWidth(defaultWidth);
    this.setMinWidth(minWidth);
    */
  }
}
