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

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseAction;
import com.github.haixing_hu.ilibrary.model.DocumentTemplate;
import com.github.haixing_hu.lang.EnumUtils;
import com.github.haixing_hu.swt.action.IActionManager;

/**
 * The action to create a new document from a document template.
 *
 * @author Haixing Hu
 */
public class NewDocumentFormTemplateAction extends BaseAction {

  private final DocumentTemplate template;

  /**
   * Creates a {@link NewDocumentFormTemplateAction}.
   *
   * @param template
   *          a document template.
   * @param application
   *          the application.
   * @param actionManager
   *          the action manager.
   */
  public NewDocumentFormTemplateAction(DocumentTemplate template,
      Application application, IActionManager actionManager) {
    super(buildActionId(template), application, actionManager);
    logger.info("Creates an NewFromTemplate action '{}' for document template '{}'.",
        this.getId(), template.getName());
    this.template = template;
    //  FIXME: we should gets the name of the document type from its template
    final AppConfig config = application.getConfig();
    final String title = config.getMessage(buildTitleKey(template));
    this.setText(title);
  }

  private static String buildActionId(DocumentTemplate template) {
    final StringBuilder builder = new StringBuilder();
    builder.append(NewAction.KEY)
           .append('.')
           .append(EnumUtils.getShortName(template.getType()))
           .append('.')
           .append(template.getName());
    return builder.toString();
  }

  private static String buildTitleKey(DocumentTemplate template) {
    final StringBuilder builder = new StringBuilder();
    builder.append("document.")
           .append(EnumUtils.getShortName(template.getType()))
           .append('.')
           .append(template.getName());
    return builder.toString();
  }

  /**
   * Gets the document template.
   *
   * @return
   *    The document template.
   */
  public DocumentTemplate getTemplate() {
    return template;
  }

  @Override
  public void run() {
    application.newDocument(template);
  }
}
