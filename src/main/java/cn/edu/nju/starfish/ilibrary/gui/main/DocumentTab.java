/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.widget.BaseTabItem;

/**
 * The document tab item.
 *
 * @author Haixing Hu
 */
public final class DocumentTab extends BaseTabItem {

  public static final String KEY = MainTabFolder.KEY + ".document";

  public DocumentTab(Application application, CTabFolder parent) {
    super(application, KEY, parent, SWT.CLOSE);
  }

  @Override
  protected void createContents() {
    // TODO Auto-generated method stub
  }

}
