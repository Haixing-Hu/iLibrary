/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.edit;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to find the previous match.
 * 
 * @author Haixing Hu
 */
public class FindPreviousAction extends BaseAction {      

  public FindPreviousAction(Application application) {    
    super(application);
  }
  
  @Override
  public String getKey() {
    return "action.edit.find-previous";
  }

  @Override
  public void run() {
    application.displayUnimplementedError();
  }
}
