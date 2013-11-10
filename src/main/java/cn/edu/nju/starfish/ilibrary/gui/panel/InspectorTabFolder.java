/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.panel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import cn.edu.nju.starfish.ilibrary.Application;

/**
 * The inspector tab folder.
 *
 * @author Haixing Hu
 */
public class InspectorTabFolder extends Composite {

  private final Application application;

  public InspectorTabFolder(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
    // TODO Auto-generated constructor stub
    this.setLayout(new FillLayout());
    new Label(this, SWT.NONE).setText("InspectorTabFolder");
  }

}
