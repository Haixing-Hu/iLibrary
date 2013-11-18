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
import cn.edu.nju.starfish.ilibrary.state.FileStatusFilter;

/**
 * The action to filter documents with attachment status.
 *
 * @author Haixing Hu
 */
public class FilterFileStatusAllAction extends BaseCheckBoxAction {

  public static final String KEY = FilterFileStatusAction.KEY + ".all";

  public FilterFileStatusAllAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

  @Override
  public void run() {
    final LibraryTabController controller = application.getLibraryTabController();
    controller.setAttachmentFilter(FileStatusFilter.ALL);
  }

}
