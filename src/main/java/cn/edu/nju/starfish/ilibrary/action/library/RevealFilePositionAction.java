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
 * The action to reveal the storage position of the files of the selected documents.
 *
 * @author Haixing Hu
 */
public class RevealFilePositionAction extends BaseAction {

  public static final String KEY = LibraryAction.KEY + ".reveal-file-position";

  public RevealFilePositionAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }
}
