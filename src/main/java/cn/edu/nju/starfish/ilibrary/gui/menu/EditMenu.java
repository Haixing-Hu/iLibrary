/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.menu;

import org.eclipse.jface.action.Separator;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.ActionManager;
import cn.edu.nju.starfish.ilibrary.action.edit.CopyAction;
import cn.edu.nju.starfish.ilibrary.action.edit.CopyReferenceAction;
import cn.edu.nju.starfish.ilibrary.action.edit.CutAction;
import cn.edu.nju.starfish.ilibrary.action.edit.DeleteAction;
import cn.edu.nju.starfish.ilibrary.action.edit.FindAction;
import cn.edu.nju.starfish.ilibrary.action.edit.FindNextAction;
import cn.edu.nju.starfish.ilibrary.action.edit.FindPreviousAction;
import cn.edu.nju.starfish.ilibrary.action.edit.FontAction;
import cn.edu.nju.starfish.ilibrary.action.edit.PasteAction;
import cn.edu.nju.starfish.ilibrary.action.edit.PreferencesAction;
import cn.edu.nju.starfish.ilibrary.action.edit.RedoAction;
import cn.edu.nju.starfish.ilibrary.action.edit.SelectAllAction;
import cn.edu.nju.starfish.ilibrary.action.edit.StyleAction;
import cn.edu.nju.starfish.ilibrary.action.edit.UndoAction;

/**
 * The edit menu.
 *
 * @author Haixing Hu
 */
public final class EditMenu extends BaseMenu {

  public static final String KEY = "action.edit";

  /**
   * Creates a edit menu.
   *
   * @param application
   *          the application this new menu belongs to.
   */
  public EditMenu(Application application) {
    super(application, KEY);
    final ActionManager am = application.getActionManager();
    this.add(am.getAction(UndoAction.KEY));
    this.add(am.getAction(RedoAction.KEY));
    this.add(new Separator());
    this.add(am.getAction(CutAction.KEY));
    this.add(am.getAction(CopyAction.KEY));
    this.add(am.getAction(CopyReferenceAction.KEY));
    this.add(am.getAction(PasteAction.KEY));
    this.add(am.getAction(DeleteAction.KEY));
    this.add(am.getAction(SelectAllAction.KEY));
    this.add(new Separator());
    this.add(am.getAction(FontAction.KEY));
    this.add(am.getAction(StyleAction.KEY));
    this.add(new Separator());
    this.add(am.getAction(FindAction.KEY));
    this.add(am.getAction(FindPreviousAction.KEY));
    this.add(am.getAction(FindNextAction.KEY));
    //  Mac will display the "Preferences" menu item in its "Apple" menu item
//    if (! SystemUtils.IS_OS_MAC) {
      this.add(new Separator());
      this.add(am.getAction(PreferencesAction.KEY));
//    }

    this.disableItems(new String[] {
        UndoAction.KEY,
        RedoAction.KEY,
        CutAction.KEY,
        CopyAction.KEY,
        CopyReferenceAction.KEY,
        PasteAction.KEY,
        DeleteAction.KEY,
    });
    this.update(true);
  }

}
