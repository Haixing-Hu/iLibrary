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

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.ApplicationConfig;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.swt.utils.SWTUtils;

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
    final ApplicationConfig config = ApplicationConfig.getInstance();
    height = config.getInt(KEY + KeySuffix.HEIGHT);
    background = config.getString(KEY + KeySuffix.BACKGROUND_IMAGE);
    fontSize = config.getInt(KEY + KeySuffix.FONT_SIZE);
    createContents();
  }

  private final void createContents() {
    setLayout(new FillLayout());
    label = new CLabel(this, SWT.NONE);
    final Image img = SWTUtils.getImage(background);
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
