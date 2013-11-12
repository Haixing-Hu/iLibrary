/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.document;

import org.eclipse.swt.widgets.Composite;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.MainPanelFooter;

/**
 * The footer in the document panel.
 *
 * @author Haixing Hu
 */
public class DocumentPanelFooter extends MainPanelFooter {

  /**
   * Creates a footer.
   *
   * @param application
   *    the application.
   * @param parent
   *    the parent of the new footer.
   */
  public DocumentPanelFooter(Application application, Composite parent) {
    super(application, parent);
  }
}

