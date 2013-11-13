/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.ActionManager;
import cn.edu.nju.starfish.ilibrary.action.view.AttachmentFilterAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.AttachmentFilterHasFileAction;
import cn.edu.nju.starfish.ilibrary.action.view.AttachmentFilterNoFileAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.Action;

/**
 * The enumeration of attachment filters.
 *
 * @author Haixing Hu
 */
public enum AttachmentFilter {

  HAS_FILE,

  NO_FILE,

  ALL;

  private static final Logger LOGGER = LoggerFactory.getLogger(AttachmentFilter.class);

  /**
   * Updates the attachment filter.
   *
   * @param application the application.
   * @param filter the new attachment filter.
   */
  public static void update(Application application, AttachmentFilter filter) {
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
      LOGGER.error("Unknown attachment filter: ", filter);
      return;
    }
    //  set the state
    final ApplicationState state = application.getState();
    state.setAttachmentFilter(filter);
  }
}
