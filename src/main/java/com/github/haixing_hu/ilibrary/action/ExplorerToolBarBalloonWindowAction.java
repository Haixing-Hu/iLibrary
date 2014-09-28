/******************************************************************************
 *
 * Copyright (c) 2014  Haixing Hu
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Haixing Hu (https://github.com/Haixing-Hu/) - Initial implementation and API.
 *
 ******************************************************************************/

package com.github.haixing_hu.ilibrary.action;

import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Widget;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.gui.BasicPage;
import com.github.haixing_hu.ilibrary.gui.MainWindow;
import com.github.haixing_hu.ilibrary.gui.explorer.ExplorerContentPanel;
import com.github.haixing_hu.ilibrary.gui.explorer.ExplorerHeader;
import com.github.haixing_hu.ilibrary.gui.explorer.ExplorerHeaderToolBar;
import com.github.haixing_hu.ilibrary.gui.explorer.ExplorerPage;
import com.github.haixing_hu.ilibrary.gui.explorer.ExplorerPanel;
import com.github.haixing_hu.swt.action.IActionManager;

/**
 * The action on the explorer page's tool bar for displaying a balloon window.
 *
 * @author Haixing Hu
 */
public abstract class ExplorerToolBarBalloonWindowAction extends BalloonWindowAction {

  public ExplorerToolBarBalloonWindowAction(String id, Application application,
      IActionManager actionManager) {
    super(id, application, actionManager);
  }

  @Override
  protected ToolItem findToolItem() {
    final MainWindow mainWindow = application.getMainWindow();
    final BasicPage page = mainWindow.getCurrentPage();
    if (! (page instanceof ExplorerPage)) {
      return null;
    }
    final ExplorerPanel panel = ((ExplorerPage) page).getExplorer();
    final ExplorerContentPanel content = panel.getContent();
    final ExplorerHeader header = content.getHeader();
    final ExplorerHeaderToolBar headerToolBar = (ExplorerHeaderToolBar) header.getControl();
    final ToolBarManager tbm = headerToolBar.getToolBarManager();
    final ActionContributionItem item = (ActionContributionItem) tbm.find(getId());
    if (item == null) {
      return null;
    }
    final Widget widget = item.getWidget();
    if ((widget != null) && (widget instanceof ToolItem)) {
      return (ToolItem) widget;
    } else {
      return null;
    }
  }
}
