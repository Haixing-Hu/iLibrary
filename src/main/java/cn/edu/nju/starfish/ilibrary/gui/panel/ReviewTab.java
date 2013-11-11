/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.panel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.widget.BaseTabItem;

/**
 * The document tab item.
 *
 * @author Haixing Hu
 */
public final class ReviewTab extends BaseTabItem {

  public static final String KEY = InspectorTabFolder.KEY + ".review";

  public ReviewTab(Application application, CTabFolder parent) {
    super(application, KEY, parent, SWT.NONE);
  }

  @Override
  protected void createContents() {
    // TODO Auto-generated method stub

  }

}
