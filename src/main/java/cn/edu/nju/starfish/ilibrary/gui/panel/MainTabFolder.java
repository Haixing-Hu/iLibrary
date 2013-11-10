/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.panel;

import org.apache.commons.configuration.Configuration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;

import cn.edu.nju.starfish.ilibrary.Application;

/**
 * The main tab folder.
 *
 * @author Haixing Hu
 */
public class MainTabFolder extends CTabFolder {

  public static final String KEY = MainPanel.KEY + ".tab";

  private final Application application;
  private LibraryTab libraryTab;

  public MainTabFolder(Application application, Composite parent) {
    //  IMPORTANT: in order to remove the margin of the tab folder, the
    //  style must be set to FLAT
    super(parent, SWT.FLAT | SWT.NO_FOCUS);
    this.application = application;
    this.marginHeight = 0;
    this.marginWidth = 0;
    //this.setSimple(false);

    configAppearance();
    createContents();
  }

  /**
   * Configures the appearance of this tab folder.
   */
  private void configAppearance() {
    final Configuration config = application.getConfig();
    final String bg_path = config.getString(KEY + ".selection.background");
    final Image bg_img = SWTResourceManager.getImage(MainTabFolder.class, bg_path);
    this.setSelectionBackground(bg_img);
    final Color color = SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND);
    this.setBackground(color);
  }

  /**
   * Creates contents of this tab folder.
   */
  private void createContents() {
    this.libraryTab = new LibraryTab(application, this);
    this.setSelection(libraryTab);
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
