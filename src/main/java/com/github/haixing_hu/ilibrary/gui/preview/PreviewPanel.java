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

package com.github.haixing_hu.ilibrary.gui.preview;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.gui.MainWindow;

/**
 * The preview panel.
 *
 * @author Haixing Hu
 */
public class PreviewPanel extends Composite {

  public static final String KEY = MainWindow.KEY + ".preview";

  private final Application application;
  private final int defaultHeight;
  private final int minHeight;
  private final int maxHeight;

  public PreviewPanel(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
    final AppConfig config = application.getConfig();
    defaultHeight = config.getInt(KEY + KeySuffix.DEFAULT_HEIGHT); // "window.main.tab.library.preview.default-height"
    minHeight = config.getInt(KEY + KeySuffix.MIN_HEIGHT);         // "window.main.tab.library.preview.min-height"
    maxHeight = config.getInt(KEY + KeySuffix.MAX_HEIGHT);         // "window.main.tab.library.preview.max-height"
  }

  /**
   * Gets the application.
   *
   * @return the application.
   */
  public Application getApplication() {
    return application;
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