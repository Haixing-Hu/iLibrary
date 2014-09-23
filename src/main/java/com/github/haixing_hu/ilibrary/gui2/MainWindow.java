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

package com.github.haixing_hu.ilibrary.gui2;

import java.awt.Window;

import org.eclipse.jface.util.Geometry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.gui.MainMenuBar;
import com.github.haixing_hu.swt.menu.MenuManagerEx;
import com.github.haixing_hu.swt.utils.SWTResourceManager;
import com.github.haixing_hu.swt.window.ApplicationWindowEx;

/**
 * The main window of the application.
 *
 * @author Haixing Hu
 */
public final class MainWindow extends ApplicationWindowEx {

  public static final String KEY = "window";

  public static final int SEARCH_PAGE_INDEX  = 0;

  public static final int LIBRARY_PAGE_INDEX = 1;

  public static final int TAGS_PAGE_INDEX    = 2;

  public static final int AUTHORS_PAGE_INDEX = 3;

  public static final int SOURCES_PAGE_INDEX = 4;

  public static final int READER_PAGE_INDEX  = 5;

  private final Application application;
  private final int defaultHeight;
  private final int defaultWidth;
  private final int minHeight;
  private final int minWidth;
  private CTabFolder tabFolder;
  private MainMenuBar menuBar;

  public MainWindow(Application application) {
    super(null);
    this.application = application;
    final AppConfig config = application.getConfig();
    defaultHeight = config.getInt(KEY + KeySuffix.DEFAULT_HEIGHT);
    defaultWidth = config.getInt(KEY + KeySuffix.DEFAULT_WIDTH);
    minHeight = config.getInt(KEY + KeySuffix.MIN_HEIGHT);
    minWidth = config.getInt(KEY + KeySuffix.MIN_WIDTH);
    addMenuBar();
    addToolBar(SWT.FLAT |SWT.WRAP);
  }

  @Override
  protected Control createContents(Composite parent) {
    final GridLayout layout = new GridLayout();
    layout.marginHeight = layout.marginWidth = 0;
    parent.setLayout(layout);

    tabFolder = new CTabFolder(parent, SWT.BORDER);
    tabFolder.setLayoutData( new GridData( GridData.FILL_BOTH ));
    tabFolder.setSimple(false);

    final AppConfig config = application.getConfig();
    final String path = config.getString(KEY + KeySuffix.SELECTION + KeySuffix.BACKGROUND_IMAGE);
    final Image img = SWTResourceManager.getImage(this.getClass(), path);
    tabFolder.setSelectionBackground(img);
    final String rgb = config.getString(KEY + KeySuffix.BACKGROUND_COLOR);
    final Color color = SWTResourceManager.getColor(rgb);
    tabFolder.setBackground(color);
    tabFolder.marginHeight = 0;
    tabFolder.marginWidth = 0;

    parent.setBackground(color);


    createTabItem(tabFolder, SearchPage.KEY,
        new SearchPage(application, tabFolder));
    createTabItem(tabFolder, LibraryPage.KEY,
        new LibraryPage(application, tabFolder));
    createTabItem(tabFolder, TagsPage.KEY,
        new TagsPage(application, tabFolder));
    createTabItem(tabFolder, AuthorsPage.KEY,
        new AuthorsPage(application, tabFolder));
    createTabItem(tabFolder, SourcesPage.KEY,
        new SourcesPage(application, tabFolder));
    createTabItem(tabFolder, ReaderPage.KEY,
        new ReaderPage(application, tabFolder));
    return parent;
  }

  private CTabItem createTabItem(CTabFolder tabFolder, String key, Composite page) {
    final CTabItem item = new CTabItem(tabFolder, SWT.NO_FOCUS);
    final AppConfig config = application.getConfig();
    final String title = config.getTitle(key);
    item.setText("   " + title + "   ");
    item.setControl(page);
    return item;
  }

  @Override
  protected MenuManagerEx createMenuManager() {
    menuBar = new MainMenuBar(application);
    return menuBar;
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
    final CTabItem item = tabFolder.getItem(SEARCH_PAGE_INDEX);
    return (SearchPage) item.getControl();
  }

  /**
   * Gets the library page.
   *
   * @return the library page.
   */
  public LibraryPage getLibraryPage() {
    final CTabItem item = tabFolder.getItem(LIBRARY_PAGE_INDEX);
    return (LibraryPage) item.getControl();
  }

  /**
   * Gets the tags page.
   *
   * @return the tags page.
   */
  public TagsPage getTagsPage() {
    final CTabItem item = tabFolder.getItem(LIBRARY_PAGE_INDEX);
    return (TagsPage) item.getControl();
  }

  /**
   * Gets the authors page.
   *
   * @return the authors page.
   */
  public AuthorsPage getAuthorsPage() {
    final CTabItem item = tabFolder.getItem(LIBRARY_PAGE_INDEX);
    return (AuthorsPage) item.getControl();
  }

  /**
   * Gets the sources page.
   *
   * @return the sources page.
   */
  public SourcesPage getSourcesPage() {
    final CTabItem item = tabFolder.getItem(LIBRARY_PAGE_INDEX);
    return (SourcesPage) item.getControl();
  }

  /**
   * Gets the reader page.
   *
   * @return the reader page.
   */
  public ReaderPage getReaderPage() {
    final CTabItem item = tabFolder.getItem(READER_PAGE_INDEX);
    return (ReaderPage) item.getControl();
  }
}
