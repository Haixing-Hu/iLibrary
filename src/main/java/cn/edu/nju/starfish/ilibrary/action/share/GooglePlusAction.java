/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.share;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to share the document on the Google+.
 *
 * @author Haixing Hu
 */
public class GooglePlusAction extends BaseAction {

  public GooglePlusAction(Application application) {
    super(application);
  }

  @Override
  public String getKey() {
    return "action.share.google-plus";
  }

}
