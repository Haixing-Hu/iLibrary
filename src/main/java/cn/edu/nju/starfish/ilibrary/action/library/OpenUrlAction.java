/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.library;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to open the URL of the selected document.
 *
 * @author Haixing Hu
 */
public class OpenUrlAction extends BaseAction {

  public static final String KEY = "action.library.open-url";

  public OpenUrlAction(Application application) {
    super(application, KEY);
  }

}
