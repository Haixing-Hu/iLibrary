/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.utils;

import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;

/**
 * Provides some font related functions.
 *
 * @author Haixing Hu
 */
public class FontUtils {

  /**
   * Sets the height of an existing SWT font.
   *
   * @param font
   *          an existing SWT font.
   * @param height
   *          the new height to be set.
   * @return a new SWT font, cloned from the existing font, but with the new
   *         height.
   */
  public static Font setHeight(Font font, int height) {
    FontData[] fontData = font.getFontData();
    for(int i = 0; i < fontData.length; ++i) {
        fontData[i].setHeight(height);
    }
    return new Font(font.getDevice(), fontData);
  }

  /**
   * Sets the style of an existing SWT font.
   *
   * @param font
   *          an existing SWT font.
   * @param style
   *          the new style to be set.
   * @return a new SWT font, cloned from the existing font, but with the new
   *         style.
   */
  public static Font setStyle(Font font, int style) {
    FontData[] fontData = font.getFontData();
    for(int i = 0; i < fontData.length; ++i) {
        fontData[i].setStyle(style);
    }
    return new Font(font.getDevice(), fontData);
  }

  /**
   * Sets the style and height of an existing SWT font.
   *
   * @param font
   *          an existing SWT font.
   * @param style
   *          the new style to be set.
   * @param height
   *          the new height to be set.
   * @return a new SWT font, cloned from the existing font, but with the new
   *         style and the new height.
   */
  public static Font setStyleAndHeight(Font font, int style, int height) {
    FontData[] fontData = font.getFontData();
    for(int i = 0; i < fontData.length; ++i) {
        fontData[i].setStyle(style);
        fontData[i].setHeight(height);
    }
    return new Font(font.getDevice(), fontData);
  }

}
