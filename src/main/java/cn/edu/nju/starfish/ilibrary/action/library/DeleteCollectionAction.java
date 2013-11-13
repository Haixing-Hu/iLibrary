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
 * The action to delete a collection.
 *
 * @author Haixing Hu
 */
public class DeleteCollectionAction extends BaseAction {

  public static final String KEY = ManageCollectionAction.KEY + ".delete";

  public DeleteCollectionAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }
}
