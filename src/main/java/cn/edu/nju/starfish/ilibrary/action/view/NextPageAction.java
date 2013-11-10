/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to goto the next page of the current document.
 *
 * @author Haixing Hu
 */
public class NextPageAction extends BaseAction {

  public static final String KEY = "action.view.next-page";

  public NextPageAction(Application application) {
    super(application, KEY);
  }
}
