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
package com.github.haixing_hu.ilibrary.gui.document;

import javafx.geometry.Orientation;
import javafx.scene.control.ButtonBase;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.file.PrintAction;
import com.github.haixing_hu.ilibrary.action.share.ShareAction;
import com.github.haixing_hu.ilibrary.action.view.HidePreviewAction;
import com.github.haixing_hu.ilibrary.action.view.ShowInspectorAction;
import com.github.haixing_hu.ilibrary.action.view.ShowNavigatorAction;
import com.github.haixing_hu.ilibrary.action.view.ShowPreviewAction;
import com.github.haixing_hu.ilibrary.action.view.browse.BrowseModeAction;
import com.github.haixing_hu.ilibrary.action.view.columns.SelectColumnsAction;
import com.github.haixing_hu.ilibrary.action.view.filter.SetFiltersAction;
import com.github.haixing_hu.ilibrary.action.view.sort.SortAction;
import com.github.haixing_hu.ilibrary.gui.ContentPanel;
import com.github.haixing_hu.ilibrary.gui.preview.PreviewPanel;
import com.github.haixing_hu.ilibrary.state.Page;
import com.github.haixing_hu.javafx.action.ActionManager;
import com.github.haixing_hu.javafx.pane.SplitPaneEx;

/**
 * The document explorer content panel.
 *
 * @author Haixing Hu
 */
public class DocumentContentPanel extends ContentPanel {

  private static final int PREVIEW_INDEX = 1;

  protected final DocumentExplorerPanel explorer;
  protected final PreviewPanel preview;

  public DocumentContentPanel(final Application application, Page page) {
    super(application, page);
    explorer = new DocumentExplorerPanel(application, page);
    preview = new PreviewPanel(application);
    init();
  }

  @Override
  protected Region createContent() {
    return new SplitPaneEx();
  }

  @Override
  protected void configHeader() {
    final ActionManager am = application.getActionManager();
    final ButtonBase browserMode = am.createButton(BrowseModeAction.ID);
    final ButtonBase filter = am.createButton(SetFiltersAction.ID);
    final ButtonBase columns = am.createButton(SelectColumnsAction.ID);
    final ButtonBase sort = am.createButton(SortAction.ID);
    header.getChildren().addAll(browserMode, filter, columns, sort);
  }

  @Override
  protected void configContent() {
    final SplitPaneEx pane = (SplitPaneEx) content;
    pane.setOrientation(Orientation.VERTICAL);
    pane.getItems().addAll(explorer, preview);
    pane.setDividerPositions(0.65);
  }

  @Override
  protected void configFooterLeftToolBar(HBox toolBar) {
    final ActionManager am = application.getActionManager();
    final ButtonBase showNavigator = am.createButton(ShowNavigatorAction.ID);
    final ButtonBase showPreview = am.createButton(ShowPreviewAction.ID);
    final ButtonBase hidePreview = am.createButton(HidePreviewAction.ID);
//    final ButtonBase markFlagged = am.createButton(MarkFlaggedAction.ID);
//    final ButtonBase markUnflagged = am.createButton(MarkUnflaggedAction.ID);
//    final ButtonBase editKeywords = am.createButton(EditKeywordsAction.ID);
//    final ButtonBase attachFile = am.createButton(AttachFileAction.ID);
    toolBar.getChildren().addAll(showNavigator, showPreview, hidePreview);
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
    final SplitPaneEx pane = (SplitPaneEx) content;
    pane.setItemVisible(PREVIEW_INDEX, visible);
  }
}
