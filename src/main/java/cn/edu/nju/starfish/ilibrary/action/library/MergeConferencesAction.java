/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.library;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to merge the selected conferences.
 *
 * @author Haixing Hu
 */
public class MergeConferencesAction extends BaseAction {

  public MergeConferencesAction(Application application) {
    super(application);
  }

  @Override
  public String getKey() {
    return "action.library.merge-conferences";
  }

}
