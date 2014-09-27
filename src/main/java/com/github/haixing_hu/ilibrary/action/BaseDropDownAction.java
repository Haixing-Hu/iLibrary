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

import javax.annotation.Nullable;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.MessageKey;
import com.github.haixing_hu.swt.action.DropDownAction;
import com.github.haixing_hu.swt.action.IActionManager;
import com.github.haixing_hu.swt.utils.SWTResourceManager;

import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * The base class for drop down actions.
 *
 * @author Haixing Hu
 */
public class BaseDropDownAction extends DropDownAction {

  protected final Application application;
  protected final IActionManager actionManager;
  protected final Logger logger;
  protected final String title;
  protected final String shortcut;
  protected ImageDescriptor icon;
  protected ImageDescriptor activeIcon;

  /**
   * Constructs an action.
   *
   * @param id
   *          the id of the new action.
   * @param application
   *          the application the new action belongs to.
   * @param actionManager
   *          the action manager, which is a map from the action's ID to the
   *          action.
   * @param subActionIds
   *          the IDs of the sub-actions in the drop-down menu of the new
   *          action.
   */
  public BaseDropDownAction(String id, Application application,
      IActionManager actionManager, String[] subActionIds) {
    this(id, null, application, actionManager, subActionIds);
  }

  /**
   * Constructs an action.
   *
   * @param id
   *          the id of the new action.
   * @param title
   *          the title of the new action. If this value is null, the title will
   *          be get from the resource bundles.
   * @param application
   *          the application the new action belongs to.
   * @param actionManager
   *          the action manager, which is a map from the action's ID to the
   *          action.
   * @param subActionIds
   *          the IDs of the sub-actions in the drop-down menu of the new
   *          action.
   */
  public BaseDropDownAction(String id, @Nullable String title,
      Application application, IActionManager actionManager,
      String[] subActionIds) {
    super(id, actionManager, subActionIds);
    this.application = requireNonNull("application", application);
    this.actionManager = requireNonNull("actionManager", actionManager);
    logger = LoggerFactory.getLogger(this.getClass());
    setId(id);
    final AppConfig config = application.getConfig();
    if (title == null) {
      title = config.getTitle(id);
    }
    if (StringUtils.isEmpty(title)) {
      logger.error("Cannot get the title for action: {}", id);
      title = config.getMessage(MessageKey.ERROR_NO_TITLE);
    }
    this.title = title;
    shortcut = config.getShortcut(id);
    if (shortcut == null) {
      setText(title);
    } else {
      setText(title + "@" + shortcut);
    }
    final String description = config.getDescription(id);
    if (description != null) {
      setDescription(description);
      setToolTipText(description);
    } else {
      setToolTipText(title);
    }
    final String iconPath = config.getIcon(id);
    if (iconPath != null) {
      final Image img = SWTResourceManager.getImage(this.getClass(), iconPath);
      icon = ImageDescriptor.createFromImage(img);
      setImageDescriptor(icon);
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
    setShowImage(false);
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
   * Sets the icon.
   *
   * @param icon the icon.
   */
  public void setIcon(ImageDescriptor icon) {
    this.icon = icon;
  }

  /**
   * Gets the active icon.
   *
   * @return the active icon.
   */
  public ImageDescriptor getActiveIcon() {
    return activeIcon;
  }

  /**
   * Sets the active icon.
   *
   * @param icon the active icon.
   */
  public void setActiveIcon(ImageDescriptor activeIcon) {
    this.activeIcon = activeIcon;
  }

  @Override
  public void setChecked(boolean checked) {
    super.setChecked(checked);
    if (checked) {
      if (activeIcon != null) {
        setImageDescriptor(activeIcon);
      }
    } else {
      if (icon != null) {
        setImageDescriptor(icon);
      }
    }
  }
}
