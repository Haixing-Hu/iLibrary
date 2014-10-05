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

package com.github.haixing_hu.ilibrary.gui.document;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.state.BrowseMode;
import com.github.haixing_hu.ilibrary.state.Page;

/**
 * The list view of documents.
 *
 * @author Haixing Hu
 */
public class DocumentExplorerPanel extends Pane {

  public static final String STYLE_CLASS = "explorer-panel";

  private final Logger logger;
  private final Application application;

  public DocumentExplorerPanel(Application application, Page page) {
    logger = LoggerFactory.getLogger(DocumentExplorerPanel.class);
    this.application = application;
    getStyleClass().add(STYLE_CLASS);

    getChildren().add(new Label(page.name()));
  }

  public void setBrowseMode(BrowseMode mode) {
    logger.debug("Setting browse mode to: {}", mode);
    //  TODO
  }
}
