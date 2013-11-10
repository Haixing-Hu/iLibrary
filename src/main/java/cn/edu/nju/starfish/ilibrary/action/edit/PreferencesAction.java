/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.edit;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to set the preferences.
 *
 * @author Haixing Hu
 */
public class PreferencesAction extends BaseAction {
  public static final String KEY = "action.edit.preferences";

  public PreferencesAction(Application application) {
    super(application, KEY);
  }
}
