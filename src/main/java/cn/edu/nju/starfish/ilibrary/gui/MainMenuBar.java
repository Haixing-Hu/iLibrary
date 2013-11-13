/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.ActionManager;
import cn.edu.nju.starfish.ilibrary.action.edit.EditAction;
import cn.edu.nju.starfish.ilibrary.action.file.FileAction;
import cn.edu.nju.starfish.ilibrary.action.help.HelpAction;
import cn.edu.nju.starfish.ilibrary.action.library.LibraryAction;
import cn.edu.nju.starfish.ilibrary.action.share.ShareAction;
import cn.edu.nju.starfish.ilibrary.action.view.ViewAction;
import cn.edu.nju.starfish.ilibrary.action.window.WindowAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.MenuManager;

/**
 * The main menu bar of the application.
 *
 * @author Haixing Hu
 */
public final class MainMenuBar extends MenuManager {

  private final Application application;

  /**
   * Constructs a menu bar.
   *
   * @param application
   *    the application the new menu bar belongs.
   */
  public MainMenuBar(Application application) {
    super(false);
    this.application = application;
    final ActionManager am = application.getActionManager();
    this.add(am.get(FileAction.KEY));
    this.add(am.get(EditAction.KEY));
    this.add(am.get(ViewAction.KEY));
    this.add(am.get(LibraryAction.KEY));
    this.add(am.get(ShareAction.KEY));
    this.add(am.get(WindowAction.KEY));
    this.add(am.get(HelpAction.KEY));
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
