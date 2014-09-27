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

/**
 * The enumeration of pages.
 *
 * @author Haixing Hu
 */
public enum Page {

  /**
   * Represents the search page.
   */
  SEARCH,

  /**
   * Represents the library page.
   */
  LIBRARY,

  /**
   * Represents the tags page.
   */
  TAGS,

  /**
   * Represents the authors page.
   */
  AUTHORS,

  /**
   * Represents the sources page.
   */
  SOURCES,

  /**
   * Represents the reader page.
   */
  READER;

  /**
   * Total number of pages.
   */
  public static final int TOTAL = 6;

}
