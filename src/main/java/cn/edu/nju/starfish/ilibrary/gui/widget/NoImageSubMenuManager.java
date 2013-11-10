/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.widget;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.SubMenuManager;

/**
 * An extension of {@link SubMenuManager} which does not display the image of the
 * action.
 *
 * @author Haixing Hu
 */
public class NoImageSubMenuManager extends SubMenuManager {

  /**
   * Constructs a new manager.
   *
   * @param mgr the parent manager.  All contributions made to the
   *      <code>SubMenuManager</code> are forwarded and appear in the
   *      parent manager.
   */
  public NoImageSubMenuManager(IMenuManager mgr) {
    super(mgr);
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
    add(new ActionContributionItem(action) {
      @Override
      public void update(String propertyName) {
        if (propertyName == null) {
          //  we must split the updating requests and ignore the IMAGE
          super.update(IAction.TEXT);
          // super.update(IAction.IMAGE);  // ignore the IMAGE
          super.update(IAction.TOOL_TIP_TEXT);
          super.update(IAction.ENABLED);
          super.update(IAction.CHECKED);
        } else if (propertyName.equals(IAction.IMAGE)) {
          //  ignore the update of IMAGE
          return;
        } else {
          super.update(propertyName);
        }
      }
    });
  }
}
