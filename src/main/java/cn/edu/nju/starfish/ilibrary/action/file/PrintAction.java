/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.file;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to print the current document.
 * 
 * @author Haixing Hu
 */
public class PrintAction extends BaseAction {      

  public PrintAction(Application application) {    
    super(application);
  }
  
  @Override
  public String getKey() {
    return "action.file.print";
  }

  @Override
  public void run() {
    application.displayUnimplementedError();
  }
}
