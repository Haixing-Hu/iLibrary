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

package com.github.haixing_hu.ilibrary.gui;

import java.awt.Window;

import org.eclipse.jface.util.Geometry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.state.InspectorTab;
import com.github.haixing_hu.ilibrary.state.Page;
import com.github.haixing_hu.lang.SystemUtils;
import com.github.haixing_hu.swt.menu.MenuManagerEx;
import com.github.haixing_hu.swt.window.ApplicationWindowEx;

/**
 * The main window of the application.
 *
 * @author Haixing Hu
 */
public final class MainWindow extends ApplicationWindowEx {

  public static final String ID = "window";

  private final Application application;
  private final int defaultHeight;
  private final int defaultWidth;
  private final int minHeight;
  private final int minWidth;
  private final BasicPage pages[];
  private MainMenuBar menuBar;
  private Label topSeparator;
  private MainWindowHeader header;
  private Composite tabFolder;
  private StackLayout stackLayout;

  public MainWindow(Application application) {
    super(null);
    this.application = application;
    final AppConfig config = application.getConfig();
    defaultHeight = config.getInt(ID + KeySuffix.DEFAULT_HEIGHT);
    defaultWidth = config.getInt(ID + KeySuffix.DEFAULT_WIDTH);
    minHeight = config.getInt(ID + KeySuffix.MIN_HEIGHT);
    minWidth = config.getInt(ID + KeySuffix.MIN_WIDTH);
    pages = new BasicPage[Page.TOTAL];
    addMenuBar();
  }

  @Override
  protected MenuManagerEx createMenuManager() {
    menuBar = new MainMenuBar(application);
    return menuBar;
  }

  @Override
  protected Layout getLayout() {
    final FormLayout layout = new FormLayout();
    layout.marginTop = 0;
    layout.marginBottom = 0;
    layout.marginLeft = 0;
    layout.marginRight = 0;
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    layout.spacing = 0;
    return layout;
  }

  @Override
  protected Control createContents(Composite parent) {
    final int offset;
    if (SystemUtils.IS_OS_WINDOWS) {
      //  fix a UI bug in Windows
      topSeparator = new Label(parent, SWT.HORIZONTAL | SWT.SEPARATOR);
      topSeparator.pack();
      offset = topSeparator.getSize().y;
      final FormData fd_top = new FormData();
      fd_top.top = new FormAttachment(0);
      fd_top.bottom = new FormAttachment(0, offset);
      fd_top.left = new FormAttachment(0);
      fd_top.right = new FormAttachment(100);
      topSeparator.setLayoutData(fd_top);
    } else {
      topSeparator = null;
      offset = 0;
    }

    header = new MainWindowHeader(application, parent);
    final FormData fd_header = new FormData();
    fd_header.top = new FormAttachment(0);
    fd_header.bottom = new FormAttachment(0, header.getHeight() + offset);
    fd_header.left = new FormAttachment(0);
    fd_header.right = new FormAttachment(100);
    header.setLayoutData(fd_header);

    tabFolder = new Composite(parent, SWT.NONE);
    final FormData fd_tabFolder = new FormData();
    fd_tabFolder.top = new FormAttachment(header);
    fd_tabFolder.bottom = new FormAttachment(100);
    fd_tabFolder.left = new FormAttachment(0);
    fd_tabFolder.right = new FormAttachment(100);
    tabFolder.setLayoutData(fd_tabFolder);

    stackLayout = new StackLayout();
    stackLayout.marginHeight = 0;
    stackLayout.marginWidth = 0;
    tabFolder.setLayout(stackLayout);

    pages[Page.LIBRARY.ordinal()] = new LibraryPage(application, tabFolder);
    pages[Page.SEARCH.ordinal()] = new SearchPage(application, tabFolder);
    pages[Page.TAGS.ordinal()] = new TagsPage(application, tabFolder);
    pages[Page.AUTHORS.ordinal()] = new AuthorsPage(application, tabFolder);
    pages[Page.SOURCES.ordinal()] = new SourcesPage(application, tabFolder);
    pages[Page.READER.ordinal()] = new ReaderPage(application, tabFolder);
    stackLayout.topControl = pages[Page.LIBRARY.ordinal()];
    return parent;
  }

  /**
   * Configure the shell.
   *
   * @param shell the shell to be configured.
   */
  @Override
  protected void configureShell(Shell shell) {
    super.configureShell(shell);
    final AppConfig config = application.getConfig();
    shell.setText(config.getAppName());
    shell.setMinimumSize(minWidth, minHeight);
    //  NOTE: Mac OS X may automatically resize the startup WINDOWS,
    //  therefore, the getInitialSize() will not be called by the
    //  framework. So we call it manually
    final Point initialSize = getInitialSize();
    shell.setSize(initialSize);
    //  and also, we set the initial location manually.
    //  note that we cannot call the Window.getInitialLocation(int),
    //  since it will use the Window.shell, which has not been initialized
    //  while calling this function. So we copy the code and implement
    //  another version by passing the shell as the argument.
    shell.setLocation(getInitialLocation(shell, initialSize));
  }

