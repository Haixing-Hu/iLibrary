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

package com.github.haixing_hu.ilibrary.gui.sources;

import javafx.scene.control.ButtonBase;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.file.source.NewSourceAction;
import com.github.haixing_hu.ilibrary.action.library.source.ManageSourceAction;
import com.github.haixing_hu.ilibrary.gui.NavigatorPanel;
import com.github.haixing_hu.ilibrary.state.Page;
import com.github.haixing_hu.javafx.action.ActionManager;

/**
 * The navigator panel for the soruces page.
 *
 * @author Haixing Hu
 */
public class SourcesNavigatorPanel extends NavigatorPanel {

  public SourcesNavigatorPanel(Application application) {
    super(application, Page.SOURCES);
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
    final ActionManager am = application.getActionManager();
    final ButtonBase newSource = am.createButton(NewSourceAction.ID);
    final ButtonBase manageSource = am.createButton(ManageSourceAction.ID);
    toolBar.getChildren().addAll(newSource, manageSource);
  }
}
