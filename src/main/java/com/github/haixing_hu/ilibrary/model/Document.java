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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Nullable;

import org.apache.commons.beanutils.BasicDynaBean;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.github.haixing_hu.data.model.tag.Tag;
import com.github.haixing_hu.data.model.tag.Taggable;

import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * The model of documents.
 *
 * @author Haixing Hu
 */
public final class Document extends BasicDynaBean implements Taggable {

  private static final long serialVersionUID = 5715588482333187201L;

  /**
   * The name of the default template of documents.
   */
  public static final String DEFAULT_TEMPLATE = "journal-article";

  private final DocumentTemplate template;
  private Integer id;
  private Date importDate;
  private Date lastReadDate;
  private Date lastPrintDate;
  private List<String> paths;
  private List<Tag> tags;

  /**
   * Construct a {@link Document} instance.
   *
   * @param dynaClass
   *          the dynamic class of the new {@link Document} instance.
   */
  public Document(final DocumentClass dynaClass) {
    super(dynaClass);
    template = dynaClass.getTemplate();
    id = null;
    importDate = null;
    lastReadDate = null;
    lastPrintDate = null;
    paths = null;
    tags = new ArrayList<Tag>();
  }

  @Override
  public DocumentClass getDynaClass() {
    return (DocumentClass) super.getDynaClass();
  }

  /**
   * Gets the ID of this document.
   *
   * @return the ID of this document, or {@code null} if none.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Sets the ID of this document.
   *
   * @param id
   *          the new ID to set, or {@code null} to set none.
   */
  public void setId(@Nullable final Integer id) {
    this.id = id;
  }

  /**
   * Gets the template of this document.
   *
   * @return the template of this document, which will never be {@code null}.
   */
  public DocumentTemplate getTemplate() {
    return template;
  }

  /**
   * Gets the importing date of this document.
   *
   * @return the importing date of this document.
   */
  public Date getImportDate() {
    return importDate;
  }

  /**
   * Sets the importing date of this document.
   *
   * @param importDate
   *          the new importing date to set.
   */
  public void setImportDate(@Nullable final Date importDate) {
    this.importDate = importDate;
  }

  /**
   * Gets the last read date of this document.
   *
   * @return the last read date of this document.
   */
  public Date getLastReadDate() {
    return lastReadDate;
  }

  /**
   * Sets the last read date of this document.
   *
   * @param lastReadDate
   *          the new last read date to set.
   */
  public void setLastReadDate(@Nullable final Date lastReadDate) {
    this.lastReadDate = lastReadDate;
  }

  /**
   * Gets the last print date of this document.
   *
   * @return the last print date of this document, or {@code null} if this
   *         document has not been printed.
   */
  public Date getLastPrintDate() {
    return lastPrintDate;
  }

  /**
   * Sets the last read print of this document.
   *
   * @param lastPrintDate
   *          the new last print date to set, or {@code null} if this document
   *          has not been printed.
   */
  public void setLastPrintDate(@Nullable final Date lastPrintDate) {
    this.lastPrintDate = lastPrintDate;
  }

  /**
   * Gets the list of file paths of this document.
   *
   * @return the list of file paths of this document.
   */
  public List<String> getPaths() {
    return paths;
  }

  /**
   * Sets the list of file paths of this document.
   *
   * @param paths
   *          the new list of file paths to set.
   */
  public void setPaths(final List<String> paths) {
    this.paths = paths;
  }

  @Override
  public List<Tag> getTags() {
    return tags;
  }

  @Override
  public void setTags(final List<Tag> tags) {
    this.tags = requireNonNull("tags", tags);
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  @Override
  public boolean equals(final Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
