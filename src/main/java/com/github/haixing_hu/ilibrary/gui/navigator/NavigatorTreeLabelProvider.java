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

package com.github.haixing_hu.ilibrary.gui.navigator;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.ApplicationConfig;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.utils.SWTUtils;

/**
 * The label provider of the navigator tree viewer.
 *
 * @author Haixing Hu
 */
public final class NavigatorTreeLabelProvider extends LabelProvider {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(NavigatorTreeLabelProvider.class);

  private final Application application;

  public NavigatorTreeLabelProvider(Application application) {
    this.application = application;
  }

  @Override
  public Image getImage(Object element) {
    final NavigatorTreeNode node = (NavigatorTreeNode) element;
    final String key = node.getKey();
    LOGGER.debug("Getting the image for navigator tree node: {}", key);
    final String icon = getNodeIcon(node);
    LOGGER.debug("The image for navigator tree node '{}' is set to: {}", key, icon);
    if (icon == null) {
      return null;
    } else {
      return SWTUtils.getImage(icon);
    }
  }

  @Override
  public String getText(Object element) {
    final NavigatorTreeNode node = (NavigatorTreeNode) element;
    final String key = node.getKey();
    LOGGER.debug("Getting the text for navigator tree node: {}", key);
    final ApplicationConfig config = ApplicationConfig.getInstance();
    String title = config.getTitle(key);
    if (getNodeIcon(node) == null) {
      title = fixNoIconNodeTitle(title);
    }
    LOGGER.debug("The text for navigator tree node '{}' is set to: '{}'", key, title);
    return title;
  }

  private String getNodeIcon(NavigatorTreeNode node) {
    final String key = node.getKey();
    final ApplicationConfig config = ApplicationConfig.getInstance();
    final String icon = config.getIcon(key);
    if (icon != null) {
      return icon;
    }
    if (isCollectionNode(node)) {
      final String suffix = (node.isSmart() ? KeySuffix.SMART_COLLECTION : KeySuffix.COLLECTION);
      final String col_key = NavigatorTreeNode.KEY + suffix;
      return config.getIcon(col_key);
    } else {  //  otherwise
      return null;
    }
  }

  private boolean isCollectionNode(NavigatorTreeNode node) {
    final NavigatorTreeNode parent = node.getParent();
    if (parent == null) {
      return false;
    } else {
      return parent.getKey().equals(NavigatorTreeNode.COLLECTIONS_KEY);
    }
  }

  private String fixNoIconNodeTitle(String title) {
    // add some space at the front if there is no icon for this node
    final String prefix_key = NavigatorTreeNode.KEY + ".no-icon-prefix";
    final ApplicationConfig config = ApplicationConfig.getInstance();
    final int prefix_count = config.getInt(prefix_key);
    return StringUtils.leftPad(title, title.length() + prefix_count);
  }
}
