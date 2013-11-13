/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action;


import org.eclipse.jface.action.IAction;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;

/**
 * The base class for check box actions.
 *
 * @author Haixing Hu
 */
public class BaseCheckBoxAction extends BaseAction {

  /**
   * Constructs an action.
   *
   * @param id
   *          the ID of the new action.
   * @param application
   *          the application the new action belongs to.
   * @param actionManager
   *          the action manager, which is a map from the action's ID to the action.
   */
  public BaseCheckBoxAction(String id, Application application,
      IActionManager actionManager) {
    super(id, application, actionManager, IAction.AS_CHECK_BOX);
  }

}
