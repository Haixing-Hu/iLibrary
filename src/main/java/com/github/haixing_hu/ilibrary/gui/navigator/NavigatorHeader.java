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
import org.eclipse.swt.widgets.Composite;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.gui.BasicHeader;
import com.github.haixing_hu.ilibrary.gui.util.LabelCreator;

/**
 * The header of the navigator bar.
 *
 * @author Haixing Hu
 */
public class NavigatorHeader extends BasicHeader {

  public static final String KEY = NavigatorPanel.KEY + ".header";

  public NavigatorHeader(Application application, Composite parent, String title) {
    super(application, parent, KEY,
        new LabelCreator(title,
          application.getConfig().getInt(KEY + KeySuffix.FONT_SIZE),
          SWT.BOLD,
          application.getConfig().getHeavyFontColor()),
    SWT.LEFT);
  }

}

