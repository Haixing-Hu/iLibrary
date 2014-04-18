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

package com.github.haixing_hu.ilibrary.controller;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.ActionManager;
import com.github.haixing_hu.ilibrary.action.view.FilterFileStatusAllAction;
import com.github.haixing_hu.ilibrary.action.view.FilterFileStatusHasFileAction;
import com.github.haixing_hu.ilibrary.action.view.FilterFileStatusNoFileAction;
import com.github.haixing_hu.ilibrary.action.view.FilterFlagStatusAllAction;
import com.github.haixing_hu.ilibrary.action.view.FilterFlagStatusFlaggedAction;
import com.github.haixing_hu.ilibrary.action.view.FilterFlagStatusUnflaggedAction;
import com.github.haixing_hu.ilibrary.action.view.FilterReadStatusAllAction;
import com.github.haixing_hu.ilibrary.action.view.FilterReadStatusHasReadAction;
import com.github.haixing_hu.ilibrary.action.view.FilterReadStatusReadingAction;
import com.github.haixing_hu.ilibrary.action.view.FilterReadStatusUnreadAction;
import com.github.haixing_hu.ilibrary.action.view.FilterTypeAllAction;
import com.github.haixing_hu.ilibrary.action.view.FilterTypeArticleAction;
import com.github.haixing_hu.ilibrary.action.view.FilterTypeBookAction;
import com.github.haixing_hu.ilibrary.action.view.FilterTypeMediaAction;
import com.github.haixing_hu.ilibrary.action.view.FilterTypeLawAction;
import com.github.haixing_hu.ilibrary.action.view.FilterTypeReferenceAction;
import com.github.haixing_hu.ilibrary.gui.widget.Action;
import com.github.haixing_hu.ilibrary.state.ApplicationState;
import com.github.haixing_hu.ilibrary.state.FileStatusFilter;
import com.github.haixing_hu.ilibrary.state.FlagStatusFilter;
import com.github.haixing_hu.ilibrary.state.ReadStatusFilter;
import com.github.haixing_hu.ilibrary.state.TypeFilter;

/**
 * The controller of the library tab.
 *
 * @author Haixing Hu
 */
public class LibraryTabController  extends BaseController {

  /**
   * Constructs a {@link LibraryTabController}.
   *
   * @param application
   *          the application.
   */
  public LibraryTabController(Application application) {
    super(application);
  }

  /**
   * Sets the flag filter.
   *
   * @param filter
   *          the new flag filter.
   */
  public void setFlagFilter(FlagStatusFilter filter) {
    logger.info("Set the flag filter to: {}", filter);
    //  TODO: set the filter in the document list table
    final ActionManager am = application.getActionManager();
    final Action all = am.get(FilterFlagStatusAllAction.KEY);
    final Action flagged = am.get(FilterFlagStatusFlaggedAction.KEY);
    final Action unflagged = am.get(FilterFlagStatusUnflaggedAction.KEY);
    switch (filter) {
    case FLAGGED:
      //  update action's checking status
      all.setChecked(false);
      flagged.setChecked(true);
      unflagged.setChecked(false);
      break;
    case UNFLAGGED:
      //  update action's checking status
      all.setChecked(false);
      flagged.setChecked(false);
      unflagged.setChecked(true);
      break;
    case ALL:
      //  update action's checking status
      all.setChecked(true);
      flagged.setChecked(false);
      unflagged.setChecked(false);
      break;
    default:
      logger.error("Unknown flag filter: ", filter);
      return;
    }
    //  set the state
    final ApplicationState state = application.getState();
    state.setFlagStatusFilter(filter);
  }

