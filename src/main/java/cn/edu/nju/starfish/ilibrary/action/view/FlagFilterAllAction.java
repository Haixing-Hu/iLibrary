/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseCheckBoxAction;
import cn.edu.nju.starfish.ilibrary.state.FlagFilter;

/**
 * The action to filter documents with all flag status.
 *
 * @author Haixing Hu
 */
public class FlagFilterAllAction extends BaseCheckBoxAction {

  public static final String KEY = FlagFilterAction.KEY + ".all";

  public FlagFilterAllAction(Application application) {
    super(application, KEY);
  }

  @Override
  public void run() {
    logger.info("Set the flag filter to {}", FlagFilter.ALL);
    FlagFilter.update(application, FlagFilter.ALL);
  }

}
