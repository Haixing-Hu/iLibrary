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
import com.github.haixing_hu.swt.action.IActionManager;

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
    ManageCollectionAction.KEY,
    AddToCollectionAction.KEY,
    EditInformationAction.KEY,
    SEPARATOR_KEY,
    MergeDocumentsAction.KEY,
    MergeAuthorsAction.KEY,
    MergeInstitutesAction.KEY,
    MergeConferencesAction.KEY,
    MergePeriodicalsAction.KEY,
    MergeWebsitesAction.KEY,
  };

  public LibraryAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager, SUB_ACTIONS);
  }

}
