/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.panel;

import org.apache.commons.configuration.Configuration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.toolbar.MainToolBar;

/**
 * The panel displaying the content of library or document.
 *
 * @author Haixing Hu
 */
public class MainPanel extends Composite {

  public static final String KEY = "gui.main-panel";

  private final Application application;
  private final int minWidth;
  private final int maxWidth;
  private MainTabFolder tabFolder;
  private MainToolBar toolBar;

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
    super(parent, SWT.BORDER);
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
    final GridLayout layout = new GridLayout(1, false);
    layout.verticalSpacing = 3;
    layout.marginTop = 0;
    layout.marginBottom = 3;
    layout.marginLeft = 0;
    layout.marginRight = 0;
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    setLayout(layout);
    tabFolder = new MainTabFolder(application, this);
    toolBar = new MainToolBar(application, this);
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
}
