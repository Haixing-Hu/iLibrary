/******************************************************************************
 *
 * Copyright (c) 2014  Haixing Hu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package com.github.haixing_hu.ilibrary.gui;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

/**
 * The about dialog.
 *
 * @author Haixing Hu
 */
public class AboutDialog extends Dialog {

  /**
   * Create the dialog.
   * @param parentShell
   */
  public AboutDialog(Shell parentShell) {
    super(parentShell);
  }

  /**
   * Create contents of the dialog.
   * @param parent
   */
  @Override
  protected Control createDialogArea(Composite parent) {
    Composite container = (Composite) super.createDialogArea(parent);
    container.setLayout(new GridLayout(2, false));

    Composite iconArea = new Composite(container, SWT.NONE);
    GridData gd_iconArea = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
    gd_iconArea.minimumWidth = 60;
    gd_iconArea.minimumHeight = 80;
    iconArea.setLayoutData(gd_iconArea);
    FillLayout fl_iconArea = new FillLayout(SWT.HORIZONTAL);
    fl_iconArea.marginWidth = 10;
    fl_iconArea.marginHeight = 10;
    iconArea.setLayout(fl_iconArea);

    Label lblNewLabel_1 = new Label(iconArea, SWT.NONE);
    lblNewLabel_1.setText("ICON");

    Composite textArea = new Composite(container, SWT.NONE);
    textArea.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
    textArea.setLayout(new GridLayout(1, false));

    CLabel productName = new CLabel(textArea, SWT.NONE);
    productName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
    productName.setFont(SWTResourceManager.getFont("Lucida Grande", 20, SWT.BOLD));
    productName.setText("Product Name");

    CLabel productVersion = new CLabel(textArea, SWT.NONE);
    productVersion.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
    productVersion.setText("Version 1.0.0");

    Label separator = new Label(textArea, SWT.SEPARATOR | SWT.HORIZONTAL);
    separator.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
    separator.setText("New Label");

    Composite composite = new Composite(textArea, SWT.NONE);
    FormLayout fl_composite = new FormLayout();
    composite.setLayout(fl_composite);
    composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

    CLabel lblProductDesign = new CLabel(composite, SWT.NONE);
    lblProductDesign.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
    FormData fd_lblProductDesign = new FormData();
    fd_lblProductDesign.top = new FormAttachment(0, 10);
    fd_lblProductDesign.left = new FormAttachment(0);
    lblProductDesign.setLayoutData(fd_lblProductDesign);
    lblProductDesign.setText("Product Design:");

    Label lblHaixingHu = new Label(composite, SWT.NONE);
    FormData fd_lblHaixingHu = new FormData();
    fd_lblHaixingHu.top = new FormAttachment(lblProductDesign, 3, SWT.TOP);
    fd_lblHaixingHu.left = new FormAttachment(lblProductDesign, 13);
    lblHaixingHu.setLayoutData(fd_lblHaixingHu);
    lblHaixingHu.setText("Haixing Hu");

    CLabel lblProgramming = new CLabel(composite, SWT.NONE);
    lblProgramming.setText("Programming:");
    lblProgramming.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
    FormData fd_lblProgramming = new FormData();
    fd_lblProgramming.top = new FormAttachment(lblProductDesign, 6);
    fd_lblProgramming.left = new FormAttachment(lblProductDesign, 0, SWT.LEFT);
    lblProgramming.setLayoutData(fd_lblProgramming);

    Label label = new Label(composite, SWT.NONE);
    label.setText("Haixing Hu");
    FormData fd_label = new FormData();
    fd_label.bottom = new FormAttachment(lblProgramming, 0, SWT.BOTTOM);
    fd_label.left = new FormAttachment(lblHaixingHu, 0, SWT.LEFT);
    label.setLayoutData(fd_label);

    CLabel lblArtDesign = new CLabel(composite, SWT.NONE);
    lblArtDesign.setText("Art Design:");
    lblArtDesign.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
    FormData fd_lblArtDesign = new FormData();
    fd_lblArtDesign.top = new FormAttachment(lblProgramming, 6);
    fd_lblArtDesign.left = new FormAttachment(lblProductDesign, 0, SWT.LEFT);
    lblArtDesign.setLayoutData(fd_lblArtDesign);

    CLabel lblTesting = new CLabel(composite, SWT.NONE);
    lblTesting.setText("Testing:");
    lblTesting.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
    FormData fd_lblTesting = new FormData();
    fd_lblTesting.top = new FormAttachment(lblArtDesign, 6);
    fd_lblTesting.left = new FormAttachment(lblProductDesign, 0, SWT.LEFT);
    lblTesting.setLayoutData(fd_lblTesting);

    CLabel lblcHaixingHu = new CLabel(composite, SWT.NONE);
    lblcHaixingHu.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
    lblcHaixingHu.setText("(c)2013, Haixing Hu. All rights reserved.");
    lblcHaixingHu.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.NORMAL));
    FormData fd_lblcHaixingHu = new FormData();
    fd_lblcHaixingHu.bottom = new FormAttachment(100);
    fd_lblcHaixingHu.left = new FormAttachment(lblProductDesign, 0, SWT.LEFT);
    lblcHaixingHu.setLayoutData(fd_lblcHaixingHu);

    return container;
  }

  /**
   * Create contents of the button bar.
   * @param parent
   */
  @Override
  protected void createButtonsForButtonBar(Composite parent) {
    createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
  }

  /**
   * Return the initial size of the dialog.
   */
  @Override
  protected Point getInitialSize() {
    return new Point(450, 300);
  }
}
