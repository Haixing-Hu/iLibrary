/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.widget;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;

import cn.edu.nju.starfish.ilibrary.Application;

/**
 * The abstract base class for all tab items.
 *
 * @author Haixing Hu
 */
public abstract class BaseTabItem extends CTabItem {

  protected final Application application;
  protected final CTabFolder parent;

  /**
   * Constructs a new tab item.
   *
   * @param application
   *          the application.
   * @param key
   *          the key of the new tab item.
   * @param parent
   *          the parent of the new tab item.
   * @param style
   *          the style of the new tab item.
   */
  public BaseTabItem(Application application, String key, CTabFolder parent,
      int style) {
    super(parent, style);
    this.application = application;
    this.parent = parent;
    this.setText("   " + application.getTitle(key) + "   ");
    this.createContents();
  }

  /**
   * Creates the contents of this tab item.
   */
  protected abstract void createContents();
}
