/******************************************************************************
 *
 * Copyright (c) 2014  Haixing Hu
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Haixing Hu (https://github.com/Haixing-Hu/) - Initial implementation and API.
 *
 ******************************************************************************/

package com.github.haixing_hu.ilibrary.gui;

import org.eclipse.swt.widgets.Composite;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.gui.explorer.ExplorerPage;

/**
 * The tags tab page.
 *
 * @author Haixing Hu
 */
public class TagsPage extends ExplorerPage {

  public static final String KEY = MainWindow.KEY + ".tags";

  public TagsPage(Application application, Composite parent) {
    super(application, parent);
  }

  @Override
  public String getKey() {
    return KEY;
  }
}
