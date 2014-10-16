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
public enum DataType {

  /**
   * A value in this class represents a {@link String} object.
   */
  STRING(String.class),

  /**
   * A value in this class represents a {@link Boolean} object.
   */
  BOOLEAN(Boolean.class),

  /**
   * A value in this class represents an {@link Integer} object.
   */
  INTEGER(Integer.class),

  /**
   * A value in this class represents a {@link Double} object.
   */
  DOUBLE(Double.class),

  /**
   * A value in this class represents a {@link DatePoint} object.
   */
  DATE(DatePoint.class),

  /**
   * A value in this class represents an {@link Edition} object.
   */
  EDITION(Edition.class),

  /**
   * A value in this class represents a {@link Person} object.
   */
  PERSON(Person.class),

  /**
   * A value in this class represents an {@link Organization} object.
   */
  ORGANIZATION(Organization.class),

  /**
   * A value in this class represents a {@link Responsibility} object.
   */
  RESPONSIBILITY(Responsibility.class),

  /**
   * A value in this class represents a {@link Country} object.
   */
  COUNTRY(Country.class),

  /**
   * A value in this class represents a {@link City} object.
   */
  CITY(City.class),

  /**
   * A value in this class represents a {@link Periodical} object.
   */
  PERIODICAL(Periodical.class),

  /**
   * A value in this class represents a {@link Event} object.
   */
  EVENT(Event.class),

  /**
   * A value in this class represents a {@link Website} object.
   */
  WEBSITE(Website.class),

  /**
   * A value in this class represents a {@link Language} object.
   */
  LANGUAGE(Language.class),

  /**
   * A value in this class represents a {@link AccessMode} object.
   */
  ACCESS_MODE(AccessMode.class),

  /**
   * A value in this class represents a {@link ReadStatus} object.
   */
  READ_STATUS(ReadStatus.class),

  /**
   * A value in this class represents a {@link PrintStatus} object.
   */
  PRINT_STATUS(PrintStatus.class);

  private Class<?> clazz;

  private DataType(final Class<?> clazz) {
    this.clazz = clazz;
  }

  /**
   * Gets the class object of the class represented by this enumerator.
   *
   * @return the class object of the class represented by this enumerator.
   */
  public Class<?> toClass() {
    return clazz;
  }
}
