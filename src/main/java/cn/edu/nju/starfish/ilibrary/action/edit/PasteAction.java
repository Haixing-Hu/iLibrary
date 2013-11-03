/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.edit;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;

/**
 * The action to paste the text in the clipboard.
 * 
 * @author Haixing Hu
 */
public class PasteAction extends BaseAction {      

  public PasteAction(Application application) {    
    super(application);
  }
  
  @Override
  public String getKey() {
    return "action.edit.paste";
  }

  @Override
  public void run() {
    application.displayUnimplementedError();
  }
}
