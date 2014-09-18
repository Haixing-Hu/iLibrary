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

import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * The model of languages.
 *
 * @author Haixing Hu
 */
public final class Language {

  private String code;
  private String name;
  private String abbreviation;

  /**
   * Constructs a language.
   */
  public Language() {
    code = null;
    name = null;
    abbreviation = null;
  }

  /**
   * Constructs a language.
   *
   * @param code
   *          the ISO code of the new language.
   * @param name
   *          the name of the new language.
   * @param abbreviation
   *          the abbreviation of the new language.
   */
  public Language(String code, String name, String abbreviation) {
    this.code = requireNonNull("code", code);
    this.name = requireNonNull("name", name);
    this.abbreviation = requireNonNull("abbreviation", abbreviation);
  }

  /**
   * Gets the ISO 639-2 language code.
   *
   * @return the ISO 639-2 language code.
   */
  public String getCode() {
    return code;
  }

  /**
   * Sets the ISO 639-2 language code.
   *
   * @param code
   *          the new ISO 639-2 language code to set.
   */
  public void setCode(@Nullable String code) {
    this.code = code;
  }

  /**
   * Gets the name.
   *
   * @return the name.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name.
   *
   * @param name
   *          the new name to set.
   */
  public void setName(@Nullable String name) {
    this.name = name;
  }

  /**
   * Gets the abbreviation.
   *
   * @return the abbreviation.
   */
  public String getAbbreviation() {
    return abbreviation;
  }

  /**
   * Sets the abbreviation.
   *
   * @param abbreviation
   *          the new abbreviation to set.
   */
  public void setAbbreviation(@Nullable String abbreviation) {
    this.abbreviation = abbreviation;
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
    return new ToStringBuilder(this)
              .append("code", code)
              .append("name", name)
              .append("abbreviation", abbreviation)
              .toString();
  }
}
