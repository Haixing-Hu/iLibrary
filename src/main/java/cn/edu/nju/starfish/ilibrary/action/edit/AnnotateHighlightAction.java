/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.edit;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;
import cn.edu.nju.starfish.ilibrary.state.AnnotateMode;

/**
 * The action to switch to the highlight mode.
 *
 * @author Haixing Hu
 */
public class AnnotateHighlightAction extends BaseAction {

  public static final String KEY = "action.edit.annotate.highlight";

  public AnnotateHighlightAction(Application application) {
    super(application, KEY);
  }

  @Override
  public void run() {
    AnnotateMode.update(application, AnnotateMode.HIGHLIGHT);
  }
}
