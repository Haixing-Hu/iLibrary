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

package com.github.haixing_hu.ilibrary.gui.navigator;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.gui.BasicHeader;
import com.github.haixing_hu.lang.Argument;
import com.github.haixing_hu.swt.utils.SWTResourceManager;

/**
 * The header of the navigator bar.
 *
 * @author Haixing Hu
 */
public class NavigatorHeader extends BasicHeader implements KeySuffix {

  public static final String ID = NavigatorPanel.ID + ".header";

  private final String title;

  public NavigatorHeader(Application application, Composite parent, String title) {
    super(application, parent, ID, SWT.LEFT);
    this.title = Argument.requireNonEmpty("title", title);
    initialize();
  }

  @Override
  protected Control createControl() {
    final AppConfig config = application.getConfig();
    final int fontSize = config.getInt(ID + FONT_SIZE);
    final Color fontColor = config.getHeavyFontColor();
    final Label label = new Label(this, SWT.NONE);
    label.setText(title);
    final Font font= SWTResourceManager.getFont(label.getFont(),
        fontSize, SWT.BOLD);
    label.setFont(font);
    label.setForeground(fontColor);
    return label;
  }

}

