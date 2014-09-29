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
import com.github.haixing_hu.ilibrary.gui2.inspector.InspectorPanel;
import com.github.haixing_hu.ilibrary.gui2.navigator.NavigatorPanel;
import com.github.haixing_hu.ilibrary.gui2.work.WorkPanel;
import javafx.scene.Parent;
import javafx.scene.control.SplitPane;

/**
 * The class of tab pages for each module.
 *
 * @author starfish
 */
public class TabPage extends SplitPane {

  private final NavigatorPanel navigator;
  private final WorkPanel workArea;
  private final InspectorPanel inspector;

  public TabPage(final AppConfig config, NavigatorPanel navigator,
          WorkPanel workArea, InspectorPanel inspector) {
    super();
    this.navigator = navigator;
    this.workArea = workArea;
    this.inspector = inspector;
    this.getItems().addAll(navigator, workArea, inspector);
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
  public void setNavigatorWidth(int width) {
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
