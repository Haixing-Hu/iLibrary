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

package com.github.haixing_hu.ilibrary.gui.sources;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.gui.NavigatorPanel;
import com.github.haixing_hu.ilibrary.state.Page;

/**
 * The navigator panel for the soruces page.
 *
 * @author Haixing Hu
 */
public class SourcesNavigatorPanel extends NavigatorPanel {

  public SourcesNavigatorPanel(Application application) {
    super(application, Page.SOURCES);
  }

  @Override
  protected void configContent() {
    // TODO Auto-generated method stub
  }
}
