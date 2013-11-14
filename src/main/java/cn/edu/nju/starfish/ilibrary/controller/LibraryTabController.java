/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.controller;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.ActionManager;
import cn.edu.nju.starfish.ilibrary.action.view.AttachmentFilterAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.AttachmentFilterHasFileAction;
import cn.edu.nju.starfish.ilibrary.action.view.AttachmentFilterNoFileAction;
import cn.edu.nju.starfish.ilibrary.action.view.FlagFilterAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.FlagFilterFlaggedAction;
import cn.edu.nju.starfish.ilibrary.action.view.FlagFilterUnflaggedAction;
import cn.edu.nju.starfish.ilibrary.action.view.ReadFilterAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.ReadFilterHasReadAction;
import cn.edu.nju.starfish.ilibrary.action.view.ReadFilterReadingAction;
import cn.edu.nju.starfish.ilibrary.action.view.ReadFilterUnreadAction;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterArticleAction;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterBookAction;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterMediaAction;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterPatentAction;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterReportAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.Action;
import cn.edu.nju.starfish.ilibrary.state.ApplicationState;
import cn.edu.nju.starfish.ilibrary.state.AttachmentFilter;
import cn.edu.nju.starfish.ilibrary.state.FlagFilter;
import cn.edu.nju.starfish.ilibrary.state.ReadFilter;
import cn.edu.nju.starfish.ilibrary.state.TypeFilter;

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
  public void setFlagFilter(FlagFilter filter) {
    logger.info("Set the flag filter to: {}", filter);
    //  TODO: set the filter in the document list table
    final ActionManager am = application.getActionManager();
    final Action all = am.get(FlagFilterAllAction.KEY);
    final Action flagged = am.get(FlagFilterFlaggedAction.KEY);
    final Action unflagged = am.get(FlagFilterUnflaggedAction.KEY);
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
    state.setFlagFilter(filter);
  }

  /**
   * Sets the read filter.
   *
   * @param filter
   *          the new read filter.
   */
  public void setReadFilter(ReadFilter filter) {
    logger.info("Set the read filter to: {}", filter);
    //  TODO: set the filter in the document list table
    final ActionManager am = application.getActionManager();
    final Action all = am.get(ReadFilterAllAction.KEY);
    final Action unread = am.get(ReadFilterUnreadAction.KEY);
    final Action reading = am.get(ReadFilterReadingAction.KEY);
    final Action hasRead = am.get(ReadFilterHasReadAction.KEY);
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
    state.setReadFilter(filter);
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
    final Action all = am.get(TypeFilterAllAction.KEY);
    final Action article = am.get(TypeFilterArticleAction.KEY);
    final Action book = am.get(TypeFilterBookAction.KEY);
    final Action report = am.get(TypeFilterReportAction.KEY);
    final Action patent = am.get(TypeFilterPatentAction.KEY);
    final Action media = am.get(TypeFilterMediaAction.KEY);
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
    case REPORT:
      all.setChecked(false);
      article.setChecked(false);
      book.setChecked(false);
      report.setChecked(true);
      patent.setChecked(false);
      media.setChecked(false);
      break;
    case PATENT:
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
  public void setAttachmentFilter(AttachmentFilter filter) {
    logger.info("Set the attachment filter to: {}", filter);
    //  TODO: set the filter in the document list table
    final ActionManager am = application.getActionManager();
    final Action all = am.get(AttachmentFilterAllAction.KEY);
    final Action has_file = am.get(AttachmentFilterHasFileAction.KEY);
    final Action no_file = am.get(AttachmentFilterNoFileAction.KEY);
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
    state.setAttachmentFilter(filter);
  }
}
