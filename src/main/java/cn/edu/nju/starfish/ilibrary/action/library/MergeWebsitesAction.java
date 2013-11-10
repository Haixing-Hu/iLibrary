/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.library;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to merge the selected websites.
 *
 * @author Haixing Hu
 */
public class MergeWebsitesAction extends BaseAction {

  public static final String KEY = "action.library.merge-websites";

  public MergeWebsitesAction(Application application) {
    super(application, KEY);
  }

}
