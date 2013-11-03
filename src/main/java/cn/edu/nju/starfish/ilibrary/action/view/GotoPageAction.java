/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to goto the specified page in the document.
 *
 * @author Haixing Hu
 */
public class GotoPageAction extends BaseAction {

  public GotoPageAction(Application application) {
    super(application);
  }

  @Override
  public String getKey() {
    return "action.view.goto-page";
  }

}
