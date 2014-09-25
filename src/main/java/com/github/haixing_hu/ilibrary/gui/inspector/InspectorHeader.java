/******************************************************************************
 *
 * Copyright (c) 2014  Haixing Hu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package com.github.haixing_hu.ilibrary.gui.inspector;

import org.eclipse.swt.widgets.Composite;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.window.InspectorInfoTabAction;
import com.github.haixing_hu.ilibrary.action.window.InspectorNotesTabAction;
import com.github.haixing_hu.ilibrary.action.window.InspectorOverviewTabAction;
import com.github.haixing_hu.ilibrary.action.window.InspectorReviewsTabAction;
import com.github.haixing_hu.ilibrary.gui.BasicHeader;
import com.github.haixing_hu.ilibrary.gui.util.ActionListToolBarCreator;

/**
 * The header of the inspector tab folder.
 *
 * @author Haixing Hu
 */
public final class InspectorHeader extends BasicHeader {

  public static final String KEY = InspectorPanel.KEY + ".header";

  private static final String ACTION_KEYS[] = {
    InspectorOverviewTabAction.KEY,
    InspectorInfoTabAction.KEY,
    InspectorNotesTabAction.KEY,
    InspectorReviewsTabAction.KEY,
  };

  public InspectorHeader(final Application application, final Composite parent) {
    super(application, parent, KEY,
        new ActionListToolBarCreator(application, ACTION_KEYS));
  }
}
