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
 * The action to archive the selected documents.
 *
 * @author Haixing Hu
 */
public class ArchiveAction extends BaseAction {

  public static final String KEY = LibraryAction.KEY + ".archive";

  public ArchiveAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }
}
