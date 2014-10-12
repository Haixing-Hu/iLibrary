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

import javax.annotation.Nullable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * The model of countries.
 *
 * @author Haixing Hu
 */
public final class Country {

  private int id;
  private String code;
  private String name;
  private String abbreviation;
  private String description;

  /**
   * Constructs a country.
   */
  public Country() {
    id = - 1;
    code = null;
    name = null;
    abbreviation = null;
    description = null;
  }

  /**
   * Constructs a country.
   *
   * @param name
   *          the name of the new country.
   */
  public Country(@Nullable String name) {
    this.id = - 1;
    this.code = null;
    this.name = name;
    this.abbreviation = null;
    this.description = null;
  }

  /**
   * Constructs a country.
   *
   * @param name
   *          the name of the new country.
   * @param abbreviation
   *          the abbreviation of the new country.
   */
  public Country(@Nullable String name, @Nullable String abbreviation) {
    this.id = - 1;
    this.code = null;
    this.name = name;
    this.abbreviation = abbreviation;
    this.description = null;
  }

  /**
   * Gets the id.
   *
   * @return the id.
   */
  public int getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * @param id
   *          the new id to set.
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Gets the ISO-3166 alpha-2 country code.
   *
   * @return the ISO-3166 alpha-2 country code.
   */
  public String getCode() {
    return code;
  }

  /**
   * Sets the ISO-3166 alpha-2 country code.
   *
   * @param code
   *          the new ISO-3166 alpha-2 country code to set.
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
   * @param description the new description to set.
   */
  public void setDescription(@Nullable String description) {
    this.description = description;
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }
}
