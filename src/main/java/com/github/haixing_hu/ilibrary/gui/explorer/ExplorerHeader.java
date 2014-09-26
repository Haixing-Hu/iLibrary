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

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.gui.BasicHeader;
import com.github.haixing_hu.ilibrary.gui.util.ControlCreator;

/**
 * The header in the library panel.
 *
 * @author Haixing Hu
 */
public final class ExplorerHeader extends BasicHeader {

  public static final String KEY = ExplorerPanel.KEY + ".header";

  public ExplorerHeader(final Application application, final Composite parent) {
    super(application, parent, KEY, new ControlCreator() {
      @Override
      public Control create(Composite parent) {
        return new ExplorerHeaderToolBar(application, parent);
      }
    }, SWT.LEFT);
  }
}
