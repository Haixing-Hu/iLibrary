/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to goto the table of contents of the current document.
 *
 * @author Haixing Hu
 */
public class TableOfContentsAction extends BaseAction {

  public static final String KEY = "action.view.table-of-contents";

  public TableOfContentsAction(Application application) {
    super(application, KEY);
  }
}
