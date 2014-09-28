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

package com.github.haixing_hu.ilibrary.gui.explorer;

import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.KeySuffix;

/**
 * The table viewer in the explorer panel.
 *
 * @author Haixing Hu
 */
public class ExplorerTableViewer extends CheckboxTableViewer {

  public static final String ID = ExplorerPanel.ID + ".viewer";

  private final int minHeight;
  private final int maxHeight;

  public ExplorerTableViewer(Application application, Composite parent) {
    super(new Table(parent, SWT.CHECK | SWT.V_SCROLL | SWT.H_SCROLL));
    final AppConfig config = application.getConfig();
    minHeight = config.getInt(ID + KeySuffix.MIN_HEIGHT);
    maxHeight = config.getInt(ID + KeySuffix.MAX_HEIGHT);
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
