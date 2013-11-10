/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.action.Action;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.edit.CopyAction;
import cn.edu.nju.starfish.ilibrary.action.edit.CopyReferenceAction;
import cn.edu.nju.starfish.ilibrary.action.edit.CutAction;
import cn.edu.nju.starfish.ilibrary.action.edit.DeleteAction;
import cn.edu.nju.starfish.ilibrary.action.edit.FindAction;
import cn.edu.nju.starfish.ilibrary.action.edit.FindNextAction;
import cn.edu.nju.starfish.ilibrary.action.edit.FindPreviousAction;
import cn.edu.nju.starfish.ilibrary.action.edit.FontAction;
import cn.edu.nju.starfish.ilibrary.action.edit.PasteAction;
import cn.edu.nju.starfish.ilibrary.action.edit.PreferencesAction;
import cn.edu.nju.starfish.ilibrary.action.edit.RedoAction;
import cn.edu.nju.starfish.ilibrary.action.edit.SelectAllAction;
import cn.edu.nju.starfish.ilibrary.action.edit.StyleAction;
import cn.edu.nju.starfish.ilibrary.action.edit.UndoAction;
import cn.edu.nju.starfish.ilibrary.action.file.CloseLibraryAction;
import cn.edu.nju.starfish.ilibrary.action.file.ExportAction;
import cn.edu.nju.starfish.ilibrary.action.file.ImportAction;
import cn.edu.nju.starfish.ilibrary.action.file.NewEntryAction;
import cn.edu.nju.starfish.ilibrary.action.file.NewLibraryAction;
import cn.edu.nju.starfish.ilibrary.action.file.OpenLibraryAction;
import cn.edu.nju.starfish.ilibrary.action.file.PageSetupAction;
import cn.edu.nju.starfish.ilibrary.action.file.PrintAction;
import cn.edu.nju.starfish.ilibrary.action.file.QuitAction;
import cn.edu.nju.starfish.ilibrary.action.help.AboutAction;
import cn.edu.nju.starfish.ilibrary.action.help.FaqAction;
import cn.edu.nju.starfish.ilibrary.action.help.FeedbackAction;
import cn.edu.nju.starfish.ilibrary.action.help.ManualAction;
import cn.edu.nju.starfish.ilibrary.action.help.WebsiteAction;
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
import cn.edu.nju.starfish.ilibrary.action.share.EmailAction;
import cn.edu.nju.starfish.ilibrary.action.share.FacebookAction;
import cn.edu.nju.starfish.ilibrary.action.share.GooglePlusAction;
import cn.edu.nju.starfish.ilibrary.action.share.SinaAction;
import cn.edu.nju.starfish.ilibrary.action.share.TencentAction;
import cn.edu.nju.starfish.ilibrary.action.share.TwitterAction;
import cn.edu.nju.starfish.ilibrary.action.view.ActualSizeAction;
import cn.edu.nju.starfish.ilibrary.action.view.AsCoverFlowAction;
import cn.edu.nju.starfish.ilibrary.action.view.AsDocumentAction;
import cn.edu.nju.starfish.ilibrary.action.view.AsPreviewAction;
import cn.edu.nju.starfish.ilibrary.action.view.AsThumbnailsAction;
import cn.edu.nju.starfish.ilibrary.action.view.AsWebpageAction;
import cn.edu.nju.starfish.ilibrary.action.view.BackAction;
import cn.edu.nju.starfish.ilibrary.action.view.ColumnsAction;
import cn.edu.nju.starfish.ilibrary.action.view.ForwardAction;
import cn.edu.nju.starfish.ilibrary.action.view.HideInspectorAction;
import cn.edu.nju.starfish.ilibrary.action.view.HideNavigatorAction;
import cn.edu.nju.starfish.ilibrary.action.view.HidePreviewAction;
import cn.edu.nju.starfish.ilibrary.action.view.NextDocumentAction;
import cn.edu.nju.starfish.ilibrary.action.view.NextPageAction;
import cn.edu.nju.starfish.ilibrary.action.view.PreviousDocumentAction;
import cn.edu.nju.starfish.ilibrary.action.view.PreviousPageAction;
import cn.edu.nju.starfish.ilibrary.action.view.ReadFullScreenAction;
import cn.edu.nju.starfish.ilibrary.action.view.ShowAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.ShowDuplicatesAction;
import cn.edu.nju.starfish.ilibrary.action.view.ShowInspectorAction;
import cn.edu.nju.starfish.ilibrary.action.view.ShowNavigatorAction;
import cn.edu.nju.starfish.ilibrary.action.view.ShowPreviewAction;
import cn.edu.nju.starfish.ilibrary.action.view.SortByAction;
import cn.edu.nju.starfish.ilibrary.action.view.TableOfContentsAction;
import cn.edu.nju.starfish.ilibrary.action.view.ViewModeAction;
import cn.edu.nju.starfish.ilibrary.action.view.ZoomInAction;
import cn.edu.nju.starfish.ilibrary.action.view.ZoomOutAction;
import cn.edu.nju.starfish.ilibrary.action.view.ZoomToFitAction;
import cn.edu.nju.starfish.ilibrary.action.window.CloseAllTabsAction;
import cn.edu.nju.starfish.ilibrary.action.window.CloseTabAction;
import cn.edu.nju.starfish.ilibrary.action.window.CycleTabsAction;
import cn.edu.nju.starfish.ilibrary.action.window.FilesAction;
import cn.edu.nju.starfish.ilibrary.action.window.InfoAction;
import cn.edu.nju.starfish.ilibrary.action.window.LibraryAction;
import cn.edu.nju.starfish.ilibrary.action.window.MaximizeAction;
import cn.edu.nju.starfish.ilibrary.action.window.MinimizeAction;
import cn.edu.nju.starfish.ilibrary.action.window.MinimizeAllAction;
import cn.edu.nju.starfish.ilibrary.action.window.NextTabAction;
import cn.edu.nju.starfish.ilibrary.action.window.NotesAction;
import cn.edu.nju.starfish.ilibrary.action.window.PreviousTabAction;
import cn.edu.nju.starfish.ilibrary.action.window.ReviewsAction;

