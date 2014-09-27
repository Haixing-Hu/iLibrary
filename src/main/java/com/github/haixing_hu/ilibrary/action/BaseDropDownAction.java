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

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.swt.action.DropDownAction;
import com.github.haixing_hu.swt.action.IActionManager;
import com.github.haixing_hu.swt.utils.SWTResourceManager;

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
    final AppConfig config = application.getConfig();
    final String title = config.getTitle(id);
    final String shortcut = config.getShortcut(id);
    if (shortcut == null) {
      setText(title);
    } else {
      setText(title + "@" + shortcut);
    }
    final String description = config.getDescription(id);
    if (description != null) {
      setToolTipText(description);
    } else {
      setToolTipText(title);
    }
    final String icon = config.getIcon(id);
    if (icon != null) {
      final Image img = SWTResourceManager.getImage(this.getClass(), icon);
      final ImageDescriptor imgdes = ImageDescriptor.createFromImage(img);
      setImageDescriptor(imgdes);
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
   * Sets the image of this action.
   *
   * @param path
   *    the resource path of the image to be set, which could be null.
   */
  public void setImage(@Nullable String path) {
    if (path == null) {
      setImageDescriptor(null);
    } else {
      final Image img = SWTResourceManager.getImage(this.getClass(), path);
      if (img != null) {
        final ImageDescriptor imgdes = ImageDescriptor.createFromImage(img);
        setImageDescriptor(imgdes);
      }
    }
  }
}
