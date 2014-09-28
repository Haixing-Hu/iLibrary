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

import org.eclipse.swt.SWT;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.swt.window.BalloonWindow;

/**
 * The base class for all balloon windows.
 *
 * @author Haixing Hu
 */
public class BasicBalloonWindow extends BalloonWindow implements KeySuffix {

  public static final String ID = "window.balloon";

  public BasicBalloonWindow(Application application) {
    super(application.getShell(), SWT.TITLE);
    setAnchor(SWT.TOP);
    setCloseOnClickInside(false);
    setCloseOnClickOutside(true);
    final AppConfig config = application.getConfig();
    setBackground(config.getColor(ID + BACKGROUND_COLOR));
    setForeground(config.getColor(ID + FOREGROUND_COLOR));
    setTitleSpacing(config.getInt(ID + TITLE_SPACING));
    final int marginLeft = config.getInt(ID + MARGIN_LEFT);
    final int marginRight = config.getInt(ID + MARGIN_RIGHT);
    final int marginTop = config.getInt(ID + MARGIN_TOP);
    final int marginBottom = config.getInt(ID + MARGIN_BOTTOM);
    this.setMargins(marginLeft, marginRight, marginTop, marginBottom);
  }
}
