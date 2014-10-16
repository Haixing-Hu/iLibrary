/******************************************************************************
 *
 * Copyright (c) 2014  Haixing Hu
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Haixing Hu (https://github.com/Haixing-Hu/) - Initial implementation and API.
 *
 ******************************************************************************/

package com.github.haixing_hu.ilibrary.gui.document;

import javafx.scene.Node;
import javafx.scene.control.ButtonBase;
import javafx.scene.layout.GridPane;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.StyleClass;
import com.github.haixing_hu.ilibrary.action.view.columns.ColumnOfAction;
import com.github.haixing_hu.ilibrary.action.view.columns.SelectColumnsAction;
import com.github.haixing_hu.ilibrary.gui.BasicPopOver;
import com.github.haixing_hu.ilibrary.model.Column;
import com.github.haixing_hu.javafx.action.ActionManager;
import com.github.haixing_hu.javafx.control.popover.ArrowLocation;

/**
 * The pop over window used to select the columns to display.
 *
 * @author Haixing Hu
 */
public class SelectColumnsPopOver extends BasicPopOver {

  public static final String ID = "popover.select-columns";

  public SelectColumnsPopOver(Application application) {
    super(application);
    setArrowLocation(ArrowLocation.TOP_CENTER);
  }

  @Override
  protected Node createContent() {
    final AppConfig config = application.getConfig();
    final ActionManager am = application.getActionManager();
    final GridPane pane = new GridPane();
    pane.getStyleClass().add(StyleClass.CONTENT);
    pane.setVgap(config.getInt(ID + KeySuffix.VERTICAL_SPACING));
    pane.setHgap(config.getInt(ID + KeySuffix.HORIZONTAL_SPACING));
    final int totalColumns = config.getInt(ID + KeySuffix.COLUMNS);

    final String title = config.getTitle(SelectColumnsAction.ID);
    setTitle(title);

    final int row = 0;
//    final Label title = new Label();
//    title.setText(config.getTitle(SelectColumnsAction.ID));
//    title.getStyleClass().add(StyleClass.TITLE);
//    pane.add(title, 0, row++, totalColumns, 1);
//
//    final Separator separator = new Separator();
//    pane.add(separator, 0, row++, totalColumns, 1);

    final Column[] types = Column.values();
    for (int i = 0; i < types.length; ++i) {
      final String actionId = ColumnOfAction.getActionId(types[i]);
      final ButtonBase button = am.createButton(actionId);
      pane.add(button, i % totalColumns, (i / totalColumns) + row);
    }
    return pane;
  }
}
