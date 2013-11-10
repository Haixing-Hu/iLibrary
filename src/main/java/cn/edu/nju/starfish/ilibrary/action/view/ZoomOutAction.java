/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to zoom out the current document.
 *
 * @author Haixing Hu
 */
public class ZoomOutAction extends BaseAction {

  public static final String KEY = "action.view.zoom-out";

  public ZoomOutAction(Application application) {
    super(application, KEY);
  }
}
