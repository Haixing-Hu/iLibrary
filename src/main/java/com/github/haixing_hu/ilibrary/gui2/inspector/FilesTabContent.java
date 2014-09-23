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

package com.github.haixing_hu.ilibrary.gui2.inspector;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.swt.utils.SWTResourceManager;

/**
 * The content of the info tab.
 *
 * @author Haixing Hu
 */
public class FilesTabContent extends Composite {

  public static final String KEY = FilesTab.KEY + ".content"; // "window.inspector.tab.files.content"

  private final Application application;

  public FilesTabContent(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
    createContents();
  }

  private void createContents() {
    final AppConfig config = application.getConfig();
    final String rgb = config.getString(KEY + KeySuffix.BACKGROUND_COLOR);
    final Color color = SWTResourceManager.getColor(rgb);
    setBackground(color);
    // TODO Auto-generated method stub
    setLayout(new FillLayout());
    new Label(this, SWT.NONE).setText("FilesTabContent");
  }
}
