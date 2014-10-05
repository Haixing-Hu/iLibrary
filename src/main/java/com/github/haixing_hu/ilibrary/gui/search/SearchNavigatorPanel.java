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

package com.github.haixing_hu.ilibrary.gui.search;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.gui.NavigatorPanel;
import com.github.haixing_hu.ilibrary.state.Page;

/**
 * The navigator panel for the search page.
 *
 * @author Haixing Hu
 */
public class SearchNavigatorPanel extends NavigatorPanel {

  public SearchNavigatorPanel(Application application) {
    super(application, Page.SEARCH);
  }

  @Override
  protected Pane createContent() {
    return new Pane();
  }

  @Override
  protected void configContent() {
    // TODO Auto-generated method stub
  }

  @Override
  protected void configFooterLeftToolBar(HBox toolBar) {
    // TODO Auto-generated method stub

  }
}
