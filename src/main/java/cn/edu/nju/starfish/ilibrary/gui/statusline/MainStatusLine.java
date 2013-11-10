/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.statusline;

import org.apache.commons.configuration.Configuration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.panel.MainPanel;
import cn.edu.nju.starfish.ilibrary.utils.FontUtils;

/**
 * The status line in the main panel.
 *
 * @author Haixing Hu
 */
public class MainStatusLine extends Composite {

  public static final String KEY = "gui.statusline";

  private final CLabel label;
  private final int height;

  /**
   * Creates a status line.
   *
   * @param application
   *    the application.
   * @param parent
   *    the parent of the new status line.
   * @param style
   *    the style of the new status line.
   */
  public MainStatusLine(Application application, Composite parent) {
    super(parent, SWT.NONE);
    final Configuration config = application.getConfig();
    setLayout(new FillLayout());
    label = new CLabel(this, SWT.NONE);
    height = config.getInt(KEY + ".height");
    final String background = config.getString(KEY + ".background");
    final Image image = SWTResourceManager.getImage(MainPanel.class, background);
    label.setBackground(image);
    label.setAlignment(SWT.CENTER);
    final int fontSize = config.getInt(KEY + ".font.size");
    final Font font = FontUtils.setHeight(label.getFont(), fontSize);
    label.setFont(font);
  }

  /**
   * Sets the message of the status line.
   *
   * @param message
   *    the message to be set.
   */
  public void setMessage(String message) {
    label.setText(message);
  }

  /**
   * Gets the height of this status line.
   *
   * @return the height of this status line.
   */
  public int getHeight() {
    return height;
  }
}
