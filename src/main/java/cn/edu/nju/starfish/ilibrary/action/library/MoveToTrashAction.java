/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.library;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to move the selected documents to the trash.
 *
 * @author Haixing Hu
 */
public class MoveToTrashAction extends BaseAction {

  public MoveToTrashAction(Application application) {
    super(application);
  }

  @Override
  public String getKey() {
    return "action.library.move-to-trash";
  }

}
