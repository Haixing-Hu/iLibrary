/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.edit.AnnotateAction;
import cn.edu.nju.starfish.ilibrary.action.edit.AnnotateHighlightAction;
import cn.edu.nju.starfish.ilibrary.action.edit.AnnotateSelectionAction;
import cn.edu.nju.starfish.ilibrary.action.edit.AnnotateStrikethroughAction;
import cn.edu.nju.starfish.ilibrary.action.edit.AnnotateUnderlineAction;
import cn.edu.nju.starfish.ilibrary.action.edit.CopyAction;
import cn.edu.nju.starfish.ilibrary.action.edit.CopyReferenceAction;
import cn.edu.nju.starfish.ilibrary.action.edit.CutAction;
import cn.edu.nju.starfish.ilibrary.action.edit.DeleteAction;
import cn.edu.nju.starfish.ilibrary.action.edit.EditAction;
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
import cn.edu.nju.starfish.ilibrary.action.file.FileAction;
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
import cn.edu.nju.starfish.ilibrary.action.help.HelpAction;
import cn.edu.nju.starfish.ilibrary.action.help.ManualAction;
import cn.edu.nju.starfish.ilibrary.action.help.WebsiteAction;
import cn.edu.nju.starfish.ilibrary.action.library.AddReviewAction;
import cn.edu.nju.starfish.ilibrary.action.library.AddToCollectionAction;
import cn.edu.nju.starfish.ilibrary.action.library.ArchiveAction;
import cn.edu.nju.starfish.ilibrary.action.library.AttachFileAction;
import cn.edu.nju.starfish.ilibrary.action.library.CreateCollectionAction;
import cn.edu.nju.starfish.ilibrary.action.library.CreateCollectionFromSelectionAction;
import cn.edu.nju.starfish.ilibrary.action.library.CreateNormalCollectionAction;
import cn.edu.nju.starfish.ilibrary.action.library.CreateSmartCollectionAction;
import cn.edu.nju.starfish.ilibrary.action.library.DeleteCollectionAction;
import cn.edu.nju.starfish.ilibrary.action.library.DuplicateCollectionAction;
import cn.edu.nju.starfish.ilibrary.action.library.EditCollectionAction;
import cn.edu.nju.starfish.ilibrary.action.library.EditInformationAction;
import cn.edu.nju.starfish.ilibrary.action.library.EditKeywordsAction;
import cn.edu.nju.starfish.ilibrary.action.library.EditNotesAction;
import cn.edu.nju.starfish.ilibrary.action.library.EmptyTrashAction;
import cn.edu.nju.starfish.ilibrary.action.library.LibraryAction;
import cn.edu.nju.starfish.ilibrary.action.library.ManageCollectionAction;
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
import cn.edu.nju.starfish.ilibrary.action.library.RefreshCollectionAction;
import cn.edu.nju.starfish.ilibrary.action.library.RestoreFromTrashAction;
import cn.edu.nju.starfish.ilibrary.action.library.RevealFilePositionAction;
import cn.edu.nju.starfish.ilibrary.action.share.EmailAction;
import cn.edu.nju.starfish.ilibrary.action.share.FacebookAction;
import cn.edu.nju.starfish.ilibrary.action.share.GooglePlusAction;
import cn.edu.nju.starfish.ilibrary.action.share.ShareAction;
import cn.edu.nju.starfish.ilibrary.action.share.SinaAction;
import cn.edu.nju.starfish.ilibrary.action.share.TencentAction;
import cn.edu.nju.starfish.ilibrary.action.share.TwitterAction;
import cn.edu.nju.starfish.ilibrary.action.ui.FilesTabAction;
import cn.edu.nju.starfish.ilibrary.action.ui.InfoTabAction;
import cn.edu.nju.starfish.ilibrary.action.ui.NotesTabAction;
import cn.edu.nju.starfish.ilibrary.action.ui.ReviewsTabAction;
import cn.edu.nju.starfish.ilibrary.action.view.ActualSizeAction;
import cn.edu.nju.starfish.ilibrary.action.view.AsCoverFlowAction;
import cn.edu.nju.starfish.ilibrary.action.view.AsDocumentAction;
import cn.edu.nju.starfish.ilibrary.action.view.AsPreviewAction;
import cn.edu.nju.starfish.ilibrary.action.view.AsThumbnailsAction;
import cn.edu.nju.starfish.ilibrary.action.view.AsWebpageAction;
import cn.edu.nju.starfish.ilibrary.action.view.AttachmentFilterAction;
import cn.edu.nju.starfish.ilibrary.action.view.AttachmentFilterAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.AttachmentFilterHasFileAction;
import cn.edu.nju.starfish.ilibrary.action.view.AttachmentFilterNoFileAction;
import cn.edu.nju.starfish.ilibrary.action.view.BackAction;
import cn.edu.nju.starfish.ilibrary.action.view.ColumnsAction;
import cn.edu.nju.starfish.ilibrary.action.view.FlagFilterAction;
import cn.edu.nju.starfish.ilibrary.action.view.FlagFilterAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.FlagFilterFlaggedAction;
import cn.edu.nju.starfish.ilibrary.action.view.FlagFilterUnflaggedAction;
import cn.edu.nju.starfish.ilibrary.action.view.ForwardAction;
import cn.edu.nju.starfish.ilibrary.action.view.HideInspectorAction;
import cn.edu.nju.starfish.ilibrary.action.view.HideNavigatorAction;
import cn.edu.nju.starfish.ilibrary.action.view.HidePreviewAction;
import cn.edu.nju.starfish.ilibrary.action.view.NextDocumentAction;
import cn.edu.nju.starfish.ilibrary.action.view.NextPageAction;
import cn.edu.nju.starfish.ilibrary.action.view.PreviousDocumentAction;
import cn.edu.nju.starfish.ilibrary.action.view.PreviousPageAction;
import cn.edu.nju.starfish.ilibrary.action.view.ReadFilterAction;
import cn.edu.nju.starfish.ilibrary.action.view.ReadFilterAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.ReadFilterHasReadAction;
import cn.edu.nju.starfish.ilibrary.action.view.ReadFilterReadingAction;
import cn.edu.nju.starfish.ilibrary.action.view.ReadFilterUnreadAction;
import cn.edu.nju.starfish.ilibrary.action.view.ReadFullScreenAction;
import cn.edu.nju.starfish.ilibrary.action.view.ShowAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.ShowDuplicatesAction;
import cn.edu.nju.starfish.ilibrary.action.view.ShowInspectorAction;
import cn.edu.nju.starfish.ilibrary.action.view.ShowNavigatorAction;
import cn.edu.nju.starfish.ilibrary.action.view.ShowPreviewAction;
import cn.edu.nju.starfish.ilibrary.action.view.SortByAction;
import cn.edu.nju.starfish.ilibrary.action.view.TableOfContentsAction;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterAction;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterArticleAction;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterBookAction;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterMediaAction;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterPatentAction;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterReportAction;
import cn.edu.nju.starfish.ilibrary.action.view.ViewAction;
import cn.edu.nju.starfish.ilibrary.action.view.ViewModeAction;
import cn.edu.nju.starfish.ilibrary.action.view.ViewModeAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.ViewModeInspectorAction;
import cn.edu.nju.starfish.ilibrary.action.view.ViewModeNoneAction;
import cn.edu.nju.starfish.ilibrary.action.view.ViewModePreviewAction;
import cn.edu.nju.starfish.ilibrary.action.view.ZoomInAction;
import cn.edu.nju.starfish.ilibrary.action.view.ZoomOutAction;
import cn.edu.nju.starfish.ilibrary.action.view.ZoomToFitAction;
import cn.edu.nju.starfish.ilibrary.action.window.CloseAllTabsAction;
import cn.edu.nju.starfish.ilibrary.action.window.CloseTabAction;
import cn.edu.nju.starfish.ilibrary.action.window.CycleTabsAction;
import cn.edu.nju.starfish.ilibrary.action.window.MaximizeAction;
import cn.edu.nju.starfish.ilibrary.action.window.MinimizeAction;
import cn.edu.nju.starfish.ilibrary.action.window.MinimizeAllAction;
import cn.edu.nju.starfish.ilibrary.action.window.NextTabAction;
import cn.edu.nju.starfish.ilibrary.action.window.PreviousTabAction;
import cn.edu.nju.starfish.ilibrary.action.window.ShowFilesTabAction;
import cn.edu.nju.starfish.ilibrary.action.window.ShowInfoTabAction;
import cn.edu.nju.starfish.ilibrary.action.window.ShowLibraryTabAction;
import cn.edu.nju.starfish.ilibrary.action.window.ShowNotesTabAction;
import cn.edu.nju.starfish.ilibrary.action.window.ShowReviewsTabAction;
import cn.edu.nju.starfish.ilibrary.action.window.WindowAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.Action;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;

