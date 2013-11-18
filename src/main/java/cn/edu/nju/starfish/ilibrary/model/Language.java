/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.model;

import javax.annotation.Nullable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The mode of languages.
 *
 * @author Haixing Hu
 */
public class Language {

  private int id;
  private String code;
  private String name;
  private String abbreviation;
  private String description;


  public static Language ENGLIST = new Language("English");

  /**
   * Constructs a language.
   */
  public Language() {
    id = -1;
    code = null;
    name = null;
    abbreviation = null;
    description = null;
  }

  /**
   * Constructs a language.
   *
   * @param name
   *          the name of the new language.
   */
  public Language(@Nullable String name) {
    this.id = - 1;
    this.code = null;
    this.name = name;
    this.abbreviation = null;
    this.description = null;
  }

  /**
   * Constructs a language.
   *
   * @param name
   *          the name of the new language.
   * @param abbreviation
   *          the abbreviation of the new language.
   */
  public Language(@Nullable String name, @Nullable String abbreviation) {
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
    return new ToStringBuilder(this)
              .append("id", id)
              .append("code", code)
              .append("name", name)
              .append("abbreviation", abbreviation)
              .toString();
  }
}
