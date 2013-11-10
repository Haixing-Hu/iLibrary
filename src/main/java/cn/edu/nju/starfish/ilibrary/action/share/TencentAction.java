/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.share;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to share the document on the Tencent Weibo.
 *
 * @author Haixing Hu
 */
public class TencentAction extends BaseAction {

  public static final String KEY = "action.share.tencent";

  public TencentAction(Application application) {
    super(application, KEY);
  }
}
