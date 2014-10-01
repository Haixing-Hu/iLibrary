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
package com.github.haixing_hu.ilibrary.gui2;

import javafx.scene.control.Control;
import javafx.scene.layout.StackPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.Application2;
import com.github.haixing_hu.ilibrary.gui2.page.AuthorsTabPage;
import com.github.haixing_hu.ilibrary.gui2.page.LibraryTabPage;
import com.github.haixing_hu.ilibrary.gui2.page.ReaderTabPage;
import com.github.haixing_hu.ilibrary.gui2.page.SearchTabPage;
import com.github.haixing_hu.ilibrary.gui2.page.SourcesTabPage;
import com.github.haixing_hu.ilibrary.gui2.page.TagsTabPage;
import com.github.haixing_hu.ilibrary.state.Page;

/**
 * The content eara of the main window.
 *
 * @author Haixing Hu
 */
public class MainContent extends StackPane {

  public static final String ID = "main-content";

  private final Logger logger;
  private final Control[] pages;

  public MainContent(final Application2 application) {
    super();
    logger = LoggerFactory.getLogger(MainWindow.class);
    logger.trace("Craeting {}", MainWindow.class);
    setId(ID);
    pages = new Control[Page.TOTAL];
    pages[Page.SEARCH.ordinal()] = new SearchTabPage(application);
    pages[Page.LIBRARY.ordinal()] = new LibraryTabPage(application);
    pages[Page.TAGS.ordinal()] = new TagsTabPage(application);
    pages[Page.AUTHORS.ordinal()] = new AuthorsTabPage(application);
    pages[Page.SOURCES.ordinal()] = new SourcesTabPage(application);
    pages[Page.READER.ordinal()] = new ReaderTabPage(application);
    for (final Control page : pages) {
      getChildren().add(page);
    }
  }

  public void switchToPage(Page page) {
    logger.trace("Swtich to page {}",page);
    pages[page.ordinal()].toFront();
  }
}
