/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.viewer;

import org.eclipse.swt.widgets.Composite;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.MainPanelHeader;

/**
 * The tool bar used to filter the documents.
 *
 * @author Haixing Hu
 */
public final class ViewerPanelHeader extends MainPanelHeader {

  private static final String ACTIONS[] = {
    //  TODO
  };

  public ViewerPanelHeader(Application application, Composite parent) {
    super(application, parent, ACTIONS);
  }
}
