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

package com.github.haixing_hu.ilibrary.gui.explorer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.swt.window.BalloonWindow;

/**
 * The balloon window used to set the filters.
 *
 * @author Haixing Hu
 */
public class FilterSettingWindow extends BalloonWindow {

  private static final String FILTERS_KEY = ExplorerHeader.KEY + ".filter";

//  private final Label readStatusLabel;
//  private final Label unreadLabel;
//  private final Label toReadLabel;
//  private final Label readingLabel;
//  private final Label hasReadLabel;
//
//  private final Label typeLabel;
//  private final Label articleLabel;
//  private final Label bookLabel;
//  private final Label

  public FilterSettingWindow(Application application, Shell parent) {
    super(parent, SWT.TITLE | SWT.ON_TOP);
    final AppConfig config = application.getConfig();
    setTitleText(config.getMessage(FILTERS_KEY));
  }




}
