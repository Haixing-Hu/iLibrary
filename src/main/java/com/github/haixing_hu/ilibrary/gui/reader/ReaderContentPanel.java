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

package com.github.haixing_hu.ilibrary.gui.reader;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.gui.ContentPanel;
import com.github.haixing_hu.ilibrary.state.Page;

/**
 * The content panel of reader.
 *
 * @author Haixing Hu
 */
public class ReaderContentPanel extends ContentPanel {

  public ReaderContentPanel(Application application) {
    super(application, Page.READER);
  }

  @Override
  protected Pane createContent() {
    // TODO Auto-generated method stub
    return new Pane();
  }

  @Override
  protected void configHeader() {
    // TODO Auto-generated method stub
  }

  @Override
  protected void configContent() {
    // TODO Auto-generated method stub
    content.getChildren().add(new Label(Page.READER.name()));
  }

  @Override
  protected void configFooter() {
    // TODO Auto-generated method stub

  }
}
