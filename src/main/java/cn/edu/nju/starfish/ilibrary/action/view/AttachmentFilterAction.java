/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseDropDownAction;

/**
 * The action to filter documents by their read status.
 *
 * @author Haixing Hu
 */
public class AttachmentFilterAction extends BaseDropDownAction {

  public static final String KEY = "action.view.filter.attachment";

  private static final String SUB_ACTIONS[] = {
    AttachmentFilterAllAction.KEY,
    AttachmentFilterHasFileAction.KEY,
    AttachmentFilterNoFileAction.KEY,
  };

  public AttachmentFilterAction(Application application) {
    super(application, KEY, SUB_ACTIONS);
  }
}
