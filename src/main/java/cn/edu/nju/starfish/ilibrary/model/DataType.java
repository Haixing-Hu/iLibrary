/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.model;

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
