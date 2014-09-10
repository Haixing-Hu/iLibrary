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

package com.github.haixing_hu.ilibrary.gui;

import java.awt.Window;

import org.eclipse.jface.util.Geometry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Sash;
import org.eclipse.swt.widgets.Shell;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.ApplicationConfig;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.gui.inspector.InspectorPanel;
import com.github.haixing_hu.ilibrary.gui.navigator.NavigatorPanel;
import com.github.haixing_hu.ilibrary.gui.widget.ApplicationWindow;
import com.github.haixing_hu.ilibrary.gui.widget.MenuManager;
import com.github.haixing_hu.ilibrary.state.ApplicationState;
import com.github.haixing_hu.swt.utils.SWTUtils;

/**
 * The main window of the application.
 *
 * @author Haixing Hu
 */
public final class MainWindow extends ApplicationWindow {

  public static final String KEY = "window";

  private final Application application;
  private final int defaultHeight;
  private final int defaultWidth;
  private final int minHeight;
  private final int minWidth;
  private final int sashWidth;
  private final Color sashColor;
  private MainMenuBar menuBar;
  private NavigatorPanel navigator;
  private Sash sash;
  private MainPanel mainPanel;

  public MainWindow(Application application) {
    super(null);
    this.application = application;
    final ApplicationConfig config = ApplicationConfig.getInstance();
    this.defaultHeight = config.getInt(KEY + KeySuffix.DEFAULT_HEIGHT);
    this.defaultWidth = config.getInt(KEY + KeySuffix.DEFAULT_WIDTH);
    this.minHeight = config.getInt(KEY + KeySuffix.MIN_HEIGHT);
    this.minWidth = config.getInt(KEY + KeySuffix.MIN_WIDTH);
    this.sashWidth = config.getInt(KEY + KeySuffix.SASH + KeySuffix.WIDTH);
    this.sashColor = SWTUtils.parseRGB(config.getString(KEY + KeySuffix.SASH + KeySuffix.COLOR));
    this.addMenuBar();
    this.addToolBar(SWT.FLAT |SWT.WRAP);
  }

  @Override
  protected Control createContents(Composite parent) {
    navigator = new NavigatorPanel(application, parent);
    sash = new Sash(parent, SWT.VERTICAL | SWT.BORDER);
    mainPanel  = new MainPanel(application, parent);
    layoutContents(parent);
    configSash();
    return parent;
  }

  private void layoutContents(Composite parent) {
    final FormLayout layout = new FormLayout();
    layout.marginTop = 0;
    layout.marginBottom = 0;
    layout.marginLeft = 0;
    layout.marginRight = 0;
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    layout.spacing = 0;
    parent.setLayout(layout);

    //  configure the layout data
    final FormData fd_navigator = new FormData();
    fd_navigator.top = new FormAttachment(0);
    fd_navigator.bottom = new FormAttachment(100);
    fd_navigator.left = new FormAttachment(0);
    fd_navigator.right = new FormAttachment(sash);
    navigator.setLayoutData(fd_navigator);

    final int navigatorWidth = navigator.getDefaultWidth();

    final FormData fd_sash = new FormData();
    fd_sash.top = new FormAttachment(0);
    fd_sash.bottom = new FormAttachment(100);
    fd_sash.left = new FormAttachment(0, navigatorWidth);
    fd_sash.right = new FormAttachment(0, navigatorWidth + sashWidth);
    sash.setLayoutData(fd_sash);

    final FormData fd_mainPanel = new FormData();
    fd_mainPanel.top = new FormAttachment(0);
    fd_mainPanel.bottom = new FormAttachment(100);
    fd_mainPanel.left = new FormAttachment(sash);
    fd_mainPanel.right = new FormAttachment(100);
    mainPanel.setLayoutData(fd_mainPanel);

  }

