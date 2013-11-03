/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.window;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to show the information of the current document.
 *
 * @author Haixing Hu
 */
public class InfoAction extends BaseAction {

  public InfoAction(Application application) {
    super(application);
  }

  @Override
  public String getKey() {
    return "action.window.info";
  }

}
