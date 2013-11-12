/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.document;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import cn.edu.nju.starfish.ilibrary.Application;

/**
 * The content panel in the document panel.
 *
 * @author Haixing Hu
 */
public final class DocumentPanelContent extends Composite {

  private final Application application;

  public DocumentPanelContent(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
    this.createContents();
    this.layoutContents();
  }

  private void createContents() {
    //  TODO
    new Label(this, SWT.NONE).setText("DocumentPanelContent");
  }

  private void layoutContents() {
    //  TODO
    setLayout(new FillLayout());
  }

}