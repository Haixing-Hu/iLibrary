/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.library;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseDropDownAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;

/**
 * The action to show the drop down menu of library related actions.
 *
 * @author Haixing Hu
 */
public class LibraryAction extends BaseDropDownAction {

  public static final String KEY = "action.library";

  private static final String SUB_ACTIONS[] = {
    MarkFlaggedAction.KEY,
    MarkUnflaggedAction.KEY,
    MarkReadAction.KEY,
    MarkUnreadAction.KEY,
    MarkPrintedAction.KEY,
    MarkUnprintedAction.KEY,
    SEPARATOR_KEY,
    ArchiveAction.KEY,
    MoveToTrashAction.KEY,
    RestoreFromTrashAction.KEY,
    EmptyTrashAction.KEY,
    SEPARATOR_KEY,
    EditKeywordsAction.KEY,
    EditNotesAction.KEY,
    AddReviewAction.KEY,
    SEPARATOR_KEY,
    OpenFileAction.KEY,
    OpenFileWithAction.KEY,
    RevealFilePositionAction.KEY,
    AttachFileAction.KEY,
    SEPARATOR_KEY,
    OpenUrlAction.KEY,
    OpenUrlInBrowserAction.KEY,
    SEPARATOR_KEY,
    CreateCollectionAction.KEY,
    ManageCollectionAction.KEY,
    AddToCollectionAction.KEY,
    EditInformationAction.KEY,
    SEPARATOR_KEY,
    MergeDocumentsAction.KEY,
    MergeAuthorsAction.KEY,
    MergePublishersAction.KEY,
    MergeConferencesAction.KEY,
    MergePeriodicalsAction.KEY,
    MergeWebsitesAction.KEY,
  };

  public LibraryAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager, SUB_ACTIONS);
  }

}
