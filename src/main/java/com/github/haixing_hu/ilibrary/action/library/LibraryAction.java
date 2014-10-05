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
import com.github.haixing_hu.ilibrary.action.BaseActionGroup;
import com.github.haixing_hu.ilibrary.action.library.author.ManageAuthorAction;
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
import com.github.haixing_hu.ilibrary.action.library.source.ManageSourceAction;
import com.github.haixing_hu.ilibrary.action.library.tag.ManageTagAction;
import com.github.haixing_hu.javafx.action.ActionManager;
import com.github.haixing_hu.javafx.action.SeparatorAction;

/**
 * The action to show the drop down menu of library related actions.
 *
 * @author Haixing Hu
 */
public class LibraryAction extends BaseActionGroup {

  public static final String ID = "action.library";

  public LibraryAction(Application application) {
    super(ID, application);
    final ActionManager am = application.getActionManager();
    addSubAction(am, new MarkFlaggedAction(application));
    addSubAction(am, new MarkUnflaggedAction(application));
    addSubAction(am, new MarkReadAction(application));
    addSubAction(am, new MarkUnreadAction(application));
    addSubAction(am, new MarkPrintedAction(application));
    addSubAction(am, new MarkUnprintedAction(application));
    addSubAction(am, new SeparatorAction());
    addSubAction(am, new ArchiveAction(application));
    addSubAction(am, new MoveToTrashAction(application));
    addSubAction(am, new RestoreFromTrashAction(application));
    addSubAction(am, new EmptyTrashAction(application));
    addSubAction(am, new SeparatorAction());
    addSubAction(am, new EditInformationAction(application));
    addSubAction(am, new EditKeywordsAction(application));
    addSubAction(am, new EditNotesAction(application));
    addSubAction(am, new AddReviewAction(application));
    addSubAction(am, new AttachFileAction(application));
    addSubAction(am, new SeparatorAction());
    addSubAction(am, new OpenFileAction(application));
    addSubAction(am, new OpenFileWithAction(application));
    addSubAction(am, new OpenUrlAction(application));
    addSubAction(am, new OpenUrlInBrowserAction(application));
    addSubAction(am, new RevealFilePositionAction(application));
    addSubAction(am, new SeparatorAction());
    addSubAction(am, new ManageTagAction(application));
    addSubAction(am, new ManageAuthorAction(application));
    addSubAction(am, new ManageSourceAction(application));
    addSubAction(am, new ManageCollectionAction(application));
    addSubAction(am, new AddToCollectionAction(application));
    addSubAction(am, new SeparatorAction());
    addSubAction(am, new MergeDocumentsAction(application));
    addSubAction(am, new MergeAuthorsAction(application));
    addSubAction(am, new MergeInstitutesAction(application));
    addSubAction(am, new MergeConferencesAction(application));
    addSubAction(am, new MergePeriodicalsAction(application));
    addSubAction(am, new MergeWebsitesAction(application));
  }

}
