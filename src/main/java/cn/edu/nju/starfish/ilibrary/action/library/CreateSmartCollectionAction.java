/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.library;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to create a smart collection.
 *
 * @author Haixing Hu
 */
public class CreateSmartCollectionAction extends BaseAction {

  public static final String KEY = CreateCollectionAction.KEY + ".smart";

  public CreateSmartCollectionAction(Application application) {
    super(application, KEY);
  }
}
