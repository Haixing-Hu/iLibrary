/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.edit;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;

/**
 * The action to copy the selected text.
 *
 * @author Haixing Hu
 */
public class CopyAction extends BaseAction {

  public static final String KEY = EditAction.KEY + ".copy";

  public CopyAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }
}
