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

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.swt.action.IActionManager;
import com.github.haixing_hu.swt.window.BalloonWindow;

/**
 * The base class for actions which open a balloon window.
 *
 * @author Haixing Hu
 */
public abstract class BalloonWindowAction extends BaseAction {

  public BalloonWindowAction(String id, Application application,
      IActionManager actionManager) {
    super(id, application, actionManager);
    setShowDialog(true);
  }

  @Override
  public void runWithEvent(Event event) {
    if (event.widget instanceof MenuItem) {
      final ToolItem ti = findToolItem();
      if (ti != null) {
        openSelectColumnsWindows(ti);
      }
    } else if (event.widget instanceof ToolItem) {
      final ToolItem ti = (ToolItem) event.widget;
      openSelectColumnsWindows(ti);
    }
  }

  private void openSelectColumnsWindows(ToolItem ti) {
    final Rectangle rect = ti.getBounds();
    Point loc = new Point(rect.x + (rect.width / 2), rect.y + rect.height);
    final ToolBar bar = ti.getParent();
    loc = bar.toDisplay(loc);
    final BalloonWindow win = createBalloonWindow();
    win.setLocation(loc);
    win.setAnchor(SWT.TOP);
    win.open();
  }

  /**
   * Creates a balloon window.
   *
   * @return a new balloon window.
   */
  protected abstract BalloonWindow createBalloonWindow();

  /**
   * Find on the current page the ToolItem corresponds to the action that pops
   * up the balloon window.
   *
   * @return the ToolItem on the current page corresponds to the action that
   *         pops up the balloon window.
   */
  protected abstract ToolItem findToolItem();
}
