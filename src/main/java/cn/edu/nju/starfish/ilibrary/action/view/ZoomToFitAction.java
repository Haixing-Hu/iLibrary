/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to zoom the current document to fit the size of the current window.
 *
 * @author Haixing Hu
 */
public class ZoomToFitAction extends BaseAction {

  public static final String KEY = "action.view.zoom-to-fit";

  public ZoomToFitAction(Application application) {
    super(application, KEY);
  }
}
