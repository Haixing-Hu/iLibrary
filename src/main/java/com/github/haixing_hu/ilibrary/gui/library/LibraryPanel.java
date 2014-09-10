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

package com.github.haixing_hu.ilibrary.gui.library;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Sash;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.ApplicationConfig;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.state.ApplicationState;
import com.github.haixing_hu.swt.utils.SWTUtils;

/**
 * The library panel.
 *
 * @author Haixing Hu
 */
public final class LibraryPanel extends Composite {

  public static final String KEY = LibraryTab.KEY; //  "window.main.tab.library"

  private final Application application;
  private final int sashHeight;
  private final String sashBg;
  private LibraryPanelHeader header;
  private LibraryPanelContent content;
  private Sash sash;
  private LibraryPanelPreview preview;
  private LibraryPanelToolBar toolBar;
  private LibraryPanelFooter footer;

  public LibraryPanel(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
    final ApplicationConfig config = ApplicationConfig.getInstance();
    this.sashHeight = config.getInt(KEY + KeySuffix.SASH + KeySuffix.HEIGHT);   // "window.main.tab.library.sash.height"
    this.sashBg = config.getString(KEY + KeySuffix.SASH + KeySuffix.BACKGROUND_IMAGE); // "window.main.tab.library.sash.background-image"
    createContents();
    layoutContents();
    configSash();
  }

  private void createContents() {
    header = new LibraryPanelHeader(application, this);
    content = new LibraryPanelContent(application, this);
    sash = new Sash(this, SWT.HORIZONTAL | SWT.BORDER | SWT.SMOOTH);
    preview = new LibraryPanelPreview(application, this);
    toolBar = new LibraryPanelToolBar(application, this);
    footer = new LibraryPanelFooter(application, this);
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
    fd_content.bottom = new FormAttachment(sash);
    content.getTable().setLayoutData(fd_content);

    final int previewHeight = preview.getDefaultHeight();
    final int toolBarHeight = toolBar.getHeight();
    final int footerHeight = footer.getHeight();

    final FormData fd_sash = new FormData();
    fd_sash.left = new FormAttachment(0);
    fd_sash.right = new FormAttachment(100);
    fd_sash.top = new FormAttachment(100,
        - footerHeight - toolBarHeight - previewHeight - sashHeight);
    fd_sash.bottom = new FormAttachment(100,
        - footerHeight - toolBarHeight - previewHeight);
    sash.setLayoutData(fd_sash);

    final FormData fd_preview = new FormData();
    fd_preview.left = new FormAttachment(0);
    fd_preview.right = new FormAttachment(100);
    fd_preview.top = new FormAttachment(sash);
    fd_preview.bottom = new FormAttachment(100,
        - footerHeight - toolBarHeight);
    preview.setLayoutData(fd_preview);

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

  private void configSash() {
    final Image img = SWTUtils.getImage(sashBg);
    sash.setBackgroundImage(img);

    final FormData fd_sash = (FormData) sash.getLayoutData();
    final Composite parent = sash.getParent();
    final ApplicationState state = application.getState();
    sash.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent event) {
        final Rectangle rect = parent.getClientArea();
        final int headerHeight = header.getHeight();
        final int footerHeight = footer.getHeight();
        final int toolBarHeight = toolBar.getHeight();
        final int delta = rect.height - sashHeight - footerHeight - toolBarHeight;
        int newHeight = delta - event.y;
        newHeight = Math.max(newHeight, preview.getMinHeight());
        newHeight = Math.min(newHeight, preview.getMaxHeight());
        newHeight = Math.min(newHeight, rect.height - headerHeight
            - content.getMinHeight() - sashHeight - footerHeight - toolBarHeight);
        // it's important to modify the event.y
        event.y = delta - newHeight;
        if (event.detail != SWT.DRAG) {
          fd_sash.top = new FormAttachment(100,
              - footerHeight - toolBarHeight - newHeight - sashHeight);
          fd_sash.bottom = new FormAttachment(100,
              - footerHeight - toolBarHeight - newHeight);
          parent.layout();
          state.setPreviewHeight(newHeight);
        }
      }
    });
  }

  /**
   * Hides the preview panel.
   */
  public void hidePreview() {
    final ApplicationState state = application.getState();
    if (! state.isPreviewHide()) {
      final int toolBarHeight = toolBar.getHeight();
      final int footerHeight = footer.getHeight();
      final FormData fd = (FormData) sash.getLayoutData();
      final int offset = - toolBarHeight - footerHeight;
      fd.top = new FormAttachment(100, offset);
      fd.bottom = new FormAttachment(100, offset);
      sash.getParent().layout();
      state.setPreviewHide(true);
    }
  }

  /**
   * Shows the preview panel.
   */
  public void showPreview() {
    final ApplicationState state = application.getState();
    if (state.isPreviewHide()) {
      final int oldHeight = state.getPreviewHeight();
      final int toolBarHeight = toolBar.getHeight();
      final int footerHeight = footer.getHeight();
      final int offset = - toolBarHeight - footerHeight;
      final FormData fd = (FormData) sash.getLayoutData();
      fd.top = new FormAttachment(100, offset - oldHeight - sashHeight);
      fd.bottom = new FormAttachment(100, offset - oldHeight);
      sash.getParent().layout();
      state.setPreviewHide(false);
    }
  }

  /**
   * Gets the header.
   *
   * @return the header.
   */
  public LibraryPanelHeader getHeader() {
    return header;
  }

  /**
   * Gets the content.
   *
   * @return the content.
   */
  public LibraryPanelContent getContent() {
    return content;
  }

  /**
   * Gets the preview.
   *
   * @return the preview.
   */
  public LibraryPanelPreview getPreview() {
    return preview;
  }

  /**
   * Gets the toolBar.
   *
   * @return the toolBar.
   */
  public LibraryPanelToolBar getToolBar() {
    return toolBar;
  }

  /**
   * Gets the footer.
   *
   * @return the footer.
   */
  public LibraryPanelFooter getFooter() {
    return footer;
  }

}
