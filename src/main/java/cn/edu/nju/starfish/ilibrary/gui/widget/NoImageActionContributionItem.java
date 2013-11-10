/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.widget;

import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;

/**
 * An extension to {@link ActionContributionItem} which does not display images.
 *
 * @author Haixing Hu
 */
public class NoImageActionContributionItem extends ActionContributionItem {

  /**
   * Creates a new contribution item from the given action. The id of the action
   * is used as the id of the item.
   *
   * @param action
   *          the action
   */
  public NoImageActionContributionItem(IAction action) {
    super(action);
  }

  /**
   * Synchronizes the UI with the given property.
   * <p>
   * <b>NOTE: </b>override the ActionContributionItem.update() in order to
   * ignore the image changing in the action.
   *
   * @param propertyName
   *          the name of the property, or <code>null</code> meaning all
   *          applicable properties
   */
  @Override
  public void update(String propertyName) {
    if (propertyName == null) {
      // we must split the updating requests and ignore the IMAGE
      super.update(IAction.TEXT);
      // super.update(IAction.IMAGE); // ignore the IMAGE
      super.update(IAction.TOOL_TIP_TEXT);
      super.update(IAction.ENABLED);
      super.update(IAction.CHECKED);
    } else if (propertyName.equals(IAction.IMAGE)) {
      // ignore the update of IMAGE
      return;
    } else {
      super.update(propertyName);
    }
  }
}
