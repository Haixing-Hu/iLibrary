/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.library;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to merge the selected authors.
 *
 * @author Haixing Hu
 */
public class MergeAuthorsAction extends BaseAction {

  public static final String KEY = "action.library.merge-authors";

  public MergeAuthorsAction(Application application) {
    super(application, KEY);
  }
}
