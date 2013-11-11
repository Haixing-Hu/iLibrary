/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.statusline;

import org.apache.commons.configuration.Configuration;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.wb.swt.SWTResourceManager;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.ActionManager;
import cn.edu.nju.starfish.ilibrary.action.library.EditInformationAction;
import cn.edu.nju.starfish.ilibrary.gui.panel.InspectorPanel;

/**
 * The status line in the inspector panel.
 *
 * @author Haixing Hu
 */
public class InspectorStatusLine extends Composite {

  public static final String KEY = InspectorPanel.KEY + ".statusline";

  private final Application application;
  private Composite corner;
  private Composite fill;
  private ToolBarManager toolBarManager;
  private final int height;

  /**
   * Creates a status line.
   *
   * @param application
   *    the application.
   * @param parent
   *    the parent of the new status line.
   * @param style
   *    the style of the new status line.
   */
  public InspectorStatusLine(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
    final Configuration config = application.getConfig();
    height = config.getInt(KEY + ".height");
    createContents();
  }

  private void createContents() {
    final Configuration config = application.getConfig();
    final FormLayout layout = new FormLayout();
    layout.spacing = 0;
    layout.marginTop = 0;
    layout.marginBottom = 0;
    layout.marginLeft = 0;
    layout.marginRight = 0;
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    layout.spacing = 0;
    this.setLayout(layout);

    final String statuslineBg = config.getString(KEY + ".background");
    final Image statuslineBgImg = SWTResourceManager.getImage(NavigatorStatusLine.class, statuslineBg);
    this.setBackgroundImage(statuslineBgImg);

    final ActionManager am = application.getActionManager();
    toolBarManager = new ToolBarManager(SWT.FLAT);
    toolBarManager.add(am.getAction(EditInformationAction.KEY));
    toolBarManager.createControl(this);
    final ToolBar toolBar = toolBarManager.getControl();

    final String toolbarBg = config.getString(KEY + ".toolbar.background");
    final Image toolbarBgImg = SWTResourceManager.getImage(NavigatorStatusLine.class, toolbarBg);
    toolBar.setBackgroundImage(toolbarBgImg);

    fill = new Composite(this, SWT.NONE);
    fill.setBackgroundImage(statuslineBgImg);

    corner = new Composite(this, SWT.NONE);
    final String cornerBackground = config.getString(KEY + ".corner.background");
    final Image cornerBackgroundImg = SWTResourceManager.getImage(InspectorStatusLine.class, cornerBackground);
    corner.setBackgroundImage(cornerBackgroundImg);

    final int cornerWidth = config.getInt(KEY + ".corner.width");
    final FormData fd_corner = new FormData();
    fd_corner.left = new FormAttachment(0);
    fd_corner.right = new FormAttachment(0, cornerWidth);
    fd_corner.top = new FormAttachment(0);
    fd_corner.bottom = new FormAttachment(100);
    corner.setLayoutData(fd_corner);

    final FormData fd_fill = new FormData();
    fd_fill.left = new FormAttachment(corner);
    fd_fill.right = new FormAttachment(toolBar);
    fd_fill.top = new FormAttachment(0);
    fd_fill.bottom = new FormAttachment(100);
    fill.setLayoutData(fd_fill);

    final int toolbarTop = config.getInt(KEY + ".toolbar.top");
    final FormData fd_toolBar = new FormData();
    //fd_toolBar.left = new FormAttachment(corner);
    fd_toolBar.right = new FormAttachment(100);
    fd_toolBar.top = new FormAttachment(0, toolbarTop);
    toolBar.setLayoutData(fd_toolBar);
  }


  /**
   * Gets the height of this status line.
   *
   * @return the height of this status line.
   */
  public int getHeight() {
    return height;
  }
}
