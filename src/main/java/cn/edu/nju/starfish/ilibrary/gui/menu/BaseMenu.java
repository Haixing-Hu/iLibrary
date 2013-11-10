/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.menu;

import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.MenuManager;

import cn.edu.nju.starfish.ilibrary.Application;

/**
 * The base class of all menu.
 *
 * @author Haixing Hu
 */
public abstract class BaseMenu  extends MenuManager {

  protected final Application application;

  public BaseMenu(Application application, String key) {
    super(application.getTitle(key));
    this.application = application;

  }

  /**
   * Gets the application this menu belongs to.
   *
   * @return the application this menu belongs to.
   */
  public Application getApplication() {
    return application;
  }

  /**
   * Gets the item by its ID.
   *
   * @param id
   *          the ID of the item to be get.
   * @return the item corresponds to the specified ID, or null if no such
   *         item.
   */
  public IContributionItem getItem(String id) {
    IContributionItem item = this.find(id);
    if (item == null) {
      return null;
    } else {
      return item;
    }
  }

  /**
   * Gets the action by its ID.
   *
   * @param id
   *          the ID of the action to be get.
   * @return the action corresponds to the specified ID, or null if no such
   *         action.
   */
  public IAction getAction(String id) {
    IContributionItem item = this.find(id);
    if (item == null) {
      return null;
    } else {
      return ((ActionContributionItem) item).getAction();
    }
  }

  /**
   * Hides a menu item.
   *
   * <b>NOTE:</b> the menu MUST be updated manually (by calling
   * {@link MenuManager#update(boolean)}) after calling this function.
   *
   * @param id
   *          the ID of the menu item to be hidden.
   */
  public void hideItem(String id) {
    IContributionItem item = getItem(id);
    if (item != null) {
      item.setVisible(false);
    }
  }

  /**
   * Hides menu items.
   *
   * <b>NOTE:</b> the menu MUST be updated manually (by calling
   * {@link MenuManager#update(boolean)}) after calling this function.
   *
   * @param ids
   *   the IDs of the menu items to be hidden.
   */
  public void hideItems(String ... ids) {
    for (String id : ids) {
      IContributionItem item = getItem(id);
      if (item != null) {
        item.setVisible(false);
      }
    }
  }

  /**
   * Shows a menu item.
   *
   * <b>NOTE:</b> the menu MUST be updated manually (by calling
   * {@link MenuManager#update(boolean)}) after calling this function.
   *
   * @param id
   *   the ID of the menu item to be shown.
   */
  public void showItem(String id) {
    IContributionItem item = getItem(id);
    if (item != null) {
      item.setVisible(true);
    }
  }

  /**
   * Shows menu items.
   *
   * <b>NOTE:</b> the menu MUST be updated manually (by calling
   * {@link MenuManager#update(boolean)}) after calling this function.
   *
   * @param ids
   *   the IDs of the menu items to be shown.
   */
  public void showItems(String ... ids) {
    for (String id : ids) {
      IContributionItem item = getItem(id);
      if (item != null) {
        item.setVisible(true);
      }
    }
  }


  /**
   * Disables a menu item.
   *
   * <b>NOTE:</b> the menu MUST be updated manually (by calling
   * {@link MenuManager#update(boolean)}) after calling this function.
   *
   * @param id
   *          the ID of the menu item to be disabled.
   */
  public void disableItem(String id) {
    IAction action = getAction(id);
    if (action != null) {
      action.setEnabled(false);
    }
  }

  /**
   * Disables menu items.
   *
   * <b>NOTE:</b> the menu MUST be updated manually (by calling
   * {@link MenuManager#update(boolean)}) after calling this function.
   *
   * @param ids
   *   the IDs of the menu items to be disabled.
   */
  public void disableItems(String ... ids) {
    for (String id : ids) {
      IAction action = getAction(id);
      if (action != null) {
        action.setEnabled(false);
      }
    }
  }

  /**
   * Enables a menu item.
   *
   * <b>NOTE:</b> the menu MUST be updated manually (by calling
   * {@link MenuManager#update(boolean)}) after calling this function.
   *
   * @param id
   *   the ID of the menu item to be enabled.
   */
  public void enableItem(String id) {
    IAction action = getAction(id);
    if (action != null) {
      action.setEnabled(true);
    }
  }

  /**
   * Enables menu items.
   *
   * <b>NOTE:</b> the menu MUST be updated manually (by calling
   * {@link MenuManager#update(boolean)}) after calling this function.
   *
   * @param ids
   *   the IDs of the menu items to be enabled.
   */
  public void enableItems(String ... ids) {
    for (String id : ids) {
      IAction action = getAction(id);
      if (action != null) {
        action.setEnabled(true);
      }
    }
  }
}
