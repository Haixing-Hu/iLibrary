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
 * The action to mark the selected documents as printed.
 *
 * @author Haixing Hu
 */
public class MarkPrintedAction extends BaseAction {

  public static final String KEY = LibraryAction.KEY + ".mark-printed";

  public MarkPrintedAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }
}
