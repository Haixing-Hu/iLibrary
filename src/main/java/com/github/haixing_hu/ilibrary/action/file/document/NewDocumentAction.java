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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseDropDownAction;
import com.github.haixing_hu.ilibrary.model.DocumentTemplate;
import com.github.haixing_hu.ilibrary.model.DocumentType;
import com.github.haixing_hu.ilibrary.service.DocumentTemplateService;
import com.github.haixing_hu.lang.EnumUtils;
import com.github.haixing_hu.swt.action.IActionManager;

/**
 * The action to create a new document of a specified type.
 *
 * @author Haixing Hu
 */
public class NewDocumentAction extends BaseDropDownAction {

  private final DocumentType type;

  /**
   * Construct a {@link NewDocumentAction} object.
   *
   * @param type
   *    A document type.
   * @param application
   *    The application.
   * @param actionManager
   *    The action manager.
   */
  public NewDocumentAction(DocumentType type, Application application,
          IActionManager actionManager) {
    super(NewAction.KEY + "." + EnumUtils.getShortName(type),
          application, actionManager,
          getSubActionIds(application.getConfig(), type));
    this.type = type;
    logger.info("Creates an NewDocument action '{}' for document type '{}'.",
        this.getId(), type);
  }

  private static String[] getSubActionIds(AppConfig config, DocumentType type) {
    final DocumentTemplateService service = config.getBean(DocumentTemplateService.class);
    final Collection<DocumentTemplate> templates = service.getAll(type);
    final List<String> ids = new ArrayList<String>();
    final String prefix = NewAction.KEY + "." + EnumUtils.getShortName(type) + ".";
    for (final DocumentTemplate template : templates) {
      ids.add(prefix + template.getName());
    }
    return ids.toArray(new String[0]);
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
