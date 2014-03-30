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
import com.github.haixing_hu.ilibrary.gui.widget.IActionManager;

/**
 * The action to show the drop down menu of view related actions.
 *
 * @author Haixing Hu
 */
public class ViewAction extends BaseDropDownAction {

  public static final String KEY = "action.view";

  private static final String SUB_ACTIONS[] = {
    AsCoverFlowAction.KEY,
    AsPreviewAction.KEY,
    AsThumbnailsAction.KEY,
    SEPARATOR_KEY,
    AsDocumentAction.KEY,
    AsWebpageAction.KEY,
    SEPARATOR_KEY,
    ColumnsAction.KEY,
    SortByAction.KEY,
    FilterFlagStatusAction.KEY,
    FilterReadStatusAction.KEY,
    FilterTypeAction.KEY,
    FilterFileStatusAction.KEY,
    SEPARATOR_KEY,
    HideNavigatorAction.KEY,
    ShowNavigatorAction.KEY,
    HideInspectorAction.KEY,
    ShowInspectorAction.KEY,
    HidePreviewAction.KEY,
    ShowPreviewAction.KEY,
    ViewModeAction.KEY,
    SEPARATOR_KEY,
    PreviousDocumentAction.KEY,
    NextDocumentAction.KEY,
    SEPARATOR_KEY,
    ShowDuplicatesAction.KEY,
    ShowAllAction.KEY,
    SEPARATOR_KEY,
    ReadFullScreenAction.KEY,
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
  }
}
