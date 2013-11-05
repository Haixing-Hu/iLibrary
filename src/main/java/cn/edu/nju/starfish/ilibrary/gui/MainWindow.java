/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.menu.MainMenuBar;

/**
 * The main window of the application.
 *
 * @author Haixing Hu
 */
public final class MainWindow extends ApplicationWindow {

  private final Application application;
  private NavigationPanel navigationPanel;
  private ContentPanel contentPanel;
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
    SashForm container = new SashForm(parent, SWT.HORIZONTAL);
    navigationPanel = new NavigationPanel(container, SWT.BORDER);        
    contentPanel = new ContentPanel(container, SWT.BORDER);
    inspectorPanel = new InspectorPanel(container, SWT.BORDER);
//    container.setMaximizedControl(contentPanel);
    container.setSashWidth(5);
//    container.setWeights(new int[]{20, 60, 20});
    return container;
  }

  @Override
  protected MenuManager createMenuManager() {
    MenuManager menubar = new MainMenuBar(application);
    return menubar;
  }

  @Override
  protected StatusLineManager createStatusLineManager() {
    StatusLineManager statusLine = new StatusLineManager();
    statusLine.setMessage(application.getTitle() + " " + application.getVersion());
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
    shell.setText(application.getTitle());
  }

  /**
   * Return the initial size of the window.
   *
   * @return the initial size of the window.
   */
  @Override
  protected Point getInitialSize() {
    return new Point(800, 600);
  }

  /**
   * Gets the navigation panel. 
   *
   * @return the navigation panel.
   */
  public NavigationPanel getNavigationPanel() {
    return navigationPanel;
  }

  /**
   * Gets the content panel. 
   *
   * @return the content panel.
   */
  public ContentPanel getContentPanel() {
    return contentPanel;
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
