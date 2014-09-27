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
import com.github.haixing_hu.ilibrary.action.edit.CopyAction;
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
import com.github.haixing_hu.ilibrary.action.edit.annotate.AnnotateAction;
import com.github.haixing_hu.ilibrary.action.edit.annotate.AnnotateHighlightAction;
import com.github.haixing_hu.ilibrary.action.edit.annotate.AnnotateNoteAction;
import com.github.haixing_hu.ilibrary.action.edit.annotate.AnnotateSelectionAction;
import com.github.haixing_hu.ilibrary.action.edit.annotate.AnnotateStrikethroughAction;
import com.github.haixing_hu.ilibrary.action.edit.annotate.AnnotateUnderlineAction;
import com.github.haixing_hu.ilibrary.action.edit.copy.CopyAsAction;
import com.github.haixing_hu.ilibrary.action.edit.copy.CopyAsBibtexRecordAction;
import com.github.haixing_hu.ilibrary.action.edit.copy.CopyAsLatexCiteAction;
import com.github.haixing_hu.ilibrary.action.edit.copy.CopyAsReferenceAction;
import com.github.haixing_hu.ilibrary.action.edit.copy.CopyAsSummaryAction;
import com.github.haixing_hu.ilibrary.action.file.CloseLibraryAction;
import com.github.haixing_hu.ilibrary.action.file.ExportAction;
import com.github.haixing_hu.ilibrary.action.file.FileAction;
import com.github.haixing_hu.ilibrary.action.file.ImportAction;
import com.github.haixing_hu.ilibrary.action.file.NewLibraryAction;
import com.github.haixing_hu.ilibrary.action.file.OpenLibraryAction;
import com.github.haixing_hu.ilibrary.action.file.OpenURLAction;
import com.github.haixing_hu.ilibrary.action.file.PageSetupAction;
import com.github.haixing_hu.ilibrary.action.file.PrintAction;
import com.github.haixing_hu.ilibrary.action.file.QuitAction;
import com.github.haixing_hu.ilibrary.action.file.collection.NewCollectionAction;
import com.github.haixing_hu.ilibrary.action.file.collection.NewCollectionFromSelectionAction;
import com.github.haixing_hu.ilibrary.action.file.collection.NewNormalCollectionAction;
import com.github.haixing_hu.ilibrary.action.file.collection.NewSmartCollectionAction;
import com.github.haixing_hu.ilibrary.action.file.document.NewAction;
import com.github.haixing_hu.ilibrary.action.file.document.NewAuthorAction;
import com.github.haixing_hu.ilibrary.action.file.document.NewConferenceAction;
import com.github.haixing_hu.ilibrary.action.file.document.NewDocumentAction;
import com.github.haixing_hu.ilibrary.action.file.document.NewDocumentFormTemplateAction;
import com.github.haixing_hu.ilibrary.action.file.document.NewInstituteAction;
import com.github.haixing_hu.ilibrary.action.file.document.NewPeriodicalAction;
import com.github.haixing_hu.ilibrary.action.file.document.NewWebSiteAction;
import com.github.haixing_hu.ilibrary.action.help.AboutAction;
import com.github.haixing_hu.ilibrary.action.help.FaqAction;
import com.github.haixing_hu.ilibrary.action.help.FeedbackAction;
import com.github.haixing_hu.ilibrary.action.help.HelpAction;
import com.github.haixing_hu.ilibrary.action.help.ManualAction;
import com.github.haixing_hu.ilibrary.action.help.WebsiteAction;
import com.github.haixing_hu.ilibrary.action.library.ArchiveAction;
import com.github.haixing_hu.ilibrary.action.library.EmptyTrashAction;
import com.github.haixing_hu.ilibrary.action.library.LibraryAction;
import com.github.haixing_hu.ilibrary.action.library.MoveToTrashAction;
import com.github.haixing_hu.ilibrary.action.library.RestoreFromTrashAction;
import com.github.haixing_hu.ilibrary.action.library.collection.AddToCollectionAction;
import com.github.haixing_hu.ilibrary.action.library.collection.DeleteCollectionAction;
import com.github.haixing_hu.ilibrary.action.library.collection.DuplicateCollectionAction;
import com.github.haixing_hu.ilibrary.action.library.collection.EditCollectionAction;
import com.github.haixing_hu.ilibrary.action.library.collection.ManageCollectionAction;
import com.github.haixing_hu.ilibrary.action.library.collection.RefreshCollectionAction;
import com.github.haixing_hu.ilibrary.action.library.edit.AddReviewAction;
import com.github.haixing_hu.ilibrary.action.library.edit.AttachFileAction;
import com.github.haixing_hu.ilibrary.action.library.edit.EditInformationAction;
import com.github.haixing_hu.ilibrary.action.library.edit.EditKeywordsAction;
import com.github.haixing_hu.ilibrary.action.library.edit.EditNotesAction;
import com.github.haixing_hu.ilibrary.action.library.mark.MarkFlaggedAction;
import com.github.haixing_hu.ilibrary.action.library.mark.MarkPrintedAction;
import com.github.haixing_hu.ilibrary.action.library.mark.MarkReadAction;
import com.github.haixing_hu.ilibrary.action.library.mark.MarkUnflaggedAction;
import com.github.haixing_hu.ilibrary.action.library.mark.MarkUnprintedAction;
import com.github.haixing_hu.ilibrary.action.library.mark.MarkUnreadAction;
import com.github.haixing_hu.ilibrary.action.library.merge.MergeAuthorsAction;
import com.github.haixing_hu.ilibrary.action.library.merge.MergeConferencesAction;
import com.github.haixing_hu.ilibrary.action.library.merge.MergeDocumentsAction;
import com.github.haixing_hu.ilibrary.action.library.merge.MergeInstitutesAction;
import com.github.haixing_hu.ilibrary.action.library.merge.MergePeriodicalsAction;
import com.github.haixing_hu.ilibrary.action.library.merge.MergeWebsitesAction;
import com.github.haixing_hu.ilibrary.action.library.open.OpenFileAction;
import com.github.haixing_hu.ilibrary.action.library.open.OpenFileWithAction;
import com.github.haixing_hu.ilibrary.action.library.open.OpenUrlAction;
import com.github.haixing_hu.ilibrary.action.library.open.OpenUrlInBrowserAction;
import com.github.haixing_hu.ilibrary.action.library.open.RevealFilePositionAction;
import com.github.haixing_hu.ilibrary.action.share.EmailAction;
import com.github.haixing_hu.ilibrary.action.share.FacebookAction;
import com.github.haixing_hu.ilibrary.action.share.GooglePlusAction;
import com.github.haixing_hu.ilibrary.action.share.ShareAction;
import com.github.haixing_hu.ilibrary.action.share.SinaAction;
import com.github.haixing_hu.ilibrary.action.share.TencentAction;
import com.github.haixing_hu.ilibrary.action.share.TwitterAction;
import com.github.haixing_hu.ilibrary.action.view.ActualSizeAction;
import com.github.haixing_hu.ilibrary.action.view.HideNavigatorAction;
import com.github.haixing_hu.ilibrary.action.view.NextDocumentAction;
import com.github.haixing_hu.ilibrary.action.view.PreviousDocumentAction;
import com.github.haixing_hu.ilibrary.action.view.ShowAllAction;
import com.github.haixing_hu.ilibrary.action.view.ShowDuplicatesAction;
import com.github.haixing_hu.ilibrary.action.view.ShowNavigatorAction;
import com.github.haixing_hu.ilibrary.action.view.ViewAction;
import com.github.haixing_hu.ilibrary.action.view.browser.AsColumnsAction;
import com.github.haixing_hu.ilibrary.action.view.browser.AsCoverFlowAction;
import com.github.haixing_hu.ilibrary.action.view.browser.AsIconsAction;
import com.github.haixing_hu.ilibrary.action.view.browser.AsListAction;
import com.github.haixing_hu.ilibrary.action.view.browser.BrowserModeAction;
import com.github.haixing_hu.ilibrary.action.view.columns.DisplayColumnForAction;
import com.github.haixing_hu.ilibrary.action.view.columns.DisplayColumnsAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterFileStatusAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterFileStatusAllAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterFileStatusHasFileAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterFileStatusNoFileAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterFlagStatusAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterFlagStatusAllAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterFlagStatusFlaggedAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterFlagStatusUnflaggedAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterReadStatusAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterReadStatusAllAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterReadStatusHasReadAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterReadStatusReadingAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterReadStatusToReadAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterReadStatusUnreadAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterTypeAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterTypeAllAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterTypeForAction;
import com.github.haixing_hu.ilibrary.action.view.inspector.HideInspectorAction;
import com.github.haixing_hu.ilibrary.action.view.inspector.InspectorAction;
import com.github.haixing_hu.ilibrary.action.view.inspector.InspectorInfoTabAction;
import com.github.haixing_hu.ilibrary.action.view.inspector.InspectorNotesTabAction;
import com.github.haixing_hu.ilibrary.action.view.inspector.InspectorOverviewTabAction;
import com.github.haixing_hu.ilibrary.action.view.inspector.InspectorReviewsTabAction;
import com.github.haixing_hu.ilibrary.action.view.inspector.ShowInspectorAction;
import com.github.haixing_hu.ilibrary.action.view.layout.LayoutModeAction;
import com.github.haixing_hu.ilibrary.action.view.layout.LayoutModeAllAction;
import com.github.haixing_hu.ilibrary.action.view.layout.LayoutModeInspectorOnlyAction;
import com.github.haixing_hu.ilibrary.action.view.layout.LayoutModeNoneAction;
import com.github.haixing_hu.ilibrary.action.view.layout.LayoutModePreviewOnlyAction;
import com.github.haixing_hu.ilibrary.action.view.preview.AsDocumentAction;
import com.github.haixing_hu.ilibrary.action.view.preview.AsThumbnailsAction;
import com.github.haixing_hu.ilibrary.action.view.preview.AsWebpageAction;
import com.github.haixing_hu.ilibrary.action.view.preview.HidePreviewAction;
import com.github.haixing_hu.ilibrary.action.view.preview.PreviewAction;
import com.github.haixing_hu.ilibrary.action.view.preview.ShowPreviewAction;
import com.github.haixing_hu.ilibrary.action.view.read.BackAction;
import com.github.haixing_hu.ilibrary.action.view.read.ForwardAction;
import com.github.haixing_hu.ilibrary.action.view.read.NextPageAction;
import com.github.haixing_hu.ilibrary.action.view.read.PreviousPageAction;
import com.github.haixing_hu.ilibrary.action.view.read.TableOfContentsAction;
import com.github.haixing_hu.ilibrary.action.view.sort.SortAction;
import com.github.haixing_hu.ilibrary.action.view.sort.SortByColumnForAction;
import com.github.haixing_hu.ilibrary.action.view.sort.SortByDefaultColumnAction;
import com.github.haixing_hu.ilibrary.action.view.sort.SortOrderAscAction;
import com.github.haixing_hu.ilibrary.action.view.sort.SortOrderDescAction;
import com.github.haixing_hu.ilibrary.action.view.zoom.ZoomInAction;
import com.github.haixing_hu.ilibrary.action.view.zoom.ZoomOutAction;
import com.github.haixing_hu.ilibrary.action.view.zoom.ZoomToFitAction;
import com.github.haixing_hu.ilibrary.action.window.MaximizeAction;
import com.github.haixing_hu.ilibrary.action.window.MinimizeAction;
import com.github.haixing_hu.ilibrary.action.window.MinimizeAllAction;
import com.github.haixing_hu.ilibrary.action.window.WindowAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageAuthorsAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageLibraryAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageReaderAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageSearchAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageSourcesAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageTagsAction;
import com.github.haixing_hu.ilibrary.action.window.tab.CloseAllTabsAction;
import com.github.haixing_hu.ilibrary.action.window.tab.CloseTabAction;
import com.github.haixing_hu.ilibrary.action.window.tab.CycleTabsAction;
import com.github.haixing_hu.ilibrary.action.window.tab.NextTabAction;
import com.github.haixing_hu.ilibrary.action.window.tab.PreviousTabAction;
import com.github.haixing_hu.ilibrary.model.DocumentTemplate;
import com.github.haixing_hu.ilibrary.model.DocumentType;
import com.github.haixing_hu.ilibrary.model.FieldType;
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
    //  file
    add(new FileAction(application, this));
    add(new NewLibraryAction(application, this));
    add(new OpenLibraryAction(application, this));
    add(new CloseLibraryAction(application, this));
    add(new OpenURLAction(application, this));
    add(new ImportAction(application, this));
    add(new ExportAction(application, this));
    add(new PageSetupAction(application, this));
    add(new PrintAction(application, this));
    add(new QuitAction(application, this));
    //  file -> new
    add(new NewAction(application, this));
    //  add the new document action for every supported document type
    for (final DocumentType type : DocumentType.values()) {
      final NewDocumentAction action = new NewDocumentAction(type, application, this);
      add(action);
    }
    // add the new document action for every supported document template
    final AppConfig config = application.getConfig();
    final DocumentTemplateService service = config.getBean(DocumentTemplateService.class);
    final Collection<DocumentTemplate> templates = service.getAll();
    for (final DocumentTemplate template : templates) {
      final NewDocumentFormTemplateAction action =
          new NewDocumentFormTemplateAction(template, application, this);
      add(action);
    }
    add(new NewAuthorAction(application, this));
    add(new NewPeriodicalAction(application, this));
    add(new NewConferenceAction(application, this));
    add(new NewInstituteAction(application, this));
    add(new NewWebSiteAction(application, this));
    //  file -> new collection
    add(new NewCollectionAction(application, this));
    add(new NewNormalCollectionAction(application, this));
    add(new NewSmartCollectionAction(application, this));
    add(new NewCollectionFromSelectionAction(application, this));
    //  edit
    add(new EditAction(application, this));
    add(new UndoAction(application, this));
    add(new RedoAction(application, this));
    add(new CutAction(application, this));
    add(new CopyAction(application, this));

    add(new PasteAction(application, this));
    add(new DeleteAction(application, this));
    add(new SelectAllAction(application, this));
    add(new FontAction(application, this));
    add(new StyleAction(application, this));
    add(new FindAction(application, this));
    add(new FindPreviousAction(application, this));
    add(new FindNextAction(application, this));
    add(new PreferencesAction(application, this));
    //  eidt -> copy as
    add(new CopyAsAction(application, this));
    add(new CopyAsReferenceAction(application, this));
    add(new CopyAsLatexCiteAction(application, this));
    add(new CopyAsBibtexRecordAction(application, this));
    add(new CopyAsSummaryAction(application, this));
    //  edit -> annotate
    add(new AnnotateAction(application, this));
    add(new AnnotateSelectionAction(application, this));
    add(new AnnotateHighlightAction(application, this));
    add(new AnnotateUnderlineAction(application, this));
    add(new AnnotateStrikethroughAction(application, this));
    add(new AnnotateNoteAction(application, this));
    //  view actions
    add(new ViewAction(application, this));
    //  view -> browser mode
    add(new BrowserModeAction(application, this));
    add(new AsListAction(application, this));
    add(new AsColumnsAction(application, this));
    add(new AsIconsAction(application, this));
    add(new AsCoverFlowAction(application, this));
    //  view -> columns
    add(new DisplayColumnsAction(application, this));
    //  add select column action for every possible columns
    for (final FieldType col : FieldType.values()) {
      final DisplayColumnForAction action = new DisplayColumnForAction(col,
          application, this);
      add(action);
    }
    //  view -> sort by
    add(new SortAction(application, this));
    add(new SortByDefaultColumnAction(application, this));
    //  add select sorting column action for every possible columns
    for (final FieldType col : FieldType.values()) {
      final SortByColumnForAction action = new SortByColumnForAction(col,
          application, this);
      add(action);
    }
    add(new SortOrderAscAction(application, this));
    add(new SortOrderDescAction(application, this));
    //  view -> filter
    add(new FilterAction(application, this));
    //  view -> filter flag status
    add(new FilterFlagStatusAction(application, this));
    add(new FilterFlagStatusAllAction(application, this));
    add(new FilterFlagStatusFlaggedAction(application, this));
    add(new FilterFlagStatusUnflaggedAction(application, this));
    //  view -> filter read status
    add(new FilterReadStatusAction(application, this));
    add(new FilterReadStatusAllAction(application, this));
    add(new FilterReadStatusUnreadAction(application, this));
    add(new FilterReadStatusToReadAction(application, this));
    add(new FilterReadStatusReadingAction(application, this));
    add(new FilterReadStatusHasReadAction(application, this));
    //  view -> filter type
    add(new FilterTypeAction(application, this));
    add(new FilterTypeAllAction(application, this));
    for (final DocumentType type : DocumentType.values()) {
      final FilterTypeForAction action = new FilterTypeForAction(type,
          application, this);
      add(action);
    }
    //  view -> filter file status
    add(new FilterFileStatusAction(application, this));
    add(new FilterFileStatusAllAction(application, this));
    add(new FilterFileStatusHasFileAction(application, this));
    add(new FilterFileStatusNoFileAction(application, this));
    //  view -> navigator
    add(new HideNavigatorAction(application, this));
    add(new ShowNavigatorAction(application, this));
    //  view -> inspector
    add(new InspectorAction(application, this));
    add(new InspectorInfoTabAction(application, this));
    add(new InspectorNotesTabAction(application, this));
    add(new InspectorReviewsTabAction(application, this));
    add(new InspectorOverviewTabAction(application, this));
    add(new HideInspectorAction(application, this));
    add(new ShowInspectorAction(application, this));
    //  view -> preview
    add(new PreviewAction(application, this));
    add(new AsDocumentAction(application, this));
    add(new AsWebpageAction(application, this));
    add(new AsThumbnailsAction(application, this));
    add(new HidePreviewAction(application, this));
    add(new ShowPreviewAction(application, this));
    //  view -> layout
    add(new LayoutModeAction(application, this));
    add(new LayoutModeAllAction(application, this));
    add(new LayoutModeInspectorOnlyAction(application, this));
    add(new LayoutModePreviewOnlyAction(application, this));
    add(new LayoutModeNoneAction(application, this));
    //  view -> document
    add(new PreviousDocumentAction(application, this));
    add(new NextDocumentAction(application, this));
    //  view -> duplicate
    add(new ShowDuplicatesAction(application, this));
    add(new ShowAllAction(application, this));
    //  view -> zoom
    add(new ActualSizeAction(application, this));
    add(new ZoomToFitAction(application, this));
    add(new ZoomInAction(application, this));
    add(new ZoomOutAction(application, this));
    //  view -> read
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
