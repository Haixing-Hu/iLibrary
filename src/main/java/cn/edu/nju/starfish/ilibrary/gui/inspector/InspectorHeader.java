/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.inspector;

import org.apache.commons.configuration.Configuration;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.wb.swt.SWTResourceManager;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.KeySuffix;
import cn.edu.nju.starfish.ilibrary.action.ActionManager;
import cn.edu.nju.starfish.ilibrary.action.ui.SwitchToFilesTabAction;
import cn.edu.nju.starfish.ilibrary.action.ui.SwitchToInfoTabAction;
import cn.edu.nju.starfish.ilibrary.action.ui.SwitchToNotesTabAction;
import cn.edu.nju.starfish.ilibrary.action.ui.SwitchToReviewsTabAction;

/**
 * The header of the inspector tab folder.
 *
 * @author Haixing Hu
 */
public final class InspectorHeader extends Composite {

  public static final String KEY = "header";

  private final Application application;
  private ToolBarManager toolBarManager;
  private final int height;
  private final int marginWidth;
  private final String backgroundImage;

  public InspectorHeader(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
    final Configuration config = application.getConfig();
    height = config.getInt(KEY + KeySuffix.HEIGHT);
    marginWidth = config.getInt(KEY + KeySuffix.MARGIN_WIDTH);
    backgroundImage = config.getString(KEY + KeySuffix.BACKGROUND_IMAGE);
    createContents();
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

    final Image bg_img = SWTResourceManager.getImage(InspectorHeader.class, backgroundImage);
    this.setBackgroundImage(bg_img);

    toolBarManager = new ToolBarManager(SWT.FLAT);
    final ActionManager am = application.getActionManager();
    toolBarManager.add(am.get(SwitchToInfoTabAction.KEY));
    toolBarManager.add(am.get(SwitchToNotesTabAction.KEY));
    toolBarManager.add(am.get(SwitchToReviewsTabAction.KEY));
    toolBarManager.add(am.get(SwitchToFilesTabAction.KEY));
    toolBarManager.createControl(this);
    final ToolBar toolBar = toolBarManager.getControl();

    final GridData gd_toolBar = new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1);
    toolBar.setLayoutData(gd_toolBar);

    //  in order to be compatible on multi-platforms, we must set the
    //  background image on both this composite and the tool bar.
    toolBar.setBackgroundImage(bg_img);
  }

  /**
   * Gets the application.
   *
   * @return the application.
   */
  public Application getApplication() {
    return application;
  }

  /**
   * Gets the tool bar manager.
   *
   * @return the tool bar manager.
   */
  public ToolBarManager getToolBarManager() {
    return toolBarManager;
  }

  /**
   * Gets the height.
   *
   * @return the height.
   */
  public int getHeight() {
    return height;
  }

}
