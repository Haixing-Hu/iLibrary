/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.help;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to display the FAQ of the application.
 * 
 * @author Haixing Hu
 */
public class FaqAction extends BaseAction {      

  public FaqAction(Application application) {    
    super(application);
  }
  
  @Override
  public String getKey() {
    return "action.help.faq";
  }

  @Override
  public void run() {
    application.displayUnimplementedError();
  }
}
