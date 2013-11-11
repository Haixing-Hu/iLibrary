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
 * The action to filter documents which are flagged.
 *
 * @author Haixing Hu
 */
public class FlagFilterFlaggedAction extends BaseCheckBoxAction {

  public static final String KEY = FlagFilterAction.KEY + ".flagged";

  public FlagFilterFlaggedAction(Application application) {
    super(application, KEY);
  }

  @Override
  public void run() {
    FlagFilter.update(application, FlagFilter.FLAGGED);
  }

}
