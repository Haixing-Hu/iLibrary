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

import javax.annotation.Nullable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.github.haixing_hu.ilibrary.utils.Argument;

/**
 * The modes of editions of publications.
 * <p>
 * The edition of a publication may be represented in two forms: either as an
 * edition number., or as a description of the edition. For example:
 * <ul>
 * <li>the number 3 represents the third edition</li>
 * <li>the string "millennium edition" represents the millennium edition, i.e.,
 * the edition published in the year of 2000.
 * </ul>
 *
 * @author Haixing Hu
 */
public class Edition {

  public enum Type {
    /**
     * Represents the edition is represented as an edition number.
     */
    AS_NUMBER,

    /**
     * Represents the edition is represented as a description of the edition.
     */
    AS_DESCRIPTION,
  }

  private int number;
  private String description;

  /**
   * Constructs an {@link Edition} represents the first edition.
   */
  public Edition() {
    number = 1;
    description = null;
  }

  /**
   * Constructs an {@link Edition}.
   *
   * @param number
   *          the number of the new edition.
   */
  public Edition(int number) {
    this.number = number;
    this.description = null;
  }

  /**
   * Constructs an {@link Edition}.
   *
   * @param description
   *          the description of the new edition.
   */
  public Edition(@Nullable String description) {
    this.number = - 1;
    this.description = description;
  }

  /**
   * Gets the number.
   *
   * @return the number.
   */
  public int getNumber() {
    return number;
  }

  /**
   * Sets the number.
   *
   * @param number
   *          the new number to set.
   */
  public void setNumber(int number) {
    this.number = number;
  }

  /**
   * Gets the description.
   *
   * @return the description.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the description.
   *
   * @param description
   *          the new description to set.
   */
  public void setDescription(@Nullable String description) {
    this.description = description;
  }

  /**
   * Gets the type of the edition.
   *
   * @return the type of the edition.
   */
  public Type getType() {
    return (number > 0 ? Type.AS_NUMBER : Type.AS_DESCRIPTION);
  }

  /**
   * Sets the edition as the type {@link Type#AS_NUMBER}.
   * <p>
   * <b>NOTE:</b> This function will clear the <code>description<code> field
   * of this {@link Edition} object.
   *
   * @param number
   *          the edition number, which must be positive.
   */
  public void setEditionAsNumber(int number) {
    this.number = Argument.requirePositive("number", number);
    this.description = null;
  }

  /**
   * Sets the edition as the type {@link Type#AS_DESCRIPTION}.
   * <p>
   * <b>NOTE:</b> This function will clear the <code>number<code> field
   * of this {@link Edition} object.
   *
   * @param description
   *          the description of the edition, which cannot be empty.
   */
  public void setEditionAsDescription(String description) {
    this.description = Argument.requireNonEmpty("description", description);
    this.number = - 1;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
