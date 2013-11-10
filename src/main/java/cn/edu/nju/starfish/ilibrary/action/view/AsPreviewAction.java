/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to view as the preview of the electronic document.
 *
 * @author Haixing Hu
 */
public class AsPreviewAction extends BaseAction {

  public static final String KEY = "action.view.as-preview";

  public AsPreviewAction(Application application) {
    super(application, KEY);
  }
}
