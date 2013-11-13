/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.edit;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseDropDownAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;

/**
 * The action to show the drop down menu of editing related actions.
 *
 * @author Haixing Hu
 */
public class EditAction extends BaseDropDownAction {

  public static final String KEY = "action.edit";

  private static final String SUB_ACTIONS[] = {
    UndoAction.KEY,
    RedoAction.KEY,
    SEPARATOR_KEY,
    CutAction.KEY,
    CopyAction.KEY,
    CopyReferenceAction.KEY,
    PasteAction.KEY,
    DeleteAction.KEY,
    SelectAllAction.KEY,
    SEPARATOR_KEY,
    AnnotateAction.KEY,
    SEPARATOR_KEY,
    FontAction.KEY,
    StyleAction.KEY,
    SEPARATOR_KEY,
    FindAction.KEY,
    FindPreviousAction.KEY,
    FindNextAction.KEY,
    SEPARATOR_KEY,
    PreferencesAction.KEY,
  };

  public EditAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager, SUB_ACTIONS);
  }

}
