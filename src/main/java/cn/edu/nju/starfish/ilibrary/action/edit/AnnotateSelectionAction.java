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
 * The action to switch to the text selection mode.
 *
 * @author Haixing Hu
 */
public class AnnotateSelectionAction extends BaseAction {

  public static final String KEY = AnnotateAction.KEY + ".selection";

  public AnnotateSelectionAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

  @Override
  public void run() {
    AnnotateMode.update(application, AnnotateMode.SELECTION);
  }
}
