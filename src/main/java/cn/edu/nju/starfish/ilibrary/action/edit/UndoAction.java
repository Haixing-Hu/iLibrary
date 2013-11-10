/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.edit;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to undo the last operation.
 *
 * @author Haixing Hu
 */
public class UndoAction extends BaseAction {
  public static final String KEY = "action.edit.undo";

  public UndoAction(Application application) {
    super(application, KEY);
  }
}
