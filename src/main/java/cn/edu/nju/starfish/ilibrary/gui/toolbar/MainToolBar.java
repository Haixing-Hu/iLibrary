/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.toolbar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.file.PrintAction;
import cn.edu.nju.starfish.ilibrary.action.library.AddReviewAction;
import cn.edu.nju.starfish.ilibrary.action.library.OpenFileAction;
import cn.edu.nju.starfish.ilibrary.action.library.OpenUrlAction;
import cn.edu.nju.starfish.ilibrary.action.library.ShowKeywordsAction;
import cn.edu.nju.starfish.ilibrary.action.library.ShowNotesAction;
import cn.edu.nju.starfish.ilibrary.action.share.EmailAction;
import cn.edu.nju.starfish.ilibrary.action.view.ReadFullScreenAction;
import cn.edu.nju.starfish.ilibrary.action.view.ViewModeAction;

/**
 * The library tool bar.
 *
 * @author Haixing Hu
 */
public final class MainToolBar {

  private final Application application;
  private final ToolBar toolBar;

  public MainToolBar(Application application, Composite parent) {
    this.application = application;
    this.toolBar = new ToolBar(parent, SWT.FLAT);
    createContents();
    configLayoutData();
  }

  /**
   * Configures the layout data of this tool bar.
   */
  private void configLayoutData() {
    final GridData layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
    toolBar.setLayoutData(layoutData);
  }

  /**
   * Creates the contents of this tool bar.
   */
  private void createContents() {
    new MainToolItem(application, toolBar, ReadFullScreenAction.KEY);
    new MainToolItem(application, toolBar, OpenFileAction.KEY);
    new MainToolItem(application, toolBar, OpenUrlAction.KEY);
    new MainToolItem(application, toolBar, EmailAction.KEY);
    new MainToolItem(application, toolBar, PrintAction.KEY);
    new ToolItem(toolBar, SWT.SEPARATOR);
    new MainToolItem(application, toolBar, ShowKeywordsAction.KEY);
    new MainToolItem(application, toolBar, ShowNotesAction.KEY);
    new MainToolItem(application, toolBar, AddReviewAction.KEY);
    new ToolItem(toolBar, SWT.SEPARATOR);
    new MainToolItem(application, toolBar, ViewModeAction.KEY);
  }


  public ToolBar getControl() {
    return toolBar;
  }
}
