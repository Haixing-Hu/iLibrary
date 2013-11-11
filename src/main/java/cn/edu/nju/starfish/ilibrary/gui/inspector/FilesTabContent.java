/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.inspector;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import cn.edu.nju.starfish.ilibrary.Application;

/**
 * The content of the info tab.
 *
 * @author Haixing Hu
 */
public class FilesTabContent extends Composite {

  public static final String KEY = InfoTab.KEY + ".content";

  private final Application application;

  public FilesTabContent(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
    createContents();
  }

  private void createContents() {
    // TODO Auto-generated method stub
    this.setLayout(new FillLayout());
    new Label(this, SWT.NONE).setText("FilesTabContent");
  }
}
