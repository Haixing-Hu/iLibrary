/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.library;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseDropDownAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;

/**
 * The action to manage collections.
 *
 * @author Haixing Hu
 */
public class ManageCollectionAction extends BaseDropDownAction {

  public static final String KEY = LibraryAction.KEY + ".manage-collection";

  private static final String SUB_ACTIONS[] = {
    EditCollectionAction.KEY,
    RefreshCollectionAction.KEY,
    DuplicateCollectionAction.KEY,
    DeleteCollectionAction.KEY,
  };

  public ManageCollectionAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager, SUB_ACTIONS);
  }
}
