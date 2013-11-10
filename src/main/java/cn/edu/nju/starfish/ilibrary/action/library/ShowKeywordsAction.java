/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.library;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to show the keywords of the selected document.
 *
 * @author Haixing Hu
 */
public class ShowKeywordsAction extends BaseAction {

  public static final String KEY = "action.library.show-keywords";

  public ShowKeywordsAction(Application application) {
    super(application, KEY);
  }
}
