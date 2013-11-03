/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.edit;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to find the next match.
 *
 * @author Haixing Hu
 */
public class FindNextAction extends BaseAction {

  public FindNextAction(Application application) {
    super(application);
  }

  @Override
  public String getKey() {
    return "action.edit.find-next";
  }

}
