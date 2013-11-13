/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action;

import javax.annotation.Nullable;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.widget.DropDownAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;
import cn.edu.nju.starfish.ilibrary.utils.SWTUtils;

/**
 * The base class for drop down actions.
 *
 * @author Haixing Hu
 */
public class BaseDropDownAction extends DropDownAction {

  protected final Application application;

  /**
   * Constructs an action.
   *
   * @param id
   *          the id of the new action.
   * @param application
   *          the application the new action belongs to.
   * @param actionManager
   *          the action manager, which is a map from the action's ID to the action.
   * @param subActionIds
   *          the IDs of the sub-actions in the drop-down menu of the new
   *          action.
   */
  public BaseDropDownAction(String id, Application application,
      IActionManager actionManager, String[] subActionIds) {
    super(id, actionManager, subActionIds);
    this.application = application;
    //  set the title and icon
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
}
