/******************************************************************************
 *
 * Copyright (c) 2014  Haixing Hu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package com.github.haixing_hu.ilibrary.model;

/**
 * The enumeration of reading status of documents.
 *
 * @author Haixing Hu
 */
public enum ReadStatus {

  /**
   * Indicates that the document has not been read.
   */
  UNREAD,

  /**
   * Indicates that the document is to be read.
   */
  TO_READ,

  /**
   * Indicates that the document is under reading.
   */
  READING,

  /**
   * Indicates that the document has been read.
   */
  HAS_READ,
}
