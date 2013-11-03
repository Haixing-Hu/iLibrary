/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.library;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to edit the information of the current document.
 *
 * @author Haixing Hu
 */
public class EditInformationAction extends BaseAction {

  public EditInformationAction(Application application) {
    super(application);
  }

  @Override
  public String getKey() {
    return "action.library.edit-information";
  }

}
