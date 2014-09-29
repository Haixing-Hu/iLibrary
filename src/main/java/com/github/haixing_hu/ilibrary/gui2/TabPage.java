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

import javafx.scene.Parent;
import javafx.scene.control.SplitPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.Application2;
import com.github.haixing_hu.ilibrary.gui2.inspector.InspectorPanel;
import com.github.haixing_hu.ilibrary.gui2.navigator.NavigatorPanel;
import com.github.haixing_hu.ilibrary.gui2.work.WorkingPanel;

/**
 * The class of tab pages for each module.
 *
 * @author starfish
 */
public class TabPage extends SplitPane {

  public static final String STYLE_CLASS = "tab-page";

  protected final Logger logger;
  protected final NavigatorPanel navigator;
  protected final WorkingPanel workArea;
  protected final InspectorPanel inspector;

  public TabPage(final Application2 application, NavigatorPanel navigator,
          WorkingPanel workArea, InspectorPanel inspector) {
    super();
    final Class<?> cls = getClass();
    logger = LoggerFactory.getLogger(cls);
    logger.trace("Creating {}", cls);
    getStyleClass().add(STYLE_CLASS);
    this.navigator = navigator;
    this.workArea = workArea;
    this.inspector = inspector;
    getItems().addAll(navigator, workArea, inspector);
    //  FIXME: How to set the divider positions in CSS?
    setDividerPositions(0.2, 0.8);
  }

  public NavigatorPanel getNavigator() {
    return navigator;
  }

  public Parent getWorkArea() {
    return workArea;
  }

  public InspectorPanel getInspector() {
    return inspector;
  }

  /**
   * Sets the width of the navigator panel.
   *
   * @param width the new width to be set. If it is non-positive, the function
   * will hide the navigator panel.
   */
  public void hideNavigator(int width) {
    //  do nothing
  }

  /**
   * Sets the width of the inspector panel.
   *
   * @param width the new width to be set. If it is non-positive, the function
   * will hide the inspector panel.
   */
  public void setInspectorWidth(int width) {
    //  do nothing
  }
}
