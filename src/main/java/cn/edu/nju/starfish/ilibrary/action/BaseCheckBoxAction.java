/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action;

import org.eclipse.jface.action.IAction;

import cn.edu.nju.starfish.ilibrary.Application;

/**
 * The base class for check box actions.
 *
 * @author Haixing Hu
 */
public class BaseCheckBoxAction extends BaseAction {

  /**
   * Constructs an action.
   *
   * @param application
   *          the application the new action belongs to.
   * @param key
   *          the key of the new action, which will be used as the ID of the
   *          new action.
   */
  public BaseCheckBoxAction(Application application, String key) {
    super(application, key, IAction.AS_CHECK_BOX);
  }

}
