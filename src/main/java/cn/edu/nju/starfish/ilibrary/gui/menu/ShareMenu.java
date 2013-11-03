/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.menu;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.share.EmailAction;
import cn.edu.nju.starfish.ilibrary.action.share.FacebookAction;
import cn.edu.nju.starfish.ilibrary.action.share.GooglePlusAction;
import cn.edu.nju.starfish.ilibrary.action.share.SinaAction;
import cn.edu.nju.starfish.ilibrary.action.share.TencentAction;
import cn.edu.nju.starfish.ilibrary.action.share.TwitterAction;

/**
 * The share menu.
 *
 * @author Haixing Hu
 */
public final class ShareMenu extends MenuManager {

  public static final String KEY = "menu.share";

  private final Application application;

  /**
   * Creates a share menu.
   *
   * @param application
   *          the application this new menu belongs to.
   */
  public ShareMenu(Application application) {
    super(application.getTitle(KEY));
    this.application = application;
    this.add(new TwitterAction(application));
    this.add(new FacebookAction(application));
    this.add(new GooglePlusAction(application));
    this.add(new SinaAction(application));
    this.add(new TencentAction(application));
    this.add(new Separator());
    this.add(new EmailAction(application));
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
