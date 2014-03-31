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

import com.github.haixing_hu.ilibrary.dao.WebsiteDao;
import com.github.haixing_hu.ilibrary.model.tag.Taggable;
import com.github.haixing_hu.ilibrary.service.WebsiteService;

/**
 * The model of web sites.
 *
 * @see WebsiteDao
 * @see WebsiteService
 * @author Haixing Hu
 */
public final class Website extends Taggable {

  private int id;
  private String title;
  private String url;
  private Language language;
  private String description;
  private int documentCount;

  /**
   * Default constructs a {@link Website}.
   */
  public Website() {
    id = -1;
    title = null;
    url = null;
    language = null;
    description = null;
    documentCount = 0;
  }

  /**
   * Constructs a {@link Website}.
   *
   * @param url
   *          the URL of the new web site.
   */
  public Website(@Nullable String url) {
    this.id = - 1;
    this.title = null;
    this.url = url;
    this.language = null;
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
   * Gets the title.
   *
   * @return the title.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Sets the title.
   *
   * @param title
   *          the new title to set.
   */
  public void setTitle(@Nullable String title) {
    this.title = title;
  }

  /**
   * Gets the url.
   *
   * @return the url.
   */
  public String getUrl() {
    return url;
  }

  /**
   * Sets the url.
   *
   * @param url
   *          the new url to set.
   */
  public void setUrl(@Nullable String url) {
    this.url = url;
  }

  /**
   * Gets the language.
   *
   * @return the language.
   */
  public Language getLanguage() {
    return language;
  }

  /**
   * Sets the language.
   *
   * @param language
   *          the new language to set.
   */
  public void setLanguage(@Nullable Language language) {
    this.language = language;
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
  public void setDescription(String description) {
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
    return ToStringBuilder.reflectionToString(this);
  }
}
