/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.library;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to open the URL of the selected document in the external browser.
 *
 * @author Haixing Hu
 */
public class OpenUrlInBrowserAction extends BaseAction {

  public OpenUrlInBrowserAction(Application application) {
    super(application);
  }

  @Override
  public String getKey() {
    return "action.library.open-url-in-browser";
  }

}
