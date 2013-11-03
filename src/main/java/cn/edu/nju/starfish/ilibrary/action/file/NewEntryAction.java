/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.file;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to create a new entry.
 * 
 * @author Haixing Hu
 */
public class NewEntryAction extends BaseAction {      

  public NewEntryAction(Application application) {    
    super(application);
  }
  
  @Override
  public String getKey() {
    return "action.file.new-entry";
  }

  @Override
  public void run() {
    application.displayUnimplementedError();
  }
}
