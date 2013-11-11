/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseCheckBoxAction;
import cn.edu.nju.starfish.ilibrary.state.ReadFilter;

/**
 * The action to filter documents which have not been read.
 *
 * @author Haixing Hu
 */
public class ReadFilterUnreadAction extends BaseCheckBoxAction {

  public static final String KEY = ReadFilterAction.KEY + ".unread";

  public ReadFilterUnreadAction(Application application) {
    super(application, KEY);
  }

  @Override
  public void run() {
    ReadFilter.update(application, ReadFilter.UNREAD);
  }
}
