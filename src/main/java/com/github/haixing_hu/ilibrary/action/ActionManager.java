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

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
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
import com.github.haixing_hu.ilibrary.action.view.FilterReadStatusToReadAction;
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
import com.github.haixing_hu.ilibrary.action.window.InspectorOverviewTabAction;
import com.github.haixing_hu.ilibrary.action.window.InspectorInfoTabAction;
import com.github.haixing_hu.ilibrary.action.window.InspectorNotesTabAction;
import com.github.haixing_hu.ilibrary.action.window.InspectorReviewsTabAction;
import com.github.haixing_hu.ilibrary.action.window.MaximizeAction;
import com.github.haixing_hu.ilibrary.action.window.MinimizeAction;
import com.github.haixing_hu.ilibrary.action.window.MinimizeAllAction;
import com.github.haixing_hu.ilibrary.action.window.NextTabAction;
import com.github.haixing_hu.ilibrary.action.window.PageAuthorsAction;
import com.github.haixing_hu.ilibrary.action.window.PageLibraryAction;
import com.github.haixing_hu.ilibrary.action.window.PageReaderAction;
import com.github.haixing_hu.ilibrary.action.window.PageSearchAction;
import com.github.haixing_hu.ilibrary.action.window.PageSourcesAction;
import com.github.haixing_hu.ilibrary.action.window.PageTagsAction;
import com.github.haixing_hu.ilibrary.action.window.PreviousTabAction;
import com.github.haixing_hu.ilibrary.action.window.WindowAction;
import com.github.haixing_hu.ilibrary.model.DocumentTemplate;
import com.github.haixing_hu.ilibrary.service.DocumentTemplateService;
import com.github.haixing_hu.swt.action.ActionEx;
import com.github.haixing_hu.swt.action.IActionManager;

/**
 * A class used to manage all the actions in this application.
 *
 * @author Haixing Hu
 */
public final class ActionManager implements IActionManager {

  private final Map<String, ActionEx> map;

