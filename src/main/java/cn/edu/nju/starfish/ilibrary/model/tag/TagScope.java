/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.model.tag;

/**
 * The enumeration of predefined tag scopes.
 *
 * @author Haixing Hu
 */
public enum TagScope {

  /**
   * Represents an unknown tag scope.
   */
  UNKNOWN,

  /**
   * The tags in the this scope represent the category of the publication.
   */
  CATEGORY,

  /**
   * The tags in the this scope represent the keyword of the publication.
   */
  KEYWORD,

  /**
   * The tags in the this scope represent the status of the publication.
   */
  STATUS,

  /**
   * The tags in the this scope represent the label of the publication.
   */
  LABEL,

  /**
   * The tags in the this scope represent the access mode of the publication.
   */
  ACCESS_MODE,

  /**
   * The tags in the this scope represent the type of the periodical.
   */
  PERIODICAL_TYPE,
}
