/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.ToolItem;
import org.slf4j.Logger;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.widget.NoImageActionContributionItem;

/**
 * The base class for drop down actions.
 *
 * @author Haixing Hu
 */
public class BaseDropDownAction extends BaseAction {

  /**
   * Constructs an action.
   *
   * @param application
   *          the application the new action belongs to.
   * @param key
   *          the key of the new action, which will be used as the ID of the
   *          new action.
   * @param subActionKeys
   *          the keys of the sub-actions in the drop-down menu
   *          of the new action.
   */
  public BaseDropDownAction(Application application, String key,
      String[] subActionKeys) {
    super(application, key, IAction.AS_DROP_DOWN_MENU);
    this.setMenuCreator(new SubMenuCreator(subActionKeys));
  }

  @Override
  public void run() {
    final Logger logger = application.getLogger();
    logger.warn("Should call runWithEvent() for the action: {}", getId());
  }

  @Override
  public void runWithEvent(Event event) {
    final IMenuCreator mc = this.getMenuCreator();
    if (mc == null) {
      final Logger logger = application.getLogger();
      logger.error("No menu creator for action: {}", getId());
      return;
    }
    if (event.widget instanceof ToolItem) {
      final ToolItem ti = (ToolItem) event.widget;
      final Menu menu = mc.getMenu(ti.getParent());
      //  calculate the position where to display the dropdown menu
      Point point = new Point(event.x, event.y);
      final Rectangle rect = ti.getBounds();
      point.x += rect.x;
      point.y += rect.y + rect.height;
      point = ti.getParent().toDisplay(point);
      // position the menu below the drop down item
      menu.setLocation(point.x, point.y);
      menu.setVisible(true);
    } else {
      final Logger logger = application.getLogger();
      logger.error("Cannot create pop-menu for action: {}", getId());
    }
  }

  /**
   * A sub-menu creator used by this class.
   *
   * @author Haixing Hu
   */
  final class SubMenuCreator implements IMenuCreator {

    private final String[] actionKeys;
    private Object parent;
    private Menu menu;

    public SubMenuCreator(String ... actionKeys) {
      this.actionKeys = actionKeys;
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
      if (actionKeys != null) {
        final ActionManager am = application.getActionManager();
        for (final String key : actionKeys) {
          final Action action = am.getAction(key);
          if (action != null) {
            final ActionContributionItem item =
                new NoImageActionContributionItem(action);
            item.fill(parent, -1);
          }
        }
      }
    }
  }
}
