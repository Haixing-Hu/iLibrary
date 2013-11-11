/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui;

import java.awt.Window;

import org.apache.commons.configuration.Configuration;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.util.Geometry;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.menu.MainMenuBar;
import cn.edu.nju.starfish.ilibrary.gui.panel.CenterPanel;
import cn.edu.nju.starfish.ilibrary.gui.panel.CenterTabFolder;
import cn.edu.nju.starfish.ilibrary.gui.panel.InspectorPanel;
import cn.edu.nju.starfish.ilibrary.gui.panel.LibraryTab;
import cn.edu.nju.starfish.ilibrary.gui.panel.NavigatorPanel;
import cn.edu.nju.starfish.ilibrary.gui.panel.PreviewPanel;
import cn.edu.nju.starfish.ilibrary.utils.ColorUtils;

/**
 * The main window of the application.
 *
 * @author Haixing Hu
 */
public final class MainWindow extends ApplicationWindow {

  public static final String KEY = "gui.main";

  private final Application application;
  private final int defaultHeight;
  private final int defaultWidth;
  private final int minHeight;
  private final int minWidth;
  private final Color backgroundColor;
  private MainMenuBar mainMenuBar;
  private NavigatorPanel navigatorPanel;
  private CenterPanel mainPanel;
  private InspectorPanel inspectorPanel;

  public MainWindow(Application application) {
    super(null);
    this.application = application;
    final Configuration config = application.getConfig();
    this.defaultHeight = config.getInt(KEY + ".height.default");
    this.defaultWidth = config.getInt(KEY + ".width.default");
    this.minHeight = config.getInt(KEY + ".height.min");
    this.minWidth = config.getInt(KEY + ".width.min");
    final String colorName = config.getString(KEY + ".background.color");
    this.backgroundColor = ColorUtils.parseRGB(colorName);
    this.addMenuBar();
    this.addToolBar(SWT.FLAT |SWT.WRAP);
  }

  @Override
  protected Control createContents(Composite parent) {
    final FormLayout layout = new FormLayout();
    layout.marginTop = 0;
    layout.marginBottom = 0;
    layout.marginLeft = 0;
    layout.marginRight = 0;
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    layout.spacing = 0;
    parent.setLayout(layout);
    parent.setBackground(backgroundColor);
    navigatorPanel = new NavigatorPanel(application, parent);
    inspectorPanel = new InspectorPanel(application, parent);
    mainPanel  = new CenterPanel(application, parent,
        navigatorPanel.getSash(), inspectorPanel.getSash());
    return parent;
  }

  @Override
  protected MenuManager createMenuManager() {
    mainMenuBar = new MainMenuBar(application);
    return mainMenuBar;
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
   * Gets the background color.
   *
   * @return the background color.
   */
  public Color getBackgroundColor() {
    return backgroundColor;
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
  public CenterPanel getMainPanel() {
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

  /**
   * Gets the preview panel.
   *
   * @return the preview panel.
   * @return
   */
  public PreviewPanel getPreviewPanel() {
    final CenterTabFolder tabFolder = mainPanel.getTabFolder();
    final LibraryTab tab = tabFolder.getLibraryTab();
    return tab.getPreviewPanel();
  }
}
