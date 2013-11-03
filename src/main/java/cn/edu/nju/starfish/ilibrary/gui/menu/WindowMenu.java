/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.menu;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.window.CloseAllTabsAction;
import cn.edu.nju.starfish.ilibrary.action.window.CloseTabAction;
import cn.edu.nju.starfish.ilibrary.action.window.CycleTabsAction;
import cn.edu.nju.starfish.ilibrary.action.window.MaximizeAction;
import cn.edu.nju.starfish.ilibrary.action.window.MinimizeAction;
import cn.edu.nju.starfish.ilibrary.action.window.MinimizeAllAction;
import cn.edu.nju.starfish.ilibrary.action.window.NextTabAction;
import cn.edu.nju.starfish.ilibrary.action.window.PreviousTabAction;
import cn.edu.nju.starfish.ilibrary.action.window.FilesAction;
import cn.edu.nju.starfish.ilibrary.action.window.InfoAction;
import cn.edu.nju.starfish.ilibrary.action.window.LibraryAction;
import cn.edu.nju.starfish.ilibrary.action.window.NotesAction;
import cn.edu.nju.starfish.ilibrary.action.window.ReviewsAction;

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
    this.add(new MinimizeAction(application));
    this.add(new MinimizeAllAction(application));
    this.add(new MaximizeAction(application));
    this.add(new Separator());
    this.add(new LibraryAction(application));
    this.add(new InfoAction(application));
    this.add(new NotesAction(application));
    this.add(new ReviewsAction(application));
    this.add(new FilesAction(application));
    this.add(new Separator());
    this.add(new CycleTabsAction(application));
    this.add(new PreviousTabAction(application));
    this.add(new NextTabAction(application));
    this.add(new Separator());
    this.add(new CloseTabAction(application));
    this.add(new CloseAllTabsAction(application));
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
