/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.library;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to restore the selected documents from the trash.
 *
 * @author Haixing Hu
 */
public class RestoreFromTrashAction extends BaseAction {

  public static final String KEY = "action.library.restore-from-trash";

  public RestoreFromTrashAction(Application application) {
    super(application, KEY);
  }

}
