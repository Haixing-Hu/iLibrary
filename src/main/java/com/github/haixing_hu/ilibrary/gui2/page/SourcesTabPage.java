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
package com.github.haixing_hu.ilibrary.gui2.page;

import javafx.scene.control.SplitPane;
import javafx.scene.control.TreeView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.Application2;
import com.github.haixing_hu.ilibrary.gui2.DocumentInspectorPanel;
import com.github.haixing_hu.ilibrary.gui2.InspectorPanel;
import com.github.haixing_hu.ilibrary.gui2.NavigatorPanel;
import com.github.haixing_hu.ilibrary.gui2.WorkingPanel;
import com.github.haixing_hu.ilibrary.state.Page;

/**
 * The tab page for the sources module.
 *
 * @author Haixing Hu
 */
public class SourcesTabPage extends SplitPane {

  public static final String ID = "sources-tab-page";

  public SourcesTabPage(final Application2 application) {
    final Logger logger = LoggerFactory.getLogger(SourcesTabPage.class);
    logger.trace("Creating {}", SourcesTabPage.class);
    setId(ID);
    final NavigatorPanel navigator = new NavigatorPanel(application,
        Page.SOURCES, new TreeView<String>());
    final WorkingPanel workArea = new WorkingPanel(application);
    final InspectorPanel inspector = new DocumentInspectorPanel(application);
    getItems().addAll(navigator, workArea, inspector);
    // FIXME: How to set the divider positions in CSS?
    setDividerPositions(0.2, 0.8);
  }
}