  public ActionManager(Application application) {
    map = new HashMap<String, ActionEx>();
    //  file actions
    add(new FileAction(application, this));
    add(new NewAction(application, this));
    add(new NewArticleDocumentAction(application, this));
    add(new NewBookDocumentAction(application, this));
    add(new NewReferenceDocumentAction(application, this));
    add(new NewLawDocumentAction(application, this));
    add(new NewMediaDocumentAction(application, this));
    add(new NewAuthorAction(application, this));
    add(new NewPeriodicalAction(application, this));
    add(new NewConferenceAction(application, this));
    add(new NewInstituteAction(application, this));
    add(new NewWebsiteAction(application, this));
    add(new NewCollectionAction(application, this));
    add(new NewNormalCollectionAction(application, this));
    add(new NewSmartCollectionAction(application, this));
    add(new NewCollectionFromSelectionAction(application, this));
    add(new NewLibraryAction(application, this));
    add(new OpenLibraryAction(application, this));
    add(new CloseLibraryAction(application, this));
    add(new ImportAction(application, this));
    add(new ExportAction(application, this));
    add(new PageSetupAction(application, this));
    add(new PrintAction(application, this));
    add(new QuitAction(application, this));
    //  edit actions
    add(new EditAction(application, this));
    add(new UndoAction(application, this));
    add(new RedoAction(application, this));
    add(new CutAction(application, this));
    add(new CopyAction(application, this));
    add(new CopyReferenceAction(application, this));
    add(new PasteAction(application, this));
    add(new DeleteAction(application, this));
    add(new SelectAllAction(application, this));
    add(new AnnotateAction(application, this));
    add(new AnnotateSelectionAction(application, this));
    add(new AnnotateHighlightAction(application, this));
    add(new AnnotateUnderlineAction(application, this));
    add(new AnnotateStrikethroughAction(application, this));
    add(new FontAction(application, this));
    add(new StyleAction(application, this));
    add(new FindAction(application, this));
    add(new FindPreviousAction(application, this));
    add(new FindNextAction(application, this));
    add(new PreferencesAction(application, this));
    //  view actions
    add(new ViewAction(application, this));
    add(new AsCoverFlowAction(application, this));
    add(new AsPreviewAction(application, this));
    add(new AsThumbnailsAction(application, this));
    add(new AsDocumentAction(application, this));
    add(new AsWebpageAction(application, this));
    add(new ColumnsAction(application, this));
    add(new SortByAction(application, this));
    add(new FilterFlagStatusAction(application, this));
    add(new FilterFlagStatusAllAction(application, this));
    add(new FilterFlagStatusFlaggedAction(application, this));
    add(new FilterFlagStatusUnflaggedAction(application, this));
    add(new FilterReadStatusAction(application, this));
    add(new FilterReadStatusAllAction(application, this));
    add(new FilterReadStatusUnreadAction(application, this));
    add(new FilterReadStatusToReadAction(application, this));
    add(new FilterReadStatusReadingAction(application, this));
    add(new FilterReadStatusHasReadAction(application, this));
    add(new FilterTypeAction(application, this));
    add(new FilterTypeAllAction(application, this));
    add(new FilterTypeArticleAction(application, this));
    add(new FilterTypeBookAction(application, this));
    add(new FilterTypeReferenceAction(application, this));
    add(new FilterTypeLawAction(application, this));
    add(new FilterTypeMediaAction(application, this));
    add(new FilterFileStatusAction(application, this));
    add(new FilterFileStatusAllAction(application, this));
    add(new FilterFileStatusHasFileAction(application, this));
    add(new FilterFileStatusNoFileAction(application, this));
    add(new HideNavigatorAction(application, this));
    add(new ShowNavigatorAction(application, this));
    add(new HideInspectorAction(application, this));
    add(new ShowInspectorAction(application, this));
    add(new HidePreviewAction(application, this));
    add(new ShowPreviewAction(application, this));
    add(new ViewModeAction(application, this));
    add(new ViewModeAllAction(application, this));
    add(new ViewModeInspectorAction(application, this));
    add(new ViewModePreviewAction(application, this));
    add(new ViewModeNoneAction(application, this));
    add(new PreviousDocumentAction(application, this));
    add(new NextDocumentAction(application, this));
    add(new ShowDuplicatesAction(application, this));
    add(new ShowAllAction(application, this));
    add(new ReadFullScreenAction(application, this));
    add(new ActualSizeAction(application, this));
    add(new ZoomToFitAction(application, this));
    add(new ZoomInAction(application, this));
    add(new ZoomOutAction(application, this));
    add(new TableOfContentsAction(application, this));
    add(new PreviousPageAction(application, this));
    add(new NextPageAction(application, this));
    add(new BackAction(application, this));
    add(new ForwardAction(application, this));
    //  library actions
    add(new LibraryAction(application, this));
    add(new MarkFlaggedAction(application, this));
    add(new MarkUnflaggedAction(application, this));
    add(new MarkReadAction(application, this));
    add(new MarkUnreadAction(application, this));
    add(new MarkPrintedAction(application, this));
    add(new MarkUnprintedAction(application, this));
    add(new ArchiveAction(application, this));
    add(new MoveToTrashAction(application, this));
    add(new RestoreFromTrashAction(application, this));
    add(new EmptyTrashAction(application, this));
    add(new EditKeywordsAction(application, this));
    add(new EditNotesAction(application, this));
    add(new AddReviewAction(application, this));
    add(new OpenFileAction(application, this));
    add(new OpenFileWithAction(application, this));
    add(new RevealFilePositionAction(application, this));
    add(new AttachFileAction(application, this));
    add(new OpenUrlAction(application, this));
    add(new OpenUrlInBrowserAction(application, this));
    add(new ManageCollectionAction(application, this));
    add(new EditCollectionAction(application, this));
    add(new RefreshCollectionAction(application, this));
    add(new DuplicateCollectionAction(application, this));
    add(new DeleteCollectionAction(application, this));
    add(new AddToCollectionAction(application, this));
    add(new EditInformationAction(application, this));
    add(new MergeDocumentsAction(application, this));
    add(new MergeAuthorsAction(application, this));
    add(new MergeInstitutesAction(application, this));
    add(new MergeConferencesAction(application, this));
    add(new MergePeriodicalsAction(application, this));
    add(new MergeWebsitesAction(application, this));
    //  share actions
    add(new ShareAction(application, this));
    add(new TwitterAction(application, this));
    add(new FacebookAction(application, this));
    add(new GooglePlusAction(application, this));
    add(new SinaAction(application, this));
    add(new TencentAction(application, this));
    add(new EmailAction(application, this));
    //  window actions
    add(new WindowAction(application, this));
    add(new MinimizeAction(application, this));
    add(new MinimizeAllAction(application, this));
    add(new MaximizeAction(application, this));
    add(new PageLibraryAction(application, this));
    add(new PageSearchAction(application, this));
    add(new PageTagsAction(application, this));
    add(new PageAuthorsAction(application, this));
    add(new PageSourcesAction(application, this));
    add(new PageReaderAction(application, this));
    add(new InspectorInfoTabAction(application, this));
    add(new InspectorNotesTabAction(application, this));
    add(new InspectorReviewsTabAction(application, this));
    add(new InspectorOverviewTabAction(application, this));
    add(new CycleTabsAction(application, this));
    add(new PreviousTabAction(application, this));
    add(new NextTabAction(application, this));
    add(new CloseTabAction(application, this));
    add(new CloseAllTabsAction(application, this));
    //  help actions
    add(new HelpAction(application, this));
    add(new ManualAction(application, this));
    add(new FaqAction(application, this));
    add(new WebsiteAction(application, this));
    add(new FeedbackAction(application, this));
    add(new AboutAction(application, this));

    // add the new document action for every supported document template
    final AppConfig config = application.getConfig();
    final DocumentTemplateService service = config.getBean(DocumentTemplateService.class);
    final Collection<DocumentTemplate> templates = service.getAll();
    for (final DocumentTemplate template : templates) {
      final NewDocumentFormTemplateAction action = new NewDocumentFormTemplateAction(
            application, this, template);
      add(action);
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
  public ActionEx get(String id) {
    return map.get(id);
  }

  @Override
  public Collection<ActionEx> getAll() {
    return map.values();
  }

  @Override
  public void add(ActionEx action) {
    map.put(action.getId(), action);
  }

  @Override
  public ActionEx remove(String id) {
    return map.remove(id);
  }

  @Override
  public void clear() {
    map.clear();
  }
}
