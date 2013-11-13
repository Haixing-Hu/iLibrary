/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.file;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;

/**
 * The action to close the current library.
 *
 * @author Haixing Hu
 */
public class CloseLibraryAction extends BaseAction {

  public static final String KEY = FileAction.KEY + ".close-library";

  public CloseLibraryAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }
}
