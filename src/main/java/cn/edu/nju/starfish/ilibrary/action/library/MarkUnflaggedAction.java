/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.library;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to mark the selected documents as unflagged.
 *
 * @author Haixing Hu
 */
public class MarkUnflaggedAction extends BaseAction {

  public static final String KEY = "action.library.mark-unflagged";

  public MarkUnflaggedAction(Application application) {
    super(application, KEY);
  }
}
