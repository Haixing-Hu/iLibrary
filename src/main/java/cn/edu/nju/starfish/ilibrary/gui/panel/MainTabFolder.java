/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.panel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;

import cn.edu.nju.starfish.ilibrary.Application;

/**
 * The main tab folder.
 *
 * @author Haixing Hu
 */
public class MainTabFolder extends CTabFolder {

  private final Application application;
  private LibraryTab libraryTab;

  public MainTabFolder(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
    configAppearance();
    configLayoutData();
    createContents();
  }

  /**
   * Configures the appearance of this tab folder.
   */
  private void configAppearance() {
    final Color bgcolor = SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT);
    setSelectionBackground(bgcolor);
  }

  /**
   * Configures the layout data of this tab folder.
   */
  private void configLayoutData() {
    final GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
    setLayoutData(layoutData);
  }

  /**
   * Creates contents of this tab folder.
   */
  private void createContents() {
    this.libraryTab = new LibraryTab(application, this);
    //  FIXME: test code
    new DocumentTab(application, this);
  }

  /**
   * Gets the library tab.
   *
   * @return the library tab.
   */
  public LibraryTab getLibraryTab() {
    return libraryTab;
  }

}
