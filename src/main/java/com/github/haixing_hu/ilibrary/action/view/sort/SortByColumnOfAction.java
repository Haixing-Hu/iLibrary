/*
 * Copyright (c) 2014  Haixing Hu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.github.haixing_hu.ilibrary.action.view.sort;

import javafx.event.ActionEvent;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.action.BaseAction;
import com.github.haixing_hu.ilibrary.action.view.columns.ColumnOfAction;
import com.github.haixing_hu.ilibrary.action.view.columns.SelectColumnsAction;
import com.github.haixing_hu.ilibrary.model.Column;
import com.github.haixing_hu.lang.EnumUtils;

/**
 * The action to select a sorting column.
 *
 * @author Haixing Hu
 */
public class SortByColumnOfAction extends BaseAction {

  private final Column column;

  /**
   * Constructs a {@link SortByColumnOfAction}.
   * <p>
   * <b>NOTE:</b> the ID of the new action is the ID of the
   * {@link SelectColumnsAction} action concatenate to a dot and the short name of the
   * enumerator representing the column. For example, if the column is
   * {@link Column#CITE_KEY}, the ID of the new action is
   * {@code {@link SelectColumnsAction#KEY} + ".cite-key"}.
   * <p>
   * A short name of an {@link Enum} value comes from lowercase the enumeration
   * name of the {@link Enum} value and replacing all '_' with '-'.
   *
   * @param column
   *          the column as the sorting key.
   * @param application
   *          the application.
   */
  public SortByColumnOfAction( Column column, Application application) {
    super(getActionId(column), getTitle(application, column), application, TOGGLE);
    this.column = column;
    logger.debug("Create a SortByColumnAction '{}' for column {}.",
        getId(), column);
  }

  private static String getTitle(Application application, Column column) {
    final AppConfig config = application.getConfig();
    final String selectColumnActionId = ColumnOfAction.getActionId(column);
    return config.getTitle(selectColumnActionId);
  }

  /**
   * Gets the ID of the {@link SortByColumnOfAction} for a column.
   *
   * @param column
   *          a column.
   * @return the ID of the {@link SortByColumnOfAction} for the column.
   */
  public static String getActionId(Column column) {
    final StringBuilder builder = new StringBuilder();
    builder.append(SortAction.ID)
           .append(KeySuffix.COLUMN)
           .append('.')
           .append(EnumUtils.getShortName(column));
    return builder.toString();
  }

  /**
   * Gets the sorting column.
   *
   * @return the sorting column.
   */
  public Column getColumn() {
    return column;
  }

  @Override
  public void handle(ActionEvent event) {
    application.getExplorerController().setSortColumn(column);
  }
}
