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
package com.github.haixing_hu.ilibrary.gui2.search;

import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import com.github.haixing_hu.ilibrary.Application2;
import com.github.haixing_hu.ilibrary.gui2.InspectorPanel;

/**
 * The inspector panel for searching result.
 *
 * @author Haixing Hu
 */
public class SearchResultInspectorPanel extends InspectorPanel {

  public SearchResultInspectorPanel(Application2 application) {
    super(application);
  }

  @Override
  protected void addHeaderButtons(Application2 application, HBox header) {
    final ToggleButton overviewButton = new ToggleButton();
    overviewButton.setId(OVERVIEW_BUTTON_ID);
    header.getChildren().add(overviewButton);

    final ToggleButton infoButton = new ToggleButton();
    infoButton.setId(INFO_BUTTON_ID);
    header.getChildren().add(infoButton);

    final ToggleButton reviewsButton = new ToggleButton();
    reviewsButton.setId(REVIEWS_BUTTON_ID);
    header.getChildren().add(reviewsButton);
  }

  @Override
  protected void addContentPages(Application2 application, StackPane content) {
    // TODO Auto-generated method stub

  }

}
