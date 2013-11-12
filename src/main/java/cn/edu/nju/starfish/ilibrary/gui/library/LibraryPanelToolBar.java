/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.library;

import org.eclipse.jface.action.Separator;
import org.eclipse.swt.widgets.Composite;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.file.PrintAction;
import cn.edu.nju.starfish.ilibrary.action.library.AddReviewAction;
import cn.edu.nju.starfish.ilibrary.action.library.EditKeywordsAction;
import cn.edu.nju.starfish.ilibrary.action.library.EditNotesAction;
import cn.edu.nju.starfish.ilibrary.action.library.OpenFileAction;
import cn.edu.nju.starfish.ilibrary.action.library.OpenUrlAction;
import cn.edu.nju.starfish.ilibrary.action.share.ShareAction;
import cn.edu.nju.starfish.ilibrary.action.view.ReadFullScreenAction;
import cn.edu.nju.starfish.ilibrary.action.view.ViewModeAction;
import cn.edu.nju.starfish.ilibrary.gui.MainPanelToolBar;

/**
 * The main tool bar.
 *
 * @author Haixing Hu
 */
public final class LibraryPanelToolBar extends MainPanelToolBar {

  private static final String ACTIONS[] = {
    ReadFullScreenAction.KEY,
    OpenFileAction.KEY,
    OpenUrlAction.KEY,
    ShareAction.KEY,
    PrintAction.KEY,
    Separator.class.getName(),
    EditKeywordsAction.KEY,
    EditNotesAction.KEY,
    AddReviewAction.KEY,
    Separator.class.getName(),
    ViewModeAction.KEY,
  };

  public LibraryPanelToolBar(Application application, Composite parent) {
    super(application, parent, ACTIONS);
  }
}
