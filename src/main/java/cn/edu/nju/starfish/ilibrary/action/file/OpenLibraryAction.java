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
 * The action to open an existing library.
 *
 * @author Haixing Hu
 */
public class OpenLibraryAction extends BaseAction {

  public static final String KEY = FileAction.KEY + ".open-library";

  public OpenLibraryAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }
}
