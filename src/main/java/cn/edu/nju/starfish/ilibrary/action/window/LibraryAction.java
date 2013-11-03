/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.window;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to switch to the library tab.
 *
 * @author Haixing Hu
 */
public class LibraryAction extends BaseAction {

  public LibraryAction(Application application) {
    super(application);
  }

  @Override
  public String getKey() {
    return "action.window.library";
  }

}
