/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.edit;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;
import cn.edu.nju.starfish.ilibrary.controller.DocumentTabController;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;
import cn.edu.nju.starfish.ilibrary.state.AnnotateMode;

/**
 * The action to switch to the highlight mode.
 *
 * @author Haixing Hu
 */
public class AnnotateHighlightAction extends BaseAction {

  public static final String KEY = AnnotateAction.KEY + ".highlight";

  public AnnotateHighlightAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

  @Override
  public void run() {
    final DocumentTabController controller = application.getDocumentTabController();
    controller.setAnnotateMode(AnnotateMode.HIGHLIGHT);
  }
}
