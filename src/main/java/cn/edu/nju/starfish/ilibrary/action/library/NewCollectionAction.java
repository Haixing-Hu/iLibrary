/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.library;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to create a new collection.
 *
 * @author Haixing Hu
 */
public class NewCollectionAction extends BaseAction {

  public static final String KEY = "action.library.new-collection";

  public NewCollectionAction(Application application) {
    super(application, KEY);
  }
}
