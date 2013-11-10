/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui;

import org.apache.commons.configuration.Configuration;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.menu.MainMenuBar;
import cn.edu.nju.starfish.ilibrary.gui.panel.InspectorPanel;
import cn.edu.nju.starfish.ilibrary.gui.panel.MainPanel;
import cn.edu.nju.starfish.ilibrary.gui.panel.NavigatorPanel;

/**
 * The main window of the application.
 *
 * @author Haixing Hu
 */
public final class MainWindow extends ApplicationWindow {

  public static final String KEY = "gui.main-window";

  private final Application application;
  private MainMenuBar mainMenuBar;
  private NavigatorPanel navigatorPanel;
  private MainPanel mainPanel;
  private InspectorPanel inspectorPanel;

  public MainWindow(Application application) {
    super(null);
    this.application = application;
    this.addMenuBar();
    this.addToolBar(SWT.FLAT |SWT.WRAP);
    this.addStatusLine();
  }

  @Override
  protected Control createContents(Composite parent) {
    final Composite container = new Composite(parent, SWT.NONE);
    container.setLayout(new FormLayout());
    navigatorPanel = new NavigatorPanel(application, container);
    inspectorPanel = new InspectorPanel(application, container);
    mainPanel  = new MainPanel(application, container,
        navigatorPanel.getSash(), inspectorPanel.getSash());
    return container;
  }

  @Override
  protected MenuManager createMenuManager() {
    mainMenuBar = new MainMenuBar(application);
    return mainMenuBar;
  }

  @Override
  protected StatusLineManager createStatusLineManager() {
    StatusLineManager statusLine = new StatusLineManager();
    return statusLine;
  }

  /**
   * Configure the shell.
   *
   * @param shell the shell to be configured.
   */
  @Override
  protected void configureShell(Shell shell) {
    super.configureShell(shell);
    shell.setText(application.getName());
    Configuration config = application.getConfig();
    int minWidth = config.getInt(KEY + ".width.min");
    int minHeight = config.getInt(KEY + ".height.min");
    shell.setMinimumSize(minWidth, minHeight);
    this.setStatus(application.getName() + " " + application.getVersion());
  }

  /**
   * Return the initial size of the window.
   *
   * @return the initial size of the window.
   */
  @Override
  protected Point getInitialSize() {
    Configuration config = application.getConfig();
    int width = config.getInt(KEY + ".width.default");
    int height = config.getInt(KEY + ".height.default");
    return new Point(width, height);
  }

  /**
   * Gets the main menu bar.
   *
   * @return the main menu bar.
   */
  @Override
  public MainMenuBar getMenuBarManager() {
    return mainMenuBar;
  }

  /**
   * Gets the navigator panel.
   *
   * @return the navigator panel.
   */
  public NavigatorPanel getNavigatorPanel() {
    return navigatorPanel;
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
   * Gets the inspector panel.
   *
   * @return the inspector panel.
   */
  public InspectorPanel getInspectorPanel() {
    return inspectorPanel;
  }
}
