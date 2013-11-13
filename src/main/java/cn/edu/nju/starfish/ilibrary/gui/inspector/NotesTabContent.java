/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.inspector;

import org.apache.commons.configuration.Configuration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.KeySuffix;
import cn.edu.nju.starfish.ilibrary.utils.SWTUtils;

/**
 * The content of the info tab.
 *
 * @author Haixing Hu
 */
public class NotesTabContent extends Composite {

  public static final String KEY = NotesTab.KEY + ".content"; // "window.inspector.tab.notes.content"

  private final Application application;

  public NotesTabContent(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
    createContents();
  }

  private void createContents() {
    final Configuration config = application.getConfig();
    final String rgb = config.getString(KEY + KeySuffix.BACKGROUND_COLOR);
    final Color color = SWTUtils.parseRGB(rgb);
    this.setBackground(color);
    // TODO Auto-generated method stub
    this.setLayout(new FillLayout());
    new Label(this, SWT.NONE).setText("NotesTabContent");
  }
}
