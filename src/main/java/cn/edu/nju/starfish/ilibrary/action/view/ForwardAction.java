/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to go forward in the visiting history.
 *
 * @author Haixing Hu
 */
public class ForwardAction extends BaseAction {

  public static final String KEY = "action.view.forward";

  public ForwardAction(Application application) {
    super(application, KEY);
  }
}
