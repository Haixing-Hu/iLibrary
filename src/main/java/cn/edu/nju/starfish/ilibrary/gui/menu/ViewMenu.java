/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.menu;

import org.eclipse.jface.action.Separator;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.ActionManager;
import cn.edu.nju.starfish.ilibrary.action.view.ActualSizeAction;
import cn.edu.nju.starfish.ilibrary.action.view.AsCoverFlowAction;
import cn.edu.nju.starfish.ilibrary.action.view.AsDocumentAction;
import cn.edu.nju.starfish.ilibrary.action.view.AsPreviewAction;
import cn.edu.nju.starfish.ilibrary.action.view.AsThumbnailsAction;
import cn.edu.nju.starfish.ilibrary.action.view.AsWebpageAction;
import cn.edu.nju.starfish.ilibrary.action.view.BackAction;
import cn.edu.nju.starfish.ilibrary.action.view.ColumnsAction;
import cn.edu.nju.starfish.ilibrary.action.view.ForwardAction;
import cn.edu.nju.starfish.ilibrary.action.view.HideInspectorAction;
import cn.edu.nju.starfish.ilibrary.action.view.HidePreviewAction;
import cn.edu.nju.starfish.ilibrary.action.view.NextDocumentAction;
import cn.edu.nju.starfish.ilibrary.action.view.NextPageAction;
import cn.edu.nju.starfish.ilibrary.action.view.PreviousDocumentAction;
import cn.edu.nju.starfish.ilibrary.action.view.PreviousPageAction;
import cn.edu.nju.starfish.ilibrary.action.view.ReadFullScreenAction;
import cn.edu.nju.starfish.ilibrary.action.view.ShowAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.ShowDuplicatesAction;
import cn.edu.nju.starfish.ilibrary.action.view.ShowInspectorAction;
import cn.edu.nju.starfish.ilibrary.action.view.ShowPreviewAction;
import cn.edu.nju.starfish.ilibrary.action.view.SortByAction;
import cn.edu.nju.starfish.ilibrary.action.view.TableOfContentsAction;
import cn.edu.nju.starfish.ilibrary.action.view.ViewModeAction;
import cn.edu.nju.starfish.ilibrary.action.view.ZoomInAction;
import cn.edu.nju.starfish.ilibrary.action.view.ZoomOutAction;
import cn.edu.nju.starfish.ilibrary.action.view.ZoomToFitAction;

/**
 * The view menu.
 *
 * @author Haixing Hu
 */
public final class ViewMenu extends BaseMenu {

  public static final String KEY = "menu.view";

  /**
   * Creates a view menu.
   *
   * @param application
   *          the application this new menu belongs to.
   */
  public ViewMenu(Application application) {
    super(application, KEY);
    final ActionManager am = application.getActionManager();
    this.add(am.getAction(AsCoverFlowAction.KEY));
    this.add(am.getAction(AsPreviewAction.KEY));
    this.add(am.getAction(AsThumbnailsAction.KEY));
    this.add(new Separator());
    this.add(am.getAction(AsDocumentAction.KEY));
    this.add(am.getAction(AsWebpageAction.KEY));
    this.add(new Separator());
    this.add(am.getAction(ColumnsAction.KEY));
    this.add(am.getAction(SortByAction.KEY));
    this.add(new Separator());
    this.add(am.getAction(HideInspectorAction.KEY));
    this.add(am.getAction(ShowInspectorAction.KEY));
    this.add(am.getAction(HidePreviewAction.KEY));
    this.add(am.getAction(ShowPreviewAction.KEY));
//    this.add(new ViewModeSubMenu(application));
    this.add(am.getAction(ViewModeAction.KEY));
    this.add(new Separator());
    this.add(am.getAction(PreviousDocumentAction.KEY));
    this.add(am.getAction(NextDocumentAction.KEY));
    this.add(new Separator());
    this.add(am.getAction(ShowDuplicatesAction.KEY));
    this.add(am.getAction(ShowAllAction.KEY));
    this.add(new Separator());
    this.add(am.getAction(ReadFullScreenAction.KEY));
    this.add(am.getAction(ActualSizeAction.KEY));
    this.add(am.getAction(ZoomToFitAction.KEY));
    this.add(am.getAction(ZoomInAction.KEY));
    this.add(am.getAction(ZoomOutAction.KEY));
    this.add(new Separator());
    this.add(am.getAction(TableOfContentsAction.KEY));
    this.add(am.getAction(PreviousPageAction.KEY));
    this.add(am.getAction(NextPageAction.KEY));
    this.add(am.getAction(BackAction.KEY));
    this.add(am.getAction(ForwardAction.KEY));

    this.hideItems(new String[]{
        ShowInspectorAction.KEY,
        ShowPreviewAction.KEY,
        ShowAllAction.KEY,
        ActualSizeAction.KEY,
        ActualSizeAction.KEY,
        ZoomToFitAction.KEY,
        ZoomInAction.KEY,
        ZoomOutAction.KEY,
        TableOfContentsAction.KEY,
        PreviousPageAction.KEY,
        NextPageAction.KEY,
        BackAction.KEY,
        ForwardAction.KEY,
    });
    this.disableItems(new String[] {
        AsDocumentAction.KEY,
        AsWebpageAction.KEY,
        PreviousDocumentAction.KEY,
        NextDocumentAction.KEY,
        ReadFullScreenAction.KEY,
    });
    this.update(true);
  }
}
