/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.help;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to display the manual of the application.
 * 
 * @author Haixing Hu
 */
public class ManualAction extends BaseAction {      

  public ManualAction(Application application) {    
    super(application);
  }
  
  @Override
  public String getKey() {
    return "action.help.manual";
  }

  @Override
  public void run() {
    application.displayUnimplementedError();
  }
}
