/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to hide the preview panel.
 *
 * @author Haixing Hu
 */
public class HidePreviewAction extends BaseAction {

  public HidePreviewAction(Application application) {
    super(application);
  }

  @Override
  public String getKey() {
    return "action.view.hide-preview";
  }

}