  private void configSash() {
    sash.setForeground(sashColor);
    sash.setBackground(sashColor);

    final ApplicationState state = application.getState();
    final FormData fd_sash = (FormData) sash.getLayoutData();
    sash.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent event) {
        int newWidth = event.x;
        newWidth = Math.max(newWidth, navigator.getMinWidth());
        newWidth = Math.min(newWidth, navigator.getMaxWidth());
        final Rectangle rect = sash.getParent().getClientArea();
        final MainPanelTab tab = mainPanel.getSelection();
        final InspectorPanel inspector = tab.getInspector();
        final int minPanelWidth = tab.getMinPanelWidth();
        final int maxPanelWidth = tab.getMaxPanelWidth();
        final int inspectorWidth = inspector.getBounds().width;
        newWidth = Math.min(newWidth, rect.width - minPanelWidth - inspectorWidth);
        newWidth = Math.max(newWidth, rect.width - maxPanelWidth - inspectorWidth);
        // it's important to modify the event
        event.x = newWidth;
        if (event.detail != SWT.DRAG) {
          fd_sash.left = new FormAttachment(0, newWidth);
          fd_sash.right = new FormAttachment(0, newWidth + sashWidth);
          sash.getParent().layout();
          state.setNavigatorWidth(newWidth);
        }
      }
    });
  }

  @Override
  protected MenuManager createMenuManager() {
    menuBar = new MainMenuBar(application);
    return menuBar;
  }

  /**
   * Configure the shell.
   *
   * @param shell the shell to be configured.
   */
  @Override
  protected void configureShell(Shell shell) {
    super.configureShell(shell);
    final ApplicationConfig config = ApplicationConfig.getInstance();
    shell.setText(config.getAppName());
    shell.setMinimumSize(minWidth, minHeight);
    //  NOTE: Mac OS X may automatically resize the startup windows,
    //  therefore, the getInitialSize() will not be called by the
    //  framework. So we call it manually
    final Point initialSize = getInitialSize();
    shell.setSize(initialSize);
    //  and also, we set the initial location manually.
    //  note that we cannot call the Window.getInitialLocation(int),
    //  since it will use the Window.shell, which has not been initialized
    //  while calling this function. So we copy the code and implement
    //  another version by passing the shell as the argument.
    shell.setLocation(getInitialLocation(shell, initialSize));
  }

  /**
   * Returns the initial location to use for the shell. The default
   * implementation centers the shell horizontally (1/2 of the difference to
   * the left and 1/2 to the right) and vertically (1/3 above and 2/3 below)
   * relative to the parent shell, or display bounds if there is no parent
   * shell.
   * <p>
   * <b>NOTE:</b> This function is copied from {@link Window#getInitialLocation},
   * but we pass the shell as the first argument. In this way, the function
   * could be called even if the {@link Window#shell} has not been initialized.
   *
   * @param shell
   *        the shell.
   * @param initialSize
   *            the initial size of the shell, as returned by
   *            <code>getInitialSize</code>.
   * @return the initial location of the shell
   */
  protected Point getInitialLocation(Shell shell, Point initialSize) {
    final Composite parent = shell.getParent();

    Monitor monitor = shell.getDisplay().getPrimaryMonitor();
    if (parent != null) {
      monitor = parent.getMonitor();
    }

    final Rectangle monitorBounds = monitor.getClientArea();
    Point centerPoint;
    if (parent != null) {
      centerPoint = Geometry.centerPoint(parent.getBounds());
    } else {
      centerPoint = Geometry.centerPoint(monitorBounds);
    }

    return new Point(centerPoint.x - (initialSize.x / 2), Math.max(
        monitorBounds.y, Math.min(centerPoint.y
            - ((initialSize.y * 2) / 3), (monitorBounds.y
            + monitorBounds.height) - initialSize.y)));
  }

  /**
   * Return the initial size of the window.
   *
   * @return the initial size of the window.
   */
  @Override
  protected Point getInitialSize() {
    return new Point(defaultWidth, defaultHeight);
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
   * Gets the default height.
   *
   * @return the default height.
   */
  public int getDefaultHeight() {
    return defaultHeight;
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
   * Gets the minimum height.
   *
   * @return the minimum height.
   */
  public int getMinHeight() {
    return minHeight;
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
   * Gets the main menu bar.
   *
   * @return the main menu bar.
   */
  @Override
  public MainMenuBar getMenuBarManager() {
    return menuBar;
  }

  /**
   * Gets the navigator panel.
   *
   * @return the navigator panel.
   */
  public NavigatorPanel getNavigator() {
    return navigator;
  }

  /**
   * Gets the main panel.
   *
   * @return the main panel.
   */
  public MainPanel getMainPanel() {
    return mainPanel;
  }

  /**
   * Hides the navigator panel.
   */
  public void hideNavigator() {
    final ApplicationState state = application.getState();
    if (! state.isNavigatorHide()) {
      final FormData data = (FormData) sash.getLayoutData();
      data.left = new FormAttachment(0);
      data.right = new FormAttachment(0);
      sash.getParent().layout();
      state.setNavigatorHide(true);
    }
  }

  /**
   * Shows the navigator panel.
   */
  public void showNavigator() {
    final ApplicationState state = application.getState();
    if (state.isNavigatorHide()) {
      final int oldWidth = state.getNavigatorWidth();
      final FormData data = (FormData) sash.getLayoutData();
      data.left = new FormAttachment(0, oldWidth);
      data.right = new FormAttachment(0, oldWidth + sashWidth);
      sash.getParent().layout();
      state.setNavigatorHide(false);
    }
  }
}
