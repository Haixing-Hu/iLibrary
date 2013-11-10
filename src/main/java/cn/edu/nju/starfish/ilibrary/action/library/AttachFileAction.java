/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.library;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to attach a file or files to the current document.
 *
 * @author Haixing Hu
 */
public class AttachFileAction extends BaseAction {

  public static final String KEY = "action.library.attach-file";

  public AttachFileAction(Application application) {
    super(application, KEY);
  }
}
