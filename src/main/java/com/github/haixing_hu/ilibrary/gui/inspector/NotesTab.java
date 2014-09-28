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

package com.github.haixing_hu.ilibrary.gui.inspector;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.github.haixing_hu.ilibrary.Application;

/**
 * The document tab item.
 *
 * @author Haixing Hu
 */
public final class NotesTab extends Composite {

  public static final String ID = InspectorTabFolder.ID + ".notes"; // "window.inspector.tab.notes"

  private final Application application;

  public NotesTab(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
    new Label(this, SWT.NONE).setText("NotesTabContent");
    layoutContents();
  }

  private void layoutContents() {
    //  TODO
  }

  /**
   * Gets the application.
   *
   * @return the application.
   */
  public Application getApplication() {
    return application;
  }
}
