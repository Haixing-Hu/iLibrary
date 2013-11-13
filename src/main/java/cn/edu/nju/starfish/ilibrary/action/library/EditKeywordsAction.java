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
 * The action to edit the keywords of the selected document.
 *
 * @author Haixing Hu
 */
public class EditKeywordsAction extends BaseAction {

  public static final String KEY = LibraryAction.KEY + ".edit-keywords";

  public EditKeywordsAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }
}
