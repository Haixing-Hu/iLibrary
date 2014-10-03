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

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.state.Page;

/**
 * The panel of main contents.
 *
 * @author Haixing Hu
 */
public abstract class ContentPanel extends PanelWithHeaderFooter  {

  public static final String STYLE_CLASS = "content-panel";

  protected final Page page;

  public ContentPanel(final Application application, Page page) {
    super(application);
    this.page = page;
    getStyleClass().add(STYLE_CLASS);
  }
}
