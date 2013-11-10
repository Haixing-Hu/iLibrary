/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.menu;

import org.eclipse.jface.action.Separator;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.ActionManager;
import cn.edu.nju.starfish.ilibrary.action.library.AddReviewAction;
import cn.edu.nju.starfish.ilibrary.action.library.AddToCollectionAction;
import cn.edu.nju.starfish.ilibrary.action.library.AttachFileAction;
import cn.edu.nju.starfish.ilibrary.action.library.EditInformationAction;
import cn.edu.nju.starfish.ilibrary.action.library.MarkFlaggedAction;
import cn.edu.nju.starfish.ilibrary.action.library.MarkPrintedAction;
import cn.edu.nju.starfish.ilibrary.action.library.MarkReadAction;
import cn.edu.nju.starfish.ilibrary.action.library.MarkUnflaggedAction;
import cn.edu.nju.starfish.ilibrary.action.library.MarkUnprintedAction;
import cn.edu.nju.starfish.ilibrary.action.library.MarkUnreadAction;
import cn.edu.nju.starfish.ilibrary.action.library.MergeAuthorsAction;
import cn.edu.nju.starfish.ilibrary.action.library.MergeConferencesAction;
import cn.edu.nju.starfish.ilibrary.action.library.MergeDocumentsAction;
import cn.edu.nju.starfish.ilibrary.action.library.MergePeriodicalsAction;
import cn.edu.nju.starfish.ilibrary.action.library.MergePublishersAction;
import cn.edu.nju.starfish.ilibrary.action.library.MergeWebsitesAction;
import cn.edu.nju.starfish.ilibrary.action.library.MoveToTrashAction;
import cn.edu.nju.starfish.ilibrary.action.library.OpenFileAction;
import cn.edu.nju.starfish.ilibrary.action.library.OpenFileWithAction;
import cn.edu.nju.starfish.ilibrary.action.library.OpenUrlAction;
import cn.edu.nju.starfish.ilibrary.action.library.OpenUrlInBrowserAction;
import cn.edu.nju.starfish.ilibrary.action.library.RestoreFromTrashAction;
import cn.edu.nju.starfish.ilibrary.action.library.RevealFilePositionAction;
import cn.edu.nju.starfish.ilibrary.action.library.ShowKeywordsAction;
import cn.edu.nju.starfish.ilibrary.action.library.ShowNotesAction;

/**
 * The library menu.
 *
 * @author Haixing Hu
 */
public final class LibraryMenu extends BaseMenu {

  public static final String KEY = "menu.library";

  /**
   * Creates a library menu.
   *
   * @param application
   *          the application this new menu belongs to.
   */
  public LibraryMenu(Application application) {
    super(application, KEY);
    final ActionManager am = application.getActionManager();
    this.add(am.getAction(MarkFlaggedAction.KEY));
    this.add(am.getAction(MarkUnflaggedAction.KEY));
    this.add(am.getAction(MarkReadAction.KEY));
    this.add(am.getAction(MarkUnreadAction.KEY));
    this.add(am.getAction(MarkPrintedAction.KEY));
    this.add(am.getAction(MarkUnprintedAction.KEY));
    this.add(new Separator());
    this.add(am.getAction(MoveToTrashAction.KEY));
    this.add(am.getAction(RestoreFromTrashAction.KEY));
    this.add(new Separator());
    this.add(am.getAction(ShowKeywordsAction.KEY));
    this.add(am.getAction(ShowNotesAction.KEY));
    this.add(am.getAction(AddReviewAction.KEY));
    this.add(new Separator());
    this.add(am.getAction(OpenFileAction.KEY));
    this.add(am.getAction(OpenFileWithAction.KEY));
    this.add(am.getAction(RevealFilePositionAction.KEY));
    this.add(am.getAction(AttachFileAction.KEY));
    this.add(new Separator());
    this.add(am.getAction(OpenUrlAction.KEY));
    this.add(am.getAction(OpenUrlInBrowserAction.KEY));
    this.add(new Separator());
    this.add(am.getAction(AddToCollectionAction.KEY));
    this.add(am.getAction(EditInformationAction.KEY));
    this.add(new Separator());
    this.add(am.getAction(MergeDocumentsAction.KEY));
    this.add(am.getAction(MergeAuthorsAction.KEY));
    this.add(am.getAction(MergePublishersAction.KEY));
    this.add(am.getAction(MergeConferencesAction.KEY));
    this.add(am.getAction(MergePeriodicalsAction.KEY));
    this.add(am.getAction(MergeWebsitesAction.KEY));
  }

}
