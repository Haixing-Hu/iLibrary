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

package com.github.haixing_hu.ilibrary.gui2;

import org.eclipse.swt.widgets.Composite;

import com.github.haixing_hu.ilibrary.Application;

/**
 * The authors tab page.
 *
 * @author Haixing Hu
 */
public class AuthorsPage extends BrowserPage {

  public static final String KEY = "authors";

  public AuthorsPage(Application application, Composite parent) {
    super(application, parent);
  }
}
