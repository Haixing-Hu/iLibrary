/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseCheckBoxAction;
import cn.edu.nju.starfish.ilibrary.state.TypeFilter;

/**
 * The action to filter documents in all types.
 *
 * @author Haixing Hu
 */
public class TypeFilterAllAction extends BaseCheckBoxAction {

  public static final String KEY = TypeFilterAction.KEY + ".all";

  public TypeFilterAllAction(Application application) {
    super(application, KEY);
  }

  @Override
  public void run() {
    TypeFilter.update(application, TypeFilter.ALL);
  }
}
