/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.model;

import javax.annotation.Nullable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 * The mode of cities.
 *
 * @author Haixing Hu
 */
public class City {

  private int id;
  private String name;
  private String abbreviation;
  private Country country;
  private String description;

  /**
   * Constructs a city.
   */
  public City() {
    id = - 1;
    name = null;
    abbreviation = null;
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
    this.id = - 1;
    this.name = name;
    this.abbreviation = null;
    this.country = null;
    this.description = null;
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
    this.id = - 1;
    this.name = name;
    this.abbreviation = null;
    this.country = country;
    this.description = null;
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
    this.id = - 1;
    this.name = name;
    this.abbreviation = abbreviation;
    this.country = null;
    this.description = null;
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
    this.id = - 1;
    this.name = name;
    this.abbreviation = abbreviation;
    this.country = country;
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
   *          the new abbreviation to set, which may be <code>null</code>.
   */
  public void setAbbreviation(@Nullable String abbreviation) {
    this.abbreviation = abbreviation;
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
   *          the new country to set, which may be <code>null</code>.
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
    return ReflectionToStringBuilder.toString(this);
  }
}
