/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.library;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to show the notes of the selected documents.
 *
 * @author Haixing Hu
 */
public class ShowNotesAction extends BaseAction {

  public static final String KEY = "action.library.show-notes";

  public ShowNotesAction(Application application) {
    super(application, KEY);
  }
}
