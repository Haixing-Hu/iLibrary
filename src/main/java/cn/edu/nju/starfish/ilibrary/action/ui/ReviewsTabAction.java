/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.ui;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseCheckBoxAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;
import cn.edu.nju.starfish.ilibrary.state.InspectorTab;

/**
 * The action to switch to the review tab.
 *
 * @author Haixing Hu
 */
public class ReviewsTabAction extends BaseCheckBoxAction {

  public static final String KEY = "action.ui.reviews-tab";

  public ReviewsTabAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

  @Override
  public void run() {
    logger.info("Switch inspector tab to {}", InspectorTab.REVIEWS);
    InspectorTab.update(application, InspectorTab.REVIEWS);
  }
}
