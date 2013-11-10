/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to view as the webpage associated with the document.
 *
 * @author Haixing Hu
 */
public class AsWebpageAction extends BaseAction {

  public static final String KEY = "action.view.as-webpage";

  public AsWebpageAction(Application application) {
    super(application, KEY);
  }

}
