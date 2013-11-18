/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.model;

/**
 * The enumeration of read status of documents.
 *
 * @author Haixing Hu
 */
public enum ReadStatus {

  /**
   * Indicates that the document has not been read.
   */
  UNREAD,

  /**
   * Indicates that the document is under reading.
   */
  READING,

  /**
   * Indicates that the document has been read.
   */
  HAS_READ,
}
