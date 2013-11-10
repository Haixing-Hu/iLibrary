/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to select the next document.
 *
 * @author Haixing Hu
 */
public class NextDocumentAction extends BaseAction {

  public static final String KEY = "action.view.next-document";

  public NextDocumentAction(Application application) {
    super(application, KEY);
  }
}
