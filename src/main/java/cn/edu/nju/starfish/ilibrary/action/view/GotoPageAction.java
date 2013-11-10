/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to goto the specified page in the document.
 *
 * @author Haixing Hu
 */
public class GotoPageAction extends BaseAction {

  public static final String KEY = "action.view.goto-page";

  public GotoPageAction(Application application) {
    super(application, KEY);
  }

}
