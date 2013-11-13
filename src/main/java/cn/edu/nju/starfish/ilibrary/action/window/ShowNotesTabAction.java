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
 * The action to show the notes of the current document.
 *
 * @author Haixing Hu
 */
public class ShowNotesTabAction extends BaseAction {

  public static final String KEY = WindowAction.KEY + ".notes";

  public ShowNotesTabAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

}
