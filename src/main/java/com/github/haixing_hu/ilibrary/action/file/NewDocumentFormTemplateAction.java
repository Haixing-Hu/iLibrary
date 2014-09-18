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

package com.github.haixing_hu.ilibrary.action.file;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.action.BaseAction;
import com.github.haixing_hu.swt.action.IActionManager;
import com.github.haixing_hu.ilibrary.model.DocumentTemplate;

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
   * @param application
   *          the application.
   * @param actionManager
   *          the action manager.
   * @param template
   *          a document template.
   */
  public NewDocumentFormTemplateAction(Application application,
      IActionManager actionManager, DocumentTemplate template) {
    super(NewAction.KEY
          + "." + template.getType().name().toLowerCase()
          + "." + template.getName(),
          application, actionManager);
    this.template = template;
    //  set the title
    final AppConfig config = application.getConfig();
    final String key = "document."
               + template.getType().name().toLowerCase()
               + "." + template.getName();
    final String title = config.getMessage(key);
    this.setText(title);
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
}
