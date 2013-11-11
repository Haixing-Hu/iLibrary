/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.inspector;

import org.eclipse.swt.widgets.Composite;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.library.AddReviewAction;

/**
 * The footer of the info tab.
 *
 * @author Haixing Hu
 */
public class ReviewsTabFooter extends InspectorTabFooter {

  private static final String ACTIONS[] = {
    AddReviewAction.KEY,
  };

  public ReviewsTabFooter(Application application, Composite parent) {
    super(application, parent, ACTIONS);
  }
}