/**
 * A class used to manage all the actions in this application.
 *
 * @author Haixing Hu
 */
public final class ActionManager implements IActionManager {

  private final Map<String, Action> map;

  public ActionManager(Application application) {
    this.map = new HashMap<String, Action>();
    //  file actions
    this.add(new FileAction(application, this));
    this.add(new NewEntryAction(application, this));
    this.add(new NewLibraryAction(application, this));
    this.add(new OpenLibraryAction(application, this));
    this.add(new CloseLibraryAction(application, this));
    this.add(new ImportAction(application, this));
    this.add(new ExportAction(application, this));
    this.add(new PageSetupAction(application, this));
    this.add(new PrintAction(application, this));
    this.add(new QuitAction(application, this));
    //  edit actions
    this.add(new EditAction(application, this));
    this.add(new UndoAction(application, this));
    this.add(new RedoAction(application, this));
    this.add(new CutAction(application, this));
    this.add(new CopyAction(application, this));
    this.add(new CopyReferenceAction(application, this));
    this.add(new PasteAction(application, this));
    this.add(new DeleteAction(application, this));
    this.add(new SelectAllAction(application, this));
    this.add(new AnnotateAction(application, this));
    this.add(new AnnotateSelectionAction(application, this));
    this.add(new AnnotateHighlightAction(application, this));
    this.add(new AnnotateUnderlineAction(application, this));
    this.add(new AnnotateStrikethroughAction(application, this));
    this.add(new FontAction(application, this));
    this.add(new StyleAction(application, this));
    this.add(new FindAction(application, this));
    this.add(new FindPreviousAction(application, this));
    this.add(new FindNextAction(application, this));
    this.add(new PreferencesAction(application, this));
    //  view actions
    this.add(new ViewAction(application, this));
    this.add(new AsCoverFlowAction(application, this));
    this.add(new AsPreviewAction(application, this));
    this.add(new AsThumbnailsAction(application, this));
    this.add(new AsDocumentAction(application, this));
    this.add(new AsWebpageAction(application, this));
    this.add(new ColumnsAction(application, this));
    this.add(new SortByAction(application, this));
    this.add(new FlagFilterAction(application, this));
    this.add(new FlagFilterAllAction(application, this));
    this.add(new FlagFilterFlaggedAction(application, this));
    this.add(new FlagFilterUnflaggedAction(application, this));
    this.add(new ReadFilterAction(application, this));
    this.add(new ReadFilterAllAction(application, this));
    this.add(new ReadFilterUnreadAction(application, this));
    this.add(new ReadFilterReadingAction(application, this));
    this.add(new ReadFilterHasReadAction(application, this));
    this.add(new TypeFilterAction(application, this));
    this.add(new TypeFilterAllAction(application, this));
    this.add(new TypeFilterArticleAction(application, this));
    this.add(new TypeFilterBookAction(application, this));
    this.add(new TypeFilterReportAction(application, this));
    this.add(new TypeFilterPatentAction(application, this));
    this.add(new TypeFilterMediaAction(application, this));
    this.add(new AttachmentFilterAction(application, this));
    this.add(new AttachmentFilterAllAction(application, this));
    this.add(new AttachmentFilterHasFileAction(application, this));
    this.add(new AttachmentFilterNoFileAction(application, this));
    this.add(new HideNavigatorAction(application, this));
    this.add(new ShowNavigatorAction(application, this));
    this.add(new HideInspectorAction(application, this));
    this.add(new ShowInspectorAction(application, this));
    this.add(new HidePreviewAction(application, this));
    this.add(new ShowPreviewAction(application, this));
    this.add(new ViewModeAction(application, this));
    this.add(new ViewModeAllAction(application, this));
    this.add(new ViewModeInspectorAction(application, this));
    this.add(new ViewModePreviewAction(application, this));
    this.add(new ViewModeNoneAction(application, this));
    this.add(new PreviousDocumentAction(application, this));
    this.add(new NextDocumentAction(application, this));
    this.add(new ShowDuplicatesAction(application, this));
    this.add(new ShowAllAction(application, this));
    this.add(new ReadFullScreenAction(application, this));
    this.add(new ActualSizeAction(application, this));
    this.add(new ZoomToFitAction(application, this));
    this.add(new ZoomInAction(application, this));
    this.add(new ZoomOutAction(application, this));
    this.add(new TableOfContentsAction(application, this));
    this.add(new PreviousPageAction(application, this));
    this.add(new NextPageAction(application, this));
    this.add(new BackAction(application, this));
    this.add(new ForwardAction(application, this));
    //  library actions
    this.add(new LibraryAction(application, this));
    this.add(new MarkFlaggedAction(application, this));
    this.add(new MarkUnflaggedAction(application, this));
    this.add(new MarkReadAction(application, this));
    this.add(new MarkUnreadAction(application, this));
    this.add(new MarkPrintedAction(application, this));
    this.add(new MarkUnprintedAction(application, this));
    this.add(new ArchiveAction(application, this));
    this.add(new MoveToTrashAction(application, this));
    this.add(new RestoreFromTrashAction(application, this));
    this.add(new EmptyTrashAction(application, this));
    this.add(new EditKeywordsAction(application, this));
    this.add(new EditNotesAction(application, this));
    this.add(new AddReviewAction(application, this));
    this.add(new OpenFileAction(application, this));
    this.add(new OpenFileWithAction(application, this));
    this.add(new RevealFilePositionAction(application, this));
    this.add(new AttachFileAction(application, this));
    this.add(new OpenUrlAction(application, this));
    this.add(new OpenUrlInBrowserAction(application, this));
    this.add(new CreateCollectionAction(application, this));
    this.add(new CreateNormalCollectionAction(application, this));
    this.add(new CreateSmartCollectionAction(application, this));
    this.add(new CreateCollectionFromSelectionAction(application, this));
    this.add(new ManageCollectionAction(application, this));
    this.add(new EditCollectionAction(application, this));
    this.add(new RefreshCollectionAction(application, this));
    this.add(new DuplicateCollectionAction(application, this));
    this.add(new DeleteCollectionAction(application, this));
    this.add(new AddToCollectionAction(application, this));
    this.add(new EditInformationAction(application, this));
    this.add(new MergeDocumentsAction(application, this));
    this.add(new MergeAuthorsAction(application, this));
    this.add(new MergePublishersAction(application, this));
    this.add(new MergeConferencesAction(application, this));
    this.add(new MergePeriodicalsAction(application, this));
    this.add(new MergeWebsitesAction(application, this));
    //  share actions
    this.add(new ShareAction(application, this));
    this.add(new TwitterAction(application, this));
    this.add(new FacebookAction(application, this));
    this.add(new GooglePlusAction(application, this));
    this.add(new SinaAction(application, this));
    this.add(new TencentAction(application, this));
    this.add(new EmailAction(application, this));
    //  window actions
    this.add(new WindowAction(application, this));
    this.add(new MinimizeAction(application, this));
    this.add(new MinimizeAllAction(application, this));
    this.add(new MaximizeAction(application, this));
    this.add(new ShowLibraryTabAction(application, this));
    this.add(new ShowInfoTabAction(application, this));
    this.add(new ShowNotesTabAction(application, this));
    this.add(new ShowReviewsTabAction(application, this));
    this.add(new ShowFilesTabAction(application, this));
    this.add(new CycleTabsAction(application, this));
    this.add(new PreviousTabAction(application, this));
    this.add(new NextTabAction(application, this));
    this.add(new CloseTabAction(application, this));
    this.add(new CloseAllTabsAction(application, this));
    //  help actions
    this.add(new HelpAction(application, this));
    this.add(new ManualAction(application, this));
    this.add(new FaqAction(application, this));
    this.add(new WebsiteAction(application, this));
    this.add(new FeedbackAction(application, this));
    this.add(new AboutAction(application, this));
    //  UI actions
    this.add(new InfoTabAction(application, this));
    this.add(new NotesTabAction(application, this));
    this.add(new ReviewsTabAction(application, this));
    this.add(new FilesTabAction(application, this));
  }

  @Override
  public boolean isEmpty() {
    return map.isEmpty();
  }

  @Override
  public int size() {
    return map.size();
  }

  @Override
  public boolean contains(String id) {
    return map.containsKey(id);
  }

  @Override
  public Action get(String id) {
    return map.get(id);
  }

  @Override
  public Collection<Action> getAll() {
    return map.values();
  }

  @Override
  public void add(Action action) {
    map.put(action.getId(), action);
  }

  @Override
  public Action remove(String id) {
    return map.remove(id);
  }

  @Override
  public void clear() {
    map.clear();
  }
}
