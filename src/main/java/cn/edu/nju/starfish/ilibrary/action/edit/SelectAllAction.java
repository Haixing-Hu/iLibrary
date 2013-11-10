/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.edit;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to select all the text or all the documents.
 *
 * @author Haixing Hu
 */
public class SelectAllAction extends BaseAction {
  public static final String KEY = "action.edit.select-all";

  public SelectAllAction(Application application) {
    super(application, KEY);
  }

}
