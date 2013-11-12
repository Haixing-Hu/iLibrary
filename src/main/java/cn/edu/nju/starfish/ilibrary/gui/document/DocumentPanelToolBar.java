/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.document;

import org.eclipse.jface.action.Separator;
import org.eclipse.swt.widgets.Composite;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.edit.AnnotateAction;
import cn.edu.nju.starfish.ilibrary.action.file.PrintAction;
import cn.edu.nju.starfish.ilibrary.action.library.AddReviewAction;
import cn.edu.nju.starfish.ilibrary.action.library.EditKeywordsAction;
import cn.edu.nju.starfish.ilibrary.action.library.EditNotesAction;
import cn.edu.nju.starfish.ilibrary.action.share.ShareAction;
import cn.edu.nju.starfish.ilibrary.action.view.ReadFullScreenAction;
import cn.edu.nju.starfish.ilibrary.action.view.TableOfContentsAction;
import cn.edu.nju.starfish.ilibrary.action.view.ViewModeAction;
import cn.edu.nju.starfish.ilibrary.gui.MainPanelToolBar;

/**
 * The tool bar in the document panel.
 *
 * @author Haixing Hu
 */
public final class DocumentPanelToolBar extends MainPanelToolBar {

  private static final String ACTIONS[] = {
    ReadFullScreenAction.KEY,
    ShareAction.KEY,
    PrintAction.KEY,
    Separator.class.getName(),
    EditKeywordsAction.KEY,
    EditNotesAction.KEY,
    AddReviewAction.KEY,
    TableOfContentsAction.KEY,
    Separator.class.getName(),
    AnnotateAction.KEY,
    ViewModeAction.KEY,
  };

  public DocumentPanelToolBar(Application application, Composite parent) {
    super(application, parent, ACTIONS);
  }
}
