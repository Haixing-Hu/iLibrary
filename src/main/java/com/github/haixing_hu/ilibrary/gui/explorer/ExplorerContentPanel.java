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

package com.github.haixing_hu.ilibrary.gui.explorer;

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

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.gui.MainWindow;
import com.github.haixing_hu.ilibrary.gui.preview.PreviewPanel;
import com.github.haixing_hu.swt.utils.SWTResourceManager;

/**
 * The content panel of the explorer.
 *
 * @author Haixing Hu
 */
public class ExplorerContentPanel extends Composite {

  private final Application application;
  private final int sashHeight;
  private final String sashBackground;
  private final ExplorerHeader header;
  private final ExplorerTableViewer tableViewer;
  private final Sash sash;
  private final PreviewPanel preview;
  private final ExplorerFooter footer;

  public ExplorerContentPanel(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
    final AppConfig config = application.getConfig();
    final String sashKey = MainWindow.KEY + KeySuffix.SASH + KeySuffix.HORIZON;
    this.sashHeight = config.getInt(sashKey + KeySuffix.HEIGHT);
    this.sashBackground = config.getString(sashKey + KeySuffix.BACKGROUND_IMAGE);
    this.header = new ExplorerHeader(application, this);
    this.tableViewer = new ExplorerTableViewer(application, this);
    this.sash = new Sash(this, SWT.HORIZONTAL | SWT.BORDER | SWT.SMOOTH);
    this.preview = new PreviewPanel(application, this);
    this.footer = new ExplorerFooter(application, this);
    layoutContents();
    configSash();
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

    final FormData fd_viewer = new FormData();
    fd_viewer.left = new FormAttachment(0);
    fd_viewer.right = new FormAttachment(100);
    fd_viewer.top = new FormAttachment(0, headerHeight);
    fd_viewer.bottom = new FormAttachment(sash);
    tableViewer.getTable().setLayoutData(fd_viewer);

    final int previewHeight = preview.getDefaultHeight();
    final int footerHeight = footer.getHeight();

    final FormData fd_sash = new FormData();
    fd_sash.left = new FormAttachment(0);
    fd_sash.right = new FormAttachment(100);
    fd_sash.top = new FormAttachment(100, - footerHeight - previewHeight - sashHeight);
    fd_sash.bottom = new FormAttachment(100, - footerHeight - previewHeight);
    sash.setLayoutData(fd_sash);

    final FormData fd_preview = new FormData();
    fd_preview.left = new FormAttachment(0);
    fd_preview.right = new FormAttachment(100);
    fd_preview.top = new FormAttachment(sash);
    fd_preview.bottom = new FormAttachment(100, - footerHeight);
    preview.setLayoutData(fd_preview);

    final FormData fd_footer = new FormData();
    fd_footer.left = new FormAttachment(0);
    fd_footer.right = new FormAttachment(100);
    fd_footer.top = new FormAttachment(100, - footerHeight);
    fd_footer.bottom = new FormAttachment(100);
    footer.setLayoutData(fd_footer);
  }

  private void configSash() {
    final Image img = SWTResourceManager.getImage(this.getClass(), sashBackground);
    sash.setBackgroundImage(img);
    sash.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent event) {
        final Rectangle rect = sash.getParent().getClientArea();
        final int headerHeight = header.getHeight();
        final int footerHeight = footer.getHeight();
        final int delta = rect.height - sashHeight - footerHeight;
        int height = delta - event.y;
        height = Math.max(height, preview.getMinHeight());
        height = Math.min(height, preview.getMaxHeight());
        height = Math.min(height, rect.height - headerHeight
            - tableViewer.getMinHeight() - sashHeight - footerHeight);
        // it's important to modify the event.y
        event.y = delta - height;
        if (event.detail != SWT.DRAG) {
          application.setPreviewHeight(height);
        }
      }
    });
  }

  public ExplorerHeader getHeader() {
    return header;
  }

  public ExplorerTableViewer getTableViewer() {
    return tableViewer;
  }

  public PreviewPanel getPreview() {
    return preview;
  }

  public ExplorerFooter getFooter() {
    return footer;
  }

  /**
   * Gets the tool bar on the footer.
   *
   * @return the tool bar on the footer.
   */
  public ExplorerFooterToolBar getFooterToolBar() {
    return footer.getToolBar();
  }

  /**
   * Sets the height of the preview panel.
   * <p>
   * <b>NOTE:</b> Calling this function will <b>not</b> change the state of the
   * application. Instead, it just change the GUI layout.
   *
   * @param height
   *          the new height to be set. If it is less than or equal to 0, the
   *          function will hide the preview panel.
   */
  public void setPreviewHeight(int height) {
    final FormData fd_sash = (FormData) sash.getLayoutData();
    final int offset = - footer.getHeight();
    if (height <= 0) {
      fd_sash.top = new FormAttachment(100, offset);
      fd_sash.bottom = new FormAttachment(100, offset);
    } else {
      fd_sash.top = new FormAttachment(100, offset - height - sashHeight);
      fd_sash.bottom = new FormAttachment(100, offset - height);
    }
    this.layout();
  }
}
