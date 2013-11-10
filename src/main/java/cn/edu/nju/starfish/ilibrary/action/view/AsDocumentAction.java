/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to view the electronic document.
 *
 * @author Haixing Hu
 */
public class AsDocumentAction extends BaseAction {

  public static final String KEY = "action.view.as-document";

  public AsDocumentAction(Application application) {
    super(application, KEY);
  }

}
