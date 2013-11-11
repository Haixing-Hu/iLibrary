/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.share;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseDropDownAction;

/**
 * The action to share the document via email.
 *
 * @author Haixing Hu
 */
public class ShareAction extends BaseDropDownAction {

  public static final String KEY = "action.share";

  private static final String SUB_ACTIONS[] = {
    TwitterAction.KEY,
    FacebookAction.KEY,
    GooglePlusAction.KEY,
    SinaAction.KEY,
    TencentAction.KEY,
    EmailAction.KEY,
  };

  public ShareAction(Application application) {
    super(application, KEY, SUB_ACTIONS);
  }

}
