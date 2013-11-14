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
 * The action to edit a collection.
 *
 * @author Haixing Hu
 */
public class EditCollectionAction extends BaseAction {

  public static final String KEY = ManageCollectionAction.KEY + ".edit";

  public EditCollectionAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
    this.setShowDialog(true);
  }
}
