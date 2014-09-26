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
import com.github.haixing_hu.ilibrary.action.BaseAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageAuthorsAction;
import com.github.haixing_hu.ilibrary.gui.explorer.ExplorerPage;

/**
 * The authors tab page.
 *
 * @author Haixing Hu
 */
public class AuthorsPage extends ExplorerPage {

  public static final String KEY = MainWindow.KEY + ".authors";

  public AuthorsPage(Application application, Composite parent) {
    super(application, parent,
        ((BaseAction) application.getActionManager().get(PageAuthorsAction.KEY)).getTitle());
  }

  @Override
  public String getKey() {
    return KEY;
  }
}
