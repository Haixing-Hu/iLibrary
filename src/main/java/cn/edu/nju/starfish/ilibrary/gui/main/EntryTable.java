/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.main;

import org.apache.commons.configuration.Configuration;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;

import cn.edu.nju.starfish.ilibrary.Application;

/**
 * The table displaying the list of documents.
 *
 * @author Haixing Hu
 */
public class EntryTable extends CheckboxTableViewer {

  public static final String KEY = LibraryTab.KEY + ".table";

  private final int minHeight;
  private final int maxHeight;

  public EntryTable(Application application, Composite parent, Control top, Control bottom) {
    super(new Table(parent, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL));
    final Configuration config = application.getConfig();
    minHeight = config.getInt(KEY + ".height.min");
    maxHeight = config.getInt(KEY + ".height.max");
    configLayoutData(top, bottom);
    this.getTable().setFocus();
  }

  private void configLayoutData(Control top, Control bottom) {
    final FormData layoutData = new FormData();
    layoutData.left = new FormAttachment(0);
    layoutData.top = new FormAttachment(top);
    layoutData.right = new FormAttachment(100);
    layoutData.bottom = new FormAttachment(bottom);
    this.getTable().setLayoutData(layoutData);
  }

  /**
   * Gets the minimum height.
   *
   * @return the minimum height.
   */
  public int getMinHeight() {
    return minHeight;
  }

  /**
   * Gets the maximum height.
   *
   * @return the maximum height.
   */
  public int getMaxHeight() {
    return maxHeight;
  }
}
