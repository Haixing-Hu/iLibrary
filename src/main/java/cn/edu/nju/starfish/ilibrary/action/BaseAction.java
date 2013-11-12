/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action;

import javax.annotation.Nullable;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.wb.swt.SWTResourceManager;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.utils.SWTUtils;

/**
 * The base class for all actions.
 *
 * @author Haixing Hu
 */
public class BaseAction extends Action {

  protected Application application;

  /**
   * Constructs an action.
   *
   * @param application
   *          the application the new action belongs to.
   * @param key
   *          the key of the new action, which will be used as the ID of the
   *          new action.
   */
  public BaseAction(Application application, String key) {
    this(application, key, SWT.NONE);
  }

  /**
   * Constructs an action.
   *
   * @param application
   *          the application the new action belongs to.
   * @param key
   *          the key of the new action, which will be used as the ID of the
   *          new action.
   * @param style
   *          the style of the new action.
   */
  protected BaseAction(Application application, String key, int style) {
    super("", style);
    this.application = application;
    this.setId(key);
    final String title = application.getTitle(key);
    final String shortcut = application.getShortcut(key);
    if (shortcut == null) {
      this.setText(title);
    } else {
      this.setText(title + "@" + shortcut);
    }
    final String description = application.getDescription(key);
    if (description != null) {
      this.setToolTipText(description);
    } else {
      this.setToolTipText(title);
    }
    final String icon = application.getIcon(key);
    if (icon != null) {
      final Image img = SWTUtils.loadImage(icon);
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
   * @param imagePath
   *    the resource path of the image to be set, which could be null.
   */
  public void setImage(@Nullable String imagePath) {
    if (imagePath == null) {
      this.setImageDescriptor(null);
    } else {
      try {
        final Image img = SWTResourceManager.getImage(BaseAction.class, imagePath);
        final ImageDescriptor imgdes = ImageDescriptor.createFromImage(img);
        this.setImageDescriptor(imgdes);
      } catch (final Exception e) {
        application.getLogger().error("Failed to load the action image: {}", imagePath);
        e.printStackTrace();
      }
    }
  }

  @Override
  public void run() {
    //  default implementation is to display an error message.
    application.displayUnimplementedError(this.getId());
  }
}
