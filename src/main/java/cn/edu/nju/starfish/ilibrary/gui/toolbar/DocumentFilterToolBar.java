/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.toolbar;

import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import cn.edu.nju.starfish.ilibrary.Application;

/**
 * The tool bar used to filter the documents.
 *
 * @author Haixing Hu
 */
public final class DocumentFilterToolBar extends ToolBarManager {

  public DocumentFilterToolBar(Application application, Composite parent) {
    super();
    super.createControl(parent);
    configLayoutData();
    addItems(application);
  }

  private void configLayoutData() {
    final FormData layoutData = new FormData();
    layoutData.left = new FormAttachment(0);
    layoutData.top = new FormAttachment(0, 3);
    layoutData.right = new FormAttachment(100);
    this.getControl().setLayoutData(layoutData);
  }

  private void addItems(Application application) {
    final ToolBar toolbar = this.getControl();

    final ToolItem tltmAll = new ToolItem(toolbar, SWT.CHECK);
    tltmAll.setText("All");

    final ToolItem tltmFlagged = new ToolItem(toolbar, SWT.CHECK);
    tltmFlagged.setText("Flagged");

    final ToolItem tltmUnread = new ToolItem(toolbar, SWT.CHECK);
    tltmUnread.setText("Unread");

    final ToolItem tltmNewItem_2 = new ToolItem(toolbar, SWT.SEPARATOR);
    tltmNewItem_2.setText("New Item");

    final ToolItem tltmAll_1 = new ToolItem(toolbar, SWT.CHECK);
    tltmAll_1.setText("All");

    final ToolItem tltmArticle = new ToolItem(toolbar, SWT.CHECK);
    tltmArticle.setText("Article");

    final ToolItem tltmBook = new ToolItem(toolbar, SWT.CHECK);
    tltmBook.setText("Book");

    final ToolItem tltmReport = new ToolItem(toolbar, SWT.CHECK);
    tltmReport.setText("Report");

    final ToolItem tltmMedia = new ToolItem(toolbar, SWT.CHECK);
    tltmMedia.setText("Media");

    final ToolItem tltmPatent = new ToolItem(toolbar, SWT.CHECK);
    tltmPatent.setText("Patent");

    final ToolItem tltmNewItem_3 = new ToolItem(toolbar, SWT.SEPARATOR);
    tltmNewItem_3.setText("New Item");

    final ToolItem tltmAll_2 = new ToolItem(toolbar, SWT.CHECK);
    tltmAll_2.setText("All");

    final ToolItem tltmPdf = new ToolItem(toolbar, SWT.CHECK);
    tltmPdf.setText("PDF");

    final ToolItem tltmNoPdf = new ToolItem(toolbar, SWT.CHECK);
    tltmNoPdf.setText("No PDF");
  }
}
