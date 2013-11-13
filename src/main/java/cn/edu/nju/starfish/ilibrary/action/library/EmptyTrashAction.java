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
 * The action to empty the trash.
 *
 * @author Haixing Hu
 */
public class EmptyTrashAction extends BaseAction {

  public static final String KEY = LibraryAction.KEY + ".empty-trash";

  public EmptyTrashAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }
}
