/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.inspector;

import org.apache.commons.configuration.Configuration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.KeySuffix;
import cn.edu.nju.starfish.ilibrary.gui.MainWindow;

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
  private InspectorHeader header;
  private InspectorTabFolder tabFolder;

  public InspectorPanel(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
    final Configuration config = application.getConfig();
    defaultWidth = config.getInt(KEY + KeySuffix.DEFAULT_WIDTH);
    minWidth = config.getInt(KEY + KeySuffix.MIN_WIDTH);
    maxWidth = config.getInt(KEY + KeySuffix.MAX_WIDTH);
    createContents();
    layoutContents();
  }

  /**
   * Creates the contents of this panel.
   */
  private void createContents() {
    header = new InspectorHeader(application, this);
    tabFolder = new InspectorTabFolder(application, this);
  }

  private void layoutContents() {
    final FormLayout layout = new FormLayout();
    layout.marginTop = 0;
    layout.marginBottom = 0;
    layout.marginLeft = 0;
    layout.marginRight = 0;
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    layout.spacing = 0;
    this.setLayout(layout);

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
