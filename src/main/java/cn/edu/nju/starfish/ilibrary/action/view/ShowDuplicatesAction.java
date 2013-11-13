/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;

/**
 * The action to show only the duplicates documents.
 *
 * @author Haixing Hu
 */
public class ShowDuplicatesAction extends BaseAction {

  public static final String KEY = ViewAction.KEY + ".show-duplicates";

  public ShowDuplicatesAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

}
