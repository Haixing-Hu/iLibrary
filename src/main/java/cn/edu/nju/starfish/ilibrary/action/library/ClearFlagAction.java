/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.library;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to clear the flag of the current document.
 *
 * @author Haixing Hu
 */
public class ClearFlagAction extends BaseAction {

  public static final String KEY = "action.library.clear-flag";

  public ClearFlagAction(Application application) {
    super(application, KEY);
  }

}
