/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.main;

import org.apache.commons.configuration.Configuration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.MainWindow;

/**
 * The main panel.
 *
 * @author Haixing Hu
 */
public class MainPanel extends Composite {

  public static final String KEY = MainWindow.KEY + ".main";

  private final Application application;
  private final int minWidth;
  private final int maxWidth;
  private MainTabFolder tabFolder;
  private MainToolBar toolBar;
  private MainFooter footer;

  /**
   * Constructs a {@link MainPanel}.
   *
   * @param application
   *          the application the new panel belongs.
   * @param parent
   *          the parent of the new panel.
   * @param left
   *          the left control of the new panel.
   * @param right
   *          the right control of the new panel.
   */
  public MainPanel(Application application, Composite parent, Control left, Control right) {
    super(parent, SWT.NONE);
    this.application = application;
    final Configuration config = application.getConfig();
    minWidth = config.getInt(KEY + ".width.min");
    maxWidth = config.getInt(KEY + ".width.max");
    configLayoutData(left, right);
    createContents();
  }

  /**
   * Configures the layout data of this panel.
   *
   * @param left
   *          the left control of the new panel.
   * @param right
   *          the right control of the new panel.
   */
  private void configLayoutData(Control left, Control right) {
    final FormData layoutData = new FormData();
    layoutData.left = new FormAttachment(left);
    layoutData.top = new FormAttachment(0);
    layoutData.right = new FormAttachment(right);
    layoutData.bottom = new FormAttachment(100);
    this.setLayoutData(layoutData);
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

    tabFolder = new MainTabFolder(application, this);
    toolBar = new MainToolBar(application, this);
    footer = new MainFooter(application, this);

    final FormData fd_tabFolder = new FormData();
    fd_tabFolder.left = new FormAttachment(0);
    fd_tabFolder.top = new FormAttachment(0);
    fd_tabFolder.right = new FormAttachment(100);
    fd_tabFolder.bottom = new FormAttachment(toolBar);
    tabFolder.setLayoutData(fd_tabFolder);

    final FormData fd_toolBar = new FormData();
    fd_toolBar.left = new FormAttachment(0);
    fd_toolBar.top = new FormAttachment(footer, - toolBar.getHeight());
    fd_toolBar.right = new FormAttachment(100);
    fd_toolBar.bottom = new FormAttachment(footer);
    toolBar.setLayoutData(fd_toolBar);

    final FormData fd_statusLine = new FormData();
    fd_statusLine.left = new FormAttachment(0);
    fd_statusLine.top = new FormAttachment(100, - footer.getHeight());
    fd_statusLine.right = new FormAttachment(100);
    fd_statusLine.bottom = new FormAttachment(100);
    footer.setLayoutData(fd_statusLine);

    final String name = application.getName();
    final String version = application.getVersion();
    footer.setMessage(name + " " + version);
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
   * Gets the tab folder of this panel.
   *
   * @return
   *    the tab folder of this panel.
   */
  public MainTabFolder getTabFolder() {
    return tabFolder;
  }

  /**
   * Gets the tool bar of this panel.
   *
   * @return
   *    the tool bar of this panel.
   */
  public MainToolBar getToolBar() {
    return toolBar;
  }

  /**
   * Gets the footer.
   *
   * @return the footer.
   */
  public MainFooter getFooter() {
    return footer;
  }
}
