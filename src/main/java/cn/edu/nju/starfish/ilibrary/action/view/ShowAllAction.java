/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to show all the documents.
 *
 * @author Haixing Hu
 */
public class ShowAllAction extends BaseAction {

  public static final String KEY = "action.view.show-all";

  public ShowAllAction(Application application) {
    super(application, KEY);
  }
}
