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
import com.github.haixing_hu.ilibrary.action.BaseDropDownAction;
import com.github.haixing_hu.ilibrary.action.view.browser.AsColumnsAction;
import com.github.haixing_hu.ilibrary.action.view.browser.AsCoverFlowAction;
import com.github.haixing_hu.ilibrary.action.view.browser.AsIconsAction;
import com.github.haixing_hu.ilibrary.action.view.browser.AsListAction;
import com.github.haixing_hu.ilibrary.action.view.columns.DisplayColumnsAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterFileStatusAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterFlagStatusAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterReadStatusAction;
import com.github.haixing_hu.ilibrary.action.view.filter.FilterTypeAction;
import com.github.haixing_hu.ilibrary.action.view.inspector.InspectorAction;
import com.github.haixing_hu.ilibrary.action.view.layout.LayoutModeAction;
import com.github.haixing_hu.ilibrary.action.view.preview.PreviewAction;
import com.github.haixing_hu.ilibrary.action.view.read.BackAction;
import com.github.haixing_hu.ilibrary.action.view.read.ForwardAction;
import com.github.haixing_hu.ilibrary.action.view.read.NextPageAction;
import com.github.haixing_hu.ilibrary.action.view.read.PreviousPageAction;
import com.github.haixing_hu.ilibrary.action.view.read.TableOfContentsAction;
import com.github.haixing_hu.ilibrary.action.view.sort.SortAction;
import com.github.haixing_hu.ilibrary.action.view.zoom.ZoomInAction;
import com.github.haixing_hu.ilibrary.action.view.zoom.ZoomOutAction;
import com.github.haixing_hu.ilibrary.action.view.zoom.ZoomToFitAction;
import com.github.haixing_hu.swt.action.IActionManager;

/**
 * The action to show the drop down menu of view related actions.
 *
 * @author Haixing Hu
 */
public class ViewAction extends BaseDropDownAction {

  public static final String KEY = "action.view";

  private static final String SUB_ACTIONS[] = {
    AsListAction.KEY,
    AsColumnsAction.KEY,
    AsIconsAction.KEY,
    AsCoverFlowAction.KEY,
    SEPARATOR_KEY,
    DisplayColumnsAction.KEY,
    SortAction.KEY,
    FilterFlagStatusAction.KEY,
    FilterReadStatusAction.KEY,
    FilterTypeAction.KEY,
    FilterFileStatusAction.KEY,
    SEPARATOR_KEY,
    HideNavigatorAction.KEY,
    ShowNavigatorAction.KEY,
    InspectorAction.KEY,
    PreviewAction.KEY,
    LayoutModeAction.KEY,
    SEPARATOR_KEY,
    PreviousDocumentAction.KEY,
    NextDocumentAction.KEY,
    SEPARATOR_KEY,
    ShowDuplicatesAction.KEY,
    ShowAllAction.KEY,
    SEPARATOR_KEY,
    ActualSizeAction.KEY,
    ZoomToFitAction.KEY,
    ZoomInAction.KEY,
    ZoomOutAction.KEY,
    SEPARATOR_KEY,
    TableOfContentsAction.KEY,
    PreviousPageAction.KEY,
    NextPageAction.KEY,
    BackAction.KEY,
    ForwardAction.KEY,
  };

  public ViewAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager, SUB_ACTIONS);
    setShowImage(true);
  }
}
