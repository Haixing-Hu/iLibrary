/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseCheckBoxAction;
import cn.edu.nju.starfish.ilibrary.state.ReadFilter;

/**
 * The action to filter documents which are under reading.
 *
 * @author Haixing Hu
 */
public class ReadFilterReadingAction extends BaseCheckBoxAction {

  public static final String KEY = ReadFilterAction.KEY + ".reading";

  public ReadFilterReadingAction(Application application) {
    super(application, KEY);
  }

  @Override
  public void run() {
    ReadFilter.update(application, ReadFilter.READING);
  }

}
