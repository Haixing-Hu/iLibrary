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

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Composite;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.gui.MainPanelTab;
import com.github.haixing_hu.ilibrary.gui.PanelCreator;

/**
 * The library tab.
 *
 * @author Haixing Hu
 */
public final class LibraryTab extends MainPanelTab {

  public static final String KEY = MainPanelTab.KEY + ".library";  //  "window.main.tab.library"

  public LibraryTab(Application application, CTabFolder parent) {
    super(application, KEY, parent, SWT.NONE, new PanelCreator() {
      @Override
      public Composite create(Application application, Composite parent) {
        return new LibraryPanel(application, parent);
      }
    });
  }

  /**
   * Gets the library panel.
   *
   * @return the library panel.
   */
  @Override
  public LibraryPanel getPanel() {
    return (LibraryPanel) panel;
  }

  /**
   * Hides the preview panel.
   */
  public void hidePreview() {
    ((LibraryPanel) panel).hidePreview();
  }

  /**
   * Shows the preview panel.
   */
  public void showPreview() {
    ((LibraryPanel) panel).showPreview();
  }
}
