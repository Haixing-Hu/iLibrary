/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.menu;

import org.eclipse.jface.action.Separator;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.ActionManager;
import cn.edu.nju.starfish.ilibrary.action.file.CloseLibraryAction;
import cn.edu.nju.starfish.ilibrary.action.file.ExportAction;
import cn.edu.nju.starfish.ilibrary.action.file.ImportAction;
import cn.edu.nju.starfish.ilibrary.action.file.NewEntryAction;
import cn.edu.nju.starfish.ilibrary.action.file.NewLibraryAction;
import cn.edu.nju.starfish.ilibrary.action.file.OpenLibraryAction;
import cn.edu.nju.starfish.ilibrary.action.file.PageSetupAction;
import cn.edu.nju.starfish.ilibrary.action.file.PrintAction;
import cn.edu.nju.starfish.ilibrary.action.file.QuitAction;

/**
 * The file menu.
 *
 * @author Haixing Hu
 */
public final class FileMenu extends BaseMenu {

  public static final String KEY = "menu.file";

  /**
   * Creates a file menu.
   *
   * @param application
   *          the application this new menu belongs to.
   */
  public FileMenu(Application application) {
    super(application, KEY);
    final ActionManager am = application.getActionManager();
    this.add(am.getAction(NewEntryAction.KEY));
    this.add(am.getAction(NewLibraryAction.KEY));
    this.add(am.getAction(OpenLibraryAction.KEY));
    this.add(am.getAction(CloseLibraryAction.KEY));
    this.add(new Separator());
    this.add(am.getAction(ImportAction.KEY));
    this.add(am.getAction(ExportAction.KEY));
    this.add(new Separator());
    this.add(am.getAction(PageSetupAction.KEY));
    this.add(am.getAction(PrintAction.KEY));
    //  Mac will display the "Quit" menu item in its "Apple" menu item
//    if (! SystemUtils.IS_OS_MAC) {
      this.add(new Separator());
      this.add(am.getAction(QuitAction.KEY));
//    }

    this.disableItems(new String[] {
        PrintAction.KEY,
    });
    this.update(true);
  }

}
