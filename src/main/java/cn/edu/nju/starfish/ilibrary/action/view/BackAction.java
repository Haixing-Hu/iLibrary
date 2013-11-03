/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to go back in the visiting history.
 *
 * @author Haixing Hu
 */
public class BackAction extends BaseAction {

  public BackAction(Application application) {
    super(application);
  }

  @Override
  public String getKey() {
    return "action.view.back";
  }
}
