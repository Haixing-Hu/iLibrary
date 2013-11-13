/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.library;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;

/**
 * The action to restore the selected documents from the trash.
 *
 * @author Haixing Hu
 */
public class RestoreFromTrashAction extends BaseAction {

  public static final String KEY = LibraryAction.KEY + ".restore-from-trash";

  public RestoreFromTrashAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

}
