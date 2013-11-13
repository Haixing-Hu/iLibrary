/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui;

import org.apache.commons.configuration.Configuration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.KeySuffix;
import cn.edu.nju.starfish.ilibrary.utils.SWTUtils;

/**
 * The base class for the footers in the tabs of the main panel.
 *
 * @author Haixing Hu
 */
public class MainPanelFooter extends Composite {

  public static final String KEY = "footer";

  protected final Application application;
  protected final int height;
  protected final String background;
  protected final int fontSize;
  protected CLabel label;

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
  public MainPanelFooter(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
    final Configuration config = application.getConfig();
    height = config.getInt(KEY + KeySuffix.HEIGHT);
    background = config.getString(KEY + KeySuffix.BACKGROUND_IMAGE);
    fontSize = config.getInt(KEY + KeySuffix.FONT_SIZE);
    createContents();
  }

  private final void createContents() {
    setLayout(new FillLayout());
    label = new CLabel(this, SWT.NONE);
    final Image img = SWTUtils.loadImage(background);
    this.setBackgroundImage(img);
    label.setBackground(img);
    label.setAlignment(SWT.CENTER);
    final Font font = SWTUtils.setFontHeight(label.getFont(), fontSize);
    label.setFont(font);
  }

  /**
   * Sets the message of the status line.
   *
   * @param message
   *    the message to be set.
   */
  public final void setMessage(String message) {
    label.setText(message);
  }

  /**
   * Gets the height of this status line.
   *
   * @return the height of this status line.
   */
  public final int getHeight() {
    return height;
  }
}
