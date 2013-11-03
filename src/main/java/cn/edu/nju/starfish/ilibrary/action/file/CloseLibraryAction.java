/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.file;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to close the current library.
 * 
 * @author Haixing Hu
 */
public class CloseLibraryAction extends BaseAction {      

  public CloseLibraryAction(Application application) {    
    super(application);
  }
  
  @Override
  public String getKey() {
    return "action.file.close-library";
  }

  @Override
  public void run() {
    application.displayUnimplementedError();
  }
}
