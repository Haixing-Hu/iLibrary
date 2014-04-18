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

import javax.annotation.Nullable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The model of templates of documents.
 *
 * @author Haixing Hu
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="document")
public final class DocumentTemplate {

  @XmlElement(name="name", required=true)
  private String name;

  @XmlElement(name="type", required=true)
  private DocumentType type;

  @XmlElement(name="default-kind", required=true)
  private String defaultKind;

  @XmlElementWrapper(name="kinds")
  @XmlElement(name="kind")
  private List<String> kinds;

  @XmlElementWrapper(name="fields")
  @XmlElement(name="field")
  private List<String> fields;

  /**
   * Constructs a {@link DocumentTemplate}.
   */
  public DocumentTemplate() {
    name = null;
    type = DocumentType.ARTICLE;
    defaultKind = null;
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
   * Gets the defaultKind.
   *
   * @return the defaultKind.
   */
  public String getDefaultKind() {
    return defaultKind;
  }

  /**
   * Sets the defaultKind.
   *
   * @param defaultKind the new defaultKind to set.
   */
  public void setDefaultKind(String defaultKind) {
    this.defaultKind = defaultKind;
  }

  /**
   * Gets the kinds.
   *
   * @return the kinds.
   */
  public List<String> getKinds() {
    return kinds;
  }

  /**
   * Sets the kinds.
   *
   * @param kinds
   *          the new kinds to set.
   */
  public void setKinds(@Nullable List<String> kinds) {
    this.kinds = kinds;
  }

  /**
   * Gets the fields.
   *
   * @return the fields.
   */
  public List<String> getFields() {
    return fields;
  }

  /**
   * Sets the fields.
   *
   * @param fields
   *          the new fields to set.
   */
  public void setFields(@Nullable List<String> fields) {
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
