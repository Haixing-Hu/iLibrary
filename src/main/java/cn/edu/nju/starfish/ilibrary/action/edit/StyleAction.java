/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.edit;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to select the style of reference.
 *
 * @author Haixing Hu
 */
public class StyleAction extends BaseAction {
  public static final String KEY = "action.edit.style";

  public StyleAction(Application application) {
    super(application, KEY);
  }

}
