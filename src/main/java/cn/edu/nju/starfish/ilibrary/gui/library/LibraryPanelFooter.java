/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.library;

import org.eclipse.swt.widgets.Composite;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.MainPanelFooter;

/**
 * The footer the library panel.
 *
 * @author Haixing Hu
 */
public class LibraryPanelFooter extends MainPanelFooter {

  /**
   * Creates a status line.
   *
   * @param application
   *    the application.
   * @param parent
   *    the parent of the new status line.
   */
  public LibraryPanelFooter(Application application, Composite parent) {
    super(application, parent);
  }
}
