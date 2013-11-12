/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.state;

import org.eclipse.jface.action.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.ActionManager;
import cn.edu.nju.starfish.ilibrary.action.view.ReadFilterAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.ReadFilterHasReadAction;
import cn.edu.nju.starfish.ilibrary.action.view.ReadFilterReadingAction;
import cn.edu.nju.starfish.ilibrary.action.view.ReadFilterUnreadAction;

/**
 * The enumeration of read filters.
 *
 * @author Haixing Hu
 */
public enum ReadFilter {

  UNREAD,

  READING,

  HAS_READ,

  ALL;

  private static final Logger LOGGER = LoggerFactory.getLogger(ReadFilter.class);

  /**
   * Updates the read filter.
   *
   * @param application the application.
   * @param filter the new read filter.
   */
  public static void update(Application application, ReadFilter filter) {
    //  TODO: set the filter in the document list table
    final ActionManager am = application.getActionManager();
    final Action all = am.getAction(ReadFilterAllAction.KEY);
    final Action unread = am.getAction(ReadFilterUnreadAction.KEY);
    final Action reading = am.getAction(ReadFilterReadingAction.KEY);
    final Action hasRead = am.getAction(ReadFilterHasReadAction.KEY);
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
      LOGGER.error("Unknown read filter: ", filter);
      return;
    }
    //  set the state
    final ApplicationState state = application.getState();
    state.setReadFilter(filter);
  }
}
