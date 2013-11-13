/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.library;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to empty the trash.
 *
 * @author Haixing Hu
 */
public class EmptyTrashAction extends BaseAction {

  public static final String KEY = "action.library.empty-trash";

  public EmptyTrashAction(Application application) {
    super(application, KEY);
  }
}
