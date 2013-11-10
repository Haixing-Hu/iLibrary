/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.library;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to add a review to the current document.
 *
 * @author Haixing Hu
 */
public class AddReviewAction extends BaseAction {

  public static final String KEY = "action.library.add-review";

  public AddReviewAction(Application application) {
    super(application, KEY);
  }
}
