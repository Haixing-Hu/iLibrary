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
 * The action to filter documents which are under reading.
 *
 * @author Haixing Hu
 */
public class ReadFilterReadingAction extends BaseCheckBoxAction {

  public static final String KEY = ReadFilterAction.KEY + ".reading";

  public ReadFilterReadingAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

  @Override
  public void run() {
    logger.info("Set the read filter to {}", ReadFilter.READING);
    ReadFilter.update(application, ReadFilter.READING);
  }

}
