/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseCheckBoxAction;
import cn.edu.nju.starfish.ilibrary.state.AttachmentFilter;

/**
 * The action to filter documents with attachment status.
 *
 * @author Haixing Hu
 */
public class AttachmentFilterAllAction extends BaseCheckBoxAction {

  public static final String KEY = AttachmentFilterAction.KEY + ".all";

  public AttachmentFilterAllAction(Application application) {
    super(application, KEY);
  }

  @Override
  public void run() {
    logger.info("Set the attachment filter to {}", AttachmentFilter.ALL);
    AttachmentFilter.update(application, AttachmentFilter.ALL);
  }

}
