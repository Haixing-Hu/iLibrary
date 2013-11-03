/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.menu;

import org.eclipse.jface.action.MenuManager;

import cn.edu.nju.starfish.ilibrary.Application;

/**
 * The window menu.
 *
 * @author Haixing Hu
 */
public final class WindowMenu extends MenuManager {
  
  public static final String KEY = "menu.window";
  
  private final Application application;

  /**
   * Creates a window menu.
   * 
   * @param application
   *          the application this new menu belongs to.
   */
  public WindowMenu(Application application) {
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
