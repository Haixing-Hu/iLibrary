/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.window;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to show files associated with the current document.
 *
 * @author Haixing Hu
 */
public class FilesAction extends BaseAction {

  public FilesAction(Application application) {
    super(application);
  }

  @Override
  public String getKey() {
    return "action.window.files";
  }

}
