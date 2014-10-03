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
package com.github.haixing_hu.ilibrary.gui;

import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.SplitPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.gui.authors.AuthorsNavigatorPanel;
import com.github.haixing_hu.ilibrary.gui.document.DocumentContentPanel;
import com.github.haixing_hu.ilibrary.gui.document.DocumentInspectorPanel;
import com.github.haixing_hu.ilibrary.gui.library.LibraryNavigatorPanel;
import com.github.haixing_hu.ilibrary.gui.reader.ReaderContentPanel;
import com.github.haixing_hu.ilibrary.gui.search.SearchContentPanel;
import com.github.haixing_hu.ilibrary.gui.search.SearchInspectorPanel;
import com.github.haixing_hu.ilibrary.gui.search.SearchNavigatorPanel;
import com.github.haixing_hu.ilibrary.gui.sources.SourcesNavigatorPanel;
import com.github.haixing_hu.ilibrary.gui.tags.TagsNavigatorPanel;
import com.github.haixing_hu.ilibrary.state.InspectorTab;
import com.github.haixing_hu.ilibrary.state.Page;
import com.github.haixing_hu.javafx.pane.CardPane;
import com.github.haixing_hu.javafx.pane.SplitPaneEx;

/**
 * The content area of the main window.
 *
 * @author Haixing Hu
 */
public class MainContent extends SplitPaneEx implements NodeLookup {

  public static final String ID = "main-content";

  public static final String LEFT_PANE_CLASS = "left-panel";

  private final Logger logger;
  private final Application application;
  private final CardPane oneColumnPane;
  private final SplitPaneEx twoColumnPane;
  private final CardPane leftPane;
  private final CardPane navigators;
  private final CardPane contents;
  private final CardPane inspectors;

  public MainContent(final Application application) {
    super();
    logger = LoggerFactory.getLogger(MainWindow.class);
    logger.trace("Craeting {}", MainWindow.class);
    setId(ID);
    setOrientation(Orientation.HORIZONTAL);

    this.application = application;
    oneColumnPane = new CardPane();
    twoColumnPane = new SplitPaneEx();
    leftPane = new CardPane();
    navigators = new CardPane();
    contents = new CardPane();
    inspectors = new CardPane();

    navigators.getStyleClass().add(NavigatorPanel.STYLE_CLASS);
    contents.getStyleClass().add(ContentPanel.STYLE_CLASS);
    inspectors.getStyleClass().add(InspectorPanel.STYLE_CLASS);
    leftPane.getStyleClass().add(LEFT_PANE_CLASS);

    SplitPane.setResizableWithParent(leftPane, true);
    SplitPane.setResizableWithParent(inspectors, false);

    getItems().addAll(leftPane, inspectors);
    setDividerPositions(0.8); //  FIXME

    createNavigators();
    createContents();
    createInspectors();
    configLeftPane();
  }

  private void createNavigators() {
    final NavigatorPanel search = new SearchNavigatorPanel(application);
    final NavigatorPanel library = new LibraryNavigatorPanel(application);
    final NavigatorPanel tags = new TagsNavigatorPanel(application);
    final NavigatorPanel authors = new AuthorsNavigatorPanel(application);
    final NavigatorPanel sources = new SourcesNavigatorPanel(application);
    navigators.addAllCards(search, library, tags, authors, sources);
//    navigators.setPrefHeight(Region.USE_COMPUTED_SIZE);
//    navigators.setPrefWidth(Region.USE_COMPUTED_SIZE);
  }

  private void createContents() {
    final ContentPanel search = new SearchContentPanel(application);
    final ContentPanel library = new DocumentContentPanel(application, Page.LIBRARY);
    final ContentPanel tags = new DocumentContentPanel(application, Page.TAGS);
    final ContentPanel authors = new DocumentContentPanel(application, Page.AUTHORS);
    final ContentPanel sources = new DocumentContentPanel(application, Page.SOURCES);
    contents.addAllCards(search, library, tags, authors, sources);
  }

  private void createInspectors() {
    final InspectorPanel search = new SearchInspectorPanel(application);
    final InspectorPanel library = new DocumentInspectorPanel(application, Page.LIBRARY);
    final InspectorPanel tags = new DocumentInspectorPanel(application, Page.TAGS);
    final InspectorPanel authors = new DocumentInspectorPanel(application, Page.AUTHORS);
    final InspectorPanel sources = new DocumentInspectorPanel(application, Page.SOURCES);
    final InspectorPanel reader = new DocumentInspectorPanel(application, Page.READER);
    inspectors.addAllCards(search, library, tags, authors, sources, reader);
  }

  private void configLeftPane() {
    oneColumnPane.addCard(new ReaderContentPanel(application));
    SplitPane.setResizableWithParent(navigators, false);
    SplitPane.setResizableWithParent(contents, true);
    twoColumnPane.getItems().addAll(navigators, contents);
    twoColumnPane.setDividerPositions(0.25);  //  FIXME
    leftPane.addAllCards(oneColumnPane, twoColumnPane);
  }


  public void setNavigatorVisible(boolean visible) {
    twoColumnPane.setItemVisible(0, visible);
  }

  public void setInspectorVisible(boolean visible) {
    setItemVisible(1, visible);
  }

  public void switchToPage(Page page) {
    logger.trace("Swtich to page {}", page);
    switch (page) {
      case READER:
        leftPane.showCard(0);
        inspectors.showCard(page.ordinal());
        break;
      default:
        leftPane.showCard(1);
        navigators.showCard(page.ordinal());
        contents.showCard(page.ordinal());
        inspectors.showCard(page.ordinal());
        break;
    }
  }

  public void swtichToInspectorTab(InspectorTab tab) {
    logger.trace("Swtich to inspector tab {}", tab);
    final int n = inspectors.size();
    for (int i = 0; i < n; ++i) {
      final InspectorPanel panel = (InspectorPanel) inspectors.getCard(i);
      panel.switchToTab(tab);
    }
  }


  @SuppressWarnings("unchecked")
  @Override
  public <T extends Node> T findNodeById(String nodeId) {
    return (T) lookup('#' + nodeId);
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends Node> T findNodeByClass(String nodeClass) {
    return (T) lookup('.' + nodeClass);
  }
}
