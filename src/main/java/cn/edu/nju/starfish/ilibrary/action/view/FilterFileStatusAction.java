/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseDropDownAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;

/**
 * The action to filter documents by their file status.
 *
 * @author Haixing Hu
 */
public class FilterFileStatusAction extends BaseDropDownAction {

  public static final String KEY = ViewAction.KEY + ".filter.file";

  private static final String SUB_ACTIONS[] = {
    FilterFileStatusAllAction.KEY,
    FilterFileStatusHasFileAction.KEY,
    FilterFileStatusNoFileAction.KEY,
  };

  public FilterFileStatusAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager, SUB_ACTIONS);
  }
}
