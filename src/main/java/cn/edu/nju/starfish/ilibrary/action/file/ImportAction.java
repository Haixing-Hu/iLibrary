/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.file;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;

/**
 * The action to import document entries.
 *
 * @author Haixing Hu
 */
public class ImportAction extends BaseAction {

  public static final String KEY = FileAction.KEY + ".import";

  public ImportAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
    this.setShowDialog(true);
  }

}
