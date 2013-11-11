/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.swt.graphics.Color;
import org.eclipse.wb.swt.SWTResourceManager;

/**
 * Some utility funcitons for colors.
 *
 * @author Haixing Hu
 */
public final class ColorUtils {

  private static final Pattern RGB_PATTERN =
      Pattern.compile("rgb *\\( *([0-9]+), *([0-9]+), *([0-9]+) *\\)",
                      Pattern.CASE_INSENSITIVE);

  /**
   * Parses a color from a string representation of an RGB color.
   * <p>
   * The string representation of an RGB color has the form: "rgb(eb, eb, eb)",
   * where the RGB values are represented in HEX numbers, and the prefix
   * "rgb" is case-insensitive.
   *
   * @param rgb
   *    The string representation of an RGB color.
   * @return
   *    The {@link Color} object corresponding to the RGB color.
   */
  public static Color parseRGB(String rgb) {
    final Matcher matcher = RGB_PATTERN.matcher(rgb);
    if (matcher.matches()) {
      final int r = Integer.valueOf(matcher.group(1), 16);
      final int g = Integer.valueOf(matcher.group(2), 16);
      final int b = Integer.valueOf(matcher.group(3), 16);
      return SWTResourceManager.getColor(r, g, b);
    } else {
      return null;
    }
  }
}
