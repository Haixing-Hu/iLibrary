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
 * The action to move the selected documents to the trash.
 *
 * @author Haixing Hu
 */
public class MoveToTrashAction extends BaseAction {

  public static final String KEY = LibraryAction.KEY + ".move-to-trash";

  public MoveToTrashAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }
}
