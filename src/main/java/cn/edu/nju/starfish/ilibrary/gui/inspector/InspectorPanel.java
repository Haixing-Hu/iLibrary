/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.inspector;

import org.apache.commons.configuration.Configuration;
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
import org.eclipse.wb.swt.SWTResourceManager;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.MainWindow;
import cn.edu.nju.starfish.ilibrary.gui.main.MainPanel;
import cn.edu.nju.starfish.ilibrary.gui.navigator.NavigatorPanel;
import cn.edu.nju.starfish.ilibrary.state.ApplicationState;

/**
 * The inspector panel.
 *
 * @author Haixing Hu
 */
public class InspectorPanel extends Composite {

  public static final String KEY = MainWindow.KEY + ".inspector";

  private final Application application;
  private final int defaultWidth;
  private final int minWidth;
  private final int maxWidth;
  private final int sashWidth;
  private final Sash sash;
  private InspectorHeader header;
  private InspectorTabFolder tabFolder;

  public InspectorPanel(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
    final Configuration config = application.getConfig();
    defaultWidth = config.getInt(KEY + ".width.default");
    minWidth = config.getInt(KEY + ".width.min");
    maxWidth = config.getInt(KEY + ".width.max");
    sashWidth = config.getInt(KEY + ".width.sash");
    sash = new Sash(parent, SWT.VERTICAL | SWT.BORDER | SWT.SMOOTH);
    configLayoutData();
    configSash();
    createContents();
  }

  /**
   * Configures the layout data of this panel.
   */
  private void configLayoutData() {
    final FormData layoutData = new FormData();
    layoutData.left = new FormAttachment(sash);
    layoutData.top = new FormAttachment(0);
    layoutData.right = new FormAttachment(100);
    layoutData.bottom = new FormAttachment(100);
    this.setLayoutData(layoutData);
  }

  /**
   * Configures the sash of this panel.
   */
  private void configSash() {
    final FormData sashData = new FormData();
    sashData.left = new FormAttachment(100, - defaultWidth - sashWidth);
    sashData.top = new FormAttachment(0);
    sashData.right = new FormAttachment(100, - defaultWidth);
    sashData.bottom = new FormAttachment(100);
    sash.setLayoutData(sashData);
    final Color color = SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW);
    sash.setBackground(color);
    sash.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        final Composite parent = sash.getParent();
        final Rectangle parentRect = parent.getClientArea();
        int newWidth = parentRect.width - e.x - sashWidth;
        newWidth = Math.max(newWidth, minWidth);
        newWidth = Math.min(newWidth, maxWidth);
        final MainWindow mainWindow = application.getMainWindow();
        final MainPanel mainPanel = mainWindow.getMainPanel();
        final NavigatorPanel navigatorPanel = mainWindow.getNavigatorPanel();
        final Sash navigatorSash = navigatorPanel.getSash();
        final Rectangle navigatorSashRect = navigatorSash.getBounds();
        final int minLeftWidth = navigatorSashRect.x + navigatorSashRect.width + mainPanel.getMinWidth();
        newWidth = Math.min(newWidth, parentRect.width - minLeftWidth);
        e.x = parentRect.width - sashWidth - newWidth;  // it's important to modify the event
        if (e.detail != SWT.DRAG) {
          sashData.left = new FormAttachment(100, -(newWidth + sashWidth));
          sashData.right = new FormAttachment(100, -newWidth);
          parent.layout();
          final ApplicationState state = application.getState();
          state.setInspectorWidth(newWidth);
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

    header = new InspectorHeader(application, this);
    tabFolder = new InspectorTabFolder(application, this);

    final FormData fd_header = new FormData();
    fd_header.top = new FormAttachment(0);
    fd_header.bottom = new FormAttachment(0, header.getHeight());
    fd_header.left = new FormAttachment(0);
    fd_header.right = new FormAttachment(100);
    header.setLayoutData(fd_header);

    final FormData fd_tabFolder = new FormData();
    fd_tabFolder.top = new FormAttachment(header);
    fd_tabFolder.bottom = new FormAttachment(100);
    fd_tabFolder.left = new FormAttachment(0);
    fd_tabFolder.right = new FormAttachment(100);
    tabFolder.setLayoutData(fd_tabFolder);
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
    final ApplicationState state = application.getState();
    if (! state.isInspectorHide()) {
      final FormData data = (FormData) sash.getLayoutData();
      data.left = new FormAttachment(100);
      data.right = new FormAttachment(100);
      sash.getParent().layout();
      state.setInspectorHide(true);
    }
  }

  /**
   * Shows this panel.
   */
  public void show() {
    final ApplicationState state = application.getState();
    if (state.isInspectorHide()) {
      final int oldWidth = state.getInspectorWidth();
      final FormData data = (FormData) sash.getLayoutData();
      data.left = new FormAttachment(100, - oldWidth - sashWidth);
      data.right = new FormAttachment(100, - oldWidth);
      sash.getParent().layout();
      state.setInspectorHide(false);
    }
  }

  /**
   * Gets the header.
   *
   * @return the header.
   */
  public InspectorHeader getHeader() {
    return header;
  }

  /**
   * Gets the tab folder.
   *
   * @return the tab folder.
   */
  public InspectorTabFolder getTabFolder() {
    return tabFolder;
  }


}
