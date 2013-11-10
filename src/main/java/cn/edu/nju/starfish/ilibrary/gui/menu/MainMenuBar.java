/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.menu;

import org.eclipse.jface.action.MenuManager;

import cn.edu.nju.starfish.ilibrary.Application;

/**
 * The main menu bar of the application.
 *
 * @author Haixing Hu
 */
public final class MainMenuBar extends MenuManager {

  private final Application application;
  private final FileMenu fileMenu;
  private final EditMenu editMenu;
  private final ViewMenu viewMenu;
  private final LibraryMenu libraryMenu;
  private final ShareMenu shareMenu;
  private final WindowMenu windowMenu;
  private final HelpMenu helpMenu;

  /**
   * Constructs a menu bar.
   *
   * @param application
   *    the application the new menu bar belongs.
   */
  public MainMenuBar(Application application) {
    super("menu");
    this.application = application;
    this.fileMenu = new FileMenu(application);
    this.editMenu = new EditMenu(application);
    this.viewMenu = new ViewMenu(application);
    this.libraryMenu = new LibraryMenu(application);
    this.shareMenu = new ShareMenu(application);
    this.windowMenu = new WindowMenu(application);
    this.helpMenu = new HelpMenu(application);
    this.add(this.fileMenu);
    this.add(this.editMenu);
    this.add(this.viewMenu);
    this.add(this.libraryMenu);
    this.add(this.shareMenu);
    this.add(this.windowMenu);
    this.add(this.helpMenu);
  }

  /**
   * Gets the application this menu belongs to.
   *
   * @return the application this menu belongs to.
   */
  public Application getApplication() {
    return application;
  }

  /**
   * Gets the file menu.
   *
   * @return the file menu.
   */
  public FileMenu getFileMenu() {
    return fileMenu;
  }

  /**
   * Gets the edit menu.
   *
   * @return the edit menu.
   */
  public EditMenu getEditMenu() {
    return editMenu;
  }

  /**
   * Gets the view menu.
   *
   * @return the view menu.
   */
  public ViewMenu getViewMenu() {
    return viewMenu;
  }

  /**
   * Gets the library menu.
   *
   * @return the library menu.
   */
  public LibraryMenu getLibraryMenu() {
    return libraryMenu;
  }

  /**
   * Gets the share menu.
   *
   * @return the share menu.
   */
  public ShareMenu getShareMenu() {
    return shareMenu;
  }

  /**
   * Gets the window menu.
   *
   * @return the window menu.
   */
  public WindowMenu getWindowMenu() {
    return windowMenu;
  }

  /**
   * Gets the help menu.
   *
   * @return the help menu.
   */
  public HelpMenu getHelpMenu() {
    return helpMenu;
  }
}
