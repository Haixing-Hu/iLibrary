/******************************************************************************
 *
 * Copyright (c) 2014  Haixing Hu
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Haixing Hu (https://github.com/Haixing-Hu/) - Initial implementation and API.
 *
 ******************************************************************************/

package com.github.haixing_hu.ilibrary.gui.explorer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
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
import com.github.haixing_hu.ilibrary.gui.inspector.InspectorPanel;
import com.github.haixing_hu.ilibrary.gui.preview.PreviewPanel;
import com.github.haixing_hu.ilibrary.state.InspectorTab;

/**
 * The main panel of explorer pages.
 *
 * @author Haixing Hu
 */
public class ExplorerPanel extends Composite {

  public static final String ID = MainWindow.ID + ".explorer";

  private final Application application;
  private final int minWidth;
  private final int maxWidth;
  private final int sashWidth;
  private final Color sashColor;
  private final ExplorerContentPanel content;
  private final Sash sash;
  private final InspectorPanel inspector;

  public ExplorerPanel(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
    final AppConfig config = application.getConfig();
    this.minWidth = config.getInt(ID + KeySuffix.MIN_WIDTH);
    this.maxWidth = config.getInt(ID + KeySuffix.MAX_WIDTH);
    final String sashKey = MainWindow.ID + KeySuffix.SASH + KeySuffix.VERTICAL;
    this.sashWidth = config.getInt(sashKey + KeySuffix.WIDTH);
    this.sashColor = config.getColor(sashKey + KeySuffix.COLOR);
    this.content = new ExplorerContentPanel(application, this);
    this.sash = new Sash(this, SWT.VERTICAL | SWT.BORDER | SWT.SMOOTH);
    this.inspector = new InspectorPanel(application, this);
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

    final FormData fd_content = new FormData();
    fd_content.left = new FormAttachment(0);
    fd_content.right = new FormAttachment(sash);
    fd_content.top = new FormAttachment(0);
    fd_content.bottom = new FormAttachment(100);
    content.setLayoutData(fd_content);

    final int inspectorWidth = inspector.getDefaultWidth();

    final FormData fd_sash = new FormData();
    fd_sash.left = new FormAttachment(100, - inspectorWidth - sashWidth);
    fd_sash.right = new FormAttachment(100, - inspectorWidth);
    fd_sash.top = new FormAttachment(0);
    fd_sash.bottom = new FormAttachment(100);
    sash.setLayoutData(fd_sash);

    final FormData fd_inspector = new FormData();
    fd_inspector.left = new FormAttachment(sash);
    fd_inspector.right = new FormAttachment(100);
    fd_inspector.top = new FormAttachment(0);
    fd_inspector.bottom = new FormAttachment(100);
    inspector.setLayoutData(fd_inspector);
  }

  private void configSash() {
    if (sashColor != null) {
      sash.setForeground(sashColor);
      sash.setBackground(sashColor);
    }
    sash.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent event) {
        final Rectangle rect = sash.getParent().getClientArea();
        final int delta =  rect.width - sashWidth;
        int width = delta - event.x;
        width = Math.max(width, inspector.getMinWidth());
        width = Math.min(width, inspector.getMaxWidth());
        width = Math.min(width, rect.width - minWidth);
        // it's important to modify the event
        event.x = delta - width;
        if (event.detail != SWT.DRAG) {
          application.setInspectorWidth(width);
        }
      }
    });
  }

  public Application getApplication() {
    return application;
  }

  public int getMinWidth() {
    return minWidth;
  }

  public int getMaxWidth() {
    return maxWidth;
  }

  /**
   * Gets the content panel.
   *
   * @return the content panel.
   */
  public ExplorerContentPanel getContent() {
    return content;
  }

  /**
   * Gets the inspector panel.
   *
   * @return the inspector panel.
   */
  public InspectorPanel getInspector() {
    return inspector;
  }

  /**
   * Gets the preview panel.
   *
   * @return the preview panel.
   */
  public PreviewPanel getPreview() {
    return content.getPreview();
  }

  /**
   * Gets the tool bar on the footer.
   *
   * @return the tool bar on the footer.
   */
  public ExplorerFooterToolBar getFooterToolBar() {
    return content.getFooterToolBar();
  }

  /**
   * Sets the width of the inspector panel.
   * <p>
   * <b>NOTE:</b> Calling this function will <b>not</b> change the state of the
   * application. Instead, it just change the GUI layout.
   *
   * @param width
   *          the new width to be set. If it is less than or equal to 0, the
   *          function will hide the inspector panel.
   */
  public void setInspectorWidth(int width) {
    final FormData fd_sash = (FormData) sash.getLayoutData();
    if (width <= 0) {
      fd_sash.left = new FormAttachment(100);
      fd_sash.right = new FormAttachment(100);
    } else {
      fd_sash.left = new FormAttachment(100, - width - sashWidth);
      fd_sash.right = new FormAttachment(100, - width);
    }
    this.layout();
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
    content.setPreviewHeight(height);
  }

  /**
   * Sets the tab folder of the inspector panel to the specified tab.
   *
   * @param tab
   *          the tab to be switched to.
   */
  public void setInspectorTab(InspectorTab tab) {
    inspector.switchToTab(tab);
  }
}
