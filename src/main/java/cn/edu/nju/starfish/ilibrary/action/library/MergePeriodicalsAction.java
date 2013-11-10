/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.library;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to merge the selected periodicals.
 *
 * @author Haixing Hu
 */
public class MergePeriodicalsAction extends BaseAction {

  public static final String KEY = "action.library.merge-periodicals";

  public MergePeriodicalsAction(Application application) {
    super(application, KEY);
  }

}
