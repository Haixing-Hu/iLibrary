/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.window;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;

/**
 * The action to show files associated with the current document.
 *
 * @author Haixing Hu
 */
public class ShowFilesTabAction extends BaseAction {

  public static final String KEY = WindowAction.KEY + ".files";

  public ShowFilesTabAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }
}
