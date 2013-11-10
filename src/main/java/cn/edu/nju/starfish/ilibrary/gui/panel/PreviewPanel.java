/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.panel;

import org.apache.commons.configuration.Configuration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Sash;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.MainWindow;

/**
 * The preview panel.
 *
 * @author Haixing Hu
 */
public class PreviewPanel extends Composite {

  public static final String KEY = MainPanel.KEY + ".preview-panel";

  private final Application application;
  private final int defaultHeight;
  private final int minHeight;
  private final int maxHeight;
  private final int sashHeight;
  private final Sash sash;
  private int oldHeight;
  private boolean hidden;

  public PreviewPanel(Application application, Composite parent) {
    super(parent, SWT.BORDER);
    this.application = application;
    final Configuration config = application.getConfig();
    defaultHeight = config.getInt(KEY + ".height.default");
    minHeight = config.getInt(KEY + ".height.min");
    maxHeight = config.getInt(KEY + ".height.max");
    sashHeight = config.getInt(KEY + ".height.sash");
    sash = new Sash(parent, SWT.HORIZONTAL | SWT.BORDER | SWT.SMOOTH);
    oldHeight = defaultHeight;
    hidden = false;
    configLayoutData();
    configSash();
  }

  private void configLayoutData() {
    final FormData layoutData = new FormData();
    layoutData.left = new FormAttachment(0);
    layoutData.top = new FormAttachment(sash);
    layoutData.right = new FormAttachment(100);
    layoutData.bottom = new FormAttachment(100);
    setLayoutData(layoutData);
  }

  private void configSash() {
    final FormData sashData = new FormData();
    sashData.left = new FormAttachment(0);
    sashData.top = new FormAttachment(100, - defaultHeight - sashHeight);
    sashData.right = new FormAttachment(100);
    sashData.bottom = new FormAttachment(100, - defaultHeight);
    sash.setLayoutData(sashData);
    sash.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        final Composite parent = sash.getParent();
        final Rectangle parentRect = parent.getClientArea();
        int newHeight = parentRect.height - e.y - sashHeight;
        newHeight = Math.max(newHeight, minHeight);
        newHeight = Math.min(newHeight, maxHeight);
        final MainWindow mainWindow = application.getMainWindow();
        final MainPanel mainPanel = mainWindow.getMainPanel();
        final MainTabFolder tabFolder = mainPanel.getTabFolder();
        final LibraryTab libraryTab = tabFolder.getLibraryTab();
        final DocumentList documentList = libraryTab.getDocumentList();
        final Control table = documentList.getControl();
        final int heightLimit = parentRect.height - table.getBounds().y - documentList.getMinHeight();
        newHeight = Math.min(newHeight, heightLimit);
        e.y = parentRect.height - newHeight - sashHeight;  // it's important to modify the event
        if (e.detail != SWT.DRAG) {
          sashData.top = new FormAttachment(100, - newHeight - sashHeight);
          sashData.bottom = new FormAttachment(100, - newHeight);
          sash.getParent().layout();
          oldHeight = newHeight;
        }
      }
    });
  }

  /**
   * Gets the default height.
   *
   * @return the default height.
   */
  public int getDefaultHeight() {
    return defaultHeight;
  }

  /**
   * Gets the minimum height.
   *
   * @return the minimum height.
   */
  public int getMinHeight() {
    return minHeight;
  }

  /**
   * Gets the maximum height.
   *
   * @return the maximum height.
   */
  public int getMaxHeight() {
    return maxHeight;
  }

  /**
   * Gets the sash height.
   *
   * @return the sash height.
   */
  public int getSashHeight() {
    return sashHeight;
  }

  /**
   * Gets the sash of this panel.
   *
   * @return the sash of this panel.
   */
  public Sash getSash() {
    return sash;
  }

  /**
   * Hides this panel.
   */
  public void hide() {
    if (! hidden) {
      final FormData data = (FormData) sash.getLayoutData();
      data.top = new FormAttachment(100);
      data.bottom = new FormAttachment(100);
      sash.getParent().layout();
      hidden = true;
    }
  }

  /**
   * Shows this panel.
   */
  public void show() {
    if (hidden) {
      final FormData data = (FormData) sash.getLayoutData();
      data.top = new FormAttachment(100, - oldHeight - sashHeight);
      data.bottom = new FormAttachment(100, - oldHeight);
      sash.getParent().layout();
      hidden = false;
    }
  }

  /**
   * Tests whether this panel is hidden.
   *
   * @return
   *    true if this panel is hidden, false otherwise.
   */
  public boolean isHidden() {
    return hidden;
  }
}
