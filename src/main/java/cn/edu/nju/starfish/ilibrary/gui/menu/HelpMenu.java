/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.menu;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;

import cn.edu.nju.starfish.ilibrary.Application;
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
public final class HelpMenu extends MenuManager {

  public static final String KEY = "menu.help";

  private final Application application;

  /**
   * Creates a help menu.
   *
   * @param application
   *          the application this new menu belongs to.
   */
  public HelpMenu(Application application) {
    super(application.getTitle(KEY));
    this.application = application;
    this.add(new ManualAction(application));
    this.add(new FaqAction(application));
    this.add(new WebsiteAction(application));
    this.add(new FeedbackAction(application));
    //  Mac will display the "About" menu item in its "Apple" menu item
//    if (! SystemUtils.IS_OS_MAC) {
      this.add(new Separator());
      this.add(new AboutAction(application));
//    }
  }

  /**
   * Gets the application this menu belongs to.
   *
   * @return the application this menu belongs to.
   */
  public Application getApplication() {
    return application;
  }

}
