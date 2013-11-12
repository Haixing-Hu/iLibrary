/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.library;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Composite;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.MainPanelTab;
import cn.edu.nju.starfish.ilibrary.gui.PanelCreator;

/**
 * The library tab item.
 *
 * @author Haixing Hu
 */
public final class LibraryTab extends MainPanelTab {

  public static final String KEY = MainPanelTab.KEY + ".library";  //  "window.main.tab.library"

  public LibraryTab(Application application, CTabFolder parent) {
    super(application, KEY, parent, SWT.NONE, new PanelCreator() {
      @Override
      public Composite create(Application application, Composite parent) {
        return new LibraryPanel(application, parent);
      }
    });
  }

  /**
   * Gets the library panel.
   *
   * @return the library panel.
   */
  @Override
  public LibraryPanel getPanel() {
    return (LibraryPanel) panel;
  }

  /**
   * Hides the preview panel.
   */
  public void hidePreview() {
    ((LibraryPanel) panel).hidePreview();
  }

  /**
   * Shows the preview panel.
   */
  public void showPreview() {
    ((LibraryPanel) panel).showPreview();
  }
}
