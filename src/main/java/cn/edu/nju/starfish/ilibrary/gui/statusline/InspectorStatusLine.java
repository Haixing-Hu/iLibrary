/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.statusline;

import org.apache.commons.configuration.Configuration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.wb.swt.SWTResourceManager;

import cn.edu.nju.starfish.ilibrary.Application;

/**
 * The status line in the inspector panel.
 *
 * @author Haixing Hu
 */
public class InspectorStatusLine extends Composite {

  public static final String KEY = "gui.statusline";

  private final Application application;
  private Composite corner;
  private ToolBar toolBar;
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

    corner = new Composite(this, SWT.NONE);
    toolBar = new ToolBar(this, SWT.FLAT);

    final String toolBarBackground = config.getString(KEY + ".background");
    final Image toolBarBackgroundImg = SWTResourceManager.getImage(InspectorStatusLine.class, toolBarBackground);
    //  in order to be compatible on multi-platforms, we must set the
    //  background image on both the composite and the tool bar.
    this.setBackgroundImage(toolBarBackgroundImg);
    toolBar.setBackgroundImage(toolBarBackgroundImg);

    final String cornerBackground = config.getString(KEY + ".corner.background");
    final Image cornerBackgroundImg = SWTResourceManager.getImage(InspectorStatusLine.class, cornerBackground);
    corner.setBackgroundImage(cornerBackgroundImg);

    final int cornerWidth = config.getInt(KEY + ".corner.width");
    final FormData fd_corner = new FormData();
    fd_corner.left = new FormAttachment(0);
    fd_corner.top = new FormAttachment(0);
    fd_corner.right = new FormAttachment(0, cornerWidth);
    fd_corner.bottom = new FormAttachment(100);
    corner.setLayoutData(fd_corner);

    final FormData fd_toolBar = new FormData();
    fd_toolBar.left = new FormAttachment(corner);
    fd_toolBar.top = new FormAttachment(0);
    fd_toolBar.right = new FormAttachment(100);
    fd_toolBar.bottom = new FormAttachment(100);
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
