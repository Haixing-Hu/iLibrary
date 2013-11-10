/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.file;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to create a new entry.
 *
 * @author Haixing Hu
 */
public class NewEntryAction extends BaseAction {

  public static final String KEY = "action.file.new-entry";

  public NewEntryAction(Application application) {
    super(application, KEY);
  }

}
