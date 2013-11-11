/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.menu;

import org.eclipse.jface.action.Separator;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.ActionManager;
import cn.edu.nju.starfish.ilibrary.action.window.CloseAllTabsAction;
import cn.edu.nju.starfish.ilibrary.action.window.CloseTabAction;
import cn.edu.nju.starfish.ilibrary.action.window.CycleTabsAction;
import cn.edu.nju.starfish.ilibrary.action.window.FilesAction;
import cn.edu.nju.starfish.ilibrary.action.window.InfoAction;
import cn.edu.nju.starfish.ilibrary.action.window.LibraryAction;
import cn.edu.nju.starfish.ilibrary.action.window.MaximizeAction;
import cn.edu.nju.starfish.ilibrary.action.window.MinimizeAction;
import cn.edu.nju.starfish.ilibrary.action.window.MinimizeAllAction;
import cn.edu.nju.starfish.ilibrary.action.window.NextTabAction;
import cn.edu.nju.starfish.ilibrary.action.window.NotesAction;
import cn.edu.nju.starfish.ilibrary.action.window.PreviousTabAction;
import cn.edu.nju.starfish.ilibrary.action.window.ReviewsAction;

/**
 * The window menu.
 *
 * @author Haixing Hu
 */
public final class WindowMenu extends BaseMenu {

  public static final String KEY = "action.window";

  /**
   * Creates a window menu.
   *
   * @param application
   *          the application this new menu belongs to.
   */
  public WindowMenu(Application application) {
    super(application, KEY);
    final ActionManager am = application.getActionManager();
    this.add(am.getAction(MinimizeAction.KEY));
    this.add(am.getAction(MinimizeAllAction.KEY));
    this.add(am.getAction(MaximizeAction.KEY));
    this.add(new Separator());
    this.add(am.getAction(LibraryAction.KEY));
    this.add(am.getAction(InfoAction.KEY));
    this.add(am.getAction(NotesAction.KEY));
    this.add(am.getAction(ReviewsAction.KEY));
    this.add(am.getAction(FilesAction.KEY));
    this.add(new Separator());
    this.add(am.getAction(CycleTabsAction.KEY));
    this.add(am.getAction(PreviousTabAction.KEY));
    this.add(am.getAction(NextTabAction.KEY));
    this.add(new Separator());
    this.add(am.getAction(CloseTabAction.KEY));
    this.add(am.getAction(CloseAllTabsAction.KEY));

    this.disableItems(new String[] {
        PreviousTabAction.KEY,
        CloseTabAction.KEY,
    });
    this.update(true);
  }
}
