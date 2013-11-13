/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.navigator;

import org.apache.commons.configuration.Configuration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.KeySuffix;
import cn.edu.nju.starfish.ilibrary.gui.MainWindow;
import cn.edu.nju.starfish.ilibrary.utils.SWTUtils;

/**
 * The panel display the navigation tree.
 *
 * @author Haixing Hu
 */
public final class NavigatorPanel extends Composite {

  public static final String KEY = MainWindow.KEY + ".navigator";

  private final Application application;
  private final int defaultWidth;
  private final int minWidth;
  private final int maxWidth;
  private final int marginTop;
  private final String backgroundColor;
  private NavigatorTree navigatorTree;
  private NavigatorFooter footer;

  /**
   * Constructs a {@link NavigatorPanel}.
   *
   * @param application
   *          the application the new panel belongs.
   * @param parent
   *          the parent of the new panel.
   */
  public NavigatorPanel(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
    final Configuration config = application.getConfig();
    defaultWidth = config.getInt(KEY + KeySuffix.DEFAULT_WIDTH);
    minWidth = config.getInt(KEY + KeySuffix.MIN_WIDTH);
    maxWidth = config.getInt(KEY + KeySuffix.MAX_WIDTH);
    marginTop = config.getInt(KEY + KeySuffix.MARGIN_TOP);
    backgroundColor = config.getString(KEY + KeySuffix.BACKGROUND_COLOR);
    createContents();
  }


  /**
   * Creates the contents of this panel.
   */
  private void createContents() {
    final FormLayout layout = new FormLayout();
    layout.marginTop = this.marginTop;
    layout.marginBottom = 0;
    layout.marginLeft = 0;
    layout.marginRight = 0;
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    layout.spacing = 0;
    this.setLayout(layout);

    final Color color = SWTUtils.parseRGB(backgroundColor);
    this.setBackground(color);

    navigatorTree = new NavigatorTree(application, this);
    footer = new NavigatorFooter(application, this);

    final FormData fd_navigatorTree = new FormData();
    fd_navigatorTree.left = new FormAttachment(0);
    fd_navigatorTree.top = new FormAttachment(0);
    fd_navigatorTree.right = new FormAttachment(100);
    fd_navigatorTree.bottom = new FormAttachment(footer);
    navigatorTree.getControl().setLayoutData(fd_navigatorTree);

    final FormData fd_statusLine = new FormData();
    fd_statusLine.left = new FormAttachment(0);
    fd_statusLine.top = new FormAttachment(100, - footer.getHeight());
    fd_statusLine.right = new FormAttachment(100);
    fd_statusLine.bottom = new FormAttachment(100);
    footer.setLayoutData(fd_statusLine);
  }

  /**
   * Gets the default width.
   *
   * @return the default width.
   */
  public int getDefaultWidth() {
    return defaultWidth;
  }

  /**
   * Gets the minimum width.
   *
   * @return the minimum width.
   */
  public int getMinWidth() {
    return minWidth;
  }

  /**
   * Gets the maximum width.
   *
   * @return the maximum width.
   */
  public int getMaxWidth() {
    return maxWidth;
  }

  /**
   * Gets the navigator tree.
   *
   * @return the navigator tree.
   */
  public NavigatorTree getNavigatorTree() {
    return navigatorTree;
  }

  /**
   * Gets the footer.
   *
   * @return the footer.
   */
  public NavigatorFooter getFooter() {
    return footer;
  }


}
