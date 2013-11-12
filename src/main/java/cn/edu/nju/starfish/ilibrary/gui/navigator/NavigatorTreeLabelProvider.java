/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.navigator;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.utils.SWTUtils;

/**
 * The label provider of the navigator tree viewer.
 *
 * @author Haixing Hu
 */
public class NavigatorTreeLabelProvider extends LabelProvider {

  private final Application application;

  public NavigatorTreeLabelProvider(Application application) {
    this.application = application;
  }

  @Override
  public Image getImage(Object element) {
    final NavigatorTreeNode node = (NavigatorTreeNode) element;
    final String key = node.getKey();
    final String icon = application.getIcon(key);
    if (icon == null) {
      return null;
    } else {
      return SWTUtils.loadImage(icon);
    }
  }

  @Override
  public String getText(Object element) {
    final NavigatorTreeNode node = (NavigatorTreeNode) element;
    final String key = node.getKey();
    return application.getTitle(key);
  }
}
