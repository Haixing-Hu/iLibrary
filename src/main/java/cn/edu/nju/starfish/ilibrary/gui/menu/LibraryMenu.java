/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.menu;

import org.eclipse.jface.action.MenuManager;

import cn.edu.nju.starfish.ilibrary.Application;

/**
 * The library menu.
 *
 * @author Haixing Hu
 */
public final class LibraryMenu extends MenuManager {
  
  public static final String KEY = "menu.library";
  
  private final Application application;

  /**
   * Creates a library menu.
   * 
   * @param application
   *          the application this new menu belongs to.
   */
  public LibraryMenu(Application application) {
    super(application.getTitle(KEY));
    this.application = application;
  }

  /**
   * Gets the application this menu belongs to.
   * 
   * @return the application this menu belongs to.
   */
  public Application getApplication() {
    return application;
  }
  
}
