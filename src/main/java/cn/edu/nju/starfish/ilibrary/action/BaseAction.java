/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action;

import java.net.URL;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

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
   */
  public BaseAction(Application application) {
    super();
    this.application = application;
    String key = this.getKey(); 
    String title = application.getTitle(key);
    String shortcut = application.getShortcut(key);
    if (shortcut == null) {
      this.setText(title);
    } else {
      this.setText(title + "@" + shortcut);
    }
    String description = application.getDescription(key);
    if (description != null) {
      this.setToolTipText(description);
    }
    String icon = application.getIcon(key);
    if (icon != null) {
      try {
        ImageDescriptor img = ImageDescriptor.createFromURL(new URL(icon));
        this.setImageDescriptor(img);
      } catch (Exception e) {
        application.getLogger().error("Failed to load the action icon.");
        e.printStackTrace();
      }
    }   
  }
  
  /**
   * Gets the key of this action.
   * 
   * @return the key of this action.
   */
  public abstract String getKey();
    
  /**
   * Gets the application this action belongs to.
   * 
   * @return the application this action belongs to.
   */
  public Application getApplication() {
    return application;
  }
}
