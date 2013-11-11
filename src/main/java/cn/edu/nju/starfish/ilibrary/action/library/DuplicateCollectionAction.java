/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.library;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to duplicate a collection.
 *
 * @author Haixing Hu
 */
public class DuplicateCollectionAction extends BaseAction {

  public static final String KEY = ManageCollectionAction.KEY + ".duplicate";

  public DuplicateCollectionAction(Application application) {
    super(application, KEY);
  }
}
