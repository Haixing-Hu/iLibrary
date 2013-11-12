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

import cn.edu.nju.starfish.ilibrary.model.tag.Taggable;

/**
 * The model of institutes.
 *
 * @author Haixing Hu
 */
public class Institute extends Taggable {

  private int id;
  private String name;
  private City city;
  private String email;
  private WebSite website;
  private String description;
  private int documentCount;

  /**
   * Default constructs an {@link Institute}.
   */
  public Institute() {
    id = -1;
    name = null;
    city = null;
    email = null;
    website = null;
    description = null;
    documentCount = 0;
  }

  /**
   * Constructs an {@link Institute}.
   *
   * @param name
   *          the name of the new institute.
   */
  public Institute(@Nullable String name) {
    this.id = -1;
    this.name = name;
    this.city = null;
    this.email = null;
    this.website = null;
    this.description = null;
    this.documentCount = 0;
  }

  /**
   * Constructs an {@link Institute}.
   *
   * @param name
   *          the name of the new institute.
   * @param city
   *          the city of the new institute.
   */
  public Institute(@Nullable String name, @Nullable City city) {
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
  public WebSite getWebsite() {
    return website;
  }

  /**
   * Sets the website.
   *
   * @param website
   *          the new website to set.
   */
  public void setWebsite(@Nullable WebSite website) {
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
