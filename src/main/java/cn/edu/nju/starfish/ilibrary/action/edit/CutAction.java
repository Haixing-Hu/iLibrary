/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.edit;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to cut the selected text.
 * 
 * @author Haixing Hu
 */
public class CutAction extends BaseAction {      

  public CutAction(Application application) {    
    super(application);
  }
  
  @Override
  public String getKey() {
    return "action.edit.cut";
  }

  @Override
  public void run() {
    application.displayUnimplementedError();
  }
}
