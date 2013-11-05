/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * The panel displaying the inspection information.
 * 
 * @author Haixing Hu
 */
public class InspectorPanel extends Composite {

  public InspectorPanel(Composite parent, int style) {
    super(parent, style);
    this.setLayout(new FillLayout());
    // TODO Auto-generated constructor stub
    new Label(this, SWT.NONE).setText("InspectorPanel");
  }

}