  /**
   * Returns the initial location to use for the shell. The default
   * implementation centers the shell horizontally (1/2 of the difference to
   * the left and 1/2 to the right) and vertically (1/3 above and 2/3 below)
   * relative to the parent shell, or display bounds if there is no parent
   * shell.
   * <p>
   * <b>NOTE:</b> This function is copied from {@link Window#getInitialLocation},
   * but we pass the shell as the first argument. In this way, the function
   * could be called even if the {@link Window#shell} has not been initialized.
   *
   * @param shell
   *        the shell.
   * @param initialSize
   *            the initial size of the shell, as returned by
   *            <code>getInitialSize</code>.
   * @return the initial location of the shell
   */
  protected Point getInitialLocation(Shell shell, Point initialSize) {
    final Composite parent = shell.getParent();

    Monitor monitor = shell.getDisplay().getPrimaryMonitor();
    if (parent != null) {
      monitor = parent.getMonitor();
    }

    final Rectangle monitorBounds = monitor.getClientArea();
    Point centerPoint;
    if (parent != null) {
      centerPoint = Geometry.centerPoint(parent.getBounds());
    } else {
      centerPoint = Geometry.centerPoint(monitorBounds);
    }

    return new Point(centerPoint.x - (initialSize.x / 2),
        Math.max(monitorBounds.y,
            Math.min(centerPoint.y - ((initialSize.y * 2) / 3),
                (monitorBounds.y + monitorBounds.height) - initialSize.y)));
  }

  /**
   * Return the initial size of the window.
   *
   * @return the initial size of the window.
   */
  @Override
  protected Point getInitialSize() {
    return new Point(defaultWidth, defaultHeight);
  }

  /**
   * Gets the application.
   *
   * @return the application.
   */
  public Application getApplication() {
    return application;
  }

  /**
   * Gets the default height.
   *
   * @return the default height.
   */
  public int getDefaultHeight() {
    return defaultHeight;
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
   * Gets the minimum height.
   *
   * @return the minimum height.
   */
  public int getMinHeight() {
    return minHeight;
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
   * Gets the main menu bar.
   *
   * @return the main menu bar.
   */
  @Override
  public MainMenuBar getMenuBarManager() {
    return menuBar;
  }

  /**
   * Gets the menu bar.
   *
   * @return the menu bar.
   */
  public MainMenuBar getMenuBar() {
    return menuBar;
  }

  /**
   * Gets the search page.
   *
   * @return the search page.
   */
  public SearchPage getSearchPage() {
    return (SearchPage) pages[Page.SEARCH.ordinal()];
  }

  /**
   * Gets the library page.
   *
   * @return the library page.
   */
  public LibraryPage getLibraryPage() {
    return (LibraryPage) pages[Page.LIBRARY.ordinal()];
  }

  /**
   * Gets the tags page.
   *
   * @return the tags page.
   */
  public TagsPage getTagsPage() {
    return (TagsPage) pages[Page.TAGS.ordinal()];
  }

  /**
   * Gets the authors page.
   *
   * @return the authors page.
   */
  public AuthorsPage getAuthorsPage() {
    return (AuthorsPage) pages[Page.AUTHORS.ordinal()];
  }

  /**
   * Gets the sources page.
   *
   * @return the sources page.
   */
  public SourcesPage getSourcesPage() {
    return (SourcesPage) pages[Page.SOURCES.ordinal()];
  }

  /**
   * Gets the reader page.
   *
   * @return the reader page.
   */
  public ReaderPage getReaderPage() {
    return (ReaderPage) pages[Page.READER.ordinal()];
  }

  /**
   * Gets the current page.
   *
   * @return the current page.
   */
  public BasicPage getCurrentPage() {
    return (BasicPage) stackLayout.topControl;
  }

  /**
   * Sets the width of the navigator panels on all pages.
   *
   * @param width
   *          the new width to be set. If it is less than or equal to 0, the
   *          function will hide the navigator panel.
   */
  public void setNavigatorWidth(int width) {
    for (int i = 0; i < Page.TOTAL; ++i) {
      pages[i].setNavigatorWidth(width);
    }
  }

  /**
   * Sets the width of the inspector panels on all pages.
   *
   * @param width
   *          the new width to be set. If it is less than or equal to 0, the
   *          function will hide the inspector panel.
   */
  public void setInspectorWidth(int width) {
    for (int i = 0; i < Page.TOTAL; ++i) {
      pages[i].setInspectorWidth(width);
    }
  }

  /**
   * Sets the height of the preview panels on all pages.
   *
   * @param height
   *          the new height to be set. If it is less than or equal to 0, the
   *          function will hide the preview panel.
   */
  public void setPreviewHeight(int height) {
    for (int i = 0; i < Page.TOTAL; ++i) {
      pages[i].setPreviewHeight(height);
    }
  }

  /**
   * Sets the tab folder of the inspector panel on all pages to the specified
   * tab.
   *
   * @param tab
   *          the tab to be switched to.
   */
  public void setInspectorTab(InspectorTab tab) {
    for (int i = 0; i < Page.TOTAL; ++i) {
      pages[i].setInspectorTab(tab);
    }
  }

  /**
   * Sets the current page of the application.
   *
   * @param page
   *    the id of the page.
   */
  public void setPage(Page page) {
    stackLayout.topControl = pages[page.ordinal()];
    tabFolder.layout();
  }


  /**
   * Set the visibility of an action on the tool bar of all pages.
   *
   * <b>NOTE:</b> After calling this function, the {@link #update(true)}
   * or {@link #updateAll(true)} must be called in order to rebuild all
   * the tool items created by the tool bar.
   *
   * @param id
   *          the ID of the action whose visibility is to be set.
   * @param visible
   *          the visibility to be set.
   */
  public void setToolBarActionVisibility(String id, boolean visible) {
    for (int i = 0; i < Page.TOTAL; ++i) {
      pages[i].setToolBarActionVisibility(id, visible);
    }
  }

  /**
   * Updates the tool bar on all pages.
   *
   * @param force
   *    true means update even if not dirty, and false for normal incremental updating.
   */
  public void updateToolBar(boolean force) {
    for (int i = 0; i < Page.TOTAL; ++i) {
      pages[i].updateToolBar(force);
    }
  }
}
