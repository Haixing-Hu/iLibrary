/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.share;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseDropDownAction;
import cn.edu.nju.starfish.ilibrary.action.file.ExportAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;

/**
 * The action to show the drop down menu of sharing related actions.
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
    SEPARATOR_KEY,
    EmailAction.KEY,
    SEPARATOR_KEY,
    ExportAction.KEY,
  };

  public ShareAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager, SUB_ACTIONS);
  }

}
