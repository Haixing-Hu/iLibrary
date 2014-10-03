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

package com.github.haixing_hu.ilibrary.action.view;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseActionGroup;
import com.github.haixing_hu.ilibrary.action.view.browser.BrowserModeAction;
import com.github.haixing_hu.ilibrary.action.view.columns.SelectColumnsAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterDocumentTypeAction;
import com.github.haixing_hu.ilibrary.action.view.inspector.InspectorAction;
import com.github.haixing_hu.ilibrary.action.view.preview.PreviewAction;
import com.github.haixing_hu.ilibrary.action.view.read.BackAction;
import com.github.haixing_hu.ilibrary.action.view.read.ForwardAction;
import com.github.haixing_hu.ilibrary.action.view.read.GotoPageAction;
import com.github.haixing_hu.ilibrary.action.view.read.NextPageAction;
import com.github.haixing_hu.ilibrary.action.view.read.PreviousPageAction;
import com.github.haixing_hu.ilibrary.action.view.read.TableOfContentsAction;
import com.github.haixing_hu.ilibrary.action.view.sort.SortAction;
import com.github.haixing_hu.ilibrary.action.view.zoom.ActualSizeAction;
import com.github.haixing_hu.ilibrary.action.view.zoom.ZoomInAction;
import com.github.haixing_hu.ilibrary.action.view.zoom.ZoomOutAction;
import com.github.haixing_hu.ilibrary.action.view.zoom.ZoomToFitAction;
import com.github.haixing_hu.javafx.action.ActionManager;
import com.github.haixing_hu.javafx.action.SeparatorAction;

/**
 * The action to show the drop down menu of view related actions.
 *
 * @author Haixing Hu
 */
public class ViewAction extends BaseActionGroup {

  public static final String ID = "action.view";


  public ViewAction(Application application) {
    super(ID, application);
    final ActionManager am = application.getActionManager();
    addSubAction(am, new BrowserModeAction(application));
    addSubAction(am, new SeparatorAction());
    addSubAction(am, new HideNavigatorAction(application));
    addSubAction(am, new ShowNavigatorAction(application));
    addSubAction(am, new InspectorAction(application));
    addSubAction(am, new PreviewAction(application));
    addSubAction(am, new SeparatorAction());
    addSubAction(am, new SelectColumnsAction(application));
    addSubAction(am, new SortAction(application));
    addSubAction(am, new FilterAction(application));
    addSubAction(am, new SeparatorAction());
    addSubAction(am, new FilterDocumentTypeAction(application));
    addSubAction(am, new SeparatorAction());
    addSubAction(am, new PreviousDocumentAction(application));
    addSubAction(am, new NextDocumentAction(application));
    addSubAction(am, new SeparatorAction());
    addSubAction(am, new ActualSizeAction(application));
    addSubAction(am, new ZoomInAction(application));
    addSubAction(am, new ZoomOutAction(application));
    addSubAction(am, new ZoomToFitAction(application));
    addSubAction(am, new SeparatorAction());
    addSubAction(am, new TableOfContentsAction(application));
    addSubAction(am, new PreviousPageAction(application));
    addSubAction(am, new NextPageAction(application));
    addSubAction(am, new GotoPageAction(application));
    addSubAction(am, new BackAction(application));
    addSubAction(am, new ForwardAction(application));
  }
}
