/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action;

import static cn.edu.nju.starfish.ilibrary.utils.Argument.requireNonNull;

import javax.annotation.Nullable;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.widget.Action;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;
import cn.edu.nju.starfish.ilibrary.utils.SWTUtils;

/**
 * The base class for all actions.
 *
 * @author Haixing Hu
 */
public class BaseAction extends Action {

  protected final Application application;
  protected final IActionManager actionManager;
  protected final Logger logger;

  /**
   * Constructs an action.
   *
   * @param id
   *          the ID of the new action.
   * @param application
   *          the application the new action belongs to.
   * @param actionManager
   *          the action manager, which is a map from the action's ID to the action.
   */
  public BaseAction(String id, Application application, IActionManager actionManager) {
    this(id, application, actionManager, SWT.NONE);
  }

  /**
   * Constructs an action.
   *
   * @param id
   *          the ID of the new action.
   * @param application
   *          the application the new action belongs to.
   * @param actionManager
   *          the action manager, which is a map from the action's ID to the action.
   * @param style
   *          the style of the new action.
   */
  protected BaseAction(String id, Application application,
      IActionManager actionManager, int style) {
    super(id, style);
    this.application = requireNonNull("application", application);
    this.actionManager = requireNonNull("actionManager", actionManager);
    this.logger = LoggerFactory.getLogger(this.getClass());
    this.setId(id);
    final String title = application.getTitle(id);
    final String shortcut = application.getShortcut(id);
    if (shortcut == null) {
      this.setText(title);
    } else {
      this.setText(title + "@" + shortcut);
    }
    final String description = application.getDescription(id);
    if (description != null) {
      this.setToolTipText(description);
    } else {
      this.setToolTipText(title);
    }
    final String icon = application.getIcon(id);
    if (icon != null) {
      final Image img = SWTUtils.getImage(icon);
      final ImageDescriptor imgdes = ImageDescriptor.createFromImage(img);
      this.setImageDescriptor(imgdes);
    }
  }

  /**
   * Gets the application this action belongs to.
   *
   * @return the application this action belongs to.
   */
  public Application getApplication() {
    return application;
  }

  /**
   * Sets the image of this action.
   *
   * @param path
   *    the resource path of the image to be set, which could be null.
   */
  public void setImage(@Nullable String path) {
    if (path == null) {
      this.setImageDescriptor(null);
    } else {
      final Image img = SWTUtils.getImage(path);
      if (img != null) {
        final ImageDescriptor imgdes = ImageDescriptor.createFromImage(img);
        this.setImageDescriptor(imgdes);
      }
    }
  }

  @Override
  public void run() {
    //  default implementation is to display an error message.
    application.displayUnimplementedError(this.getId());
  }

  @Override
  public void runWithEvent(Event event) {
    run();
  }
}
