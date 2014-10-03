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

package com.github.haixing_hu.ilibrary.state;

import com.github.haixing_hu.ilibrary.action.window.page.PageAuthorsAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageLibraryAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageReaderAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageSearchAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageSourcesAction;
import com.github.haixing_hu.ilibrary.action.window.page.PageTagsAction;

/**
 * The enumeration of pages.
 *
 * @author Haixing Hu
 */
public enum Page {

  /**
   * Represents the search page.
   */
  SEARCH(PageSearchAction.ID),

  /**
   * Represents the library page.
   */
  LIBRARY(PageLibraryAction.ID),

  /**
   * Represents the tags page.
   */
  TAGS(PageTagsAction.ID),

  /**
   * Represents the authors page.
   */
  AUTHORS(PageAuthorsAction.ID),

  /**
   * Represents the sources page.
   */
  SOURCES(PageSourcesAction.ID),

  /**
   * Represents the reader page.
   */
  READER(PageReaderAction.ID);

  /**
   * Total number of pages.
   */
  public static final int TOTAL = 6;


  private String actionId;

  private Page(String actionId) {
    this.actionId = actionId;
  }

  public String actionId() {
    return actionId;
  }
}
