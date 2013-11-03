/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.menu;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;

import cn.edu.nju.starfish.ilibrary.Application;
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
import cn.edu.nju.starfish.ilibrary.action.view.ZoomInAction;
import cn.edu.nju.starfish.ilibrary.action.view.ZoomOutAction;
import cn.edu.nju.starfish.ilibrary.action.view.ZoomToFitAction;

/**
 * The view menu.
 *
 * @author Haixing Hu
 */
public final class ViewMenu extends MenuManager {

  public static final String KEY = "menu.view";

  private final Application application;

  /**
   * Creates a view menu.
   *
   * @param application
   *          the application this new menu belongs to.
   */
  public ViewMenu(Application application) {
    super(application.getTitle(KEY));
    this.application = application;
    this.add(new AsCoverFlowAction(application));
    this.add(new AsPreviewAction(application));
    this.add(new AsThumbnailsAction(application));
    this.add(new Separator());
    this.add(new AsDocumentAction(application));
    this.add(new AsWebpageAction(application));
    this.add(new Separator());
    this.add(new ColumnsAction(application));
    this.add(new SortByAction(application));
    this.add(new Separator());
    this.add(new HidePreviewAction(application));
    this.add(new ShowPreviewAction(application));
    this.add(new HideInspectorAction(application));
    this.add(new ShowInspectorAction(application));
    this.add(new Separator());
    this.add(new PreviousDocumentAction(application));
    this.add(new NextDocumentAction(application));
    this.add(new Separator());
    this.add(new ShowDuplicatesAction(application));
    this.add(new ShowAllAction(application));
    this.add(new Separator());
    this.add(new ReadFullScreenAction(application));
    this.add(new ActualSizeAction(application));
    this.add(new ZoomToFitAction(application));
    this.add(new ZoomInAction(application));
    this.add(new ZoomOutAction(application));
    this.add(new Separator());
    this.add(new TableOfContentsAction(application));
    this.add(new PreviousPageAction(application));
    this.add(new NextPageAction(application));
    this.add(new BackAction(application));
    this.add(new ForwardAction(application));
  }

  /**
   * Gets the application this menu belongs to.
   *
   * @return the application this menu belongs to.
   */
  public Application getApplication() {
    return application;
  }

}
