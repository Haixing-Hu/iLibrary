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

import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.share.ShareAction;
import com.github.haixing_hu.ilibrary.action.view.ShowInspectorAction;
import com.github.haixing_hu.ilibrary.action.view.ShowNavigatorAction;
import com.github.haixing_hu.ilibrary.gui.ContentPanel;
import com.github.haixing_hu.ilibrary.state.Page;
import com.github.haixing_hu.javafx.action.ActionManager;
import com.github.haixing_hu.javafx.control.textfield.SearchBox;

/**
 * The panel for the search page.
 *
 * @author Haixing Hu
 */
public class SearchContentPanel extends ContentPanel {

  public SearchContentPanel(Application application) {
    super(application, Page.SEARCH);
    configHeader();
    configContent();
    configFooter();
  }

  @Override
  protected Pane createContent() {
    // TODO Auto-generated method stub
    return new Pane();
  }

  @Override
  protected void configHeader() {
    final SearchBox search = new SearchBox();
    HBox.setHgrow(search, Priority.ALWAYS);
    header.getChildren().add(search);
  }

  @Override
  protected void configContent() {
    // TODO Auto-generated method stub
    ((Pane) content).getChildren().add(new Label("SEARCH"));
  }

  @Override
  protected void configFooterLeftToolBar(HBox toolBar) {
    final ActionManager am = application.getActionManager();
    final ButtonBase showNavigator = am.createButton(ShowNavigatorAction.ID);
    toolBar.getChildren().addAll(showNavigator);
  }

  @Override
  protected void configFooterRightToolBar(HBox toolBar) {
    final ActionManager am = application.getActionManager();
    final ButtonBase share = am.createButton(ShareAction.ID);
    final ButtonBase showInspector = am.createButton(ShowInspectorAction.ID);
    toolBar.getChildren().addAll(share, showInspector);
  }

  @Override
  public void setPreviewVisible(boolean visible) {
    //  do nothing
  }
}
