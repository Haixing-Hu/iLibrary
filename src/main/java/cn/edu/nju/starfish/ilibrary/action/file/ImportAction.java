/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.file;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to import document entries.
 * 
 * @author Haixing Hu
 */
public class ImportAction extends BaseAction {      

  public ImportAction(Application application) {    
    super(application);
  }
  
  @Override
  public String getKey() {
    return "action.file.import";
  }

  @Override
  public void run() {
    application.displayUnimplementedError();
  }
}
