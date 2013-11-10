/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.widget;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * An extension of {@link MenuManager} which does not display the image of the
 * action.
 *
 * @author Haixing Hu
 */
public class NoImageMenuManager extends MenuManager {

  /**
   * Creates a menu manager. The text and id are <code>null</code>. Typically
   * used for creating a context menu, where it doesn't need to be referred to
   * by id.
   */
  public NoImageMenuManager() {
    super(null, null, null);
  }

  /**
   * Creates a menu manager with the given text. The id of the menu is
   * <code>null</code>. Typically used for creating a sub-menu, where it doesn't
   * need to be referred to by id.
   *
   * @param text
   *          the text for the menu, or <code>null</code> if none
   */
  public NoImageMenuManager(String text) {
    super(text, null, null);
  }

  /**
   * Creates a menu manager with the given text and id. Typically used for
   * creating a sub-menu, where it needs to be referred to by id.
   *
   * @param text
   *          the text for the menu, or <code>null</code> if none
   * @param id
   *          the menu id, or <code>null</code> if it is to have no id
   */
  public NoImageMenuManager(String text, String id) {
    super(text, null, id);
  }

  /**
   * Creates a menu manager with the given text, image, and id. Typically used
   * for creating a sub-menu, where it needs to be referred to by id.
   *
   * @param text
   *          the text for the menu, or <code>null</code> if none
   * @param image
   *          the image for the menu, or <code>null</code> if none
   * @param id
   *          the menu id, or <code>null</code> if it is to have no id
   * @since 3.4
   */
  public NoImageMenuManager(String text, ImageDescriptor image, String id) {
    super(text, image, id);
  }

  /**
   * Adds an action to this menu.
   * <p>
   * <b>NOTE:</b>
   * We override this method in order to disable the image in the menu items.
   *
   * @param action the action to be added.
   */
  @Override
  public void add(IAction action) {
    Assert.isNotNull(action, "Action must not be null"); //$NON-NLS-1$
    //  we override the ActionContributionItem.update() in order to ignore the
    //  image changing in the action.
    add(new NoImageActionContributionItem(action));
  }
}
