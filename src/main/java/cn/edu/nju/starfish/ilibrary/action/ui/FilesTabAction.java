/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.ui;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseCheckBoxAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;
import cn.edu.nju.starfish.ilibrary.state.InspectorTab;

/**
 * The action to switch to the files tab.
 *
 * @author Haixing Hu
 */
public class FilesTabAction extends BaseCheckBoxAction {

  public static final String KEY = "action.ui.files-tab";

  public FilesTabAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

  @Override
  public void run() {
    logger.info("Switch inspector tab to {}", InspectorTab.FILES);
    InspectorTab.update(application, InspectorTab.FILES);
  }

}
