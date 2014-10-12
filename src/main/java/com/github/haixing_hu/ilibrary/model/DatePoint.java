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

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.github.haixing_hu.lang.Argument;

/**
 * Represents a day.
 *
 * @author Haixing Hu
 */
public final class DatePoint {

  public enum Type {
    /**
     * Represents an exact date.
     */
    EXACT_DATE,

    /**
     * Represents a date with only year and month.
     */
    YEAR_MONTH,

    /**
     * Represents a date with only year.
     */
    YEAR_ONLY,

    /**
     * Represents a circa year.
     */
    CIRCA,
  }

  private short year;
  private byte month;
  private byte day;
  private boolean circa;

  /**
   * Default constructs a {@link DatePoint} which does not represent any valid date.
   */
  public DatePoint() {
    year = -1;
    month = -1;
    day = -1;
    circa = false;
  }

  /**
   * Constructs a {@link DatePoint} represents an exact date.
   *
   * @param year
   *          the year of the new date.
   * @param month
   *          the month of the new date.
   * @param day
   *          the day of the new date.
   */
  public DatePoint(short year, byte month, byte day) {
    this.year = year;
    this.month = Argument.requireInCloseRange("month", month, (byte)1, (byte)12);
    this.day = Argument.requireInCloseRange("day", day, (byte)1, (byte)31);
    circa = false;
  }

  /**
   * Constructs a {@link DatePoint} represents a year-month date.
   *
   * @param year
   *          the year of the new date.
   * @param month
   *          the month of the new date.
   */
  public DatePoint(short year, byte month) {
    this.year = year;
    this.month = Argument.requireInCloseRange("month", month, (byte)1, (byte)12);
    day = -1;
    circa = false;
  }

  /**
   * Constructs a {@link DatePoint} represents a circa date.
   *
   * @param year
   *          the year of the new date.
   * @param circa
   *          indicate whether the new date is circa.
   */
  public DatePoint(short year, boolean circa) {
    this.year = year;
    month = -1;
    day = -1;
    this.circa = circa;
  }

  /**
   * Gets the year.
   *
   * @return the year.
   */
  public short getYear() {
    return year;
  }

  /**
   * Sets the year.
   *
   * @param year
   *          the new year to set.
   */
  public void setYear(short year) {
    this.year = year;
  }

  /**
   * Gets the month.
   *
   * @return the month.
   */
  public byte getMonth() {
    return month;
  }

  /**
   * Sets the month.
   *
   * @param month
   *          the new month to set.
   */
  public void setMonth(byte month) {
    this.month = month;
  }

  /**
   * Gets the day.
   *
   * @return the day.
   */
  public byte getDay() {
    return day;
  }

  /**
   * Sets the day.
   *
   * @param day
   *          the new day to set.
   */
  public void setDay(byte day) {
    this.day = day;
  }

  /**
   * Gets the circa.
   *
   * @return the circa.
   */
  public boolean isCirca() {
    return circa;
  }

  /**
   * Sets the circa.
   *
   * @param circa
   *          the new circa to set.
   */
  public void setCirca(boolean circa) {
    this.circa = circa;
  }

  /**
   * Gets the type of this publishing date.
   *
   * @return the type of this publishing date.
   */
  public Type getType() {
    if (circa) {
      return Type.CIRCA;
    } else if (month <= 0) {
      return Type.YEAR_ONLY;
    } else if (day <= 0) {
      return Type.YEAR_MONTH;
    } else {
      return Type.EXACT_DATE;
    }
  }

  /**
   * Sets an exact date.
   * <p>
   * <b>NOTE:</b> this function does NOT check whether the date is valid.
   *
   * @param year
   *          the year, which may be negative, indicating the year before Christ
   *          (i.e., B.C.).
   * @param month
   *          the month, which must be positive and less than 13.
   * @param day
   *          the day, which must be positive and less than 32.
   */
  public void setExactDate(short year, byte month, byte day) {
    if ((month <= 0) || (day <= 0)) {
      throw new IllegalArgumentException("month and day must be positive.");
    }
    if (month > 12) {
      throw new IllegalArgumentException("month must be less than 13.");
    }
    if (day > 31) {
      throw new IllegalArgumentException("day must be less than 32.");
    }
    this.year = year;
    this.month = month;
    this.day = day;
    circa = false;
  }

  /**
   * Sets a year-month date.
   * <p>
   * <b>NOTE:</b> this function does NOT check whether the date is valid.
   *
   * @param year
   *          the year, which may be negative, indicating the year before Christ
   *          (i.e., B.C.).
   * @param month
   *          the month, which must be positive and less than 13.
   */
  public void setYearMonthDate(short year, byte month) {
    if (month <= 0) {
      throw new IllegalArgumentException("month must be positive.");
    }
    if (month > 12) {
      throw new IllegalArgumentException("month must be less than 13.");
    }
    this.year = year;
    this.month = month;
    day = -1;
    circa = false;
  }

  /**
   * Sets a year-only date.
   * <p>
   * <b>NOTE:</b> this function does NOT check whether the date is valid.
   *
   * @param year
   *          the year, which may be negative, indicating the year before Christ
   *          (i.e., B.C.).
   */
  public void setYearOnlyDate(short year) {
    this.year = year;
    month = -1;
    day = -1;
    circa = false;
  }

  /**
   * Sets a circa date.
   * <p>
   * <b>NOTE:</b> this function does NOT check whether the date is valid.
   *
   * @param year
   *          the year, which may be negative, indicating the year before Christ
   *          (i.e., B.C.).
   */
  public void setCircaDate(short year) {
    this.year = year;
    month = -1;
    day = -1;
    circa = true;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }
}
