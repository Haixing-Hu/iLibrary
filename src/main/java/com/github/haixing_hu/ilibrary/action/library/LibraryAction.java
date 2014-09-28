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

package com.github.haixing_hu.ilibrary.action.library;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseDropDownAction;
import com.github.haixing_hu.ilibrary.action.library.collection.AddToCollectionAction;
import com.github.haixing_hu.ilibrary.action.library.collection.ManageCollectionAction;
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
import com.github.haixing_hu.swt.action.IActionManager;
import com.github.haixing_hu.swt.toolbar.Separator;

/**
 * The action to show the drop down menu of library related actions.
 *
 * @author Haixing Hu
 */
public class LibraryAction extends BaseDropDownAction {

  public static final String ID = "action.library";

  private static final String SUB_ACTIONS[] = {
    MarkFlaggedAction.ID,
    MarkUnflaggedAction.ID,
    MarkReadAction.ID,
    MarkUnreadAction.ID,
    MarkPrintedAction.ID,
    MarkUnprintedAction.ID,
    Separator.ID,
    ArchiveAction.ID,
    MoveToTrashAction.ID,
    RestoreFromTrashAction.ID,
    EmptyTrashAction.ID,
    Separator.ID,
    EditInformationAction.ID,
    EditKeywordsAction.ID,
    EditNotesAction.ID,
    AddReviewAction.ID,
    AttachFileAction.ID,
    Separator.ID,
    OpenFileAction.ID,
    OpenFileWithAction.ID,
    OpenUrlAction.ID,
    OpenUrlInBrowserAction.ID,
    RevealFilePositionAction.ID,
    Separator.ID,
    ManageCollectionAction.ID,
    AddToCollectionAction.ID,
    Separator.ID,
    MergeDocumentsAction.ID,
    MergeAuthorsAction.ID,
    MergeInstitutesAction.ID,
    MergeConferencesAction.ID,
    MergePeriodicalsAction.ID,
    MergeWebsitesAction.ID,
  };

  public LibraryAction(Application application, IActionManager actionManager) {
    super(ID, application, actionManager, SUB_ACTIONS);
  }

}
