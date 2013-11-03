/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to show only the duplicates documents.
 *
 * @author Haixing Hu
 */
public class ShowDuplicatesAction extends BaseAction {

  public ShowDuplicatesAction(Application application) {
    super(application);
  }

  @Override
  public String getKey() {
    return "action.view.show-duplicates";
  }

}
