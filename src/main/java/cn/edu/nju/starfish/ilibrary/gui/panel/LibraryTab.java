/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.panel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.toolbar.FilterToolBar;

/**
 * The library tab item.
 *
 * @author Haixing Hu
 */
public class LibraryTab extends CTabItem {

  public static final String KEY = MainTabFolder.KEY + ".library";

  private FilterToolBar filterToolBar;
  private DocumentList documentList;
  private PreviewPanel previewPanel;

  public LibraryTab(Application application, CTabFolder parent) {
    super(parent, SWT.NONE);
    // TODO Auto-generated constructor stub
    this.setText("   " + application.getTitle(KEY) + "   ");
    this.createContents(application, parent);
  }

  /**
   * Creates the contents of this tab.
   *
   * @param application the application this tab belongs.
   * @param parent the parent of this tab.
   */
  private void createContents(Application application, CTabFolder parent) {
    final Composite composite = new Composite(parent, SWT.NONE);
    this.setControl(composite);
    // composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
    final FormLayout layout = new FormLayout();
    layout.marginLeft = 0;
    layout.marginRight = 0;
    layout.marginTop = 0;
    layout.marginBottom = 0;
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    layout.spacing = 0;
    composite.setLayout(layout);

    filterToolBar = new FilterToolBar(application, composite);
    previewPanel = new PreviewPanel(application, composite);
    documentList = new DocumentList(application, composite, filterToolBar, previewPanel);
  }

  /**
   * Gets the document filter tool bar.
   *
   * @return the document filter tool bar.
   */
  public FilterToolBar getFilterToolBar() {
    return filterToolBar;
  }

  /**
   * Gets the document list.
   *
   * @return the document list.
   */
  public DocumentList getDocumentList() {
    return documentList;
  }

  /**
   * Gets the preview panel.
   *
   * @return the preview panel.
   */
  public PreviewPanel getPreviewPanel() {
    return previewPanel;
  }

}