  /**
   * Sets the read filter.
   *
   * @param filter
   *          the new read filter.
   */
  public void setReadFilter(ReadStatusFilter filter) {
    logger.info("Set the read filter to: {}", filter);
    //  TODO: set the filter in the document list table
    final ActionManager am = application.getActionManager();
    final Action all = am.get(FilterReadStatusAllAction.KEY);
    final Action unread = am.get(FilterReadStatusUnreadAction.KEY);
    final Action reading = am.get(FilterReadStatusReadingAction.KEY);
    final Action hasRead = am.get(FilterReadStatusHasReadAction.KEY);
    switch (filter) {
    case UNREAD:
      //  update action's checking status
      all.setChecked(false);
      unread.setChecked(true);
      reading.setChecked(false);
      hasRead.setChecked(false);
      break;
    case READING:
      //  update action's checking status
      all.setChecked(false);
      unread.setChecked(false);
      reading.setChecked(true);
      hasRead.setChecked(false);
      break;
    case HAS_READ:
      //  update action's checking status
      all.setChecked(false);
      unread.setChecked(false);
      reading.setChecked(false);
      hasRead.setChecked(true);
      break;
    case ALL:
      //  update action's checking status
      all.setChecked(true);
      unread.setChecked(false);
      reading.setChecked(false);
      hasRead.setChecked(false);
      break;
    default:
      logger.error("Unknown read filter: ", filter);
      return;
    }
    //  set the state
    final ApplicationState state = application.getState();
    state.setReadStatusFilter(filter);
  }

  /**
   * Sets the type filter.
   *
   * @param filter the new type filter.
   */
  public void setTypeFilter(TypeFilter filter) {
    logger.info("Set the type filter to: {}", filter);
    //  TODO: set the filter in the document list table
    final ActionManager am = application.getActionManager();
    final Action all = am.get(FilterTypeAllAction.KEY);
    final Action article = am.get(FilterTypeArticleAction.KEY);
    final Action book = am.get(FilterTypeBookAction.KEY);
    final Action report = am.get(FilterTypeReferenceAction.KEY);
    final Action patent = am.get(FilterTypeLawAction.KEY);
    final Action media = am.get(FilterTypeMediaAction.KEY);
    switch (filter) {
    case ALL:
      all.setChecked(true);
      article.setChecked(false);
      book.setChecked(false);
      report.setChecked(false);
      patent.setChecked(false);
      media.setChecked(false);
      break;
    case ARTICLE:
      all.setChecked(false);
      article.setChecked(true);
      book.setChecked(false);
      report.setChecked(false);
      patent.setChecked(false);
      media.setChecked(false);
      break;
    case BOOK:
      all.setChecked(false);
      article.setChecked(false);
      book.setChecked(true);
      report.setChecked(false);
      patent.setChecked(false);
      media.setChecked(false);
      break;
    case REFERENCE:
      all.setChecked(false);
      article.setChecked(false);
      book.setChecked(false);
      report.setChecked(true);
      patent.setChecked(false);
      media.setChecked(false);
      break;
    case LAW:
      all.setChecked(false);
      article.setChecked(false);
      book.setChecked(false);
      report.setChecked(false);
      patent.setChecked(true);
      media.setChecked(false);
      break;
    case MEDIA:
      all.setChecked(false);
      article.setChecked(false);
      book.setChecked(false);
      report.setChecked(false);
      patent.setChecked(false);
      media.setChecked(true);
      break;
    default:
      logger.error("Unknown type filter: {}", filter);
      return;
    }
    //  set the state
    final ApplicationState state = application.getState();
    state.setTypeFilter(filter);
  }


  /**
   * Sets the attachment filter.
   *
   * @param filter
   *          the new attachment filter.
   */
  public void setAttachmentFilter(FileStatusFilter filter) {
    logger.info("Set the attachment filter to: {}", filter);
    //  TODO: set the filter in the document list table
    final ActionManager am = application.getActionManager();
    final Action all = am.get(FilterFileStatusAllAction.KEY);
    final Action has_file = am.get(FilterFileStatusHasFileAction.KEY);
    final Action no_file = am.get(FilterFileStatusNoFileAction.KEY);
    switch (filter) {
    case HAS_FILE:
      //  update action's checking status
      all.setChecked(false);
      has_file.setChecked(true);
      no_file.setChecked(false);
      break;
    case NO_FILE:
      //  update action's checking status
      all.setChecked(false);
      has_file.setChecked(false);
      no_file.setChecked(true);
      break;
    case ALL:
      //  update action's checking status
      all.setChecked(true);
      has_file.setChecked(false);
      no_file.setChecked(false);
      break;
    default:
      logger.error("Unknown attachment filter: ", filter);
      return;
    }
    //  set the state
    final ApplicationState state = application.getState();
    state.setFileStatusFilter(filter);
  }
}
