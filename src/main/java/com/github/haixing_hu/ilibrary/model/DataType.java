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
 * The enumeration of data types used in the values of documents.
 *
 * @author Haixing Hu
 */
public enum DataType {

  /**
   * A value in this type is a string.
   */
  STRING,

  /**
   * A value in this type is a boolean value.
   */
  BOOLEAN,

  /**
   * A value in this type is an integer.
   */
  INTEGER,

  /**
   * A value in this type is a real number.
   */
  REAL,

  /**
   * A value in this type is a date, accurate to day.
   */
  DATE,

  /**
   * A value in this type is a enumerator in a user-defined enumeration.
   */
  ENUMERATION,

  /**
   * A value in this type represents a person.
   */
  PERSON,

  /**
   * A value in this type represents an institute.
   */
  INSTITUTE,

  /**
   * A value in this type represents a responsibility, which is either a person
   * or a institute.
   */
  RESPONSIBILITY,

  /**
   * A value in this type represents a country.
   */
  COUNTRY,

  /**
   * A value in this type represents a city.
   */
  CITY,

  /**
   * A value in this type represents a periodical.
   */
  PERIODICAL,

  /**
   * A value in this type represents a publisher.
   */
  PUBLISHER,

  /**
   * A value in this type represents a website.
   */
  WEBSITE,
}
