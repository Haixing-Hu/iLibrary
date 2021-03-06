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

package com.github.haixing_hu.ilibrary.gui.search;

import javafx.scene.control.Label;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.gui.VBoxBase;


/**
 * The overview panel of a search result.
 *
 * @author Haixing Hu
 */
public class SearchOverviewPanel extends VBoxBase {

  public SearchOverviewPanel(Application application) {
    super(application);
    getChildren().add(new Label("Overview"));
  }
}
