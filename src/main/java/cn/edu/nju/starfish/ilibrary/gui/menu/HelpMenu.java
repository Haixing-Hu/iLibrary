/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.menu;

import org.eclipse.jface.action.Separator;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.ActionManager;
import cn.edu.nju.starfish.ilibrary.action.help.AboutAction;
import cn.edu.nju.starfish.ilibrary.action.help.FaqAction;
import cn.edu.nju.starfish.ilibrary.action.help.FeedbackAction;
import cn.edu.nju.starfish.ilibrary.action.help.ManualAction;
import cn.edu.nju.starfish.ilibrary.action.help.WebsiteAction;

/**
 * The help menu.
 *
 * @author Haixing Hu
 */
public final class HelpMenu extends BaseMenu {

  public static final String KEY = "menu.help";

  /**
   * Creates a help menu.
   *
   * @param application
   *          the application this new menu belongs to.
   */
  public HelpMenu(Application application) {
    super(application, KEY);
    final ActionManager am = application.getActionManager();
    this.add(am.getAction(ManualAction.KEY));
    this.add(am.getAction(FaqAction.KEY));
    this.add(am.getAction(WebsiteAction.KEY));
    this.add(am.getAction(FeedbackAction.KEY));
    //  Mac will display the "About" menu item in its "Apple" menu item
//    if (! SystemUtils.IS_OS_MAC) {
      this.add(new Separator());
      this.add(am.getAction(AboutAction.KEY));
//    }
  }

}
