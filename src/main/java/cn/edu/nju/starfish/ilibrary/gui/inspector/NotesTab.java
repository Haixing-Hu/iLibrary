/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.inspector;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;

import cn.edu.nju.starfish.ilibrary.Application;

/**
 * The document tab item.
 *
 * @author Haixing Hu
 */
public final class NotesTab extends Composite {

  public static final String KEY = InspectorTabFolder.KEY + ".notes";

  private final Application application;
  private NotesTabContent content;
  private NotesTabFooter footer;

  public NotesTab(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
    createContents();
  }

  private void createContents() {
    final FormLayout layout = new FormLayout();
    layout.marginTop = 0;
    layout.marginBottom = 0;
    layout.marginLeft = 0;
    layout.marginRight = 0;
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    layout.spacing = 0;
    this.setLayout(layout);

    content = new NotesTabContent(application, this);
    footer = new NotesTabFooter(application, this);

    final FormData fd_content = new FormData();
    fd_content.left = new FormAttachment(0);
    fd_content.right = new FormAttachment(100);
    fd_content.top = new FormAttachment(0);
    fd_content.bottom = new FormAttachment(footer);
    content.setLayoutData(fd_content);

    final FormData fd_footer = new FormData();
    fd_footer.left = new FormAttachment(0);
    fd_footer.right = new FormAttachment(100);
    fd_footer.top = new FormAttachment(100, - footer.getHeight());
    fd_footer.bottom = new FormAttachment(100);
    footer.setLayoutData(fd_footer);
  }

}
