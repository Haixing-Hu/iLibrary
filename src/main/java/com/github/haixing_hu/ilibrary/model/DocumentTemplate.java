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

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The model of types of documents.
 *
 * @author Haixing Hu
 */
public final class DocumentTemplate {

  private String name;
  private DocumentType type;
  private String defaultLocale;
  private Map<String, String> displayNames;
  private List<DocumentKind> kinds;
  private List<FieldTemplate> fields;

  /**
   * Constructs a {@link DocumentTemplate}.
   */
  public DocumentTemplate() {
    name = null;
    type = DocumentType.ARTICLE;
    defaultLocale = null;
    displayNames = null;
    kinds = null;
    fields = null;
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
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the type.
   *
   * @return the type.
   */
  public DocumentType getType() {
    return type;
  }

  /**
   * Sets the type.
   *
   * @param type
   *          the new type to set.
   */
  public void setType(DocumentType type) {
    this.type = type;
  }

  /**
   * Gets the default locale.
   *
   * @return the default locale.
   */
  public String getDefaultLocale() {
    return defaultLocale;
  }

  /**
   * Sets the default locale.
   *
   * @param defaultLocale
   *          the new default locale to set.
   */
  public void setDefaultLocale(String defaultLocale) {
    this.defaultLocale = defaultLocale;
  }

  /**
   * Gets the display names.
   *
   * @return the display names, which is a map from the name of a locale to the
   *         corresponding display name for the locale.
   */
  public Map<String, String> getDisplayNames() {
    return displayNames;
  }

  /**
   * Sets the display names.
   *
   * @param displayNames
   *          the new display names to set, which is a map from the name of a
   *          locale to the corresponding display name for the locale.
   */
  public void setDisplayNames(Map<String, String> displayNames) {
    this.displayNames = displayNames;
  }

  /**
   * Gets the kinds.
   *
   * @return the kinds.
   */
  public List<DocumentKind> getKinds() {
    return kinds;
  }

  /**
   * Sets the kinds.
   *
   * @param kinds
   *          the new kinds to set.
   */
  public void setKinds(List<DocumentKind> kinds) {
    this.kinds = kinds;
  }

  /**
   * Gets the fields.
   *
   * @return the fields.
   */
  public List<FieldTemplate> getFields() {
    return fields;
  }

  /**
   * Sets the fields.
   *
   * @param fields
   *          the new fields to set.
   */
  public void setFields(List<FieldTemplate> fields) {
    this.fields = fields;
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
