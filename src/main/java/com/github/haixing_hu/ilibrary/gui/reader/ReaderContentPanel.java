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

import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.edit.annotation.AnnotateHighlightAction;
import com.github.haixing_hu.ilibrary.action.edit.annotation.AnnotateNoteAction;
import com.github.haixing_hu.ilibrary.action.edit.annotation.AnnotateStrikethroughAction;
import com.github.haixing_hu.ilibrary.action.edit.annotation.AnnotateUnderlineAction;
import com.github.haixing_hu.ilibrary.action.file.PrintAction;
import com.github.haixing_hu.ilibrary.action.share.ShareAction;
import com.github.haixing_hu.ilibrary.action.view.ShowInspectorAction;
import com.github.haixing_hu.ilibrary.gui.ContentPanel;
import com.github.haixing_hu.ilibrary.state.Page;
import com.github.haixing_hu.javafx.action.ActionManager;

/**
 * The content panel of reader.
 *
 * @author Haixing Hu
 */
public class ReaderContentPanel extends ContentPanel {

  public ReaderContentPanel(Application application) {
    super(application, Page.READER);
    init();
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
    ((Pane) content).getChildren().add(new Label(Page.READER.name()));
  }

  @Override
  protected void configFooterLeftToolBar(HBox toolBar) {
    final ActionManager am = application.getActionManager();
    final ButtonBase createNote = am.createButton(AnnotateNoteAction.ID);
    final ButtonBase highlight = am.createButton(AnnotateHighlightAction.ID);
    final ButtonBase underline = am.createButton(AnnotateUnderlineAction.ID);
    final ButtonBase strikethrough = am.createButton(AnnotateStrikethroughAction.ID);
    toolBar.getChildren().addAll(createNote, highlight, underline, strikethrough);
  }

  @Override
  protected void configFooterRightToolBar(HBox toolBar) {
    final ActionManager am = application.getActionManager();
    final ButtonBase print = am.createButton(PrintAction.ID);
    final ButtonBase share = am.createButton(ShareAction.ID);
    final ButtonBase showInspector = am.createButton(ShowInspectorAction.ID);
    toolBar.getChildren().addAll(print, share, showInspector);
  }

  @Override
  public void setPreviewVisible(boolean visible) {
    //  do nothing
  }
}
