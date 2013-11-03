/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to read the document in the full screen.
 *
 * @author Haixing Hu
 */
public class ReadFullScreenAction extends BaseAction {

  public ReadFullScreenAction(Application application) {
    super(application);
  }

  @Override
  public String getKey() {
    return "action.view.read-full-screen";
  }

}
