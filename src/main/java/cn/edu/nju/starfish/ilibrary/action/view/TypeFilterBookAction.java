/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseCheckBoxAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;
import cn.edu.nju.starfish.ilibrary.state.TypeFilter;

/**
 * The action to filter book documents.
 *
 * @author Haixing Hu
 */
public class TypeFilterBookAction extends BaseCheckBoxAction {

  public static final String KEY = TypeFilterAction.KEY + ".book";

  public TypeFilterBookAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

  @Override
  public void run() {
    logger.info("Set the type filter to {}", TypeFilter.BOOK);
    TypeFilter.update(application, TypeFilter.BOOK);
  }
}
