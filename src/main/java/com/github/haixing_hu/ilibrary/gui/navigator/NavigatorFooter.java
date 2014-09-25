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

package com.github.haixing_hu.ilibrary.gui.navigator;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.gui.BasicFooter;
import com.github.haixing_hu.ilibrary.gui.util.ControlCreator;

/**
 * The footer of the navigator panel.
 *
 * @author Haixing Hu
 */
public class NavigatorFooter extends BasicFooter {

  public static final String KEY = NavigatorPanel.KEY + ".footer";

  /**
   * Creates a status line.
   *
   * @param application
   *    the application.
   * @param parent
   *    the parent of the new status line.
   * @param style
   *    the style of the new status line.
   */
  public NavigatorFooter(final Application application, final Composite parent) {
    super(application, parent, KEY, new ControlCreator() {
      @Override
      public Control create(Composite parent) {
        return new NavigatorFooterToolBar(application, parent);
      }
    });
  }


}
