/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.panel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;

import cn.edu.nju.starfish.ilibrary.Application;

/**
 * The document tab item.
 *
 * @author Haixing Hu
 */
public class DocumentTab extends CTabItem {

  public DocumentTab(Application application, CTabFolder parent) {
    super(parent, SWT.CLOSE);
    // TODO Auto-generated constructor stub
    this.setText("Document");
  }

}
