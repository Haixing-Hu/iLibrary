/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.toolbar;

import org.apache.commons.configuration.Configuration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.wb.swt.SWTResourceManager;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.panel.LibraryTab;

/**
 * The tool bar used to filter the documents.
 *
 * @author Haixing Hu
 */
public final class FilterToolBar extends Composite {

  public static final String KEY = LibraryTab.KEY + ".toolbar";

  private final Application application;
  private final int height;
  private final String background;
  private ToolBar toolBar;

  public FilterToolBar(Application application, Composite parent) {
    super(parent, SWT.FLAT);
    this.application = application;
    final Configuration config = application.getConfig();
    height = config.getInt(KEY + ".height");
    background = config.getString(KEY + ".background");
    configLayoutData();
    createContents();
  }

  private void configLayoutData() {
    final FormData layoutData = new FormData();
    layoutData.left = new FormAttachment(0);
    layoutData.top = new FormAttachment(0);
    layoutData.right = new FormAttachment(100);
    layoutData.bottom = new FormAttachment(0, height);
    setLayoutData(layoutData);
  }

  private void createContents() {

    final GridLayout layout = new GridLayout(1, true);
    layout.horizontalSpacing = 0;
    layout.verticalSpacing = 0;
    layout.marginLeft = 0;
    layout.marginTop = 0;
    layout.marginRight = 0;
    layout.marginBottom = 0;
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    this.setLayout(layout);

    toolBar = new ToolBar(this, SWT.FLAT);
    final GridData gd_toolBar = new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1);
    toolBar.setLayoutData(gd_toolBar);

    final Image image = SWTResourceManager.getImage(FilterToolBar.class, background);
    //  in order to be compatible on multi-platforms, we must set the
    //  background image on both the composite and the tool bar.
    this.setBackgroundImage(image);
    toolBar.setBackgroundImage(image);

    final ToolItem tltmAll = new ToolItem(toolBar, SWT.CHECK);
    tltmAll.setText("All");

    final ToolItem tltmFlagged = new ToolItem(toolBar, SWT.CHECK);
    tltmFlagged.setText("Flagged");

    final ToolItem tltmUnread = new ToolItem(toolBar, SWT.CHECK);
    tltmUnread.setText("Unread");

    final ToolItem tltmNewItem_2 = new ToolItem(toolBar, SWT.SEPARATOR);
    tltmNewItem_2.setText("New Item");

    final ToolItem tltmAll_1 = new ToolItem(toolBar, SWT.CHECK);
    tltmAll_1.setText("All");

    final ToolItem tltmArticle = new ToolItem(toolBar, SWT.CHECK);
    tltmArticle.setText("Article");

    final ToolItem tltmBook = new ToolItem(toolBar, SWT.CHECK);
    tltmBook.setText("Book");

    final ToolItem tltmReport = new ToolItem(toolBar, SWT.CHECK);
    tltmReport.setText("Report");

    final ToolItem tltmMedia = new ToolItem(toolBar, SWT.CHECK);
    tltmMedia.setText("Media");

    final ToolItem tltmPatent = new ToolItem(toolBar, SWT.CHECK);
    tltmPatent.setText("Patent");

    final ToolItem tltmNewItem_3 = new ToolItem(toolBar, SWT.SEPARATOR);
    tltmNewItem_3.setText("New Item");

    final ToolItem tltmAll_2 = new ToolItem(toolBar, SWT.CHECK);
    tltmAll_2.setText("All");

    final ToolItem tltmPdf = new ToolItem(toolBar, SWT.CHECK);
    tltmPdf.setText("PDF");

    final ToolItem tltmNoPdf = new ToolItem(toolBar, SWT.CHECK);
    tltmNoPdf.setText("No PDF");
  }

  public int getHeight() {
    return height;
  }
}
