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

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.gui.ContentPanel;
import com.github.haixing_hu.ilibrary.state.Page;


/**
 * The document explorer content panel.
 *
 * @author Haixing Hu
 */
public class DocumentContentPanel extends ContentPanel {

  public DocumentContentPanel(final Application application, Page page) {
    super(application, page);
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
    content.getChildren().add(new Label(page.name()));
  }

  @Override
  protected void configFooter() {
    // TODO Auto-generated method stub

  }
}
