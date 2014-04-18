/******************************************************************************
 *
 * Copyright (c) 2014  Haixing Hu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package com.github.haixing_hu.ilibrary.action;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.ApplicationConfig;
import com.github.haixing_hu.ilibrary.action.edit.AnnotateAction;
import com.github.haixing_hu.ilibrary.action.edit.AnnotateHighlightAction;
import com.github.haixing_hu.ilibrary.action.edit.AnnotateSelectionAction;
import com.github.haixing_hu.ilibrary.action.edit.AnnotateStrikethroughAction;
import com.github.haixing_hu.ilibrary.action.edit.AnnotateUnderlineAction;
import com.github.haixing_hu.ilibrary.action.edit.CopyAction;
import com.github.haixing_hu.ilibrary.action.edit.CopyReferenceAction;
import com.github.haixing_hu.ilibrary.action.edit.CutAction;
import com.github.haixing_hu.ilibrary.action.edit.DeleteAction;
import com.github.haixing_hu.ilibrary.action.edit.EditAction;
import com.github.haixing_hu.ilibrary.action.edit.FindAction;
import com.github.haixing_hu.ilibrary.action.edit.FindNextAction;
import com.github.haixing_hu.ilibrary.action.edit.FindPreviousAction;
import com.github.haixing_hu.ilibrary.action.edit.FontAction;
import com.github.haixing_hu.ilibrary.action.edit.PasteAction;
import com.github.haixing_hu.ilibrary.action.edit.PreferencesAction;
import com.github.haixing_hu.ilibrary.action.edit.RedoAction;
import com.github.haixing_hu.ilibrary.action.edit.SelectAllAction;
import com.github.haixing_hu.ilibrary.action.edit.StyleAction;
import com.github.haixing_hu.ilibrary.action.edit.UndoAction;
import com.github.haixing_hu.ilibrary.action.file.CloseLibraryAction;
import com.github.haixing_hu.ilibrary.action.file.ExportAction;
import com.github.haixing_hu.ilibrary.action.file.FileAction;
import com.github.haixing_hu.ilibrary.action.file.ImportAction;
import com.github.haixing_hu.ilibrary.action.file.NewAction;
import com.github.haixing_hu.ilibrary.action.file.NewArticleDocumentAction;
import com.github.haixing_hu.ilibrary.action.file.NewAuthorAction;
import com.github.haixing_hu.ilibrary.action.file.NewBookDocumentAction;
import com.github.haixing_hu.ilibrary.action.file.NewCollectionAction;
import com.github.haixing_hu.ilibrary.action.file.NewCollectionFromSelectionAction;
import com.github.haixing_hu.ilibrary.action.file.NewConferenceAction;
import com.github.haixing_hu.ilibrary.action.file.NewDocumentFormTemplateAction;
import com.github.haixing_hu.ilibrary.action.file.NewInstituteAction;
import com.github.haixing_hu.ilibrary.action.file.NewLawDocumentAction;
import com.github.haixing_hu.ilibrary.action.file.NewLibraryAction;
import com.github.haixing_hu.ilibrary.action.file.NewMediaDocumentAction;
import com.github.haixing_hu.ilibrary.action.file.NewNormalCollectionAction;
import com.github.haixing_hu.ilibrary.action.file.NewPeriodicalAction;
import com.github.haixing_hu.ilibrary.action.file.NewReferenceDocumentAction;
import com.github.haixing_hu.ilibrary.action.file.NewSmartCollectionAction;
import com.github.haixing_hu.ilibrary.action.file.NewWebsiteAction;
import com.github.haixing_hu.ilibrary.action.file.OpenLibraryAction;
import com.github.haixing_hu.ilibrary.action.file.PageSetupAction;
import com.github.haixing_hu.ilibrary.action.file.PrintAction;
import com.github.haixing_hu.ilibrary.action.file.QuitAction;
import com.github.haixing_hu.ilibrary.action.help.AboutAction;
import com.github.haixing_hu.ilibrary.action.help.FaqAction;
import com.github.haixing_hu.ilibrary.action.help.FeedbackAction;
import com.github.haixing_hu.ilibrary.action.help.HelpAction;
import com.github.haixing_hu.ilibrary.action.help.ManualAction;
import com.github.haixing_hu.ilibrary.action.help.WebsiteAction;
import com.github.haixing_hu.ilibrary.action.library.AddReviewAction;
import com.github.haixing_hu.ilibrary.action.library.AddToCollectionAction;
import com.github.haixing_hu.ilibrary.action.library.ArchiveAction;
import com.github.haixing_hu.ilibrary.action.library.AttachFileAction;
import com.github.haixing_hu.ilibrary.action.library.DeleteCollectionAction;
import com.github.haixing_hu.ilibrary.action.library.DuplicateCollectionAction;
import com.github.haixing_hu.ilibrary.action.library.EditCollectionAction;
import com.github.haixing_hu.ilibrary.action.library.EditInformationAction;
import com.github.haixing_hu.ilibrary.action.library.EditKeywordsAction;
import com.github.haixing_hu.ilibrary.action.library.EditNotesAction;
import com.github.haixing_hu.ilibrary.action.library.EmptyTrashAction;
import com.github.haixing_hu.ilibrary.action.library.LibraryAction;
import com.github.haixing_hu.ilibrary.action.library.ManageCollectionAction;
import com.github.haixing_hu.ilibrary.action.library.MarkFlaggedAction;
import com.github.haixing_hu.ilibrary.action.library.MarkPrintedAction;
import com.github.haixing_hu.ilibrary.action.library.MarkReadAction;
import com.github.haixing_hu.ilibrary.action.library.MarkUnflaggedAction;
import com.github.haixing_hu.ilibrary.action.library.MarkUnprintedAction;
import com.github.haixing_hu.ilibrary.action.library.MarkUnreadAction;
import com.github.haixing_hu.ilibrary.action.library.MergeAuthorsAction;
import com.github.haixing_hu.ilibrary.action.library.MergeConferencesAction;
import com.github.haixing_hu.ilibrary.action.library.MergeDocumentsAction;
import com.github.haixing_hu.ilibrary.action.library.MergeInstitutesAction;
import com.github.haixing_hu.ilibrary.action.library.MergePeriodicalsAction;
import com.github.haixing_hu.ilibrary.action.library.MergeWebsitesAction;
import com.github.haixing_hu.ilibrary.action.library.MoveToTrashAction;
import com.github.haixing_hu.ilibrary.action.library.OpenFileAction;
import com.github.haixing_hu.ilibrary.action.library.OpenFileWithAction;
import com.github.haixing_hu.ilibrary.action.library.OpenUrlAction;
import com.github.haixing_hu.ilibrary.action.library.OpenUrlInBrowserAction;
import com.github.haixing_hu.ilibrary.action.library.RefreshCollectionAction;
import com.github.haixing_hu.ilibrary.action.library.RestoreFromTrashAction;
import com.github.haixing_hu.ilibrary.action.library.RevealFilePositionAction;
import com.github.haixing_hu.ilibrary.action.share.EmailAction;
import com.github.haixing_hu.ilibrary.action.share.FacebookAction;
import com.github.haixing_hu.ilibrary.action.share.GooglePlusAction;
import com.github.haixing_hu.ilibrary.action.share.ShareAction;
import com.github.haixing_hu.ilibrary.action.share.SinaAction;
import com.github.haixing_hu.ilibrary.action.share.TencentAction;
import com.github.haixing_hu.ilibrary.action.share.TwitterAction;
import com.github.haixing_hu.ilibrary.action.ui.SwitchToFilesTabAction;
import com.github.haixing_hu.ilibrary.action.ui.SwitchToInfoTabAction;
import com.github.haixing_hu.ilibrary.action.ui.SwitchToNotesTabAction;
import com.github.haixing_hu.ilibrary.action.ui.SwitchToReviewsTabAction;
import com.github.haixing_hu.ilibrary.action.view.ActualSizeAction;
import com.github.haixing_hu.ilibrary.action.view.AsCoverFlowAction;
import com.github.haixing_hu.ilibrary.action.view.AsDocumentAction;
import com.github.haixing_hu.ilibrary.action.view.AsPreviewAction;
import com.github.haixing_hu.ilibrary.action.view.AsThumbnailsAction;
import com.github.haixing_hu.ilibrary.action.view.AsWebpageAction;
import com.github.haixing_hu.ilibrary.action.view.BackAction;
import com.github.haixing_hu.ilibrary.action.view.ColumnsAction;
import com.github.haixing_hu.ilibrary.action.view.FilterFileStatusAction;
import com.github.haixing_hu.ilibrary.action.view.FilterFileStatusAllAction;
import com.github.haixing_hu.ilibrary.action.view.FilterFileStatusHasFileAction;
import com.github.haixing_hu.ilibrary.action.view.FilterFileStatusNoFileAction;
import com.github.haixing_hu.ilibrary.action.view.FilterFlagStatusAction;
import com.github.haixing_hu.ilibrary.action.view.FilterFlagStatusAllAction;
import com.github.haixing_hu.ilibrary.action.view.FilterFlagStatusFlaggedAction;
import com.github.haixing_hu.ilibrary.action.view.FilterFlagStatusUnflaggedAction;
import com.github.haixing_hu.ilibrary.action.view.FilterReadStatusAction;
import com.github.haixing_hu.ilibrary.action.view.FilterReadStatusAllAction;
import com.github.haixing_hu.ilibrary.action.view.FilterReadStatusHasReadAction;
import com.github.haixing_hu.ilibrary.action.view.FilterReadStatusReadingAction;
import com.github.haixing_hu.ilibrary.action.view.FilterReadStatusUnreadAction;
import com.github.haixing_hu.ilibrary.action.view.FilterTypeAction;
import com.github.haixing_hu.ilibrary.action.view.FilterTypeAllAction;
import com.github.haixing_hu.ilibrary.action.view.FilterTypeArticleAction;
import com.github.haixing_hu.ilibrary.action.view.FilterTypeBookAction;
import com.github.haixing_hu.ilibrary.action.view.FilterTypeLawAction;
import com.github.haixing_hu.ilibrary.action.view.FilterTypeMediaAction;
import com.github.haixing_hu.ilibrary.action.view.FilterTypeReferenceAction;
import com.github.haixing_hu.ilibrary.action.view.ForwardAction;
import com.github.haixing_hu.ilibrary.action.view.HideInspectorAction;
import com.github.haixing_hu.ilibrary.action.view.HideNavigatorAction;
import com.github.haixing_hu.ilibrary.action.view.HidePreviewAction;
import com.github.haixing_hu.ilibrary.action.view.NextDocumentAction;
import com.github.haixing_hu.ilibrary.action.view.NextPageAction;
import com.github.haixing_hu.ilibrary.action.view.PreviousDocumentAction;
import com.github.haixing_hu.ilibrary.action.view.PreviousPageAction;
import com.github.haixing_hu.ilibrary.action.view.ReadFullScreenAction;
import com.github.haixing_hu.ilibrary.action.view.ShowAllAction;
import com.github.haixing_hu.ilibrary.action.view.ShowDuplicatesAction;
import com.github.haixing_hu.ilibrary.action.view.ShowInspectorAction;
import com.github.haixing_hu.ilibrary.action.view.ShowNavigatorAction;
import com.github.haixing_hu.ilibrary.action.view.ShowPreviewAction;
import com.github.haixing_hu.ilibrary.action.view.SortByAction;
import com.github.haixing_hu.ilibrary.action.view.TableOfContentsAction;
import com.github.haixing_hu.ilibrary.action.view.ViewAction;
import com.github.haixing_hu.ilibrary.action.view.ViewModeAction;
import com.github.haixing_hu.ilibrary.action.view.ViewModeAllAction;
import com.github.haixing_hu.ilibrary.action.view.ViewModeInspectorAction;
import com.github.haixing_hu.ilibrary.action.view.ViewModeNoneAction;
import com.github.haixing_hu.ilibrary.action.view.ViewModePreviewAction;
import com.github.haixing_hu.ilibrary.action.view.ZoomInAction;
import com.github.haixing_hu.ilibrary.action.view.ZoomOutAction;
import com.github.haixing_hu.ilibrary.action.view.ZoomToFitAction;
import com.github.haixing_hu.ilibrary.action.window.CloseAllTabsAction;
import com.github.haixing_hu.ilibrary.action.window.CloseTabAction;
import com.github.haixing_hu.ilibrary.action.window.CycleTabsAction;
import com.github.haixing_hu.ilibrary.action.window.MaximizeAction;
import com.github.haixing_hu.ilibrary.action.window.MinimizeAction;
import com.github.haixing_hu.ilibrary.action.window.MinimizeAllAction;
import com.github.haixing_hu.ilibrary.action.window.NextTabAction;
import com.github.haixing_hu.ilibrary.action.window.PreviousTabAction;
import com.github.haixing_hu.ilibrary.action.window.ShowFilesTabAction;
import com.github.haixing_hu.ilibrary.action.window.ShowInfoTabAction;
import com.github.haixing_hu.ilibrary.action.window.ShowLibraryTabAction;
import com.github.haixing_hu.ilibrary.action.window.ShowNotesTabAction;
import com.github.haixing_hu.ilibrary.action.window.ShowReviewsTabAction;
import com.github.haixing_hu.ilibrary.action.window.WindowAction;
import com.github.haixing_hu.ilibrary.gui.widget.Action;
import com.github.haixing_hu.ilibrary.gui.widget.IActionManager;
import com.github.haixing_hu.ilibrary.model.DocumentTemplate;
import com.github.haixing_hu.ilibrary.service.DocumentTemplateService;

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
    this.add(new NewAction(application, this));
    this.add(new NewArticleDocumentAction(application, this));
    this.add(new NewBookDocumentAction(application, this));
    this.add(new NewReferenceDocumentAction(application, this));
    this.add(new NewLawDocumentAction(application, this));
    this.add(new NewMediaDocumentAction(application, this));
    this.add(new NewAuthorAction(application, this));
    this.add(new NewPeriodicalAction(application, this));
    this.add(new NewConferenceAction(application, this));
    this.add(new NewInstituteAction(application, this));
    this.add(new NewWebsiteAction(application, this));
    this.add(new NewCollectionAction(application, this));
    this.add(new NewNormalCollectionAction(application, this));
    this.add(new NewSmartCollectionAction(application, this));
    this.add(new NewCollectionFromSelectionAction(application, this));
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
    this.add(new FilterFlagStatusAction(application, this));
    this.add(new FilterFlagStatusAllAction(application, this));
    this.add(new FilterFlagStatusFlaggedAction(application, this));
    this.add(new FilterFlagStatusUnflaggedAction(application, this));
    this.add(new FilterReadStatusAction(application, this));
    this.add(new FilterReadStatusAllAction(application, this));
    this.add(new FilterReadStatusUnreadAction(application, this));
    this.add(new FilterReadStatusReadingAction(application, this));
    this.add(new FilterReadStatusHasReadAction(application, this));
    this.add(new FilterTypeAction(application, this));
    this.add(new FilterTypeAllAction(application, this));
    this.add(new FilterTypeArticleAction(application, this));
    this.add(new FilterTypeBookAction(application, this));
    this.add(new FilterTypeReferenceAction(application, this));
    this.add(new FilterTypeLawAction(application, this));
    this.add(new FilterTypeMediaAction(application, this));
    this.add(new FilterFileStatusAction(application, this));
    this.add(new FilterFileStatusAllAction(application, this));
    this.add(new FilterFileStatusHasFileAction(application, this));
    this.add(new FilterFileStatusNoFileAction(application, this));
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
    this.add(new ManageCollectionAction(application, this));
    this.add(new EditCollectionAction(application, this));
    this.add(new RefreshCollectionAction(application, this));
    this.add(new DuplicateCollectionAction(application, this));
    this.add(new DeleteCollectionAction(application, this));
    this.add(new AddToCollectionAction(application, this));
    this.add(new EditInformationAction(application, this));
    this.add(new MergeDocumentsAction(application, this));
    this.add(new MergeAuthorsAction(application, this));
    this.add(new MergeInstitutesAction(application, this));
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
    this.add(new SwitchToInfoTabAction(application, this));
    this.add(new SwitchToNotesTabAction(application, this));
    this.add(new SwitchToReviewsTabAction(application, this));
    this.add(new SwitchToFilesTabAction(application, this));

    // add the new document action for every supported document template
    final ApplicationConfig config = ApplicationConfig.getInstance();
    final DocumentTemplateService service = config.getBean(DocumentTemplateService.class);
    final Collection<DocumentTemplate> templates = service.getAll();
    for (final DocumentTemplate template : templates) {
      final NewDocumentFormTemplateAction action = new NewDocumentFormTemplateAction(
            application, this, template);
      this.add(action);
    }
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
