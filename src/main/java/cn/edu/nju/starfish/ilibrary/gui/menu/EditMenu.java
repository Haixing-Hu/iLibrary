/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.menu;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;

import cn.edu.nju.starfish.ilibrary.Application;
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
public final class EditMenu extends MenuManager {

  public static final String KEY = "menu.edit";

  private final Application application;

  /**
   * Creates a edit menu.
   *
   * @param application
   *          the application this new menu belongs to.
   */
  public EditMenu(Application application) {
    super(application.getTitle(KEY));
    this.application = application;
    this.add(new UndoAction(application));
    this.add(new RedoAction(application));
    this.add(new Separator());
    this.add(new CutAction(application));
    this.add(new CopyAction(application));
    this.add(new CopyReferenceAction(application));
    this.add(new PasteAction(application));
    this.add(new DeleteAction(application));
    this.add(new SelectAllAction(application));
    this.add(new Separator());
    this.add(new FontAction(application));
    this.add(new StyleAction(application));
    this.add(new Separator());
    this.add(new FindAction(application));
    this.add(new FindPreviousAction(application));
    this.add(new FindNextAction(application));
    //  Mac will display the "Preferences" menu item in its "Apple" menu item
//    if (! SystemUtils.IS_OS_MAC) {
      this.add(new Separator());
      this.add(new PreferencesAction(application));
//    }
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
