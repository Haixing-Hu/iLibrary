/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.edit;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to find the specified text or the specified document.
 *
 * @author Haixing Hu
 */
public class FindAction extends BaseAction {
  public static final String KEY = "action.edit.find";

  public FindAction(Application application) {
    super(application, KEY);
  }

}
