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

package com.github.haixing_hu.ilibrary.action.file.document;

import java.util.Collection;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseActionGroup;
import com.github.haixing_hu.ilibrary.model.DocumentTemplate;
import com.github.haixing_hu.ilibrary.model.DocumentType;
import com.github.haixing_hu.ilibrary.service.DocumentTemplateService;
import com.github.haixing_hu.javafx.action.ActionManager;
import com.github.haixing_hu.lang.EnumUtils;

/**
 * The action to create a new document of a specified type.
 *
 * @author Haixing Hu
 */
public class NewDocumentForTypeAction extends BaseActionGroup {

  private final DocumentType type;

  /**
   * Construct a {@link NewDocumentForTypeAction} object.
   *
   * @param type
   *          A document type.
   * @param application
   *          The application.
   */
  public NewDocumentForTypeAction(DocumentType type, Application application) {
    super(getActionId(type), application);
    this.type = type;
    logger.debug("Creates an NewDocumentForTypeAction '{}' for document type '{}'.",
        getId(), type);
    final AppConfig config = application.getConfig();
    final DocumentTemplateService service = config.getBean(DocumentTemplateService.class);
    final Collection<DocumentTemplate> templates = service.getAll(type);
    final ActionManager am = application.getActionManager();
    for (final DocumentTemplate template : templates) {
      final NewDocumentFormTemplateAction action =
          new NewDocumentFormTemplateAction(template, application);
      addSubAction(am, action);
    }
  }

  /**
   * Gets the id of the action for creating a document in the specified type .
   *
   * @param type
   *          a document type.
   * @return the id of the action for creating a document in the specified type.
   */
  public static String getActionId(DocumentType type) {
    return NewDocumentAction.ID + "." + EnumUtils.getShortName(type);
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
