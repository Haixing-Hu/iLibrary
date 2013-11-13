/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.file;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseDropDownAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;

/**
 * The action to show the drop down menu of file related actions.
 *
 * @author Haixing Hu
 */
public class FileAction extends BaseDropDownAction {

  public static final String KEY = "action.file";

  private static final String SUB_ACTIONS[] = {
    NewEntryAction.KEY,
    NewLibraryAction.KEY,
    OpenLibraryAction.KEY,
    CloseLibraryAction.KEY,
    SEPARATOR_KEY,
    ImportAction.KEY,
    ExportAction.KEY,
    SEPARATOR_KEY,
    PageSetupAction.KEY,
    PrintAction.KEY,
    SEPARATOR_KEY,
    QuitAction.KEY,
  };

  public FileAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager, SUB_ACTIONS);
  }

}
