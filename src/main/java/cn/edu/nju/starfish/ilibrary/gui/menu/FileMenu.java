/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.menu;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;

import cn.edu.nju.starfish.ilibrary.Application;
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
public final class FileMenu extends MenuManager {

  public static final String KEY = "menu.file";

  private final Application application;

  /**
   * Creates a file menu.
   *
   * @param application
   *          the application this new menu belongs to.
   */
  public FileMenu(Application application) {
    super(application.getTitle(KEY));
    this.application = application;
    this.add(new NewEntryAction(application));
    this.add(new NewLibraryAction(application));
    this.add(new OpenLibraryAction(application));
    this.add(new CloseLibraryAction(application));
    this.add(new Separator());
    this.add(new ImportAction(application));
    this.add(new ExportAction(application));
    this.add(new Separator());
    this.add(new PageSetupAction(application));
    this.add(new PrintAction(application));
    //  Mac will display the "Quit" menu item in its "Apple" menu item
//    if (! SystemUtils.IS_OS_MAC) {
      this.add(new Separator());
      this.add(new QuitAction(application));
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
