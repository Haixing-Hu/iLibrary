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
 * The mode of cities.
 *
 * @author Haixing Hu
 */
public final class City {

  private int id;
  private String name;
  private String abbreviation;
  private String province;
  private Country country;
  private String description;

  /**
   * Constructs a city.
   */
  public City() {
    id = - 1;
    name = null;
    abbreviation = null;
    province = null;
    country = null;
    description = null;
  }

  /**
   * Constructs a city.
   *
   * @param name
   *          the name of the new city.
   */
  public City(@Nullable String name) {
    id = - 1;
    this.name = name;
    abbreviation = null;
    country = null;
    description = null;
  }

  /**
   * Constructs a city.
   *
   * @param name
   *          the name of the new city.
   * @param country
   *          the country of the new city.
   */
  public City(@Nullable String name, @Nullable Country country) {
    id = - 1;
    this.name = name;
    abbreviation = null;
    this.country = country;
    description = null;
  }

  /**
   * Constructs a city.
   *
   * @param name
   *          the name of the new city.
   * @param abbreviation
   *          the abbreviation of the new city.
   */
  public City(@Nullable String name, @Nullable String abbreviation) {
    id = - 1;
    this.name = name;
    this.abbreviation = abbreviation;
    country = null;
    description = null;
  }

  /**
   * Constructs a city.
   *
   * @param name
   *          the name of the new city.
   * @param abbreviation
   *          the abbreviation of the new city.
   * @param country
   *          the country of the new city.
   */
  public City(@Nullable String name, @Nullable String abbreviation,
      @Nullable Country country) {
    id = - 1;
    this.name = name;
    this.abbreviation = abbreviation;
    this.country = country;
    description = null;
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
   *          the new abbreviation to set, which may be {@code null}.
   */
  public void setAbbreviation(@Nullable String abbreviation) {
    this.abbreviation = abbreviation;
  }

  /**
   * Gets the province.
   *
   * @return the province.
   */
  public String getProvince() {
    return province;
  }

  /**
   * Sets the province.
   *
   * @param province
   *          the new province to set, which may be {@code null}.
   */
  public void setProvince(@Nullable String province) {
    this.province = province;
  }

  /**
   * Gets the country.
   *
   * @return the country.
   */
  public Country getCountry() {
    return country;
  }

  /**
   * Sets the country.
   *
   * @param country
   *          the new country to set, which may be {@code null}.
   */
  public void setCountry(@Nullable Country country) {
    this.country = country;
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
