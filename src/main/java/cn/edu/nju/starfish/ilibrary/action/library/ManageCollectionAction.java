/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.library;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to manage collections.
 *
 * @author Haixing Hu
 */
public class ManageCollectionAction extends BaseAction {

  public static final String KEY = "action.library.manage-collection";

  public ManageCollectionAction(Application application) {
    super(application, KEY);
  }
}
