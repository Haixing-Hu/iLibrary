/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseCheckBoxAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;
import cn.edu.nju.starfish.ilibrary.state.AttachmentFilter;

/**
 * The action to filter documents with no file.
 *
 * @author Haixing Hu
 */
public class AttachmentFilterNoFileAction extends BaseCheckBoxAction {

  public static final String KEY = AttachmentFilterAction.KEY + ".no-file";

  public AttachmentFilterNoFileAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

  @Override
  public void run() {
    logger.info("Set the attachment filter to {}", AttachmentFilter.NO_FILE);
    AttachmentFilter.update(application, AttachmentFilter.NO_FILE);
  }
}
