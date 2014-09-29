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

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.KeySuffix;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

/**
 * The header of the main window. 
 *
 * @author Haixing Hu
 */
public class MainHeader extends ToolBar implements KeySuffix {

  public static final String ID = MainWindow.ID + HEADER;

  public static final String STYLE_CLASS = "main-header";

  private final Button searchTab;
  private final Button libraryTab;
  private final Button tagsTab;
  private final Button authorsTab;
  private final Button sourcesTab;
  private final Button readerTab;

  public MainHeader(final AppConfig config) {
    super();
    this.setId("main-header");

    libraryTab = new Button();
    libraryTab.setId("library-tab-btn");
    searchTab = new Button();
    searchTab.setId("search-tab-btn");
    tagsTab = new Button();
    tagsTab.setId("tags-tab-btn");
    authorsTab = new Button();
    authorsTab.setId("authors-tab-btn");
    sourcesTab = new Button();
    sourcesTab.setId("sources-tab-btn");
    readerTab = new Button();
    readerTab.setId("reader-tab-btn");

    this.getItems().addAll(searchTab, libraryTab, tagsTab, authorsTab,
            sourcesTab, readerTab );

  }
}
