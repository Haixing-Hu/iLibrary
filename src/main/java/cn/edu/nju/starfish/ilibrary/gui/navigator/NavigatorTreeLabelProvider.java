/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.navigator;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.KeySuffix;
import cn.edu.nju.starfish.ilibrary.utils.SWTUtils;

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
    LOGGER.debug("The image for navigator tree node {} is set to: {}", key, icon);
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
    String title = application.getTitle(key);
    if (getNodeIcon(node) == null) {
      title = fixNoIconNodeTitle(title);
    }
    LOGGER.debug("The text for navigator tree node {} is set to: '{}'", key, title);
    return title;
  }

  private String getNodeIcon(NavigatorTreeNode node) {
    final String key = node.getKey();
    final String icon = application.getIcon(key);
    if (icon != null) {
      return icon;
    }
    if (isCollectionNode(node)) {
      final String suffix = (node.isSmart() ? KeySuffix.SMART_COLLECTION : KeySuffix.COLLECTION);
      final String col_key = NavigatorTreeNode.KEY + suffix;
      return application.getIcon(col_key);
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
    final Configuration config = application.getConfig();
    final int prefix_count = config.getInt(prefix_key);
    return StringUtils.leftPad(title, title.length() + prefix_count);
  }
}
