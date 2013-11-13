/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseCheckBoxAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;
import cn.edu.nju.starfish.ilibrary.state.ReadFilter;

/**
 * The action to filter documents with all read status.
 *
 * @author Haixing Hu
 */
public class ReadFilterAllAction extends BaseCheckBoxAction {

  public static final String KEY = ReadFilterAction.KEY + ".all";

  public ReadFilterAllAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

  @Override
  public void run() {
    logger.info("Set the read filter to {}", ReadFilter.ALL);
    ReadFilter.update(application, ReadFilter.ALL);
  }
}
