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

  /**
   * Constructs a {@link LabelCreator}.
   *
   * @param text
   *    the text on the created label.
   */
  public LabelCreator(String text) {
    this.text = text;
    this.size = -1;
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
   * Gets the size of font.
   *
   * @return the size of font.
   */
  public int getSize() {
    return size;
  }

  /**
   * Sets the size of font.
   *
   * @param size the new size of font to set.
   */
  public void setSize(int size) {
    this.size = size;
  }

  @Override
  public Control create(Composite parent) {
    final Label label = new Label(parent, SWT.NONE);
    label.setText(text);
    if (size > 0) {
      final Font font = SWTResourceManager.changeFontSize(label.getFont(), size);
      label.setFont(font);
    }
    return label;
  }

}
