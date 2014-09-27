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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.state.InspectorTab;

/**
 * The searching tab page.
 *
 * @author Haixing Hu
 */
public class SearchPage extends BasicPage {

  public static final String KEY = MainWindow.KEY + ".search";

  public SearchPage(Application application, Composite parent) {
    super(application, parent);
    createContents();
  }

  private void createContents() {
    //  TODO
    new Label(this, SWT.NONE).setText(this.getClass().getName());
  }

  @Override
  public String getKey() {
    return KEY;
  }

  @Override
  public void setNavigatorWidth(int width) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setInspectorWidth(int width) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setPreviewHeight(int height) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setInspectorTab(InspectorTab tab) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setToolBarActionVisibility(String id, boolean visible) {
    // TODO Auto-generated method stub

  }

  @Override
  public void updateToolBar(boolean force) {
    // TODO Auto-generated method stub

  }
}
