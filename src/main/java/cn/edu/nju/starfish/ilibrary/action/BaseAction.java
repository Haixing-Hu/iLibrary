/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action;

import org.eclipse.jface.action.Action;

import cn.edu.nju.starfish.ilibrary.Application;

/**
 * The base class for all actions.
 *
 * @author Haixing Hu
 */
public abstract class BaseAction extends Action {

  protected Application application;

  /**
   * Constructs an application.
   *
   * @param application
   *          the application this action belongs to.
   * @param key
   *          the key of this action, which will be used as the ID of the
   *          new action.
   */
  public BaseAction(Application application, String key) {
    super();
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
    }
//    final String icon = application.getIcon(key);
//    if (icon != null) {
//      try {
//        final ImageDescriptor img = ImageDescriptor.createFromFile(BaseAction.class, icon);
//        this.setImageDescriptor(img);
//      } catch (final Exception e) {
//        application.getLogger().error("Failed to load the action icon.");
//        e.printStackTrace();
//      }
//    }
  }

  /**
   * Gets the application this action belongs to.
   *
   * @return the application this action belongs to.
   */
  public Application getApplication() {
    return application;
  }

  @Override
  public void run() {
    //  default implementation is to display an error message.
    application.displayUnimplementedError(this.getId());
  }
}
