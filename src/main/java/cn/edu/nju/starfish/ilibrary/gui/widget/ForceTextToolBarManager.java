/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.widget;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.ContributionManager;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.widgets.ToolBar;

/**
 * An extension of {@link ToolBarManager} which force displaying text even if
 * there is an icon.
 *
 * @author Haixing Hu
 */
public class ForceTextToolBarManager extends ToolBarManager {

  public ForceTextToolBarManager() {
    super();
  }

  public ForceTextToolBarManager(int style) {
    super(style);
  }

  public ForceTextToolBarManager(ToolBar toolBar) {
    super(toolBar);
  }

  /**
   * Adds an action to this tool bar manager.
   * <p>
   * <b>NOTE:</b> Overrides the {@link ContributionManager#add(IAction)} method
   * in order to force displaying text in each tool item.
   *
   * @param action
   *          The action to be added.
   */
  @Override
  public void add(IAction action) {
    Assert.isNotNull(action, "Action must not be null"); //$NON-NLS-1$
    final ActionContributionItem item = new ActionContributionItem(action);
    item.setMode(ActionContributionItem.MODE_FORCE_TEXT);
    add(item);
  }

}
