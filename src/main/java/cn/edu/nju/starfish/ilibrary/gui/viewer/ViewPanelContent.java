/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.viewer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import cn.edu.nju.starfish.ilibrary.Application;

/**
 * The content area of the viewer panel.
 *
 * @author Haixing Hu
 */
public final class ViewPanelContent extends Composite {

  private final Application application;

  public ViewPanelContent(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
    this.createContents();
    this.layoutContents();
  }

  private void createContents() {
    //  TODO
    new Label(this, SWT.NONE).setText("ViewPanelContent");
  }

  private void layoutContents() {
    //  TODO
    setLayout(new FillLayout());
  }

}
