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

package com.github.haixing_hu.ilibrary.gui.document;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;

import com.github.haixing_hu.ilibrary.Application;

/**
 * The document panel.
 *
 * @author Haixing Hu
 */
public final class DocumentPanel extends Composite {

  public static final String KEY = DocumentTab.KEY + ".panel"; //  "window.main.tab.document.panel"

  private final Application application;
  private DocumentPanelHeader header;
  private DocumentPanelContent content;
  private DocumentPanelToolBar toolBar;
  private DocumentPanelFooter footer;

  public DocumentPanel(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
    createContents();
    layoutContents();
  }

  private void createContents() {
    header = new DocumentPanelHeader(application, this);
    content = new DocumentPanelContent(application, this);
    toolBar = new DocumentPanelToolBar(application, this);
    footer = new DocumentPanelFooter(application, this);
  }

  private void layoutContents() {
    final FormLayout layout = new FormLayout();
    layout.marginLeft = 0;
    layout.marginRight = 0;
    layout.marginTop = 0;
    layout.marginBottom = 0;
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    layout.spacing = 0;
    this.setLayout(layout);

    final int headerHeight = header.getHeight();
    final FormData fd_header = new FormData();
    fd_header.left = new FormAttachment(0);
    fd_header.right = new FormAttachment(100);
    fd_header.top = new FormAttachment(0);
    fd_header.bottom = new FormAttachment(0, headerHeight);
    header.setLayoutData(fd_header);

    final FormData fd_content = new FormData();
    fd_content.left = new FormAttachment(0);
    fd_content.right = new FormAttachment(100);
    fd_content.top = new FormAttachment(0, headerHeight);
    fd_content.bottom = new FormAttachment(toolBar);
    content.setLayoutData(fd_content);

    final int toolBarHeight = toolBar.getHeight();
    final int footerHeight = footer.getHeight();

    final FormData fd_toolBar = new FormData();
    fd_toolBar.left = new FormAttachment(0);
    fd_toolBar.right = new FormAttachment(100);
    fd_toolBar.top = new FormAttachment(100,
        - footerHeight - toolBarHeight);
    fd_toolBar.bottom = new FormAttachment(100,
        - footerHeight);
    toolBar.setLayoutData(fd_toolBar);

    final FormData fd_footer = new FormData();
    fd_footer.left = new FormAttachment(0);
    fd_footer.right = new FormAttachment(100);
    fd_footer.top = new FormAttachment(100,
        - footerHeight);
    fd_footer.bottom = new FormAttachment(100);
    footer.setLayoutData(fd_footer);
  }
}
