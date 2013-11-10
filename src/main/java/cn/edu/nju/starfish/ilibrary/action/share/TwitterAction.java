/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.share;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to share the document on the Twitter.
 *
 * @author Haixing Hu
 */
public class TwitterAction extends BaseAction {

  public static final String KEY = "action.share.twitter";

  public TwitterAction(Application application) {
    super(application, KEY);
  }

}
