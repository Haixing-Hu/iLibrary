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

  public AddReviewAction(Application application) {
    super(application);
  }

  @Override
  public String getKey() {
    return "action.library.add-review";
  }

}
