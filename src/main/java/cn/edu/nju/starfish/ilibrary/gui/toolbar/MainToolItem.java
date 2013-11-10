/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.toolbar;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.wb.swt.SWTResourceManager;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.ActionManager;

/**
 * The tool items in the main tool bar.
 *
 * @author Haixing Hu
 */
public class MainToolItem {

  private final ToolItem item;

  public MainToolItem(Application application, ToolBar parent, String key) {
    item = new ToolItem(parent, SWT.NONE);
    final ActionManager am = application.getActionManager();
    final Action action = am.getAction(key);
    final String title = application.getTitle(key);
    item.setText(title);
    final String description = application.getDescription(key);
    item.setToolTipText(description);
    final String icon = application.getIcon(key);
    if (icon != null) {
      final Image img = SWTResourceManager.getImage(MainToolItem.class, icon);
      if (img == null) {
        System.err.println("ERROR: img == null");
      }
      item.setImage(img);
    }
    item.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        action.run();
      }
    });
  }

  public ToolItem getControl() {
    return item;
  }
}
