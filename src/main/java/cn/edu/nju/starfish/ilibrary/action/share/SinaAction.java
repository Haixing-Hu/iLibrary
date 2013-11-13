/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.share;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;

/**
 * The action to share the document on the Sina Weibo.
 *
 * @author Haixing Hu
 */
public class SinaAction extends BaseAction {

  public static final String KEY = ShareAction.KEY + ".sina";

  public SinaAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

}
