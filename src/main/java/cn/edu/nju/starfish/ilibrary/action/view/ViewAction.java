/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseDropDownAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;

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
    FlagFilterAction.KEY,
    ReadFilterAction.KEY,
    TypeFilterAction.KEY,
    AttachmentFilterAction.KEY,
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
