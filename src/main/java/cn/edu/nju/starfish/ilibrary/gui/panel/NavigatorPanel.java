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
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Sash;
import org.eclipse.wb.swt.SWTResourceManager;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.MainWindow;
import cn.edu.nju.starfish.ilibrary.gui.statusline.NavigatorStatusLine;

/**
 * The panel display the navigation tree.
 *
 * @author Haixing Hu
 */
public final class NavigatorPanel extends Composite {

  public static final String KEY = "gui.navigator-panel";

  private final Application application;
  private final int defaultWidth;
  private final int minWidth;
  private final int maxWidth;
  private final int sashWidth;
  private final Sash sash;
  private int oldWidth;
  private boolean hidden;
  private NavigatorTree navigatorTree;
  private NavigatorStatusLine statusLine;

  /**
   * Constructs a {@link NavigatorPanel}.
   *
   * @param application
   *          the application the new panel belongs.
   * @param parent
   *          the parent of the new panel.
   */
  public NavigatorPanel(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
    final Configuration config = application.getConfig();
    defaultWidth = config.getInt(KEY + ".width.default");
    minWidth = config.getInt(KEY + ".width.min");
    maxWidth = config.getInt(KEY + ".width.max");
    sashWidth = config.getInt(KEY + ".width.sash");
    sash = new Sash(parent, SWT.VERTICAL | SWT.BORDER | SWT.SMOOTH);
    oldWidth = defaultWidth;
    hidden = false;
    configLayoutData();
    configSash();
    createContents();
  }

  /**
   * Configures the layout data of this panel.
   */
  private void configLayoutData() {
    final FormData layoutData = new FormData();
    layoutData.left = new FormAttachment(0);
    layoutData.top = new FormAttachment(0);
    layoutData.right = new FormAttachment(sash);
    layoutData.bottom = new FormAttachment(100);
    this.setLayoutData(layoutData);
  }

  /**
   * Configures the sash of this panel.
   */
  private void configSash() {
    final FormData sashData = new FormData();
    sashData.left = new FormAttachment(0, defaultWidth);
    sashData.top = new FormAttachment(0);
    sashData.right = new FormAttachment(0, defaultWidth + sashWidth);
    sashData.bottom = new FormAttachment(100);
    sash.setLayoutData(sashData);
    final Color color = SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW);
    sash.setBackground(color);
    sash.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        int newWidth = Math.max(e.x, minWidth);
        newWidth = Math.min(newWidth, maxWidth);
        final MainWindow mainWindow = application.getMainWindow();
        final MainPanel mainPanel = mainWindow.getMainPanel();
        final InspectorPanel inspectorPanel = mainWindow.getInspectorPanel();
        final Sash inspectorSash = inspectorPanel.getSash();
        newWidth = Math.min(newWidth, inspectorSash.getBounds().x - mainPanel.getMinWidth());
        e.x = newWidth;  // it's important to modify the event
        if (e.detail != SWT.DRAG) {
          sashData.left = new FormAttachment(0, newWidth);
          sashData.right = new FormAttachment(0, newWidth + sashWidth);
          sash.getParent().layout();
          oldWidth = newWidth;
        }
      }
    });
  }

  /**
   * Creates the contents of this panel.
   */
  private void createContents() {
    final FormLayout layout = new FormLayout();
    layout.marginTop = 0;
    layout.marginBottom = 0;
    layout.marginLeft = 0;
    layout.marginRight = 0;
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    layout.spacing = 0;
    this.setLayout(layout);

    final Color backgroundColor = application.getMainWindow().getBackgroundColor();
    this.setBackground(backgroundColor);

    navigatorTree = new NavigatorTree(application, this);
    statusLine = new NavigatorStatusLine(application, this);

    final FormData fd_navigatorTree = new FormData();
    fd_navigatorTree.left = new FormAttachment(0);
    fd_navigatorTree.top = new FormAttachment(0);
    fd_navigatorTree.right = new FormAttachment(100);
    fd_navigatorTree.bottom = new FormAttachment(statusLine);
    navigatorTree.setLayoutData(fd_navigatorTree);

    final FormData fd_statusLine = new FormData();
    fd_statusLine.left = new FormAttachment(0);
    fd_statusLine.top = new FormAttachment(100, - statusLine.getHeight());
    fd_statusLine.right = new FormAttachment(100);
    fd_statusLine.bottom = new FormAttachment(100);
    statusLine.setLayoutData(fd_statusLine);
  }

  /**
   * Gets the application this panel belongs.
   *
   * @return the application this panel belongs.
   */
  public Application getApplication() {
    return application;
  }

  /**
   * Gets the default width.
   *
   * @return the default width.
   */
  public int getDefaultWidth() {
    return defaultWidth;
  }

  /**
   * Gets the minimum width.
   *
   * @return the minimum width.
   */
  public int getMinWidth() {
    return minWidth;
  }

  /**
   * Gets the maximum width.
   *
   * @return the maximum width.
   */
  public int getMaxWidth() {
    return maxWidth;
  }

  /**
   * Gets the sash width.
   *
   * @return the sash width.
   */
  public int getSashWidth() {
    return sashWidth;
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
      data.left = new FormAttachment(0);
      data.right = new FormAttachment(0);
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
      data.left = new FormAttachment(0, oldWidth);
      data.right = new FormAttachment(0, oldWidth + sashWidth);
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

  /**
   * Gets the navigator tree.
   *
   * @return the navigator tree.
   */
  public NavigatorTree getNavigatorTree() {
    return navigatorTree;
  }

  /**
   * Gets the status line.
   *
   * @return the status line.
   */
  public NavigatorStatusLine getStatusLine() {
    return statusLine;
  }


}
