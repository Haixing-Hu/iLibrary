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
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import com.github.haixing_hu.ilibrary.model.tag.Taggable;

/**
 * The model of publishers, which store the information of an publisher.
 *
 * @author Haixing Hu
 */
public class Publisher extends Taggable {

  private int id;
  private String name;
  private String abbreviation;
  private City city;
  private Website website;
  private String description;
  private int documentCount;

  /**
   * Default constructs a {@link Publisher}.
   */
  public Publisher() {
    id = - 1;
    name = null;
    abbreviation = null;
    city = null;
    website = null;
    description = null;
    documentCount = 0;
  }

  /**
   * Constructs a {@link Publisher}.
   *
   * @param name
   *          the name of the new publisher.
   */
  public Publisher(@Nullable String name) {
    this.id = - 1;
    this.name = name;
    this.abbreviation = null;
    this.city = null;
    this.website = null;
    this.description = null;
    this.documentCount = 0;
  }

  /**
   * Gets the ID.
   *
   * @return the ID.
   */
  public int getId() {
    return id;
  }

  /**
   * Sets the ID.
   *
   * @param id
   *          the new ID to set.
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
   *          the new abbreviation to set.
   */
  public void setAbbreviation(@Nullable String abbreviation) {
    this.abbreviation = abbreviation;
  }

  /**
   * Gets the city.
   *
   * @return the city.
   */
  public City getCity() {
    return city;
  }

  /**
   * Sets the city.
   *
   * @param city
   *          the new city to set.
   */
  public void setCity(@Nullable City city) {
    this.city = city;
  }

  /**
   * Gets the website.
   *
   * @return the website.
   */
  public Website getWebsite() {
    return website;
  }

  /**
   * Sets the website.
   *
   * @param website the new website to set.
   */
  public void setWebsite(@Nullable Website website) {
    this.website = website;
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

  /**
   * Gets the document count.
   *
   * @return the document count.
   */
  public int getDocumentCount() {
    return documentCount;
  }

  /**
   * Sets the document count.
   *
   * @param documentCount
   *          the new document count to set.
   */
  public void setDocumentCount(int documentCount) {
    this.documentCount = documentCount;
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
