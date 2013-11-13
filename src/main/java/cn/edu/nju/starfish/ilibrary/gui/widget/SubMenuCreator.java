/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.widget;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A {@link IMenuCreator} which create a sub-menu.
 *
 * @author Haixing Hu
 */
public class SubMenuCreator implements IMenuCreator {

  /**
   * The key for the separator item.
   */
  public static final String SEPARATOR_KEY = "SEPARATOR";

  private final IActionManager actionManager;
  private final String[] subActionIds;
  private final boolean showImage;
  private final Map<Object, MenuManager> subMenuCache;
  private final Logger logger;

  /**
   * Constructs a sub-menu creator.
   *
   * @param actionManager
   *          a map from the ID of the action to the action object.
   * @param subActionIds
   *          an array of IDs of the sub-action which will be used to create the
   *          menu items in the sub-menus created by this creator.
   * @param showImage
   *          indicates whether the sub-menu created by this creator should
   *          display the image on its menu items.
   */
  public SubMenuCreator(IActionManager actionManager, String[] subActionIds, boolean showImage) {
    if (actionManager == null) {
      throw new NullPointerException("actionManager cannnot be null.");
    }
    if (subActionIds == null) {
      throw new NullPointerException("subActionIds cannnot be null.");
    }
    this.actionManager = actionManager;
    this.subActionIds = subActionIds;
    this.showImage = showImage;
    this.subMenuCache = new HashMap<Object, MenuManager>();
    this.logger = LoggerFactory.getLogger(SubMenuCreator.class);
  }

  @Override
  public void dispose() {
    for (final Map.Entry<Object, MenuManager> entry : subMenuCache.entrySet()) {
      final MenuManager menuManager = entry.getValue();
      menuManager.dispose();
    }
    subMenuCache.clear();
  }

  @Override
  public Menu getMenu(Control parent) {
    logger.debug("Getting the submenu for parent: {}", parent);
    MenuManager menuManager = subMenuCache.get(parent);
    if (menuManager == null) {
      logger.debug("Creating a submenu for parent: {}", parent);
      menuManager = new MenuManager(showImage);
      addActions(menuManager);
      menuManager.createContextMenu(parent);
      subMenuCache.put(parent, menuManager);
    }
    return menuManager.getMenu();
  }

  @Override
  public Menu getMenu(Menu parent) {
    logger.debug("Getting the submenu for parent: {}", parent);
    MenuManager menuManager = subMenuCache.get(parent);
    if (menuManager == null) {
      logger.debug("Creating a submenu for parent: {}", parent);
      menuManager = new MenuManager(showImage);
      addActions(menuManager);
      menuManager.createSubMenu(parent);
      subMenuCache.put(parent, menuManager);
    }
    return menuManager.getMenu();
  }

  /**
   * Gets all menu managers created by this creator.
   *
   * @return the collection of all menu managers created by this creator.
   */
  public Collection<MenuManager> getMenuManagers() {
    return subMenuCache.values();
  }

  private void addActions(MenuManager menuManager) {
    for (final String id : subActionIds) {
      if (id.equals(SEPARATOR_KEY)) {
        logger.debug("Adding a separator to the sub-menu: {}", id);
        menuManager.add(new Separator());
      } else {
        final Action action = actionManager.get(id);
        if (action != null) {
          logger.debug("Adding an action to the sub-menu: {}", id);
          menuManager.add(action);
        } else {
          logger.error("Cannot found the action in the action manager: {}", id);
        }
      }
    }
  }
}
