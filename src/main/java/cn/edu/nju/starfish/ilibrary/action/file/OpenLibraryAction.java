/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.file;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to open an existing library.
 *
 * @author Haixing Hu
 */
public class OpenLibraryAction extends BaseAction {

  public static final String KEY = "action.file.open-library";

  public OpenLibraryAction(Application application) {
    super(application, KEY);
  }
}
