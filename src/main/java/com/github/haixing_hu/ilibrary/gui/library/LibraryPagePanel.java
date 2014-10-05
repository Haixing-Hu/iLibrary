/******************************************************************************
 *
 * Copyright (c) 2014  Haixing Hu
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Haixing Hu (https://github.com/Haixing-Hu/) - Initial implementation and API.
 *
 ******************************************************************************/

package com.github.haixing_hu.ilibrary.gui.library;

import javafx.scene.control.SplitPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.Application;

/**
 * The panel of the library.
 *
 * @author Haixing Hu
 */
public class LibraryPagePanel extends SplitPane {

  public static final String STYLE_CLASS = "library-panel";

  public LibraryPagePanel(Application application) {
    super();
    final Logger logger = LoggerFactory.getLogger(LibraryPagePanel.class);
    logger.trace("Craeting {}", LibraryPagePanel.class);
    getStyleClass().add(STYLE_CLASS);
  }
}
