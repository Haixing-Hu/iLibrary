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

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseCheckBoxAction;
import com.github.haixing_hu.ilibrary.model.FieldType;
import com.github.haixing_hu.lang.EnumUtils;
import com.github.haixing_hu.swt.action.IActionManager;

/**
 * The action to select or deselect a column.
 *
 * @author Haixing Hu
 */
public class SelectColumnAction extends BaseCheckBoxAction {

  public static final String KEY = ColumnsAction.KEY + ".authors";


  private final FieldType column;

  /**
   * Constructs a {@link SelectColumnAction}.
   * <p>
   * <b>NOTE:</b> the ID of the new action is the ID of the
   * {@link ColumnsAction} action concatenate to a dot and the short name of the
   * enumerator representing the column. For example, if the column is
   * {@link FieldType#CITE_KEY}, the ID of the new action is
   * <code>{@link ColumnsAction#KEY} + ".cite-key"</code>.
   * <p>
   * A short name of an {@link Enum} value comes from lowercase the enumeration
   * name of the {@link Enum} value and replacing all '_' with '-'.
   *
   * @param application
   *          the application.
   * @param column
   *          the column.
   * @param actionManager
   *          the action manager.
   */
  public SelectColumnAction(Application application, FieldType column,
      IActionManager actionManager) {
    super(ColumnsAction.KEY + "." + EnumUtils.getShortName(column),
        application, actionManager);
    this.column = column;
    logger.info("Create a SelectColumn actino '{}' for column {}.",
        this.getId(), column);
  }

  @Override
  public void run() {
    if (isChecked()) {
      application.addColumn(column);
    } else {
      application.removeColumn(column);
    }
  }
}
