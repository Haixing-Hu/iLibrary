/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.library;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseDropDownAction;

/**
 * The action to create a new collection.
 *
 * @author Haixing Hu
 */
public class CreateCollectionAction extends BaseDropDownAction {

  public static final String KEY = "action.library.create-collection";

  private static final String SUB_ACTIONS[] = {
    CreateNormalCollectionAction.KEY,
    CreateSmartCollectionAction.KEY,
    CreateCollectionFromSelectionAction.KEY,
  };

  public CreateCollectionAction(Application application) {
    super(application, KEY, SUB_ACTIONS);
  }
}
