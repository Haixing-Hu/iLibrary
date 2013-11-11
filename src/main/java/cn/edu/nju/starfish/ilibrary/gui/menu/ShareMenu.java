/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.menu;

import org.eclipse.jface.action.Separator;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.ActionManager;
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
public final class ShareMenu extends BaseMenu {

  public static final String KEY = "action.share";

  /**
   * Creates a share menu.
   *
   * @param application
   *          the application this new menu belongs to.
   */
  public ShareMenu(Application application) {
    super(application, KEY);
    final ActionManager am = application.getActionManager();
    this.add(am.getAction(TwitterAction.KEY));
    this.add(am.getAction(FacebookAction.KEY));
    this.add(am.getAction(GooglePlusAction.KEY));
    this.add(am.getAction(SinaAction.KEY));
    this.add(am.getAction(TencentAction.KEY));
    this.add(new Separator());
    this.add(am.getAction(EmailAction.KEY));

    this.disableItems(new String[] {
        TwitterAction.KEY,
        FacebookAction.KEY,
        GooglePlusAction.KEY,
        SinaAction.KEY,
        TencentAction.KEY,
        EmailAction.KEY,
    });
    this.update(true);
  }
}
