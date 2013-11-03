/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.file;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to open the page setup dialog.
 * 
 * @author Haixing Hu
 */
public class PageSetupAction extends BaseAction {      

  public PageSetupAction(Application application) {    
    super(application);
  }
  
  @Override
  public String getKey() {
    return "action.file.page-setup";
  }

  @Override
  public void run() {
    application.displayUnimplementedError();
  }
}
