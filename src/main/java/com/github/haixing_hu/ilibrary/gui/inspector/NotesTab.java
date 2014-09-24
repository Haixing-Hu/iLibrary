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

package com.github.haixing_hu.ilibrary.gui.inspector;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;

import com.github.haixing_hu.ilibrary.Application;

/**
 * The document tab item.
 *
 * @author Haixing Hu
 */
public final class NotesTab extends Composite {

  public static final String KEY = InspectorTabFolder.KEY + ".notes"; // "window.inspector.tab.notes"

  private final Application application;
  private final NotesTabContent content;
  private final NotesTabFooter footer;

  public NotesTab(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
    content = new NotesTabContent(application, this);
    footer = new NotesTabFooter(application, this);
    layoutContents();
  }

  private void layoutContents() {
    final FormLayout layout = new FormLayout();
    layout.marginTop = 0;
    layout.marginBottom = 0;
    layout.marginLeft = 0;
    layout.marginRight = 0;
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    layout.spacing = 0;
    this.setLayout(layout);

    final FormData fd_content = new FormData();
    fd_content.left = new FormAttachment(0);
    fd_content.right = new FormAttachment(100);
    fd_content.top = new FormAttachment(0);
    fd_content.bottom = new FormAttachment(footer);
    content.setLayoutData(fd_content);

    final FormData fd_footer = new FormData();
    fd_footer.left = new FormAttachment(0);
    fd_footer.right = new FormAttachment(100);
    fd_footer.top = new FormAttachment(100, - footer.getHeight());
    fd_footer.bottom = new FormAttachment(100);
    footer.setLayoutData(fd_footer);
  }

  /**
   * Gets the application.
   *
   * @return the application.
   */
  public Application getApplication() {
    return application;
  }

  /**
   * Gets the content panel.
   *
   * @return the content panel.
   */
  public NotesTabContent getContent() {
    return content;
  }

  /**
   * Gets the footer panel.
   *
   * @return the footer panel.
   */
  public NotesTabFooter getFooter() {
    return footer;
  }

}
