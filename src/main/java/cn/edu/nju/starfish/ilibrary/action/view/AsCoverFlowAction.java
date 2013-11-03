/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to view as cover flow.
 *
 * @author Haixing Hu
 */
public class AsCoverFlowAction extends BaseAction {

  public AsCoverFlowAction(Application application) {
    super(application);
  }

  @Override
  public String getKey() {
    return "action.view.as-cover-flow";
  }

}
