/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.library;

import org.apache.commons.configuration.Configuration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.KeySuffix;

/**
 * The preview panel.
 *
 * @author Haixing Hu
 */
public class LibraryPanelPreview extends Composite {

  public static final String KEY = LibraryTab.KEY + ".preview"; //  "window.main.tab.library.preview"

  private final Application application;
  private final int defaultHeight;
  private final int minHeight;
  private final int maxHeight;

  public LibraryPanelPreview(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
    final Configuration config = application.getConfig();
    defaultHeight = config.getInt(KEY + KeySuffix.DEFAULT_HEIGHT);
    minHeight = config.getInt(KEY + KeySuffix.MIN_HEIGHT);
    maxHeight = config.getInt(KEY + KeySuffix.MAX_HEIGHT);
  }

  /**
   * Gets the default height.
   *
   * @return the default height.
   */
  public int getDefaultHeight() {
    return defaultHeight;
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
