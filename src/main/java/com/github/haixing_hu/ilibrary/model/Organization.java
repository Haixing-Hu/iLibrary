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
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.github.haixing_hu.ilibrary.model.tag.Taggable;

/**
 * The model of organization.
 *
 * @author Haixing Hu
 */
public final class Organization extends Taggable {

  private int id;
  private String name;
  private City city;
  private String address;
  private String email;
  private Website website;
  private String description;
  private int documentCount;

  /**
   * Default constructs an {@link Organization}.
   */
  public Organization() {
    id = -1;
    name = null;
    city = null;
    address = null;
    email = null;
    website = null;
    description = null;
    documentCount = 0;
  }

  /**
   * Constructs an {@link Organization}.
   *
   * @param name
   *          the name of the new institute.
   */
  public Organization(@Nullable String name) {
    this.id = -1;
    this.name = name;
    this.city = null;
    this.email = null;
    this.website = null;
    this.description = null;
    this.documentCount = 0;
  }

  /**
   * Constructs an {@link Organization}.
   *
   * @param name
   *          the name of the new institute.
   * @param city
   *          the city of the new institute.
   */
  public Organization(@Nullable String name, @Nullable City city) {
    this.id = -1;
    this.name = name;
    this.city = city;
    this.email = null;
    this.website = null;
    this.description = null;
    this.documentCount = 0;
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
   * Gets the address.
   *
   * @return the address.
   */
  public String getAddress() {
    return address;
  }

  /**
   * Sets the address.
   *
   * @param address the new address to set.
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Gets the email.
   *
   * @return the email.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the email.
   *
   * @param email
   *          the new email to set.
   */
  public void setEmail(@Nullable String email) {
    this.email = email;
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
   * @param website
   *          the new website to set.
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
    return ToStringBuilder.reflectionToString(this);
  }
}
