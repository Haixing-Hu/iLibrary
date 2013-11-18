/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseCheckBoxAction;
import cn.edu.nju.starfish.ilibrary.controller.LibraryTabController;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;
import cn.edu.nju.starfish.ilibrary.state.ReadStatusFilter;

/**
 * The action to filter documents which have been read.
 *
 * @author Haixing Hu
 */
public class FilterReadStatusHasReadAction extends BaseCheckBoxAction {

  public static final String KEY = FilterReadStatusAction.KEY + ".has-read";

  public FilterReadStatusHasReadAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

  @Override
  public void run() {
    final LibraryTabController controller = application.getLibraryTabController();
    controller.setReadFilter(ReadStatusFilter.HAS_READ);
  }
}
