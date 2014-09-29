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
package com.github.haixing_hu.ilibrary.control;
import javafx.scene.control.ToggleButton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.Application2;
import com.github.haixing_hu.ilibrary.gui2.MainContent;
import com.github.haixing_hu.ilibrary.gui2.MainHeader;
import com.github.haixing_hu.ilibrary.state.ApplicationState;
import com.github.haixing_hu.ilibrary.state.Page;
import com.github.haixing_hu.lang.EnumUtils;

/**
 * The controler used to control the document exploring related busyness logic.
 *
 * @author starfish
 */
public class ExplorerController {

  private final Application2 application;
  private final Logger logger;


  public ExplorerController(final Application2 application) {
    this.application = application;
    logger = LoggerFactory.getLogger(ExplorerController.class);
  }

  public void setPage(Page page) {
    final ApplicationState state = application.getState();
    if (state.getPage() == page) {
      return;
    }
    logger.info("Switch to page: {}", page);
    state.setPage(page);
    updatePage();
  }

  public void updatePage() {
    final ToggleButton[] buttons = new ToggleButton[Page.TOTAL];
    final Page[] pages = Page.values();
    for (int i = 0; i < Page.TOTAL; ++i) {
      final String pageId = EnumUtils.getShortName(pages[i]);
      final String buttonId = pageId + MainHeader.BUTTON_ID_SUFFIX;
      buttons[i] = application.findNode(buttonId);
      buttons[i].setSelected(false);
    }
    final ApplicationState state = application.getState();
    final Page page = state.getPage();
    buttons[page.ordinal()].setSelected(true);
    final MainContent mainContent = application.findNode(MainContent.ID);
    mainContent.switchToPage(page);
  }
}
