/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.edit;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseDropDownAction;

/**
 * The action to switch to the highlight mode.
 *
 * @author Haixing Hu
 */
public class AnnotateAction extends BaseDropDownAction {

  public static final String KEY = "action.edit.annotate";

  private static final String ACTIONS[] = {
    AnnotateSelectionAction.KEY,
    AnnotateHighlightAction.KEY,
    AnnotateUnderlineAction.KEY,
    AnnotateStrikethroughAction.KEY,
  };

  public AnnotateAction(Application application) {
    super(application, KEY, ACTIONS);
  }
}
