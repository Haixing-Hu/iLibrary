/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.menu;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;

import cn.edu.nju.starfish.ilibrary.Application;
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
public final class LibraryMenu extends MenuManager {

  public static final String KEY = "menu.library";

  private final Application application;

  /**
   * Creates a library menu.
   *
   * @param application
   *          the application this new menu belongs to.
   */
  public LibraryMenu(Application application) {
    super(application.getTitle(KEY));
    this.application = application;
    this.add(new MarkFlaggedAction(application));
    this.add(new MarkUnflaggedAction(application));
    this.add(new MarkReadAction(application));
    this.add(new MarkUnreadAction(application));
    this.add(new MarkPrintedAction(application));
    this.add(new MarkUnprintedAction(application));
    this.add(new Separator());
    this.add(new MoveToTrashAction(application));
    this.add(new RestoreFromTrashAction(application));
    this.add(new Separator());
    this.add(new ShowKeywordsAction(application));
    this.add(new ShowNotesAction(application));
    this.add(new AddReviewAction(application));
    this.add(new Separator());
    this.add(new OpenFileAction(application));
    this.add(new OpenFileWithAction(application));
    this.add(new RevealFilePositionAction(application));
    this.add(new AttachFileAction(application));
    this.add(new Separator());
    this.add(new OpenUrlAction(application));
    this.add(new OpenUrlInBrowserAction(application));
    this.add(new Separator());
    this.add(new AddToCollectionAction(application));
    this.add(new EditInformationAction(application));
    this.add(new Separator());
    this.add(new MergeDocumentsAction(application));
    this.add(new MergeAuthorsAction(application));
    this.add(new MergePublishersAction(application));
    this.add(new MergeConferencesAction(application));
    this.add(new MergePeriodicalsAction(application));
    this.add(new MergeWebsitesAction(application));
  }

  /**
   * Gets the application this menu belongs to.
   *
   * @return the application this menu belongs to.
   */
  public Application getApplication() {
    return application;
  }

}
