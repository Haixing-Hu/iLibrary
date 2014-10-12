/*
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
 */
package com.github.haixing_hu.ilibrary.model;

import javax.xml.bind.annotation.XmlEnum;

/**
 * The enumeration of data types used in the values of documents.
 *
 * @author Haixing Hu
 */
@XmlEnum
public enum FieldDataType {

  /**
   * A value in this type represents a {@link String} object.
   */
  STRING,

  /**
   * A value in this type represents a {@link Boolean} object.
   */
  BOOLEAN,

  /**
   * A value in this type represents an {@link Integer} object.
   */
  INTEGER,

  /**
   * A value in this type represents a {@link Double} object.
   */
  DOUBLE,

  /**
   * A value in this type represents a {@link DatePoint} object.
   */
  DATE,

  /**
   * A value in this type represents an {@link Edition} object.
   */
  EDITION,

  /**
   * A value in this type represents a {@link Person} object.
   */
  PERSON,

  /**
   * A value in this type represents an {@link Organization} object.
   */
  ORGANIZATION,

  /**
   * A value in this type represents a {@link Responsibility} object.
   */
  RESPONSIBILITY,

  /**
   * A value in this type represents a {@link Country} object.
   */
  COUNTRY,

  /**
   * A value in this type represents a {@link City} object.
   */
  CITY,

  /**
   * A value in this type represents a {@link Periodical} object.
   */
  PERIODICAL,

  /**
   * A value in this type represents a {@link Event} object.
   */
  EVENT,

  /**
   * A value in this type represents a {@link Website} object.
   */
  WEBSITE,
}
