/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.main;

import org.apache.commons.configuration.Configuration;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.wb.swt.SWTResourceManager;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.ActionManager;
import cn.edu.nju.starfish.ilibrary.action.view.AttachmentFilterAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.AttachmentFilterHasFileAction;
import cn.edu.nju.starfish.ilibrary.action.view.AttachmentFilterNoFileAction;
import cn.edu.nju.starfish.ilibrary.action.view.FlagFilterAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.FlagFilterFlaggedAction;
import cn.edu.nju.starfish.ilibrary.action.view.FlagFilterUnflaggedAction;
import cn.edu.nju.starfish.ilibrary.action.view.ReadFilterAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.ReadFilterHasReadAction;
import cn.edu.nju.starfish.ilibrary.action.view.ReadFilterReadingAction;
import cn.edu.nju.starfish.ilibrary.action.view.ReadFilterUnreadAction;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterArticleAction;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterBookAction;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterMediaAction;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterPatentAction;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterReportAction;

/**
 * The tool bar used to filter the documents.
 *
 * @author Haixing Hu
 */
public final class LibraryTabHeader extends Composite {

  public static final String KEY = "header";

  private final Application application;
  private final int height;
  private final int marginWidth;
  private final String background;
  private ToolBarManager toolBarManager;

  public LibraryTabHeader(Application application, Composite parent) {
    super(parent, SWT.FLAT);
    this.application = application;
    final Configuration config = application.getConfig();
    height = config.getInt(KEY + ".height");
    marginWidth = config.getInt(KEY + ".margin-width");
    background = config.getString(KEY + ".background");
    configLayoutData();
    createContents();
  }

  private void configLayoutData() {
    final FormData layoutData = new FormData();
    layoutData.left = new FormAttachment(0);
    layoutData.top = new FormAttachment(0);
    layoutData.right = new FormAttachment(100);
    layoutData.bottom = new FormAttachment(0, height);
    setLayoutData(layoutData);
  }

  private void createContents() {

    final GridLayout layout = new GridLayout(1, true);
    layout.horizontalSpacing = 0;
    layout.verticalSpacing = 0;
    layout.marginLeft = 0;
    layout.marginTop = 0;
    layout.marginRight = 0;
    layout.marginBottom = 0;
    layout.marginHeight = 0;
    layout.marginWidth = marginWidth;
    this.setLayout(layout);
    final Image image = SWTResourceManager.getImage(LibraryTabHeader.class, background);
    this.setBackgroundImage(image);

    toolBarManager = new ToolBarManager(SWT.FLAT);
    final ActionManager am = application.getActionManager();
    toolBarManager.add(am.getAction(FlagFilterAllAction.KEY));
    toolBarManager.add(am.getAction(FlagFilterFlaggedAction.KEY));
    toolBarManager.add(am.getAction(FlagFilterUnflaggedAction.KEY));
    toolBarManager.add(new Separator());
    toolBarManager.add(am.getAction(ReadFilterAllAction.KEY));
    toolBarManager.add(am.getAction(ReadFilterUnreadAction.KEY));
    toolBarManager.add(am.getAction(ReadFilterReadingAction.KEY));
    toolBarManager.add(am.getAction(ReadFilterHasReadAction.KEY));
    toolBarManager.add(new Separator());
    toolBarManager.add(am.getAction(TypeFilterAllAction.KEY));
    toolBarManager.add(am.getAction(TypeFilterArticleAction.KEY));
    toolBarManager.add(am.getAction(TypeFilterBookAction.KEY));
    toolBarManager.add(am.getAction(TypeFilterReportAction.KEY));
    toolBarManager.add(am.getAction(TypeFilterPatentAction.KEY));
    toolBarManager.add(am.getAction(TypeFilterMediaAction.KEY));
    toolBarManager.add(new Separator());
    toolBarManager.add(am.getAction(AttachmentFilterAllAction.KEY));
    toolBarManager.add(am.getAction(AttachmentFilterHasFileAction.KEY));
    toolBarManager.add(am.getAction(AttachmentFilterNoFileAction.KEY));
    toolBarManager.createControl(this);
    final ToolBar toolBar = toolBarManager.getControl();

    final GridData gd_toolBar = new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1);
    toolBar.setLayoutData(gd_toolBar);

    //  in order to be compatible on multi-platforms, we must set the
    //  background image on both this composite and the tool bar.
    toolBar.setBackgroundImage(image);
  }

  public int getHeight() {
    return height;
  }
}
