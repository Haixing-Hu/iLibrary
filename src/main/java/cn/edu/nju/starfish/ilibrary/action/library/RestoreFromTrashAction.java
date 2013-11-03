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

  public RestoreFromTrashAction(Application application) {
    super(application);
  }

  @Override
  public String getKey() {
    return "action.library.restore-from-trash";
  }

}
