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
 * The model of countries.
 *
 * @author Haixing Hu
 */
public class Country {

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
