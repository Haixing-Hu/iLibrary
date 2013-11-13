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
 * The action to merge the selected periodicals.
 *
 * @author Haixing Hu
 */
public class MergePeriodicalsAction extends BaseAction {

  public static final String KEY = LibraryAction.KEY + ".merge-periodicals";

  public MergePeriodicalsAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

}
