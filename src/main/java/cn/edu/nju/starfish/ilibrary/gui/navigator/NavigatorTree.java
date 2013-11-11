/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.navigator;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import cn.edu.nju.starfish.ilibrary.Application;

/**
 * The navigator tree panel.
 *
 * @author Haixing Hu
 */
public class NavigatorTree extends Composite {

  public static final String KEY = NavigatorPanel.KEY + ".tree";

  private final Application application;

  public NavigatorTree(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
    createContents();
  }

  private void createContents() {
    this.setLayout(new FillLayout());
    //  TODO
    new Label(this, SWT.NONE).setText("NavigationTree");
  }

}
