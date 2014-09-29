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

import javafx.scene.control.TreeView;

import com.github.haixing_hu.ilibrary.Application2;
import com.github.haixing_hu.ilibrary.gui2.inspector.InspectorPanel;
import com.github.haixing_hu.ilibrary.gui2.navigator.NavigatorPanel;
import com.github.haixing_hu.ilibrary.gui2.work.WorkingPanel;
import com.github.haixing_hu.ilibrary.state.Page;

/**
 * The tab page for the reader module.
 *
 * @author starfish
 */
public class ReaderTabPage extends TabPage {

  public static final String ID = "reader-tab-page";

  public ReaderTabPage(final Application2 application) {
    super(application,
          new NavigatorPanel(application, Page.READER, new TreeView<String>()),
          new WorkingPanel(application),
          new InspectorPanel(application));
    this.setId(ID);
    //  TODO
  }
}
