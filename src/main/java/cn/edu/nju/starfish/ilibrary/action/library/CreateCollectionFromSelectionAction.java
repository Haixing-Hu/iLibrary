/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.library;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to create a normal collection from the selection.
 *
 * @author Haixing Hu
 */
public class CreateCollectionFromSelectionAction extends BaseAction {

  public static final String KEY = CreateCollectionAction.KEY + ".selection";

  public CreateCollectionFromSelectionAction(Application application) {
    super(application, KEY);
  }
}
