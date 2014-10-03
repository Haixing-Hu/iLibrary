/******************************************************************************
 *
 * Copyright (c) 2013  Haixing Hu
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

package com.github.haixing_hu.ilibrary.action.view.filter;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseAction;
import com.github.haixing_hu.ilibrary.model.DocumentType;
import com.github.haixing_hu.lang.EnumUtils;

/**
 * The action to filter the documents of a type.
 *
 * @author Haixing Hu
 */
public class FilterDocumentTypeForAction extends BaseAction {

  private final DocumentType type;

  /**
   * Constructs a {@link FilterDocumentTypeForAction}.
   * <p>
   * <b>NOTE:</b> the ID of the new action is the ID of the
   * {@link FilterDocumentTypeAction} action concatenate to a dot and the short name of the
   * enumerator representing the document type.
   * <p>
   * A short name of an {@link Enum} value comes from lowercase the enumeration
   * name of the {@link Enum} value and replacing all '_' with '-'.
   *
   * @param type
   *          the document type.
   * @param application
   *          the application.
   * @param actionManager
   *          the action manager.
   */
  public FilterDocumentTypeForAction(DocumentType type, Application application) {
    super(getActionId(type), application, BaseAction.CHECK);
    this.type = type;
    logger.debug("Create a FilterDocumentTypeForAction '{}' for type {}.",
        getId(), type);
  }

  /**
   * Gets the ID of the {@link FilterDocumentTypeForAction} for a document type.
   *
   * @param type
   *          a document type.
   * @return the ID of the {@link FilterDocumentTypeForAction} for the document type.
   */
  public static String getActionId(DocumentType type) {
    return FilterDocumentTypeAction.ID + "." + EnumUtils.getShortName(type);
  }

  /**
   * Gets the document type.
   *
   * @return the document type.
   */
  public DocumentType getType() {
    return type;
  }

}
