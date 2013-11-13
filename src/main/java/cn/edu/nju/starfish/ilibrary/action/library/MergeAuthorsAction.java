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
 * The action to merge the selected authors.
 *
 * @author Haixing Hu
 */
public class MergeAuthorsAction extends BaseAction {

  public static final String KEY = LibraryAction.KEY + ".merge-authors";

  public MergeAuthorsAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }
}
