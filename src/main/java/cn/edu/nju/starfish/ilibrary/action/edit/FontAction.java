/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.edit;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to set the display font.
 *
 * @author Haixing Hu
 */
public class FontAction extends BaseAction {
  public static final String KEY = "action.edit.font";

  public FontAction(Application application) {
    super(application, KEY);
  }

}
