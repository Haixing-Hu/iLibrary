/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.panel;

import org.eclipse.swt.widgets.Composite;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.widget.BaseTabFolder;

/**
 * The main tab folder.
 *
 * @author Haixing Hu
 */
public class CenterTabFolder extends BaseTabFolder {

  public static final String KEY = CenterPanel.KEY + ".tab";

  private LibraryTab libraryTab;

  public CenterTabFolder(Application application, Composite parent) {
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
