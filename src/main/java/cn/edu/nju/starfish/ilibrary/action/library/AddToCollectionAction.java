/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.library;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to add the selected documents to a specified collection.
 *
 * @author Haixing Hu
 */
public class AddToCollectionAction extends BaseAction {

  public static final String KEY = "action.library.add-to-collection";

  public AddToCollectionAction(Application application) {
    super(application, KEY);
  }

}
