/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.main;

import org.eclipse.swt.widgets.Composite;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.widget.BaseTabFolder;

/**
 * The tab folder in the main panel.
 *
 * @author Haixing Hu
 */
public class MainTabFolder extends BaseTabFolder {

  public static final String KEY = MainPanel.KEY + ".tab";

  private LibraryTab libraryTab;

  public MainTabFolder(Application application, Composite parent) {
    super(application, KEY, parent);
  }

  @Override
  protected void createContents() {
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
