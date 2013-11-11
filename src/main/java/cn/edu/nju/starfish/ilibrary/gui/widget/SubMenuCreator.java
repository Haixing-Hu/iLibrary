/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.widget;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;

/**
 * A {@link IMenuCreator} which create a sub-menu.
 *
 * @author Haixing Hu
 */
public class SubMenuCreator implements IMenuCreator {

  private final boolean displayImage;
  private final Action[] actions;
  private Object parent;
  private Menu menu;

  public SubMenuCreator(boolean displayImage, Action ... actions) {
    this.displayImage = displayImage;
    this.actions = actions;
    this.parent = null;
    this.menu = null;
  }

  @Override
  public void dispose() {
    if (menu != null) {
      menu.dispose();
      menu = null;
    }
  }

  @Override
  public Menu getMenu(Control parent) {
    if (menu != null) {
      if (this.parent == parent) {
        return menu;
      }
      menu.dispose();
      menu = null;
    }
    menu = new Menu(parent);
    addActions(menu);
    this.parent = parent;
    return menu;
  }

  @Override
  public Menu getMenu(Menu parent) {
    if (menu != null) {
      if (this.parent == parent) {
        return menu;
      }
      menu.dispose();
      menu = null;
    }
    menu = new Menu(parent);
    addActions(menu);
    this.parent = parent;
    return menu;
  }

  private void addActions(Menu parent) {
    if (actions != null) {
      for (final Action action: actions) {
        final ActionContributionItem item;
        if (displayImage) {
          item = new ActionContributionItem(action);
        } else {
          item = new NoImageActionContributionItem(action);
        }
        item.fill(parent, -1);
      }
    }
  }
}
