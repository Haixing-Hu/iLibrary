/******************************************************************************
 *
 * Copyright (c) 2014  Haixing Hu
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Haixing Hu (https://github.com/Haixing-Hu/) - Initial implementation and API.
 *
 ******************************************************************************/

package com.github.haixing_hu.ilibrary.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.state.InspectorTab;

/**
 * The searching tab page.
 *
 * @author Haixing Hu
 */
public abstract class Page extends Composite {

  /**
   * Represents the search page.
   */
  public static final int SEARCH = 0;

  /**
   * Represents the library page.
   */
  public static final int LIBRARY = 1;

  /**
   * Represents the tags page.
   */
  public static final int TAGS = 2;

  /**
   * Represents the authors page.
   */
  public static final int AUTHORS = 3;

  /**
   * Represents the sources page.
   */
  public static final int SOURCES = 4;

  /**
   * Represents the reader page.
   */
  public static final int READER = 5;

  /**
   * The total number of pages.
   */
  public static final int TOTAL_COUNT = 6;

  protected final Application application;

  /**
   * Constructs a page.
   *
   * @param application
   *          the application.
   * @param parent
   *          the parent of this component.
   */
  public Page(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
  }

  /**
   * Gets the key of this page.
   *
   * @return the key of this page.
   */
  public abstract String getKey();

  /**
   * Sets the width of the navigator panel.
   * <p>
   * <b>NOTE:</b> Calling this function will <b>not</b> change the state of the
   * application. Instead, it just change the GUI layout.
   *
   * @param width
   *          the new width to be set. If it is less than or equal to 0, the
   *          function will hide the navigator panel.
   */
  public abstract void setNavigatorWidth(int width);

  /**
   * Sets the width of the inspector panel.
   * <p>
   * <b>NOTE:</b> Calling this function will <b>not</b> change the state of the
   * application. Instead, it just change the GUI layout.
   *
   * @param width
   *          the new width to be set. If it is less than or equal to 0, the
   *          function will hide the inspector panel.
   */
  public abstract void setInspectorWidth(int width);

  /**
   * Sets the height of the preview panel.
   * <p>
   * <b>NOTE:</b> Calling this function will <b>not</b> change the state of the
   * application. Instead, it just change the GUI layout.
   *
   * @param height
   *          the new height to be set. If it is less than or equal to 0, the
   *          function will hide the preview panel.
   */
  public abstract void setPreviewHeight(int height);

  /**
   * Sets the tab folder of the inspector panel to the specified tab.
   *
   * @param tab
   *          the tab to be switched to.
   */
  public abstract void setInspectorTab(InspectorTab tab);
}
