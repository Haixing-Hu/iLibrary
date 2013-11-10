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

  public static final String KEY = "action.library.edit-information";

  public EditInformationAction(Application application) {
    super(application, KEY);
  }
}
