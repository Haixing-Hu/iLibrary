/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.edit;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to delete the selected text or the selected document.
 *
 * @author Haixing Hu
 */
public class DeleteAction extends BaseAction {
  public static final String KEY = "action.edit.delete";

  public DeleteAction(Application application) {
    super(application, KEY);
  }
}
