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
import cn.edu.nju.starfish.ilibrary.action.view.FlagFilterAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.FlagFilterFlaggedAction;
import cn.edu.nju.starfish.ilibrary.action.view.FlagFilterUnflaggedAction;

/**
 * The enumeration of flag filters.
 *
 * @author Haixing Hu
 */
public enum FlagFilter {

  FLAGGED,

  UNFLAGGED,

  ALL;

  private static final Logger LOGGER = LoggerFactory.getLogger(FlagFilter.class);

  /**
   * Updates the flag filter.
   *
   * @param application the application.
   * @param filter the new flag filter.
   */
  public static void update(Application application, FlagFilter filter) {
    //  TODO: set the filter in the document list table
    final ActionManager am = application.getActionManager();
    final Action all = am.getAction(FlagFilterAllAction.KEY);
    final Action flagged = am.getAction(FlagFilterFlaggedAction.KEY);
    final Action unflagged = am.getAction(FlagFilterUnflaggedAction.KEY);
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
      LOGGER.error("Unknown flag filter: ", filter);
      return;
    }
    //  set the state
    final ApplicationState state = application.getState();
    state.setFlagFilter(filter);
  }
}
