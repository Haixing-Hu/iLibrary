/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.viewer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;

import cn.edu.nju.starfish.ilibrary.Application;

/**
 * The viewer panel.
 *
 * @author Haixing Hu
 */
public final class ViewerPanel extends Composite {

  public static final String KEY = ViewerTab.KEY + ".panel"; //  "window.main.tab.viewer.panel"

  private final Application application;
  private ViewerPanelHeader header;
  private ViewPanelContent content;
  private ViewerPanelToolBar toolBar;
  private ViewerPanelFooter footer;

  public ViewerPanel(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
    createContents();
    layoutContents();
  }

  private void createContents() {
    header = new ViewerPanelHeader(application, this);
    content = new ViewPanelContent(application, this);
    toolBar = new ViewerPanelToolBar(application, this);
    footer = new ViewerPanelFooter(application, this);
  }

  private void layoutContents() {
    final FormLayout layout = new FormLayout();
    layout.marginLeft = 0;
    layout.marginRight = 0;
    layout.marginTop = 0;
    layout.marginBottom = 0;
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    layout.spacing = 0;
    this.setLayout(layout);

    final int headerHeight = header.getHeight();
    final FormData fd_header = new FormData();
    fd_header.left = new FormAttachment(0);
    fd_header.right = new FormAttachment(100);
    fd_header.top = new FormAttachment(0);
    fd_header.bottom = new FormAttachment(0, headerHeight);
    header.setLayoutData(fd_header);

    final FormData fd_content = new FormData();
    fd_content.left = new FormAttachment(0);
    fd_content.right = new FormAttachment(100);
    fd_content.top = new FormAttachment(0, headerHeight);
    fd_content.bottom = new FormAttachment(toolBar);
    content.setLayoutData(fd_content);

    final int toolBarHeight = toolBar.getHeight();
    final int footerHeight = footer.getHeight();

    final FormData fd_toolBar = new FormData();
    fd_toolBar.left = new FormAttachment(0);
    fd_toolBar.right = new FormAttachment(100);
    fd_toolBar.top = new FormAttachment(100,
        - footerHeight - toolBarHeight);
    fd_toolBar.bottom = new FormAttachment(100,
        - footerHeight);
    toolBar.setLayoutData(fd_toolBar);

    final FormData fd_footer = new FormData();
    fd_footer.left = new FormAttachment(0);
    fd_footer.right = new FormAttachment(100);
    fd_footer.top = new FormAttachment(100,
        - footerHeight);
    fd_footer.bottom = new FormAttachment(100);
    footer.setLayoutData(fd_footer);
  }
}
