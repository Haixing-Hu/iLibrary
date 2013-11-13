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
 * The action to add the selected documents to a specified collection.
 *
 * @author Haixing Hu
 */
public class AddToCollectionAction extends BaseAction {

  public static final String KEY = LibraryAction.KEY + ".add-to-collection";

  public AddToCollectionAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

}
