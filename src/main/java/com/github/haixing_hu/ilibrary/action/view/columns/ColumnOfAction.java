/******************************************************************************
 *
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
 ******************************************************************************/

package com.github.haixing_hu.ilibrary.action.view.columns;

import javafx.event.ActionEvent;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseAction;
import com.github.haixing_hu.ilibrary.action.view.sort.SortByColumnOfAction;
import com.github.haixing_hu.ilibrary.model.FieldType;
import com.github.haixing_hu.lang.EnumUtils;

/**
 * The action to select or deselect a column.
 *
 * @author Haixing Hu
 */
public class ColumnOfAction extends BaseAction {

  private final FieldType column;

  /**
   * Constructs a {@link SortByColumnOfAction}.
   * <p>
   * <b>NOTE:</b> the ID of the new action is the ID of the
   * {@link SelectColumnsAction} action concatenate to a dot and the short name of the
   * enumerator representing the column. For example, if the column is
   * {@link FieldType#CITE_KEY}, the ID of the new action is
   * <code>{@link SelectColumnsAction#KEY} + ".cite-key"</code>.
   * <p>
   * A short name of an {@link Enum} value comes from lowercase the enumeration
   * name of the {@link Enum} value and replacing all '_' with '-'.
   *
   * @param column
   *          the column.
   * @param application
   *          the application.
   */
  public ColumnOfAction( FieldType column, Application application) {
    super(getActionId(column), application, CHECKBOX_SHOW_TEXT);
    this.column = column;
    logger.debug("Create a SelectDisplayColumnAction '{}' for column {}.",
        getId(), column);
  }

  /**
   * Gets the ID of the {@link SortByColumnOfAction} for a column.
   *
   * @param column
   *          a column.
   * @return the ID of the {@link SortByColumnOfAction} for the column.
   */
  public static String getActionId(FieldType column) {
    return ColumnsAction.ID + "." + EnumUtils.getShortName(column);
  }

  /**
   * Gets the column.
   *
   * @return the column.
   */
  public FieldType getColumn() {
    return column;
  }

  @Override
  public void handle(ActionEvent event) {
    if (selected.get()) {
      application.getExplorerController().addColumn(column);
    } else {
      application.getExplorerController().removeColumn(column);
    }
  }
}
