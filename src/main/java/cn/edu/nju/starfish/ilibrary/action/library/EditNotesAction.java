/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.library;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to edit the notes of the selected documents.
 *
 * @author Haixing Hu
 */
public class EditNotesAction extends BaseAction {

  public static final String KEY = "action.library.edit-notes";

  public EditNotesAction(Application application) {
    super(application, KEY);
  }
}
