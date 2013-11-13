/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.library;

import org.apache.commons.configuration.Configuration;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.KeySuffix;

/**
 * The content panel in the library panel.
 *
 * @author Haixing Hu
 */
public class LibraryPanelContent extends CheckboxTableViewer {

  public static final String KEY = LibraryPanel.KEY + ".content"; //  "window.main.tab.library.content"

  private final int minHeight;
  private final int maxHeight;

  public LibraryPanelContent(Application application, Composite parent) {
    super(new Table(parent, SWT.CHECK | SWT.V_SCROLL | SWT.H_SCROLL));
    final Configuration config = application.getConfig();
    minHeight = config.getInt(KEY + KeySuffix.MIN_HEIGHT); // "window.main.tab.library.content.min-height"
    maxHeight = config.getInt(KEY + KeySuffix.MAX_HEIGHT); // "window.main.tab.library.content.max-height"
    createContents();
  }

  private void createContents() {
    //  TODO
    this.getTable().setFocus();
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
