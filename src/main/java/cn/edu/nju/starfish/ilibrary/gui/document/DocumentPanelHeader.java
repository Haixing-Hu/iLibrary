/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.document;

import org.eclipse.swt.widgets.Composite;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.MainPanelHeader;

/**
 * The header in the document panel.
 *
 * @author Haixing Hu
 */
public final class DocumentPanelHeader extends MainPanelHeader {

  private static final String ACTIONS[] = {
    //  TODO
  };

  public DocumentPanelHeader(Application application, Composite parent) {
    super(application, parent, ACTIONS);
  }
}
