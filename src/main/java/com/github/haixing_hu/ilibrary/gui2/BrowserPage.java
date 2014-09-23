/******************************************************************************
 *
 * Copyright (c) 2014  Haixing Hu
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Haixing Hu (https://github.com/Haixing-Hu/) - Initial implementation and API.
 *
 ******************************************************************************/

package com.github.haixing_hu.ilibrary.gui2;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Sash;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.gui.MainPanelTab;
import com.github.haixing_hu.ilibrary.gui.inspector.InspectorPanel;
import com.github.haixing_hu.ilibrary.gui2.browser.BrowserPanel;
import com.github.haixing_hu.ilibrary.gui2.navigator.NavigatorPanel;
import com.github.haixing_hu.ilibrary.state.ApplicationState;
import com.github.haixing_hu.swt.utils.SWTResourceManager;

/**
 * The {@link BrowserPage} class is the base class for all pages in which
 * the user browser the documents in some way.
 *
 * @author Haixing Hu
 * @see {@link LibraryPage}
 * @see {@link TagsPage}
 * @see {@link AuthorsPage}
 * @see {@link SourcesPage}
 */
public class BrowserPage extends Composite  {

  private static final String KEY = "browser";

  protected final Application application;
  private final int sashWidth;
  private final Color sashColor;
  private final NavigatorPanel navigatorPanel;
  private final Sash sash;
  private final BrowserPanel browserPanel;

  public BrowserPage(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
    final AppConfig config = application.getConfig();
    sashWidth = config.getInt(KEY + KeySuffix.SASH + KeySuffix.WIDTH);
    final String rgb = config.getString(KEY + KeySuffix.SASH + KeySuffix.COLOR);
    sashColor = SWTResourceManager.getColor(rgb);
    navigatorPanel = new NavigatorPanel(application, this);
    sash = new Sash(this, SWT.VERTICAL | SWT.BORDER);
    browserPanel  = new BrowserPanel(application, this);
    layoutContents();
    configSash();
  }

  private void layoutContents() {
    final FormLayout layout = new FormLayout();
    layout.marginTop = 0;
    layout.marginBottom = 0;
    layout.marginLeft = 0;
    layout.marginRight = 0;
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    layout.spacing = 0;
    setLayout(layout);

    //  configure the layout data
    final FormData fd_navigator = new FormData();
    fd_navigator.top = new FormAttachment(0);
    fd_navigator.bottom = new FormAttachment(100);
    fd_navigator.left = new FormAttachment(0);
    fd_navigator.right = new FormAttachment(sash);
    navigatorPanel.setLayoutData(fd_navigator);

    final int navigatorWidth = navigatorPanel.getDefaultWidth();

    final FormData fd_sash = new FormData();
    fd_sash.top = new FormAttachment(0);
    fd_sash.bottom = new FormAttachment(100);
    fd_sash.left = new FormAttachment(0, navigatorWidth);
    fd_sash.right = new FormAttachment(0, navigatorWidth + sashWidth);
    sash.setLayoutData(fd_sash);

    final FormData fd_browser = new FormData();
    fd_browser.top = new FormAttachment(0);
    fd_browser.bottom = new FormAttachment(100);
    fd_browser.left = new FormAttachment(sash);
    fd_browser.right = new FormAttachment(100);
    browserPanel.setLayoutData(fd_browser);
  }

  private void configSash() {
    sash.setForeground(sashColor);
    sash.setBackground(sashColor);

    final ApplicationState state = application.getState();
    final FormData fd_sash = (FormData) sash.getLayoutData();
    sash.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent event) {
        int newWidth = event.x;
        newWidth = Math.max(newWidth, navigatorPanel.getMinWidth());
        newWidth = Math.min(newWidth, navigatorPanel.getMaxWidth());
        final Rectangle rect = sash.getParent().getClientArea();
        final MainPanelTab tab = mainPanel.getSelection();
        final InspectorPanel inspector = tab.getInspector();
        final int minPanelWidth = tab.getMinPanelWidth();
        final int maxPanelWidth = tab.getMaxPanelWidth();
        final int inspectorWidth = inspector.getBounds().width;
        newWidth = Math.min(newWidth, rect.width - minPanelWidth - inspectorWidth);
        newWidth = Math.max(newWidth, rect.width - maxPanelWidth - inspectorWidth);
        // it's important to modify the event
        event.x = newWidth;
        if (event.detail != SWT.DRAG) {
          fd_sash.left = new FormAttachment(0, newWidth);
          fd_sash.right = new FormAttachment(0, newWidth + sashWidth);
          sash.getParent().layout();
          state.setNavigatorWidth(newWidth);
        }
      }
    });
  }

  /**
   * Gets the navigator panel.
   *
   * @return the navigator panel.
   */
  public NavigatorPanel getNavigatorPanel() {
    return navigatorPanel;
  }

  /**
   * Gets the sash.
   *
   * @return the sash.
   */
  public Sash getSash() {
    return sash;
  }

  /**
   * Gets the browser panel.
   *
   * @return the browser panel.
   */
  public BrowserPanel getBrowserPanel() {
    return browserPanel;
  }


}
