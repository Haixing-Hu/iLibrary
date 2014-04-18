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

package com.github.haixing_hu.ilibrary.gui.library;

import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.ApplicationConfig;
import com.github.haixing_hu.ilibrary.KeySuffix;

/**
 * The content panel in the library panel.
 *
 * @author Haixing Hu
 */
public class LibraryPanelContent extends CheckboxTableViewer {

  public static final String KEY = LibraryPanel.KEY + ".content"; //  "window.main.tab.library.content"

  private final int minHeight;
  private final int maxHeight;

  public LibraryPanelContent(Application application, Composite parent) {
    super(new Table(parent, SWT.CHECK | SWT.V_SCROLL | SWT.H_SCROLL));
    final ApplicationConfig config = ApplicationConfig.getInstance();
    minHeight = config.getInt(KEY + KeySuffix.MIN_HEIGHT); // "window.main.tab.library.content.min-height"
    maxHeight = config.getInt(KEY + KeySuffix.MAX_HEIGHT); // "window.main.tab.library.content.max-height"
    createContents();
  }

  private void createContents() {
    //  TODO
    this.getTable().setFocus();
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
