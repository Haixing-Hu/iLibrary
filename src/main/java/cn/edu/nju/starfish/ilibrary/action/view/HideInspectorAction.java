/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to hide the inspector panel.
 *
 * @author Haixing Hu
 */
public class HideInspectorAction extends BaseAction {

  public HideInspectorAction(Application application) {
    super(application);
  }

  @Override
  public String getKey() {
    return "action.view.hide-inspector";
  }

}
