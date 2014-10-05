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
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.StyleClass;
import com.github.haixing_hu.ilibrary.action.view.filter.TypeFilterAction;
import com.github.haixing_hu.ilibrary.action.view.filter.TypeFilterAllAction;
import com.github.haixing_hu.ilibrary.action.view.filter.TypeFilterOfAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FileFilterAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FileFilterAllAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FileFilterHasFileAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FileFilterNoFileAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FlagFilterAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FlagFilterAllAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FlagFilterFlaggedAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FlagFilterUnflaggedAction;
import com.github.haixing_hu.ilibrary.action.view.filter.StatusFilterAction;
import com.github.haixing_hu.ilibrary.action.view.filter.StatusFilterAllAction;
import com.github.haixing_hu.ilibrary.action.view.filter.StatusFilterHasReadAction;
import com.github.haixing_hu.ilibrary.action.view.filter.StatusFilterReadingAction;
import com.github.haixing_hu.ilibrary.action.view.filter.StatusFilterToReadAction;
import com.github.haixing_hu.ilibrary.action.view.filter.StatusFilterUnreadAction;
import com.github.haixing_hu.ilibrary.action.view.filter.SetFiltersAction;
import com.github.haixing_hu.ilibrary.gui.BasicPopOver;
import com.github.haixing_hu.ilibrary.model.DocumentType;
import com.github.haixing_hu.javafx.action.ActionManager;
import com.github.haixing_hu.javafx.control.popover.ArrowLocation;

/**
 * The pop over window for setting the document filters.
 *
 * @author Haixing Hu
 */
public class SetFiltersPopOver extends BasicPopOver {

  public static final String ID = "popover.set-filters";

  public SetFiltersPopOver(Application application) {
    super(application);
    setArrowLocation(ArrowLocation.TOP_CENTER);
  }

  @Override
  protected Node createContent() {
    final AppConfig config = application.getConfig();
    final GridPane pane = new GridPane();
    pane.getStyleClass().add(StyleClass.CONTENT);
    pane.setVgap(config.getInt(ID + KeySuffix.VERTICAL_SPACING));
    pane.setHgap(config.getInt(ID + KeySuffix.HORIZONTAL_SPACING));
    final int totalColumns = config.getInt(ID + KeySuffix.COLUMNS);
    final String title = config.getTitle(SetFiltersAction.ID);
    setTitle(title);

    int row = 0;
    row = addFlagFilterActions(pane, row, totalColumns);
    ++row;
    row = addReadFilterActions(pane, row, totalColumns);
    ++row;
    row = addFileFilterActions(pane, row, totalColumns);
    ++row;
    row = addTypeFilterActions(pane, row, totalColumns);
    return pane;
  }

  private int addFlagFilterActions(GridPane pane, int row, int totalColumns) {
    final ActionManager am = application.getActionManager();
    final Label title = new Label();
    title.setText(am.getText(FlagFilterAction.ID));
    title.getStyleClass().add(StyleClass.TITLE);
    pane.add(title, 0, row++, totalColumns, 1);
    pane.add(new Separator(), 0, row++, totalColumns, 1);

    pane.add(am.createButton(FlagFilterAllAction.ID),
            (0 % totalColumns), (0 / totalColumns) + row);
    pane.add(am.createButton(FlagFilterFlaggedAction.ID),
            (1 % totalColumns), (1 / totalColumns) + row);
    pane.add(am.createButton(FlagFilterUnflaggedAction.ID),
            (2 % totalColumns), (2 / totalColumns) + row);
    row += (3 + (totalColumns - 1)) / totalColumns;
    return row;
  }

  private int addReadFilterActions(GridPane pane, int row, int totalColumns) {
    final ActionManager am = application.getActionManager();
    final Label title = new Label();
    title.setText(am.getText(StatusFilterAction.ID));
    title.getStyleClass().add(StyleClass.TITLE);
    pane.add(title, 0, row++, totalColumns, 1);
    pane.add(new Separator(), 0, row++, totalColumns, 1);

    pane.add(am.createButton(StatusFilterAllAction.ID),
            (0 % totalColumns), (0 / totalColumns) + row);
    pane.add(am.createButton(StatusFilterUnreadAction.ID),
            (1 % totalColumns), (1 / totalColumns) + row);
    pane.add(am.createButton(StatusFilterToReadAction.ID),
            (2 % totalColumns), (2 / totalColumns) + row);
    pane.add(am.createButton(StatusFilterReadingAction.ID),
            (3 % totalColumns), (3 / totalColumns) + row);
    pane.add(am.createButton(StatusFilterHasReadAction.ID),
            (4 % totalColumns), (4 / totalColumns) + row);
    row += (5 + (totalColumns - 1)) / totalColumns;
    return row;
  }

  private int addFileFilterActions(GridPane pane, int row, int totalColumns) {
    final ActionManager am = application.getActionManager();
    final Label title = new Label();
    title.setText(am.getText(FileFilterAction.ID));
    title.getStyleClass().add(StyleClass.TITLE);
    pane.add(title, 0, row++, totalColumns, 1);
    pane.add(new Separator(), 0, row++, totalColumns, 1);

    pane.add(am.createButton(FileFilterAllAction.ID),
            (0 % totalColumns), (0 / totalColumns) + row);
    pane.add(am.createButton(FileFilterHasFileAction.ID),
            (1 % totalColumns), (1 / totalColumns) + row);
    pane.add(am.createButton(FileFilterNoFileAction.ID),
            (2 % totalColumns), (2 / totalColumns) + row);
    row += (3 + (totalColumns - 1)) / totalColumns;
    return row;
  }

  private int addTypeFilterActions(GridPane pane, int row, int totalColumns) {
    final ActionManager am = application.getActionManager();
    final Label title = new Label();
    title.setText(am.getText(TypeFilterAction.ID));
    title.getStyleClass().add(StyleClass.TITLE);
    pane.add(title, 0, row++, totalColumns, 1);
    pane.add(new Separator(), 0, row++, totalColumns, 1);

    pane.add(am.createButton(TypeFilterAllAction.ID),
            (0 % totalColumns), (0 / totalColumns) + row);
    final DocumentType[] types = DocumentType.values();
    for (int i = 0; i < types.length; ++i) {
      final String actionId = TypeFilterOfAction.getActionId(types[i]);
      pane.add(am.createButton(actionId),
               ((i + 1) % totalColumns),
               ((i + 1) / totalColumns) + row);
    }
    row += (types.length + 1 + (totalColumns - 1)) / totalColumns;
    return row;
  }
}
