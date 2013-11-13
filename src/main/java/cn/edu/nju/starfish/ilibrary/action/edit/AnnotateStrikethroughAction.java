/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.edit;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;
import cn.edu.nju.starfish.ilibrary.state.AnnotateMode;

/**
 * The action to switch to the strikethrough mode.
 *
 * @author Haixing Hu
 */
public class AnnotateStrikethroughAction extends BaseAction {

  public static final String KEY = AnnotateAction.KEY + ".strikethrough";

  public AnnotateStrikethroughAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

  @Override
  public void run() {
    AnnotateMode.update(application, AnnotateMode.STRIKETHORUGH);
  }
}
