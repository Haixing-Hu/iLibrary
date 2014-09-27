/******************************************************************************
 *
 * Copyright (c) 2013  Haixing Hu
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

package com.github.haixing_hu.ilibrary.gui.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

import com.github.haixing_hu.swt.utils.SWTResourceManager;

/**
 * The creator for a label.
 *
 * @author Haixing Hu
 */
public class LabelCreator implements ControlCreator {

  private String text;
  private int size;
  private int style;
  private Color foregroundColor;

  /**
   * Constructs a {@link LabelCreator}.
   *
   * @param text
   *    the text on the created label.
   */
  public LabelCreator(String text) {
    this.text = text;
    size = -1;
    style = -1;
    foregroundColor = null;
  }

  /**
   * Constructs a {@link LabelCreator}.
   *
   * @param text
   *    the text on the created label.
   * @param size
   *    the size of the font of the created label.
   */
  public LabelCreator(String text, int size) {
    this.text = text;
    this.size = size;
    style = -1;
    foregroundColor = null;
  }

  /**
   * Constructs a {@link LabelCreator}.
   *
   * @param text
   *    the text on the created label.
   * @param size
   *    the size of the font of the created label.
   * @param style
   *    the style of the font of the created label.
   */
  public LabelCreator(String text, int size, int style) {
    this.text = text;
    this.size = size;
    this.style = style;
    foregroundColor = null;
  }

  /**
   * Constructs a {@link LabelCreator}.
   *
   * @param text
   *    the text on the created label.
   * @param size
   *    the size of the font of the created label.
   * @param style
   *    the style of the font of the created label.
   * @param foregroundColor
   *    the foreground color of the font of the created label.
   */
  public LabelCreator(String text, int size, int style, Color foregroundColor) {
    this.text = text;
    this.size = size;
    this.style = style;
    this.foregroundColor = foregroundColor;
  }

  /**
   * Gets the text.
   *
   * @return the text.
   */
  public String getText() {
    return text;
  }

  /**
   * Sets the text.
   *
   * @param text the new text to set.
   */
  public void setText(String text) {
    this.text = text;
  }

  /**
   * Gets the size of the font.
   *
   * @return the size of the font.
   */
  public int getSize() {
    return size;
  }

  /**
   * Sets the size of the font.
   *
   * @param size the new size of the font to set.
   */
  public void setSize(int size) {
    this.size = size;
  }

  /**
   * Gets the style of the font.
   *
   * @return the style of the font.
   */
  public int getStyle() {
    return style;
  }

  /**
   * Sets the style of the font.
   *
   * @param style
   *          the new style of the font to set.
   */
  public void setStyle(int style) {
    this.style = style;
  }

  /**
   * Gets the foreground color.
   *
   * @return the foreground color.
   */
  public Color getColor() {
    return foregroundColor;
  }

  /**
   * Sets the foreground color.
   *
   * @param foregroundColor
   *          the new foreground color to set.
   */
  public void setForegroundColor(Color color) {
    foregroundColor = color;
  }

  @Override
  public Control create(Composite parent) {
    final Label label = new Label(parent, SWT.NONE);
    label.setText(text);
    final Font font;
    if (size > 0) {
      if (style > 0) {
        font = SWTResourceManager.getFont(label.getFont(), size, style);
      } else {
        font = SWTResourceManager.changeFontSize(label.getFont(), size);
      }
    } else if (style > 0) {
      font = SWTResourceManager.changeFontStyle(label.getFont(), style, false, false);
    } else {
      font = null;
    }
    if (font != null) {
      label.setFont(font);
    }
    if (foregroundColor != null) {
      label.setForeground(foregroundColor);
    }
    return label;
  }

}
