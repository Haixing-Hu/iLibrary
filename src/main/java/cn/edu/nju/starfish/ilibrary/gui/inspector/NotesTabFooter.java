/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.inspector;

import org.eclipse.swt.widgets.Composite;

import cn.edu.nju.starfish.ilibrary.Application;

/**
 * The footer of the info tab.
 *
 * @author Haixing Hu
 */
public class NotesTabFooter extends InspectorTabFooter {

  private static final String ACTIONS[] = {
   // EditNotesAction.KEY,
  };

  public NotesTabFooter(Application application, Composite parent) {
    super(application, parent, ACTIONS);
  }
}