/**
 * A class used to manage all the actions in this application.
 *
 * @author Haixing Hu
 */
public final class ActionManager {

  private final Map<String, Action> actions;

  public ActionManager(Application application) {
    actions = new HashMap<String, Action>();
    //  file actions
    this.add(new NewEntryAction(application));
    this.add(new NewLibraryAction(application));
    this.add(new OpenLibraryAction(application));
    this.add(new CloseLibraryAction(application));
    this.add(new ImportAction(application));
    this.add(new ExportAction(application));
    this.add(new PageSetupAction(application));
    this.add(new PrintAction(application));
    this.add(new QuitAction(application));
    //  edit actions
    this.add(new UndoAction(application));
    this.add(new RedoAction(application));
    this.add(new CutAction(application));
    this.add(new CopyAction(application));
    this.add(new CopyReferenceAction(application));
    this.add(new PasteAction(application));
    this.add(new DeleteAction(application));
    this.add(new SelectAllAction(application));
    this.add(new FontAction(application));
    this.add(new StyleAction(application));
    this.add(new FindAction(application));
    this.add(new FindPreviousAction(application));
    this.add(new FindNextAction(application));
    this.add(new PreferencesAction(application));
    //  view actions
    this.add(new AsCoverFlowAction(application));
    this.add(new AsPreviewAction(application));
    this.add(new AsThumbnailsAction(application));
    this.add(new AsDocumentAction(application));
    this.add(new AsWebpageAction(application));
    this.add(new ColumnsAction(application));
    this.add(new SortByAction(application));
    this.add(new ViewModeAction(application));
    this.add(new HideNavigatorAction(application));
    this.add(new ShowNavigatorAction(application));
    this.add(new HideInspectorAction(application));
    this.add(new ShowInspectorAction(application));
    this.add(new HidePreviewAction(application));
    this.add(new ShowPreviewAction(application));
    this.add(new PreviousDocumentAction(application));
    this.add(new NextDocumentAction(application));
    this.add(new ShowDuplicatesAction(application));
    this.add(new ShowAllAction(application));
    this.add(new ReadFullScreenAction(application));
    this.add(new ActualSizeAction(application));
    this.add(new ZoomToFitAction(application));
    this.add(new ZoomInAction(application));
    this.add(new ZoomOutAction(application));
    this.add(new TableOfContentsAction(application));
    this.add(new PreviousPageAction(application));
    this.add(new NextPageAction(application));
    this.add(new BackAction(application));
    this.add(new ForwardAction(application));
    //  library actions
    this.add(new MarkFlaggedAction(application));
    this.add(new MarkUnflaggedAction(application));
    this.add(new MarkReadAction(application));
    this.add(new MarkUnreadAction(application));
    this.add(new MarkPrintedAction(application));
    this.add(new MarkUnprintedAction(application));
    this.add(new MoveToTrashAction(application));
    this.add(new RestoreFromTrashAction(application));
    this.add(new ShowKeywordsAction(application));
    this.add(new ShowNotesAction(application));
    this.add(new AddReviewAction(application));
    this.add(new OpenFileAction(application));
    this.add(new OpenFileWithAction(application));
    this.add(new RevealFilePositionAction(application));
    this.add(new AttachFileAction(application));
    this.add(new OpenUrlAction(application));
    this.add(new OpenUrlInBrowserAction(application));
    this.add(new AddToCollectionAction(application));
    this.add(new EditInformationAction(application));
    this.add(new MergeDocumentsAction(application));
    this.add(new MergeAuthorsAction(application));
    this.add(new MergePublishersAction(application));
    this.add(new MergeConferencesAction(application));
    this.add(new MergePeriodicalsAction(application));
    this.add(new MergeWebsitesAction(application));
    //  share actions
    this.add(new TwitterAction(application));
    this.add(new FacebookAction(application));
    this.add(new GooglePlusAction(application));
    this.add(new SinaAction(application));
    this.add(new TencentAction(application));
    this.add(new EmailAction(application));
    //  window actions
    this.add(new MinimizeAction(application));
    this.add(new MinimizeAllAction(application));
    this.add(new MaximizeAction(application));
    this.add(new LibraryAction(application));
    this.add(new InfoAction(application));
    this.add(new NotesAction(application));
    this.add(new ReviewsAction(application));
    this.add(new FilesAction(application));
    this.add(new CycleTabsAction(application));
    this.add(new PreviousTabAction(application));
    this.add(new NextTabAction(application));
    this.add(new CloseTabAction(application));
    this.add(new CloseAllTabsAction(application));
    //  help actions
    this.add(new ManualAction(application));
    this.add(new FaqAction(application));
    this.add(new WebsiteAction(application));
    this.add(new FeedbackAction(application));
    this.add(new AboutAction(application));
  }

  /**
   * Adds an action.
   *
   * @param action the action to be added.
   */
  private void add(Action action) {
    actions.put(action.getId(), action);
  }

  /**
   * Gets the action by its key.
   *
   * @param key
   *          the key of the action to be get.
   * @return the action with the specified key, or null if no such action.
   */
  public Action getAction(String key) {
    return actions.get(key);
  }
}
