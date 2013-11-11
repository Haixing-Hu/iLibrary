/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.widget;

import org.apache.commons.configuration.Configuration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.main.MainTabFolder;

/**
 * The abstract base class for all tab folders.
 *
 * @author Haixing Hu
 */
public abstract class BaseTabFolder extends CTabFolder {

  protected final Application application;
  protected final String key;
  protected final Composite parent;

  /**
   * Constructs a new tab folder.
   *
   * @param application
   *          the application.
   * @param key
   *          the key of the new tab folder.
   * @param parent
   *          the parent of the new tab folder.
   */
  public BaseTabFolder(Application application, String key, Composite parent) {
    //  IMPORTANT: in order to remove the margin of the tab folder, the
    //  style must be set to FLAT
    super(parent, SWT.FLAT);
    this.application = application;
    this.key = key;
    this.parent = parent;
    configAppearance();
    createContents();
  }

  /**
   * Configures the appearance of this tab folder.
   */
  private void configAppearance() {
    final Configuration config = application.getConfig();
    final String bg_path = config.getString(key + ".selection-background");
    final Image bg_img = SWTResourceManager.getImage(MainTabFolder.class, bg_path);
    this.setSelectionBackground(bg_img);
    final Color color = SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND);
    this.setBackground(color);
    this.marginHeight = 0;
    this.marginWidth = 0;
    //this.setSimple(false);
  }

  /**
   * Creates the contents of this tab folder.
   */
  protected abstract void createContents();
}
