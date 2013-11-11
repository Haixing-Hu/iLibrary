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
 * The action to filter documents which have files.
 *
 * @author Haixing Hu
 */
public class AttachmentFilterHasFileAction extends BaseCheckBoxAction {

  public static final String KEY = AttachmentFilterAction.KEY + ".has-file";

  public AttachmentFilterHasFileAction(Application application) {
    super(application, KEY);
  }

  @Override
  public void run() {
    AttachmentFilter.update(application, AttachmentFilter.HAS_FILE);
  }
}
