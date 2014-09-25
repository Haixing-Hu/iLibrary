/******************************************************************************
 *
 * Copyright (c) 2014  Haixing Hu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package com.github.haixing_hu.ilibrary.action;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.swt.action.ActionEx;
import com.github.haixing_hu.swt.action.IActionManager;
import com.github.haixing_hu.swt.utils.SWTResourceManager;

import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * The base class for all actions.
 *
 * @author Haixing Hu
 */
public class BaseAction extends ActionEx {

  protected final Application application;
  protected final IActionManager actionManager;
  protected final Logger logger;
  protected final String title;
  protected final String shortcut;
  protected final ImageDescriptor icon;
  protected final ImageDescriptor activeIcon;

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
    final AppConfig config = application.getConfig();
    title = config.getTitle(id);
    shortcut = config.getShortcut(id);
    if (shortcut == null) {
      this.setText(title);
    } else {
      this.setText(title + "@" + shortcut);
    }
    final String description = config.getDescription(id);
    if (description != null) {
      this.setDescription(description);
      this.setToolTipText(description);
    } else {
      this.setToolTipText(title);
    }
    final String iconPath = config.getIcon(id);
    if (iconPath != null) {
      final Image img = SWTResourceManager.getImage(this.getClass(), iconPath);
      icon = ImageDescriptor.createFromImage(img);
      this.setImageDescriptor(icon);
    } else {
      icon = null;
    }
    final String activeIconPath = config.getActiveIcon(id);
    if (activeIconPath != null) {
      final Image img = SWTResourceManager.getImage(this.getClass(), activeIconPath);
      activeIcon = ImageDescriptor.createFromImage(img);
      //this.setHoverImageDescriptor(activeIcon);
    } else {
      activeIcon = null;
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
   * Gets the title.
   *
   * @return the title.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Gets the shortcut.
   *
   * @return the shortcut.
   */
  public String getShortcut() {
    return shortcut;
  }

  /**
   * Gets the icon.
   *
   * @return the icon.
   */
  public ImageDescriptor getIcon() {
    return icon;
  }

  /**
   * Gets the active icon.
   *
   * @return the active icon.
   */
  public ImageDescriptor getActiveIcon() {
    return activeIcon;
  }

  @Override
  public void setChecked(boolean checked) {
    super.setChecked(checked);
    if (checked) {
      if (activeIcon != null) {
        this.setImageDescriptor(activeIcon);
      }
    } else {
      if (icon != null) {
        this.setImageDescriptor(icon);
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
