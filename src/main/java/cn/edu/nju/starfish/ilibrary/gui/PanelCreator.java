/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui;

import org.eclipse.swt.widgets.Composite;

import cn.edu.nju.starfish.ilibrary.Application;

/**
 * An interface for the creators used to create a panel on a tab item.
 *
 * @author Haixing Hu
 */
public interface PanelCreator {

  /**
   * Creates a panel.
   *
   * @param application
   *          the application.
   * @param parent
   *          the parent composite.
   * @return the created panel.
   */
  public Composite create(Application application, Composite parent);
}
