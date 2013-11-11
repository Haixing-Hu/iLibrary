/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.panel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.toolbar.FilterToolBar;
import cn.edu.nju.starfish.ilibrary.gui.widget.BaseTabItem;

/**
 * The library tab item.
 *
 * @author Haixing Hu
 */
public final class LibraryTab extends BaseTabItem {

  public static final String KEY = CenterTabFolder.KEY + ".library";

  private FilterToolBar filterToolBar;
  private DocumentList documentList;
  private PreviewPanel previewPanel;

  public LibraryTab(Application application, CTabFolder parent) {
    super(application, KEY, parent, SWT.NONE);
  }

  @Override
  protected void createContents() {
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
