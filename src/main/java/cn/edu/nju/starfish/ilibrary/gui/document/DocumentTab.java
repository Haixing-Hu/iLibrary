/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.document;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Composite;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.MainPanelTab;
import cn.edu.nju.starfish.ilibrary.gui.PanelCreator;

/**
 * The document tab item.
 *
 * @author Haixing Hu
 */
public final class DocumentTab extends MainPanelTab {

  public static final String KEY = MainPanelTab.KEY + ".document";   //   "window.main.tab.document"

  public DocumentTab(Application application, CTabFolder parent) {
    super(application, KEY, parent, SWT.CLOSE, new PanelCreator() {
      @Override
      public Composite create(Application application, Composite parent) {
        return new DocumentPanel(application, parent);
      }
    });
  }

}
