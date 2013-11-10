/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to view the document in the actual size.
 *
 * @author Haixing Hu
 */
public class ActualSizeAction extends BaseAction {

  public static final String KEY = "action.view.actual-size";

  public ActualSizeAction(Application application) {
    super(application, KEY);
  }

}
