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
 * The action to filter patent documents.
 *
 * @author Haixing Hu
 */
public class TypeFilterPatentAction extends BaseCheckBoxAction {

  public static final String KEY = TypeFilterAction.KEY + ".patent";

  public TypeFilterPatentAction(Application application) {
    super(application, KEY);
  }

  @Override
  public void run() {
    logger.info("Set the type filter to {}", TypeFilter.PATENT);
    TypeFilter.update(application, TypeFilter.PATENT);
  }
}
