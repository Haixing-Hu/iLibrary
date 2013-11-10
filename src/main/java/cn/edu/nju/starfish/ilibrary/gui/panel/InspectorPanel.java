/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.panel;

import org.apache.commons.configuration.Configuration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Sash;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.MainWindow;

/**
 * The panel displaying the inspection information.
 *
 * @author Haixing Hu
 */
public class InspectorPanel extends Composite {

  public static final String KEY = "gui.inspector-panel";

  private final Application application;
  private final int defaultWidth;
  private final int minWidth;
  private final int maxWidth;
  private final int sashWidth;
  private final Sash sash;
  private int oldWidth;
  private boolean hidden;

  public InspectorPanel(Application application, Composite parent) {
    super(parent, SWT.BORDER | SWT.V_SCROLL);
    this.application = application;
    final Configuration config = application.getConfig();
    defaultWidth = config.getInt(KEY + ".width.default");
    minWidth = config.getInt(KEY + ".width.min");
    maxWidth = config.getInt(KEY + ".width.max");
    sashWidth = config.getInt(KEY + ".width.sash");
    sash = new Sash(parent, SWT.VERTICAL | SWT.BORDER | SWT.SMOOTH);
    oldWidth = defaultWidth;
    hidden = false;
    configLayoutData();
    configSash();
    createContents();
  }

  /**
   * Configures the layout data of this panel.
   */
  private void configLayoutData() {
    final FormData layoutData = new FormData();
    layoutData.left = new FormAttachment(sash);
    layoutData.top = new FormAttachment(0);
    layoutData.right = new FormAttachment(100);
    layoutData.bottom = new FormAttachment(100);
    this.setLayoutData(layoutData);
  }

  /**
   * Configures the sash of this panel.
   */
  private void configSash() {
    final FormData sashData = new FormData();
    sashData.left = new FormAttachment(100, - defaultWidth - sashWidth);
    sashData.top = new FormAttachment(0);
    sashData.right = new FormAttachment(100, - defaultWidth);
    sashData.bottom = new FormAttachment(100);
    sash.setLayoutData(sashData);
    sash.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        final Composite parent = sash.getParent();
        final Rectangle parentRect = parent.getClientArea();
        int newWidth = parentRect.width - e.x - sashWidth;
        newWidth = Math.max(newWidth, minWidth);
        newWidth = Math.min(newWidth, maxWidth);
        final MainWindow mainWindow = application.getMainWindow();
        final MainPanel mainPanel = mainWindow.getMainPanel();
        final NavigatorPanel navigatorPanel = mainWindow.getNavigatorPanel();
        final Sash navigatorSash = navigatorPanel.getSash();
        final Rectangle navigatorSashRect = navigatorSash.getBounds();
        final int minLeftWidth = navigatorSashRect.x + navigatorSashRect.width + mainPanel.getMinWidth();
        newWidth = Math.min(newWidth, parentRect.width - minLeftWidth);
        e.x = parentRect.width - sashWidth - newWidth;  // it's important to modify the event
        if (e.detail != SWT.DRAG) {
          sashData.left = new FormAttachment(100, -(newWidth + sashWidth));
          sashData.right = new FormAttachment(100, -newWidth);
          parent.layout();
          oldWidth = newWidth;
        }
      }
    });
  }

  /**
   * Creates the contents of this panel.
   */
  private void createContents() {
    // TODO create the content of this panel
    setLayout(new FillLayout());
    new Label(this, SWT.NONE).setText("InspectorPanel");
  }

  /**
   * Gets the application this panel belongs.
   *
   * @return the application this panel belongs.
   */
  public Application getApplication() {
    return application;
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
   * Gets the sash width.
   *
   * @return the sash width.
   */
  public int getSashWidth() {
    return sashWidth;
  }

  /**
   * Gets the sash of this panel.
   *
   * @return the sash of this panel.
   */
  public Sash getSash() {
    return sash;
  }


  /**
   * Hides this panel.
   */
  public void hide() {
    if (! hidden) {
      final FormData data = (FormData) sash.getLayoutData();
      data.left = new FormAttachment(100);
      data.right = new FormAttachment(100);
      sash.getParent().layout();
      hidden = true;
    }
  }

  /**
   * Shows this panel.
   */
  public void show() {
    if (hidden) {
      final FormData data = (FormData) sash.getLayoutData();
      data.left = new FormAttachment(100, - oldWidth - sashWidth);
      data.right = new FormAttachment(100, - oldWidth);
      sash.getParent().layout();
      hidden = false;
    }
  }

  /**
   * Tests whether this panel is hidden.
   *
   * @return
   *    true if this panel is hidden, false otherwise.
   */
  public boolean isHidden() {
    return hidden;
  }
}
