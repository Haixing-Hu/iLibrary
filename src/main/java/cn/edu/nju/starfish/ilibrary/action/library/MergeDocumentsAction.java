/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.library;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to merge the selected documents.
 *
 * @author Haixing Hu
 */
public class MergeDocumentsAction extends BaseAction {

  public static final String KEY = "action.library.merge-documents";

  public MergeDocumentsAction(Application application) {
    super(application, KEY);
  }

}
