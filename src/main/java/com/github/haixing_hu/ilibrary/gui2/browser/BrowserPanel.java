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

package com.github.haixing_hu.ilibrary.gui2.browser;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.github.haixing_hu.ilibrary.Application;

/**
 * The main panel of browser pages.
 *
 * @author Haixing Hu
 */
public class BrowserPanel extends Composite {

  private final Application application;

  public BrowserPanel(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
  }
}
