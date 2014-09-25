/******************************************************************************
 *
 * Copyright (c) 2013  Haixing Hu
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

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.view.HideInspectorAction;
import com.github.haixing_hu.ilibrary.gui.BasicFooter;
import com.github.haixing_hu.ilibrary.gui.util.ActionListToolBarCreator;

/**
 * The footer of the inspector panel.
 *
 * @author Haixing Hu
 */
public class InspectorFooter extends BasicFooter {

  public static final String KEY = InspectorPanel.KEY + ".footer";

  private static final String ACTION_KEYS[] = {
    HideInspectorAction.KEY,
  };

  public InspectorFooter(final Application application, final Composite parent) {
    super(application, parent, KEY,
        new ActionListToolBarCreator(application, ACTION_KEYS),
        (SWT.RIGHT | SWT.SEPARATOR));
  }
}
