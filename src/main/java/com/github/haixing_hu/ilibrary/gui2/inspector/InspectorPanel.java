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
package com.github.haixing_hu.ilibrary.gui2.inspector;

import javafx.scene.layout.VBox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.Application2;

/**
 * The inspector panel.
 *
 * @author Haixing Hu
 */
public class InspectorPanel extends VBox {

  public static final String STYLE_CLASS = "inspector-panel";

  private final Logger logger;

  public InspectorPanel(final Application2 application) {
    super();
    logger = LoggerFactory.getLogger(InspectorPanel.class);
    logger.trace("Craeting {}", InspectorPanel.class);
    getStyleClass().add(STYLE_CLASS);

    //  TODO
  }
}
