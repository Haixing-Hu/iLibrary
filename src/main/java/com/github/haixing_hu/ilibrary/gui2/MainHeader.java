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

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application2;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.control.ExplorerController;
import com.github.haixing_hu.ilibrary.state.Page;
import com.github.haixing_hu.lang.EnumUtils;

/**
 * The header of the main window. 
 *
 * @author Haixing Hu
 */
public class MainHeader extends HBox implements KeySuffix {

  public static final String ID = "main-header";

  public static final String TOOLBAR_ID = "main-toolbar";

  public static final String BUTTON_ID_SUFFIX = "-tab-button";

  private final Logger logger;
  private final ToggleButton buttons[];

  public MainHeader(final Application2 application) {
    super();
    logger = LoggerFactory.getLogger(MainHeader.class);
    logger.trace("Craeting {}", MainHeader.class);
    setId(ID);
    final ObservableList<Node> children = getChildren();
    final Page[] pages = Page.values();
    buttons = new ToggleButton[pages.length];
    for (int i = 0; i < pages.length; ++i) {
      buttons[i] = createButton(application, pages[i]);
      children.add(buttons[i]);
    }
  }

  private ToggleButton createButton(final Application2 application, final Page page) {
    logger.trace("Creating page tab button for page {}", page);
    final ToggleButton button = new ToggleButton();
    final String pageId = EnumUtils.getShortName(page);
    button.setId(pageId + BUTTON_ID_SUFFIX);
    final AppConfig config = application.getConfig();
    final String pageTitle = config.getMessage(pageId + TITLE);
    button.setTooltip(new Tooltip(pageTitle));
    final ExplorerController controller = application.getExplorerControler();
    button.setOnAction(new EventHandler<ActionEvent>(){
      @Override
      public void handle(ActionEvent actionEvent) {
        controller.setPage(page);
      }
    });
    return button;
  }
}
