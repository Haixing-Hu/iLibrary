package com.github.haixing_hu.ilibrary;

import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;

import com.github.haixing_hu.swt.utils.SWTResourceManager;

public class TestGUI extends Composite {
  private class TableLabelProvider extends LabelProvider implements ITableLabelProvider {
    @Override
    public Image getColumnImage(Object element, int columnIndex) {
      return null;
    }
    @Override
    public String getColumnText(Object element, int columnIndex) {
      return element.toString();
    }
  }
  private final Table libraryTable;


  /**
   * Create the composite.
   * @param parent
   * @param style
   */
  public TestGUI(Composite parent, int style) {
    super(parent, style);
    final GridLayout gridLayout = new GridLayout(1, false);
    gridLayout.verticalSpacing = 0;
    gridLayout.marginWidth = 0;
    gridLayout.marginHeight = 0;
    setLayout(gridLayout);

    final CTabFolder mainTabFolder = new CTabFolder(this, SWT.NONE);
    mainTabFolder.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
    mainTabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
    mainTabFolder.setSelectionBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));


    final CTabItem libraryTab = new CTabItem(mainTabFolder, SWT.NONE);
    libraryTab.setText("Library");

    final Composite composite = new Composite(mainTabFolder, SWT.NONE);
    composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
    libraryTab.setControl(composite);
    final FormLayout fl_composite = new FormLayout();
    composite.setLayout(fl_composite);

    final ToolBar libraryToolBar = new ToolBar(composite, SWT.NONE);
    libraryToolBar.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
    final CheckboxTableViewer checkboxTableViewer = CheckboxTableViewer.newCheckList(composite, SWT.FULL_SELECTION | SWT.MULTI);
    final Composite previewPanel = new Composite(composite, SWT.NONE);

    final FormData fd_libraryToolBar = new FormData();
    fd_libraryToolBar.right = new FormAttachment(100);
    fd_libraryToolBar.top = new FormAttachment(0);
    fd_libraryToolBar.left = new FormAttachment(0);
    libraryToolBar.setLayoutData(fd_libraryToolBar);

    libraryTable = checkboxTableViewer.getTable();
    libraryTable.setHeaderVisible(true);
    final FormData fd_libraryTable = new FormData();
    fd_libraryTable.top = new FormAttachment(libraryToolBar);
    fd_libraryTable.left = new FormAttachment(0);
    fd_libraryTable.right = new FormAttachment(100);
    fd_libraryTable.bottom = new FormAttachment(previewPanel);

    final FormData fd_previewPanel = new FormData();
    fd_previewPanel.top = new FormAttachment(100, -120);
    fd_previewPanel.left = new FormAttachment(0);
    fd_previewPanel.right = new FormAttachment(100);
    fd_previewPanel.bottom = new FormAttachment(100);
    previewPanel.setLayoutData(fd_previewPanel);

    final ToolItem tltmAll = new ToolItem(libraryToolBar, SWT.CHECK);
    tltmAll.setText("All");

    final ToolItem tltmFlagged = new ToolItem(libraryToolBar, SWT.CHECK);
    tltmFlagged.setText("Flagged");

    final ToolItem tltmUnread = new ToolItem(libraryToolBar, SWT.CHECK);
    tltmUnread.setText("Unread");

    final ToolItem tltmNewItem_2 = new ToolItem(libraryToolBar, SWT.SEPARATOR);
    tltmNewItem_2.setText("New Item");

    final ToolItem tltmAll_1 = new ToolItem(libraryToolBar, SWT.CHECK);
    tltmAll_1.setText("All");

    final ToolItem tltmArticle = new ToolItem(libraryToolBar, SWT.CHECK);
    tltmArticle.setText("Article");

    final ToolItem tltmBook = new ToolItem(libraryToolBar, SWT.CHECK);
    tltmBook.setText("Book");

    final ToolItem tltmReport = new ToolItem(libraryToolBar, SWT.CHECK);
    tltmReport.setText("Report");

    final ToolItem tltmMedia = new ToolItem(libraryToolBar, SWT.CHECK);
    tltmMedia.setText("Media");

    final ToolItem tltmPatent = new ToolItem(libraryToolBar, SWT.CHECK);
    tltmPatent.setText("Patent");

    final ToolItem tltmNewItem_3 = new ToolItem(libraryToolBar, SWT.SEPARATOR);
    tltmNewItem_3.setText("New Item");

    final ToolItem tltmAll_2 = new ToolItem(libraryToolBar, SWT.CHECK);
    tltmAll_2.setText("All");

    final ToolItem tltmPdf = new ToolItem(libraryToolBar, SWT.CHECK);
    tltmPdf.setText("PDF");

    final ToolItem tltmNoPdf = new ToolItem(libraryToolBar, SWT.CHECK);
    tltmNoPdf.setText("No PDF");

    fd_libraryTable.left = new FormAttachment(0);
    fd_libraryTable.right = new FormAttachment(100);
    libraryTable.setLayoutData(fd_libraryTable);

    final TableColumn pdfColumn = new TableColumn(libraryTable, SWT.LEFT);
    pdfColumn.setResizable(false);
    pdfColumn.setText("PDF");
    pdfColumn.setWidth(20);

    final TableColumn authorColumn = new TableColumn(libraryTable, SWT.LEFT);
    authorColumn.setWidth(100);
    authorColumn.setText("Authors");

    final TableColumn editorsColumn = new TableColumn(libraryTable, SWT.NONE);
    editorsColumn.setWidth(100);
    editorsColumn.setText("Editors");

    final TableColumn titleColumn = new TableColumn(libraryTable, SWT.LEFT);
    titleColumn.setWidth(100);
    titleColumn.setText("Title");


    final CTabItem documentTab = new CTabItem(mainTabFolder, SWT.CLOSE);
    documentTab.setText("Document");

    final Composite composite_1 = new Composite(mainTabFolder, SWT.NONE);
    documentTab.setControl(composite_1);
    composite_1.setLayout(new FormLayout());

    final TreeViewer treeViewer = new TreeViewer(composite_1, SWT.BORDER);
    final Tree tree = treeViewer.getTree();
    final FormData fd_tree = new FormData();
    fd_tree.top = new FormAttachment(0);
    fd_tree.left = new FormAttachment(0);
    fd_tree.right = new FormAttachment(0, 224);
    fd_tree.bottom = new FormAttachment(100, -48);
    tree.setLayoutData(fd_tree);

    final ToolBar mainToolBar = new ToolBar(this, SWT.NONE);
    mainToolBar.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, true, false, 1, 1));

    final ToolItem tltmNewItem = new ToolItem(mainToolBar, SWT.WRAP);
    tltmNewItem.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        System.out.println("Clicked");
      }
    });
    tltmNewItem.setImage(SWTResourceManager.getImage(TestGUI.class, "/images/toolstrip_fullscreen.tif"));
    tltmNewItem.setText("Read Full Screen");

    final ToolItem tltmNewItem_1 = new ToolItem(mainToolBar, SWT.NONE);
    tltmNewItem_1.setText("New Item");

  }
}
