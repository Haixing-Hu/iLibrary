/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.ui;

import org.eclipse.jface.action.IAction;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;
import cn.edu.nju.starfish.ilibrary.state.InspectorTab;

/**
 * The action to switch to the notes tab.
 *
 * @author Haixing Hu
 */
public class NotesTabAction extends BaseAction {

  public static final String KEY = "action.ui.notes-tab";

  public NotesTabAction(Application application) {
    super(application, KEY, IAction.AS_CHECK_BOX);
  }

  @Override
  public void run() {
    InspectorTab.update(application, InspectorTab.NOTES);
  }
}
